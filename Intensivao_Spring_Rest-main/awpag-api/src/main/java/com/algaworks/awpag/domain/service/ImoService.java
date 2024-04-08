package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.api.model.ImoModel;
import com.algaworks.awpag.api.model.NavioModel;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Imo;
import com.algaworks.awpag.domain.repository.ImoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@AllArgsConstructor
@Service
public class ImoService {
    private final ImoRepository imoRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Imo cadastrar(Imo novoImo){
        if(novoImo.getId() != null){
            throw new NegocioException("Imo a ser criado não deve possuir um código");

        }
        return imoRepository.save(novoImo);
    }
    @Transactional
    public void excluir(Long navioId){
        imoRepository.deleteById(navioId);
    }
    @Transactional
    public Imo buscar(long clienteId){
        return  imoRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("imo não encontrado"));
    }
    public Page<ImoModel> obterTodos(Pageable paginacao) {
        return imoRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, ImoModel.class));
    }
}
