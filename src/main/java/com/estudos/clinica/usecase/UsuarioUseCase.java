package com.estudos.clinica.usecase;

import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioUseCase {
    UsuarioResponseDTO criarUsuario(UsuarioRequestDTO requestDTO) throws Exception;

    List<UsuarioResponseDTO> buscarTodosUsuarios();

    UsuarioResponseDTO buscarUsuarioPorLogin(String login);

    UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO requestDTO) throws Exception;

    void deletarUsuarioPorId(Long id) throws Exception;
}
