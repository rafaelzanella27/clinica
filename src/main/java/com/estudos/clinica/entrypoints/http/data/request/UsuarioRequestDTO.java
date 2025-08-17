package com.estudos.clinica.entrypoints.http.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String login;
    private String senha;
    private String nome;
    private String email;
    private String perfil;

}
