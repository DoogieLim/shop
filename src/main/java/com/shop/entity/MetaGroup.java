package com.shop.entity;

import com.shop.constant.MetaGroupType;
import com.shop.constant.TrueFalse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pr_meta_group")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MetaGroup extends Common {

    @Column(name="group_type")
    @Enumerated(EnumType.STRING)
    private MetaGroupType groupType;    // 그룹타입

    @Column(name="group_name")
    private String groupName;           // 이름

    @Column(name="description")
    private String description;         // 설명

    @Column(name="is_deleted")
    @Enumerated(EnumType.STRING)
    private TrueFalse isDeleted;        // 삭제여부

    @OneToMany(mappedBy = "metaGroup")
    private List<MetaItem> metaItem;     // 그룹아이디
}
