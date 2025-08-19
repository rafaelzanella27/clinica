package com.estudos.clinica.entrypoints.http.data.response;

import com.estudos.clinica.domain.model.PerfilUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private Long id;
    private String login;
    private String nome;
    private String email;
    private String cep;
    private PerfilUsuarioEnum perfil;
}
