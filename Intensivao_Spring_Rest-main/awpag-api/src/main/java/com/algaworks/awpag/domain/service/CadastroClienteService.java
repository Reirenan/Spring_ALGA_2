package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.repository.ClienteRepository;
import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroClienteService {


    private final ClienteRepository clienteRepository;

    public Cliente buscar(long clienteId){
        return  clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cleinte não encontrado"));
    }


    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .filter(cliente1 -> !cliente1.equals(cliente))
                .isPresent();

        if(emailEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }


}
