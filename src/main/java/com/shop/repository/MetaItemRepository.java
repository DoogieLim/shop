package com.shop.repository;


import com.shop.entity.MetaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface MetaItemRepository extends JpaRepository<MetaItem, Long> {
}
