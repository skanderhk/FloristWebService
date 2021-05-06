package com.ipsas.WebService.Exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String s) {
        super(s);
    }
}
