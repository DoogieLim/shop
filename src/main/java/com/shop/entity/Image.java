package com.shop.entity;

import com.shop.constant.ImageType;
import com.shop.constant.TrueFalse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="pr_image")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Image extends Common {

    @Column(name="service_uid")
    private Long serviceId;

    @Column(name="image_type")
    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    @Column(name="image_file_name")
    private String imageFileName;

    @Column(name="description")
    private String description;

    @Column(name="image_path")
    private String imagePath;

    @Column(name="is_primary")
    @Enumerated(EnumType.STRING)
    private TrueFalse isPrimary;

    @Column(name="order_nums")
    private Integer orderNums;
}
