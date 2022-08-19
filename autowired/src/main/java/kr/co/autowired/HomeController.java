package kr.co.autowired;
 
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired  // xml을 통한 클래스의 객체생성과 값을 할당
	private Student student1,student2;
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		 
		Student student=new Student();
		student.setName("hong");
		student.setHakbun("20220105");
		student.setAge(33);
		
		model.addAttribute("student",student);
		model.addAttribute("student1",student1);
		model.addAttribute("student2",student2);
		
		return "home";
	}
	
}
