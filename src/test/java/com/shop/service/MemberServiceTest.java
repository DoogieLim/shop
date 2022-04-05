package com.shop.service;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class MemberServiceTest {
  @Autowired
  MemberService memberService;

  @Autowired
  PasswordEncoder passwordEncoder;

  public Member createMember() {
    MemberFormDto memberFormDto = new MemberFormDto();
    memberFormDto.setEmail("imdw@nate.com");
    memberFormDto.setName("임두욱");
    memberFormDto.setAddress("서울 동대문구 장안동");
    memberFormDto.setPassword("1234");
    return Member.createMember(memberFormDto, passwordEncoder);
  }
  @Test
  @DisplayName("회원가입 테스트")
  public void saveMemberTest() {
    Member member = createMember();
    Member saveMember = memberService.saveMember(member);

    assertEquals(member.getEmail(), saveMember.getEmail());
    assertEquals(member.getName(), saveMember.getName());
    assertEquals(member.getAddress(), saveMember.getAddress());
    assertEquals(member.getPassword(), saveMember.getPassword());
    assertEquals(member.getRole(), saveMember.getRole());

  }
}