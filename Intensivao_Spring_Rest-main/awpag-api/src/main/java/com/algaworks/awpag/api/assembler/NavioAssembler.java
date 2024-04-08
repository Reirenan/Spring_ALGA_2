package com.algaworks.awpag.api.assembler;

import com.algaworks.awpag.api.model.NavioModel;
import com.algaworks.awpag.api.model.ParcelamentoModel;
import com.algaworks.awpag.domain.model.Navio;
import com.algaworks.awpag.domain.model.Parcelamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class NavioAssembler {
    private final ModelMapper modelMapper;

    public NavioModel toModel(Navio navio){
        return modelMapper.map(navio, NavioModel.class);
    }

    public List<NavioModel> toCollectionModel(List<Navio> navios){
        return navios.stream()
                .map(p -> toModel(p))
                .toList();
    }
    }