package com.clase.exceptions;

public class TestException {
    public static void main(String[] args) {
        try {
            throwsAnException();
            // Do other things that might throw my exception
        } catch (FooException e) {
            System.err.printf("File: %s, error: %s, caused by %s%n", e.getFilename(), e, e.getCause());
        }
    }

    public static void throwsAnException() throws FooException {
        try {
            int x = 2 / 0;
        } catch (ArithmeticException e) {
            throw new FooException("bob.file", e);
        }
    }
}
