package com.shop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="uid")
    private Long id;
}
