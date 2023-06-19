package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    public List<Member> findAllByOrderByFirstNameAsc();
}
