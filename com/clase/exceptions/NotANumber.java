package com.clase.exceptions;

public class NotANumber extends CodeException {
    public NotANumber(String message)
    {
        super(101, message);
    }
}
