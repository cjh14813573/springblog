package me.jinhao.springblog.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Blog blog;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    private String website;

    @Column(nullable = false)
    private String content;
    
}