package kr.co.folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reserve")
@Controller
public class ReserveController {

	
	@RequestMapping("/content")
	public String content() {
		
		return "/reserve/content";
	}
	@RequestMapping("/delete")
	public String delete() {
		
		return "/reserve/delete";
	}
	@RequestMapping("/list")
	public String list() {
		
		return "/reserve/list";
	}
	@RequestMapping("/reserve") // 버전 5.0.7 
	public String reserve() {
		
		return "/reserve/reserve";
	}
	@RequestMapping("/update_ok")
	public String update_ok() {
		
		return "/reserve/update_ok";
	}
	@RequestMapping("/update")
	public String update() {
		
		return "/reserve/update";
	}
	@RequestMapping("/write_ok")
	public String write_ok() {
		
		return "/reserve/write_ok";
	}
	@RequestMapping("/write")
	public String write() {
		
		return "/reserve/write";
	}
}
