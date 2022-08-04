package kr.co.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // 현재 클래스는 컨트롤러 파일로 정의
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 정보확인용도 => 콘솔창에 정보를 확인 => System.out.printIn()보다 편하다.

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	// 사용자의 요청을 처리하는 어노테이션 : 사용자가 문서를 요청하면 @RequestMapping에서 일치하는 요청을 검색
	// 사용자가 get방식으로 /를 요청한다.
	@RequestMapping(value = "/", method = RequestMethod.GET) // value : 사용자 요청문서, method : post,get
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// view폴더에 만들어진 문서를 사용자에게 보여주기 위해서는 controller에서 매핑을 꼭 해줘야 된다.
	@RequestMapping(value = "/my", method = RequestMethod.POST)
	public String my() {

		// 처리부분이 코딩
		return "/my";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {

		return "/form";
	}
	
	@RequestMapping("/your") // get, post 둘다 가능
	public String your() {
		
		return "/your";
	}
	
	// 4.x 버전이상에서는 GetMapping, PostMapping을 지원
	
	@GetMapping("/test")
	public String test() {
		
		return "/test";
	}
	
	@PostMapping("/test2")
	public String test2() {
		
		return "/test2";
	}

}






















