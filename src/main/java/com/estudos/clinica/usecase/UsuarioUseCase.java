package com.estudos.clinica.usecase;

import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;

public interface UsuarioUseCase {
    UsuarioResponseDTO criarUsuario(UsuarioRequestDTO requestDTO);

    UsuarioResponseDTO buscarUsuarioPorId(String login);

    UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO requestDTO);

    void deletarUsuario(String login);
}
