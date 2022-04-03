package com.shop.entity;

import com.shop.constant.TrueFalse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="pr_meta_item")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MetaItem extends Common {
  @Column(name="item_type")
  private String itemType;      // 아이템 타입

  @ManyToOne
  @JoinColumn(name="meta_group_uid")
  private MetaGroup metaGroup;     // 그룹아이디

  @Column(name="item_name")
  private String itemName;      // 아이템명

  @Column(name="default_value1")
  private String defaultValue1; // 초기값1

  @Column(name="default_value2")
  private String defaultValue2; // 초기값2

  @Column(name="default_value3")
  private String defaultValue3; // 초기값3

  @Column(name="order_nums")
  private Integer orderNums;      // 정렬순서

  @Column(name="is_deleted")
  @Enumerated(EnumType.STRING)
  private TrueFalse isDeleted;  // 삭제여부
}
