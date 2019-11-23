package me.jinhao.springblog.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Optional<Blog> findById(Integer id);

    
}