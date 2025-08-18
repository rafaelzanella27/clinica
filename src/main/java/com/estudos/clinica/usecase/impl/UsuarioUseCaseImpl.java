package com.estudos.clinica.usecase.impl;

import com.estudos.clinica.domain.repository.UsuarioRepository;
import com.estudos.clinica.entrypoints.http.data.request.UsuarioRequestDTO;
import com.estudos.clinica.entrypoints.http.data.response.UsuarioResponseDTO;
import com.estudos.clinica.usecase.UsuarioUseCase;
import com.estudos.clinica.usecase.converter.UsuarioUseCaseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioUseCaseConverter usuarioUseCaseConverter;
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO criarUsuario(final UsuarioRequestDTO requestDTO) {

        return usuarioUseCaseConverter.toUsuarioResponseDTO(
                usuarioRepository.save(usuarioUseCaseConverter.toUsuario(requestDTO)));
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorLogin(final String login) {

        return usuarioUseCaseConverter.toUsuarioResponseDTO(usuarioRepository.findByLogin(login)); // Retornar a resposta apropriada
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(final UsuarioRequestDTO requestDTO) throws Exception {
        if (requestDTO == null || requestDTO.getLogin() == null) {
            return null;
        }
        var usuario = usuarioRepository.findByLogin(requestDTO.getLogin());
        if (isNull(usuario)) {
            throw new Exception("Usuário não encontrado");
        }
        usuarioUseCaseConverter.updateUsuarioFromRequest(usuario, requestDTO);
        usuarioRepository.save(usuario);

        return usuarioUseCaseConverter.toUsuarioResponseDTO(usuario);
    }

    @Override
    public void deletarUsuario(final String login) throws Exception {
        if (isNull(login)) {
            return;
        }
        var usuario = usuarioRepository.findByLogin(login);
        if (isNull(usuario)) {
            throw new Exception("Usuário não encontrado");
        }
        usuarioRepository.delete(usuario);
    }
}
