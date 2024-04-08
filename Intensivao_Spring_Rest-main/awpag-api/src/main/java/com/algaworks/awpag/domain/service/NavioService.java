package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.api.model.NavioModel;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Imo;
import com.algaworks.awpag.domain.model.Navio;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ImoRepository;
import com.algaworks.awpag.domain.repository.NavioRepository;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class NavioService {

    private final NavioRepository navioRepository;
    private final ImoService cadastroImoService;
    private ModelMapper modelMapper;

    @Transactional
    public Navio cadastrar(Navio novoNavio){
        Imo imo = cadastroImoService.buscar(novoNavio.getImo().getId());
        novoNavio.setImo(imo);
        return navioRepository.save(novoNavio);
    }
    @Transactional
    public void excluir(Long navioId){
        navioRepository.deleteById(navioId);
    }
    public Page<NavioModel> obterTodos(Pageable paginacao) {
        return navioRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, NavioModel.class));
    }
}
