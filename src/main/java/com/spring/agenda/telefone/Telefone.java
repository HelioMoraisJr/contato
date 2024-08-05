package com.spring.agenda.telefone;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {

    //Atributos
    private String phone;
    private String tipo;
    private String codigo_pais;
    private String codigo_area;

    //Contrutor
    public Telefone(DadosTelefone dadosTelefone){
        this.phone = dadosTelefone.phone();
        this.tipo = dadosTelefone.tipo();
        this.codigo_pais = dadosTelefone.codigo_pais();
        this.codigo_area = dadosTelefone.codigo_area();
    }

    public void atualizarinformacoe(DadosTelefone dadosTelefone){
        if(dadosTelefone.phone() != null) {
            this.phone = dadosTelefone.phone();
        }
        if(dadosTelefone.tipo() != null) {
            this.tipo = dadosTelefone.tipo();
        }
        if(dadosTelefone.codigo_pais() != null) {
            this.codigo_pais = dadosTelefone.codigo_pais();
        }
        if(dadosTelefone.codigo_area() != null) {
            this.codigo_area = dadosTelefone.codigo_area();
        }
    }

}
