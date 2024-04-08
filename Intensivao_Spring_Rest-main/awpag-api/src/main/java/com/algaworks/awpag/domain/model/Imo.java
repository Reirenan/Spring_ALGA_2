package com.algaworks.awpag.domain.model;

import com.algaworks.awpag.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Imo {
    @NotNull(groups = ValidationGroups.ImoId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 60)
    private String imo_numero ;
    @NotNull
    @Size(max = 60)
    private String nome;

    @NotNull
    @Positive
    private Float loa;

    @NotNull
    @Positive
    private Float boca;

    @NotNull
    @Positive
    private Float pontal;

    @NotNull
    @Positive
    private Float calado;

}
