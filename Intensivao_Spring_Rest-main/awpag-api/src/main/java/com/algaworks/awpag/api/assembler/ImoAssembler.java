package com.algaworks.awpag.api.assembler;

import com.algaworks.awpag.api.model.ImoModel;
import com.algaworks.awpag.api.model.NavioModel;
import com.algaworks.awpag.domain.model.Imo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ImoAssembler {
    private final ModelMapper modelMapper;

    public ImoModel toModel(Imo imo) {
        return modelMapper.map(imo, ImoModel.class);
    }

    public List<ImoModel> toCollectionModel(List<Imo> imos) {
        return imos.stream().
                map(this::toModel).
                collect(Collectors.toList());
    }
}
