package com.estudos.clinica.usecase.converter;

import com.estudos.clinica.domain.model.Usuario;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.gateway.cep.data.output.CepIntegrationOutput;

import java.util.List;

public interface UsuarioUseCaseConverter {

    Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO);
    List<UsuarioResponseDTO> toListUsuarioResponseDTO(List<Usuario> usuario);
    UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario);
    void updateUsuarioFromRequest(Usuario usuario, UsuarioRequestDTO requestDTO);
    String toCep(CepIntegrationOutput cepIntegrationOutput);
}
