package kr.co.data;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
   
	@RequestMapping("/")
	public String home()
	{
		return "/home";
	}
	
	@RequestMapping("/data1")
	public String data1(HttpServletRequest request, Model model)
	{
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		request.setAttribute("phone", "010");
		
		return "/data1";
	}
	
	@RequestMapping("/data2")
	public String data2(@RequestParam("name") String name, @RequestParam("age") String age, Model model)
	{
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "/data2";
	}
	
	@RequestMapping("/data3")
	public String data3(String name, String age, Model model)
	{
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "/data2";
	}
	
	@RequestMapping("/data4")
	public String data4(MyDto mdto , Model model)
	{
		model.addAttribute("name",mdto.getName());
		model.addAttribute("age",mdto.getAge());
		model.addAttribute("phone",mdto.getPhone());
		model.addAttribute("juso",mdto.getJuso());
		
		// dto를 보낸다
		model.addAttribute("mdto",mdto);
 		
		return "/data4";
	}
	
	@RequestMapping("/data5/{name}/{age}")
	public String data5(@PathVariable String name, @PathVariable String age,Model model )
	{
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "/data5";
	}
}









