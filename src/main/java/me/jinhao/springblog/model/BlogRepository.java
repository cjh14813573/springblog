package me.jinhao.springblog.model;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Optional<Blog> findById(Integer id);

    Page<Blog> findAll(Pageable pageable);

    
}