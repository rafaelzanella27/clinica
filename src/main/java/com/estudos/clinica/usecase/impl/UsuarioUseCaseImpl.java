package com.estudos.clinica.usecase.impl;

import com.estudos.clinica.domain.model.Usuario;
import com.estudos.clinica.domain.repository.UsuarioRepository;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.exceptions.RecursoNaoEncontradoException;
import com.estudos.clinica.gateway.cep.BuscaCepGateway;
import com.estudos.clinica.usecase.UsuarioUseCase;
import com.estudos.clinica.usecase.converter.UsuarioUseCaseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioUseCaseConverter usuarioUseCaseConverter;
    private final UsuarioRepository usuarioRepository;
    private final BuscaCepGateway buscaCepGateway;

    @Override
    public UsuarioResponseDTO criarUsuario(final UsuarioRequestDTO requestDTO) throws Exception {

        validarCep(requestDTO.getCep());

        return usuarioUseCaseConverter.toUsuarioResponseDTO(
                usuarioRepository.save(usuarioUseCaseConverter.toUsuario(requestDTO)));
    }

    @Override
    public List<UsuarioResponseDTO> buscarTodosUsuarios() {
        List<Usuario> usuariosList = usuarioRepository.findAll();

        return usuarioUseCaseConverter.toListUsuarioResponseDTO(usuariosList);

    }

    private boolean validarCep(final String cep) throws Exception {
        if (isNull(cep) || cep.isBlank()) {
            return false;
        }
        String cepValidado = usuarioUseCaseConverter.toCep(buscaCepGateway.validarCep(cep));
        if (isNull(cepValidado)) {
            return false;
        }
        return true;
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorLogin(final String login) {

        var usuario = usuarioRepository.findByLogin(login);
        if (isNull(usuario)) {
            throw new RecursoNaoEncontradoException("Usuário com login " +login +" não encontrado");
        }

        return usuarioUseCaseConverter.toUsuarioResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(final UsuarioRequestDTO requestDTO) throws Exception {
        if (requestDTO == null || requestDTO.getLogin() == null) {
            return null;
        }
        var usuario = usuarioRepository.findByLogin(requestDTO.getLogin());
        if (isNull(usuario)) {
            throw new RecursoNaoEncontradoException("Usuário com login " +requestDTO.getLogin() +" não encontrado");
        }
        usuarioUseCaseConverter.updateUsuarioFromRequest(usuario, requestDTO);
        usuarioRepository.save(usuario);

        return usuarioUseCaseConverter.toUsuarioResponseDTO(usuario);
    }

    @Override
    public void deletarUsuarioPorId(final Long id) {
        if (isNull(id)) {
            return;
        }
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new RecursoNaoEncontradoException("Usuário com ID " +id +" não encontrado");
        }

        usuarioRepository.delete(usuario.get());
    }
}
