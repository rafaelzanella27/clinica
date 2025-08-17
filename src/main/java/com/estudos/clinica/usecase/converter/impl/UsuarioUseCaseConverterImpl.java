package com.estudos.clinica.usecase.converter.impl;

import com.estudos.clinica.domain.model.PerfilUsuarioEnum;
import com.estudos.clinica.domain.model.Usuario;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.usecase.converter.UsuarioUseCaseConverter;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class UsuarioUseCaseConverterImpl implements UsuarioUseCaseConverter {

    @Override
    public Usuario toUsuario(final UsuarioRequestDTO request) {

        if (isNull(request)) {
            return null;
        }
        return Usuario.builder()
                .login(request.getLogin())
                .senha(request.getSenha())
                .nome(request.getNome())
                .email(request.getEmail())
                .perfil(PerfilUsuarioEnum.fromValue(request.getPerfil()))
                .build();
    }

    @Override
    public UsuarioResponseDTO toUsuarioResponseDTO(final Usuario usuario) {

        if (isNull(usuario)) {
            return null;
        }
        return UsuarioResponseDTO.builder()
                .login(usuario.getLogin())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .perfil(usuario.getPerfil())
                .build();
    }
}
