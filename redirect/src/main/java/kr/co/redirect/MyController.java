package kr.co.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
   
	@RequestMapping("/")
	public String home()
	{
		return "/index";
	}
	
	@RequestMapping("/member")
	public String member(Model model)
	{
		String name="배트맨";
		int age=33;
		String phone="010-1234-5678";
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("phone",phone);
		
		return "/member";
	}
	
	@RequestMapping("/member_update")
	public String member_update()
	{
		// 수정처리
		
		return "redirect:/member";
	}
}










