package kr.co.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
   
	@RequestMapping("/")
	public String home()
	{
		return "/input";
	}
	
	@RequestMapping("/input")
	public String input()
	{
		return "/input";
	}
	
	@RequestMapping("/sungview")
	public String sungview(SungDto sdto,Model model)
	{
		int total=sdto.getKor()+sdto.getEng()+sdto.getMat();
		int avg=total/3;
		
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		model.addAttribute("name",sdto.getName());
		return "/sungview";
	}
}








