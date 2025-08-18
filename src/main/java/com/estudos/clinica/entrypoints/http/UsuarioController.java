package com.estudos.clinica.entrypoints.http;

import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/usuario")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public interface UsuarioController {


    @Operation(summary = "Criar um novo usuário")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UsuarioResponseDTO criarUsuario(@RequestBody UsuarioRequestDTO usuarioRequest);

    @Operation(summary = "Buscar usuário por login")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "login/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    UsuarioResponseDTO buscarUsuarioPorId(@PathVariable String login);

    @Operation(summary = "Atualizar um usuário existente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void atualizarUsuario(@RequestBody UsuarioRequestDTO usuarioRequest) throws Exception;

    @Operation(summary = "Deletar um usuário por login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/deletar/login/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deletarUsuario(@PathVariable String login) throws Exception;
}
