package com.estudos.clinica.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException (String mensagem){
        super(mensagem);
    }
}
