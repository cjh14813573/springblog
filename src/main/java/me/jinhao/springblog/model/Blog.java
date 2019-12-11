package me.jinhao.springblog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String brief;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date createdTime;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Category category;

    @JsonManagedReference
    @ManyToMany
    private List<Tag> tagList;

    @JsonBackReference
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> commentList;
    
}