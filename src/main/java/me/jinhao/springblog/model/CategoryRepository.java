package me.jinhao.springblog.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends JpaRepository<Category,Integer>{

    Optional<Category> findById(Integer id);

    //void deleteById(Integer id);
    
}