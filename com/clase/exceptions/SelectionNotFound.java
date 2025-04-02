package com.clase.exceptions;

public class SelectionNotFound extends CodeException {
    public SelectionNotFound(String message)
    {
        super(102, message);
    }
}
