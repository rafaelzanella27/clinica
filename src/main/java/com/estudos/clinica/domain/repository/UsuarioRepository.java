package com.estudos.clinica.domain.repository;

import com.estudos.clinica.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);

    List<Usuario> findAll();
}
