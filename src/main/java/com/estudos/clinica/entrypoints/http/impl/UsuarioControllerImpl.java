package com.estudos.clinica.entrypoints.http.impl;

import com.estudos.clinica.entrypoints.http.UsuarioController;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.usecase.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @Override
    public UsuarioResponseDTO criarUsuario(final UsuarioRequestDTO usuarioRequest) throws Exception {

        if (isNull(usuarioRequest)) {
            return null;

        }
        return usuarioUseCase.criarUsuario(usuarioRequest);
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorLogin(final String login) {
        if (isNull(login)) {
            return null;
        }
        return usuarioUseCase.buscarUsuarioPorLogin(login);
    }

    @Override
    public void atualizarUsuario(final UsuarioRequestDTO usuarioRequest) throws Exception {
        if (isNull(usuarioRequest)) {
            return;
        }
        usuarioUseCase.atualizarUsuario(usuarioRequest);
    }

    @Override
    public void deletarUsuario(final String login) throws Exception {
        if (isNull(login)) {
            return;
        }
        usuarioUseCase.deletarUsuario(login);
    }
}
