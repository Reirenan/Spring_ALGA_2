package com.algaworks.awpag.api.model;

import lombok.Data;

@Data
public class ImoModel {
    private Long id;
    private String imo;
    private String nome;
    private Float loa;
    private Float boca;
    private Float pontal;
    private Float calado;
}
