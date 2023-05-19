package com.uahb.m1info.commande.service.service.exception;

public class CommandeException extends Throwable {

    public CommandeException(String message) {
        super(message);
    }

    public CommandeException(String message, Throwable cause) {
        super(message, cause);
    }
}
