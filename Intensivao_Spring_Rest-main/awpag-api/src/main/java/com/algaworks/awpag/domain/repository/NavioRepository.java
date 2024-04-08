package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Navio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NavioRepository extends JpaRepository<Navio, Long> {
}