package com.luv2code.springboot.thymeleafdemo.service;
import java.util.List;
import com.luv2code.springboot.thymeleafdemo.entity.Member;

public interface MemberService {

	List<Member> findAll();

	List<Member> findMembersBySearchTerm(String searchTerm);

	Member findById(int theId);

	void save(Member theEmployee);
	
	void deleteById(int theId);
	
}
