package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
public class Responce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int note;
    private String text;

    @ManyToOne
    @JoinColumn(name="diagnostic_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Diagnostic diagnostic;

    @OneToOne
    @JoinColumn(name = "question_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Question question;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;


    public Responce() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

