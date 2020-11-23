package com.Sandar.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sandar.demo.models.DiscountType;

@Repository
public interface DiscountTypeRepository extends JpaRepository<DiscountType, Long>{

}
