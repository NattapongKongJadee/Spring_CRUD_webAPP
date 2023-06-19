package com.luv2code.springboot.thymeleafdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.thymeleafdemo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.thymeleafdemo.dao.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository theMemberRepository) {

		memberRepository = theMemberRepository;
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public List<Member> findMembersBySearchTerm(String searchTerm) {
		List<Member> allMembers = memberRepository.findAll();
		List<Member> matchingMembers = new ArrayList<>();

		if (searchTerm == null || searchTerm.isEmpty()) {
			return allMembers; // Return all members if search term is empty or null
		}

		for (Member member : allMembers) {
			String firstName = member.getFirstName();
			String lastName = member.getLastName();
			String phoneNumber = member.getPhonenumber();

			if (firstName.equalsIgnoreCase(searchTerm)
					|| lastName.equalsIgnoreCase(searchTerm)
					|| phoneNumber.equalsIgnoreCase(searchTerm)) {
				matchingMembers.add(member);
			}
		}

		return matchingMembers;
	}





	@Override
	public Member findById(int theId) {
		Optional<Member> result = memberRepository.findById(theId);
		Member theMember = null;
		if (result.isPresent()) {
			theMember = result.get();
		}
		else {
			throw new RuntimeException("Did not find member ID - " + theId);
		}
		return theMember;
	}



	@Override
	public void save(Member theMember) {
		memberRepository.save(theMember);
	}

	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}

}






