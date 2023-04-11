package com.example.thymelead.controller;

import com.example.thymelead.controller.dto.PessoaAtualizarDto;
import com.example.thymelead.controller.dto.PessoaDto;
import com.example.thymelead.repository.PessoaRepository;
import com.example.thymelead.repository.model.PessoaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String chamaFormulario(PessoaDto pessoaDto, Model model){
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

        model.addAttribute("pessoaDtos", pessoaDtos);
        return "lista_pessoas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPessoa(
            @PathVariable("id") Long id,
            Model model
    ){
        repository.deleteById(id);

        List<PessoaDto> pessoaDtos =
                repository.findAll()//Lista de PessoaEntity
                        .stream() //Stream de PessoaEntity, apenas a Stream tem acesso ao map
                        .map( // vai ser executado para cada item da lista de PessoaEntity
                                // e vai criar um novo item que será armazenado na lista nova
                                pessoaEntity -> new PessoaDto(pessoaEntity.getNome(), pessoaEntity.getIdade())
                        ).collect(Collectors.toList()); //define o tipo da lista que vamos salvar

        model.addAttribute("pessoaDtos", pessoaDtos);
        return "lista_pessoas";
    }

    @GetMapping("/atualizar")
    public String chamaAtualizarPessoa(PessoaAtualizarDto pessoaAtualizarDto, Model model){
        return "formulario_atualizar";
    }
    @PostMapping("/atualizar")
    public String atualizarPessoa(
            PessoaAtualizarDto pessoaAtualizaDto,
            Model model
    ){
        PessoaEntity entity = repository
                .findById(pessoaAtualizaDto.getId())
                .orElse(null);

        entity.setNome(pessoaAtualizaDto.getNome());
        entity.setIdade(pessoaAtualizaDto.getIdade());

        repository.save(entity);

        List<PessoaDto> pessoaDtos =
                repository.findAll()//Lista de PessoaEntity
                        .stream() //Stream de PessoaEntity, apenas a Stream tem acesso ao map
                        .map( // vai ser executado para cada item da lista de PessoaEntity
                                // e vai criar um novo item que será armazenado na lista nova
                                pessoaEntity -> new PessoaDto(pessoaEntity.getNome(), pessoaEntity.getIdade())
                        ).collect(Collectors.toList()); //define o tipo da lista que vamos salvar

        model.addAttribute("pessoaDtos", pessoaDtos);
        return "lista_pessoas";
    }


}
