package com.exemple.coach.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;
    @Column(length = 1000)
    private String question;
    private int note;
    private Instant date = Instant.now();
    protected Resultat() {}   // exigé par JPA
    public Resultat(String theme, String question, int note) {
        this.theme = theme;
        this.question = question;
        this.note = note;
    }
    public Long getId() { return id; }
    public String getTheme() { return theme; }
    public String getQuestion() { return question; }
    public int getNote() { return note; }
    public Instant getDate() { return date; }
}