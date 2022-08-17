package kr.co.board_model.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model.dto.BoardDto;
import kr.co.board_model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("bs")
	private BoardService bservice;
	
	@RequestMapping("/list")
	public String list(Model model) {
			
		return bservice.list(model);
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,Model model) {
		
		return bservice.content(request,model);
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) {
		
		return bservice.readnum(request);
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model) {
		
		return bservice.update(request, model);
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(HttpServletRequest request,BoardDto bdto) {
		
		return bservice.update_ok(request, bdto);
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		return bservice.delete(request);
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardDto bdto) {
		
		return bservice.write_ok(bdto);
	}
}













