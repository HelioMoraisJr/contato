package com.spring.agenda.contato;

import com.spring.agenda.telefone.DadosTelefone;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarContato(
    @NotNull
    Long id,
    String nome,
    String sobrenome,
    DadosTelefone telefone){
}
