package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.entity.Member;
import com.luv2code.springboot.thymeleafdemo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

	private MemberService memberService;

	public MemberController(MemberService theMemberService) {
		memberService = theMemberService;
	}

	@GetMapping("/homepage")
	public String mainWebPage(){
		return "employees/main";
	}


	@GetMapping("/list")
	public String listMembers(Model theModel) {
		List<Member> theMembers = memberService.findAll();
		theModel.addAttribute("members", theMembers);
		return "members/list-members";
	}

	@GetMapping("/showform")
	public String showFormForAdd(Model theModel) {
		Member theMember = new Member();
		theModel.addAttribute("member", theMember);
		return "members/member-form";
	}


	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("member") Member theMember) {
		int remainingTimeInDays = theMember.getRemainingtime();
		theMember.setRemainingtime(remainingTimeInDays);
		memberService.save(theMember);
		return "redirect:/members/list";
	}


	@GetMapping("/showformForUpdate")
	public String showFromForUpdate(@RequestParam("memberId") int theId, Model theModel) {
		Member theMember = memberService.findById(theId);
		theModel.addAttribute("member", theMember);
		return "members/member-form";
	}



	@GetMapping("/delete")
	public String delete(@RequestParam("memberId") int theId){
		memberService.deleteById(theId);
		return  "redirect:/members/list";
	}

	@GetMapping("/search")
	public String search(@RequestParam(value = "term", required = false, defaultValue = "") String searchTerm, Model theModel) {
		List<Member> searchResults = memberService.findMembersBySearchTerm(searchTerm);
		theModel.addAttribute("searchTerm", searchTerm);
		theModel.addAttribute("searchResults", searchResults);
		return "members/search";
	}

}










