package com.estudos.clinica.usecase;

import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;

public interface UsuarioUseCase {
    UsuarioResponseDTO criarUsuario(UsuarioRequestDTO requestDTO) throws Exception;

    UsuarioResponseDTO buscarUsuarioPorLogin(String login);

    UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO requestDTO) throws Exception;

    void deletarUsuario(String login) throws Exception;
}
