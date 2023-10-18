package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;



@Entity
public class Diagnostic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "diagnostic")
    private List<Responce> responceList;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Diagnostic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Responce> getResponceList() {
        return responceList;
    }

    public void setResponceList(List<Responce> responceList) {
        this.responceList = responceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
