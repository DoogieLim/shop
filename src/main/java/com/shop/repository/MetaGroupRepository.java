package com.shop.repository;


import com.shop.entity.MetaGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface MetaGroupRepository extends JpaRepository<MetaGroup, Long> {
}
