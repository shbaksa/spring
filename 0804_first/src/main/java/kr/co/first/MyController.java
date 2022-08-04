package kr.co.first;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	
	
	@RequestMapping("/")
	public String home() {
		
		return "/input";
	}
	
	@RequestMapping("/input")
	public String input() {
		
		return "input";
	}
	
	@RequestMapping("/sungview")
	public String sungview(HttpServletRequest request, Model model) {
		
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		String name = request.getParameter("name");
		
		int hap = kor+eng+mat;
		int avg = hap/3;
		
		model.addAttribute("name",name);
		model.addAttribute("hap",hap);
		model.addAttribute("avg",avg);
		
		
		return "/sungview";
	}
}
