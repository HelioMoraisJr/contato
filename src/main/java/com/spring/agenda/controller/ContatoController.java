package com.spring.agenda.controller;

import com.spring.agenda.contato.Contato;
import com.spring.agenda.contato.ContatoRepository;
import com.spring.agenda.contato.DadosAtualizarContato;
import com.spring.agenda.contato.DadosCadastroContato;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contato")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @PostMapping
    @Transactional
    public void contatoAdicionar(@RequestBody DadosCadastroContato adicionar){
        repository.save(new Contato(adicionar));
    }

    @GetMapping
    public List<Contato> contatoListar(){
        return repository.findAll();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody  DadosAtualizarContato dados){
        // Atualiza informações de um contato existente
        var contato = repository.getReferenceById(dados.id());
        contato.atualizarInformacoe(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        // Marca o contato  como inativo (exclusão lógica)
        var contato = repository.getReferenceById(id);
        contato.excluir();
    }
}
