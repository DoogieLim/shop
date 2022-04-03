package com.shop.repository;

import com.shop.constant.ImageType;
import com.shop.constant.TrueFalse;
import com.shop.entity.Image;
import com.shop.entity.Image;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ImageRepositoryTest {
    @PersistenceContext
    EntityManager em;

    @Autowired
    ImageRepository imageRepository;

    @Test
    @Order(1)
    @DisplayName("상품 저장 테스트")
    public void createImageTest() {
        Image Image = new Image();
        Image.setImagePath("/usr/local");
        Image.setImageType(ImageType.BUILDING);
        Image.setImageFileName("곽경호바보.jpg");
        Image.setDescription("경호야 살빼자");
        Image.setIsPrimary(TrueFalse.TRUE);
        Image.setServiceId(181818L);
        Image.setOrderNums(1);
        Image savedImage = imageRepository.save(Image);
        System.out.println("결과 : " + savedImage.toString());
    }

    @Test
    @Order(2)
    @DisplayName("이미지 설명 조회 테스트")
    public void findByDescriptionTest() {
     //   this.createImageList();;
        List<Image> ImageList = imageRepository.findByDescription("경호야 살빼자");
        for(Image Image : ImageList) {
            System.out.println("결과: " + Image.toString());
        }
    }
    @Test
    @Order(3)
    @DisplayName("이미지 설명 like 조회 테스트")
    public void findByDescriptionLikeTest() {
        //   this.createImageList();;
        List<Image> ImageList = imageRepository.findByDescriptionLike("%경호야%");
        for(Image Image : ImageList) {
            System.out.println("결과: " + Image.toString());
        }
    }
}