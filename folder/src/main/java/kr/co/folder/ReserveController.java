package kr.co.folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reserve")
@Controller
public class ReserveController {
   
	@RequestMapping("/reserve")
	public String reserve()
	{
		System.out.println("하하하");
		return "/reserve/reserve";
		
	}
	@RequestMapping("/reserve_next")
	public String reserve_next()
	{
		return "/reserve/reserve_next";
	}
	
	@RequestMapping("/reserve_view")
	public String reserve_view()
	{
		return "/reserve/reserve_view";
	}
	
}
