package kr.co.folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TourController {

	@RequestMapping("/tour/content")
	public String contet() {
		
		return "/tour/content";
	}
	@RequestMapping("/tour/delete")
	public String delete() {
		
		return "/tour/delete";
	}
	@RequestMapping("/tour/list")
	public String list() {
		
		return "/tour/list";
	}
	@RequestMapping("/tour/reserve")
	public String reserve() {
		
		return "/tour/reserve";
	}
	@RequestMapping("/tour/update_ok")
	public String update_ok() {
		
		return "/tour/update_ok";
	}
	@RequestMapping("/tour/update")
	public String update() {
		
		return "/tour/update";
	}
	@RequestMapping("/tour/write_ok")
	public String write_ok() {
		
		return "/tour/write_ok";
	}
	@RequestMapping("/tour/write")
	public String write() {
		
		return "/tour/write";
	}
}
