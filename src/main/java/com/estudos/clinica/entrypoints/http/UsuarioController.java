package com.estudos.clinica.entrypoints.http;

import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/usuario")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public interface UsuarioController {


    @PostMapping(value = "/criar", consumes = "application/json", produces = "application/json")
    @Operation(summary = "Criar um novo usuário")
    UsuarioResponseDTO criarUsuario(@RequestBody UsuarioRequestDTO usuarioRequest);

    @GetMapping
    UsuarioResponseDTO buscarUsuarioPorId(String login);

    @PutMapping
    UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO usuarioRequest);

    @DeleteMapping
    void deletarUsuario(String login);
}
