package kr.co.page.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.page.service.PageService;
import kr.co.page.vo.PageVo;

@Controller
public class PageController {

	@Autowired
	@Qualifier("bs")
	private PageService service;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		
		return service.list(request,model);
	}
	
	@RequestMapping("/readnum")
	public String readnum(PageVo pvo) {
		
		return service.readnum(pvo);
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request , Model model) {
		
		return service.content(request,model);
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		
		return service.update(request,model);
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(PageVo pvo) {
		
		return service.update_ok(pvo);
	}
	
	@RequestMapping("/delete")
	public String delete(PageVo pvo) {
		
		return service.delete(pvo);
	}
	
	@RequestMapping("/write")
	public String write(PageVo pvo,Model model) {
		
		model.addAttribute("pvo",pvo);		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(PageVo pvo) {
		
		return service.write_ok(pvo);
	}
	
	
	
	
	
	
	
	
	
}
