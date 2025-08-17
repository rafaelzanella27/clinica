package com.estudos.clinica.usecase.impl;

import com.estudos.clinica.domain.repository.UsuarioRepository;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.usecase.UsuarioUseCase;
import com.estudos.clinica.usecase.converter.UsuarioUseCaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    @Autowired
    private UsuarioUseCaseConverter usuarioUseCaseConverter;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO criarUsuario(final UsuarioRequestDTO requestDTO) {

        return usuarioUseCaseConverter.toUsuarioResponseDTO(
                usuarioRepository.save(usuarioUseCaseConverter.toUsuario(requestDTO)));
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorId(final String login) {
        return null; // Retornar a resposta apropriada
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(final UsuarioRequestDTO requestDTO) {
        return null; // Retornar a resposta apropriada
    }

    @Override
    public void deletarUsuario(final String login) {
        // Lógica para deletar um usuário por ID (login)
    }
}
