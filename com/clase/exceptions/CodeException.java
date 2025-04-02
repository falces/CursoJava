package com.clase.exceptions;

public abstract class CodeException extends Exception{
    private final int code;
    public CodeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
