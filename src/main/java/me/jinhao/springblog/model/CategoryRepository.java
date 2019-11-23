package me.jinhao.springblog.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends JpaRepository<Category,Integer>{

    Optional<Category> findById(Integer id);

    //void deleteById(Integer id);
    
}