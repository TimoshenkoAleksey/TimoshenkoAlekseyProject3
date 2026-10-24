package ru.aston.timoshenko.aleksey.project3.chainofresponsibility;

public class HandlerNotExistException extends RuntimeException {
    public HandlerNotExistException(String message) {
        super(message);
    }
}
