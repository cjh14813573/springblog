package me.jinhao.springblog.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Blog blog;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    private String website;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date createdTime;

    @Transient
    private String avatar;
    
}