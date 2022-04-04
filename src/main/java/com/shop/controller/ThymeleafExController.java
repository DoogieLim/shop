package com.shop.controller;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController
{
  @Autowired
  ItemService itemService;

  @GetMapping(value = "/ex02")
  public String thymeleafExample02(Model model) {
      ItemDto itemDto = new ItemDto();
      itemDto.setItemDetail("상품 상세 설명");
      itemDto.setItemNm("테스트 상품1");
      itemDto.setPrice(10000);
      itemDto.setRegTime(LocalDateTime.now());

      model.addAttribute("itemDto", itemDto);
      return "thymeleafEx/thymeleafEx02";
    }

  @GetMapping(value = "/ex03")
  public String thymeleafExample03(Model model,
                                   @PageableDefault(page=0, size=10, sort="id", direction= Sort.Direction.DESC) Pageable pageable) {
    Page<ItemDto> itemDtoPage = itemService.getItemPage(pageable);
//    model.addAttribute("items", itemDtoPage);
//    return "thymeleafEx/thymeleafEx03";
    return itemDtoPage.toString();
  }
}
