package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private Responce responce;

    public Question(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Responce getResponce() {
        return responce;
    }

    public void setResponce(Responce responce) {
        this.responce = responce;
    }
}
