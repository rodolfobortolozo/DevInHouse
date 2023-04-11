package com.example.thymelead.controller;

import com.example.thymelead.controller.dto.PessoaDto;
import com.example.thymelead.repository.PessoaRepository;
import com.example.thymelead.repository.model.PessoaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/formulario")
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String paginaFormulario(PessoaDto pessoaDto, Model model){
        return "formulario";
    }

    @PostMapping
    public String postFormulario(
            @Validated PessoaDto pessoaDto,
            Model model
    ){
        repository.save(
                PessoaEntity.builder()
                    .nome(pessoaDto.getNome())
                    .idade(pessoaDto.getIdade())
                    .build()
        );
        return "redirect:formulario/lista"; //vai para o edpoint /formulario/lista
    }

    @GetMapping("/lista")
    public String listarPessoas(
            Model model
    ){
        List<PessoaDto> pessoaDtos =
                repository.findAll()//Lista de PessoaEntity
                        .stream() //Stream de PessoaEntity, apenas a Stream tem acesso ao map
                        .map( // vai ser executado para cada item da lista de PessoaEntity
                                // e vai criar um novo item que será armazenado na lista nova
                pessoaEntity -> new PessoaDto(pessoaEntity.getNome(), pessoaEntity.getIdade())
        ).collect(Collectors.toList()); //define o tipo da lista que vamos salvar

        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setNome();
        model.addAttribute("pessoaDtos", pessoaDtos);
        return "lista_pessoas";
    }


}
