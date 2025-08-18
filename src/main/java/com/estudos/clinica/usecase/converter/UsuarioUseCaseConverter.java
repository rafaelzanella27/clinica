package com.estudos.clinica.usecase.converter;

import com.estudos.clinica.domain.model.Usuario;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;

public interface UsuarioUseCaseConverter {

    Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario);
    void updateUsuarioFromRequest(Usuario usuario, UsuarioRequestDTO requestDTO);
}
