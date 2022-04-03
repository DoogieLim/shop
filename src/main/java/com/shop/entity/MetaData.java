package com.shop.entity;

import com.shop.constant.TrueFalse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="pr_meta_data")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MetaData extends Common {
  @ManyToOne
  @JoinColumn(name="meta_item_id")
  private MetaItem metaItem;        // 아이템ID
  
  @Column(name="service_uid")
  private Long serviceId;         // 서비스ID
  
  @Column(name="order_nums")
  private Integer orderNums;       // 정렬순번

  @Column(name="value1")
  private String value1;          // 입력값1

  @Column(name="value2")
  private String value2;          // 입력값2

  @Column(name="value3")
  private String value3;          // 입력값3
  
  @Column(name="is_deleted")
  @Enumerated(EnumType.STRING)
  private TrueFalse isDeleted;    // 삭제여부
}
