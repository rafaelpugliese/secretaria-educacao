package com.fat.pweb2.secretaria.educacao.controller;

import com.fat.pweb2.secretaria.educacao.model.Aluno;
import com.fat.pweb2.secretaria.educacao.model.Escola;
import com.fat.pweb2.secretaria.educacao.model.EscolaAluno;
import com.fat.pweb2.secretaria.educacao.repository.AlunoRepository;
import com.fat.pweb2.secretaria.educacao.repository.EscolaAlunoRepository;
import com.fat.pweb2.secretaria.educacao.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping
public class AlunoController {

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EscolaAlunoRepository escolaAlunoRepository;

    @GetMapping("/aluno/")
    public ModelAndView aluno() {
        ModelAndView modelAndView = new ModelAndView("Aluno");
        modelAndView.addObject("escolas", escolaRepository.findAll());
        modelAndView.addObject("escolaAluno", new EscolaAlunoDTO());
        return modelAndView;
    }

    @PostMapping("/aluno/adicionar")
    public ModelAndView adicionar(@Valid EscolaAlunoDTO escolaAlunoDTO,
                                  BindingResult result,
                                  RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("Aluno");
            modelAndView.addObject("escolas", escolaRepository.findAll());
            modelAndView.addObject("escolaAluno", escolaAlunoDTO);
            return modelAndView;
        }

        Aluno aluno = this.alunoRepository.save(escolaAlunoDTO.getAluno());

        Escola escola = escolaRepository.findById(escolaAlunoDTO.getIdEscola()).get();
        EscolaAluno escolaAluno = new EscolaAluno(escola, aluno);

        escolaAlunoRepository.save(escolaAluno);

        modelAndView = new ModelAndView("HomeEscola");
        attributes.addFlashAttribute("mensagem", "Aluno adicionado com sucesso.");
        return modelAndView;
    }

    @GetMapping("/alunos/{idEscola}")
    public ModelAndView listarAlunos(@PathVariable("idEscola") Long idEscola) {
        Escola escola = escolaRepository.findById(idEscola).get();
        ModelAndView modelAndView = new ModelAndView("Alunos");
        modelAndView.addObject("alunos", escola.obterAlunos());
        modelAndView.addObject("qntAlunos", escolaAlunoRepository.listarQuantidadeAlunosSQL(idEscola));
        return modelAndView;
    }

    public Long listarQuantidadeAlunos(Long idEscola) {
        this.escolaAlunoRepository.countByEscola_Id(idEscola);
        escolaAlunoRepository.listarQuantidadeAlunosSQL(idEscola);
        return this.escolaAlunoRepository.contarPorIdEscolaJPQL(idEscola);
    }

}
