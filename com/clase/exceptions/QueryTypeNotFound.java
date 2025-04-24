package com.clase.exceptions;

public class QueryTypeNotFound extends CodeException {
    public QueryTypeNotFound(String message)
    {
        super(103, message);
    }
}
