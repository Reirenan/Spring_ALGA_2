package com.algaworks.awpag.api.model;
import com.algaworks.awpag.domain.model.Imo;
import lombok.Data;


@Data

public class NavioModel {
    private Long id;
    private String agente_solicitante;
    private Imo imo;
}
