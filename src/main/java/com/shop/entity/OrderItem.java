package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="order_item")
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="order_item_id")
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="item_id")
  private Item item;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="order_id")
  private Order order;

  private int orderPrice;

  private int count;

  private LocalDateTime regTime;

  private LocalDateTime updateTime;
}
