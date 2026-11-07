package com.exemple.coach.exception;

public class AucunDocumentException extends RuntimeException {
    public AucunDocumentException(String theme) {
        super("Aucun document pour le thème « " + theme
              + " ». Ingérez d'abord vos fiches avec POST /documents.");
    }
}