package com.clase.exceptions;

class FooException extends Exception {

    private final String filename;
    private final Throwable cause;

    public FooException(String filename) {
        this(filename, null);
    }

    public FooException(String filename, Throwable cause) {
        this.filename = filename;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return "Error reading file";
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public String getFilename() {
        return filename;
    }
}
