package me.jinhao.springblog.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page,Integer>{

	Page findBySlug(String slug);

    
}