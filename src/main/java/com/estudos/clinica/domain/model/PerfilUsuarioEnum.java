package com.estudos.clinica.domain.model;

import java.util.Arrays;

import static java.util.Arrays.stream;

public enum PerfilUsuarioEnum {
    MEDICO("Medico"),
    RECEPCIONISTA("Recepcionista"),
    ADMINISTRATIVO("Administrativo");

    private String descricao;

    PerfilUsuarioEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PerfilUsuarioEnum fromValue(final String value) {
        return Arrays.stream(PerfilUsuarioEnum.values())
                .filter(perfilEnum -> perfilEnum.name().equalsIgnoreCase(value)
                        || perfilEnum.getDescricao().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Perfil inválido: " + value));
    }
}
