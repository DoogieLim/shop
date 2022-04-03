package com.shop.entity;

import com.shop.constant.TrueFalse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Entity
@Table(name="pr_building")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Building extends Common{
  @Column(name="building_name")
  private String buildingName;                  //건물이름

  @Column(name="description")
  private String description;                   //설명

  @Column(name="floor_nums")
  private Integer floorNums;                    // 지상층수

  @Column(name="underground_floor_nums")
  private Integer undergroundFloorNums;         // 지하층수
  
  @Column(name="feature")
  private String feature;                       // 특징
  
  @Column(name="completion_ymd")
  private String completionYmd;                 // 준공일자

  @Column(name="entry_start_time")
  private LocalDateTime entryStartTime;         // 출입시작시간
  
  @Column(name="entry_end_time")
  private LocalDateTime entryEndTime;           // 출입종료시간
  
  @Column(name="passenger_elev")
  private Integer passengerElev;                // 승객 엘리베이터

  @Column(name="freight_elev")
  private Integer freightElev;                  // 화물 엘리베이터 

  @Column(name="is_displayed")
  @Enumerated(EnumType.STRING)
  private TrueFalse isDisplayed;                // 노출여부

  @Column(name="is_deleted")
  @Enumerated(EnumType.STRING)
  private TrueFalse isDeleted;                  // 삭제여부
}
