package com.exemple.coach.exception;


public class ReponseModeleInvalideException extends RuntimeException {
	
    public ReponseModeleInvalideException(String message) { super(message); }
    public ReponseModeleInvalideException(String message, Throwable cause) {
        super(message, cause);
    }
}