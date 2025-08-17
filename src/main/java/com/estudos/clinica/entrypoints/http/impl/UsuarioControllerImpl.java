package com.estudos.clinica.entrypoints.http.impl;

import com.estudos.clinica.entrypoints.http.UsuarioController;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.usecase.UsuarioUseCase;
import com.estudos.clinica.usecase.impl.UsuarioUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;


    @Override
    public UsuarioResponseDTO criarUsuario(final UsuarioRequestDTO usuarioRequest) {

        if (isNull(usuarioRequest)) {
            return null;

        }
        return usuarioUseCase.criarUsuario(usuarioRequest);
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorId(final String login) {
        return null;
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(final UsuarioRequestDTO usuarioRequest) {
        return null;
    }

    @Override
    public void deletarUsuario(final String login) {

    }
}
