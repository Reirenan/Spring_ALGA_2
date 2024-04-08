package com.algaworks.awpag.api.Controller;

import com.algaworks.awpag.api.assembler.ImoAssembler;
import com.algaworks.awpag.api.model.ImoModel;
import com.algaworks.awpag.api.model.NavioModel;
import com.algaworks.awpag.domain.model.Imo;
import com.algaworks.awpag.domain.repository.ImoRepository;
import com.algaworks.awpag.domain.service.ImoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/imos")
public class ImoController {
    private final ImoRepository imoRepository;
    private final ImoService imoService;
    private final ImoAssembler imoAssembler;

    @GetMapping
    public Page<ImoModel> listar(@PageableDefault(size = 10) Pageable paginacao){
        return imoService.obterTodos(paginacao);
    }

    @GetMapping("/{imoId}")
    public ResponseEntity<ImoModel> buscar(@PathVariable Long imoId){
        return imoRepository.findById(imoId)
                .map(imoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ImoModel cadastrar(@Valid @RequestBody Imo parcelamento){
        Imo parcelamentoCadastrado =  imoService.cadastrar(parcelamento);
        return imoAssembler.toModel(parcelamentoCadastrado);
    }
}
