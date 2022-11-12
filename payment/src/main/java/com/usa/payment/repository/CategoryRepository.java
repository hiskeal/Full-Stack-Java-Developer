package com.usa.payment.repository;

import com.usa.payment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //void deleteById(Long id);
}
