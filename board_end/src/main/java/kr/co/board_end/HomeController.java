package kr.co.board_end;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		 	
		return "redirect:/list?page=1";
	}
	
	
	@RequestMapping("aa")
	public String aa()
	{
		return "/aa";
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,Model model)
	{
		model.addAttribute("name",request.getParameter("name"));
		model.addAttribute("food","짜장면");
		return "/test";
	}
	
    @RequestMapping("/target")
    public void target(PrintWriter out)
    {
    	String str=URLEncoder.encode("안녕하세요");
    	out.print(str);
    }
	
}
