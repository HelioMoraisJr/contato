package com.spring.agenda.contato;

import com.spring.agenda.endereco.DadosEndereco;
import com.spring.agenda.telefone.DadosTelefone;

public record DadosCadastroContato(String nome, String sobrenome, DadosTelefone dadosTelefone, String email, DadosEndereco dadosEndereco) {
}
