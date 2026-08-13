package com.shopsmart.shopsmart.repository;

import com.shopsmart.shopsmart.model.Mall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallRepository
        extends JpaRepository<Mall, Integer> {

}