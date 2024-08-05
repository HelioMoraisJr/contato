package com.spring.agenda.contato;

import com.spring.agenda.endereco.Endereco;
import com.spring.agenda.telefone.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contato")
@Entity(name = "Contato")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Contato {

    //atrubutos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;

    @Embedded
    private Telefone telefone;

    private String email;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    //Contrutor
    public Contato(DadosCadastroContato dadosContato) {
        this.ativo = true;
        this.nome = dadosContato.nome();
        this.sobrenome = dadosContato.sobrenome();
        this.telefone = new Telefone(dadosContato.dadosTelefone());
        this.email = dadosContato.email();
        this.endereco = new Endereco(dadosContato.dadosEndereco());
    }

    public void atualizarInformacoe(DadosAtualizarContato dadosAtualizar){
        if(dadosAtualizar.nome() != null){
            this.nome = dadosAtualizar.nome();
        }

        if(dadosAtualizar.sobrenome() != null){
            this.sobrenome = dadosAtualizar.sobrenome();
        }

        if(dadosAtualizar.telefone() != null){
            this.telefone.atualizarinformacoe(dadosAtualizar.telefone());
        }
    }

    public void excluir() {
        this.ativo = false;
    }


}
