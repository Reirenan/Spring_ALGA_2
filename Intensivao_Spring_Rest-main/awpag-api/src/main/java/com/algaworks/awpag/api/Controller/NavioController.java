package com.algaworks.awpag.api.Controller;

import com.algaworks.awpag.api.assembler.NavioAssembler;
import com.algaworks.awpag.api.model.NavioModel;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Navio;
import com.algaworks.awpag.domain.repository.NavioRepository;
import com.algaworks.awpag.domain.service.NavioService;
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
@RequestMapping("/navios")
public class NavioController {
    private final NavioRepository navioRepository;
    private final NavioService navioService;
    private final NavioAssembler navioAssembler;

    @GetMapping
    public Page<NavioModel> listar(@PageableDefault(size = 10) Pageable paginacao){
        return navioService.obterTodos(paginacao);
    }

    @GetMapping("/{navioId}")
    public ResponseEntity<NavioModel> buscar(@PathVariable Long navioId){
        return navioRepository.findById(navioId)
                .map(navioAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NavioModel cadastrar(@Valid @RequestBody Navio parcelamento){
        Navio parcelamentoCadastrado =  navioService.cadastrar(parcelamento);
        return navioAssembler.toModel(parcelamentoCadastrado);
    }
    @PutMapping("/{navioId}")
    public ResponseEntity<NavioModel> editar(@PathVariable Long navioId, @RequestBody Navio navio){
        if(!navioRepository.existsById(navioId)){
            return ResponseEntity.notFound().build();
        }
        navio.setId(navioId);
        Navio navioAtualizado = navioService.cadastrar(navio);
        return ResponseEntity.ok(navioAssembler.toModel(navioAtualizado));
    }
    @DeleteMapping("/{navioId}")
    public ResponseEntity<Void> excluir(@PathVariable Long navioId){
        if(!navioRepository.existsById(navioId)){
            return ResponseEntity.notFound().build();
        }
        navioService.excluir(navioId);
        return ResponseEntity.noContent().build();

    }
}
