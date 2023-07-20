package com.raiko.project.myCafe.exceptions;

public class NotFindDishException extends RuntimeException{

    private String message;



    public NotFindDishException(String message) {
        super(message);
    }
}
