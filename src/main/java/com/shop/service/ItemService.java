package com.shop.service;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
  @Autowired
  private final ItemRepository itemRepository;

  private static final ModelMapper modelMapper = new ModelMapper();

  public Page<ItemDto> getItemPage(Pageable pageable) {
    Page<Item> itemPage = itemRepository.findAll(pageable);
    List<ItemDto> itemDtoPage = itemPage.stream().map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
    return new PageImpl<>(itemDtoPage, pageable, itemDtoPage.size());
  }
}
