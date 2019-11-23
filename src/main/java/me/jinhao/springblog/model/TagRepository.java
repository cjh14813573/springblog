package me.jinhao.springblog.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer>{

    Optional<Tag> findById(Integer id);
}