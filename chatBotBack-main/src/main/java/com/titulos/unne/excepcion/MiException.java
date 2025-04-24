package com.titulos.unne.excepcion;

public class MiException extends RuntimeException {

    public MiException() {
        super();
    }

    public MiException(String msg) {
        super(msg);
    }
}