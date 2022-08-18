package kr.co.board_model.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model.service.BoardService;
import kr.co.board_model.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("bs")
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		return service.list(model);
	}
	
	@RequestMapping("write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardVo bvo) {
		
		return service.write_ok(bvo);
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) {
		
		return service.readnum(request);
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,Model model) {
		
		return service.content(request,model);
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model) {
		
		return service.update(request,model);
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(BoardVo bvo) {
		
		return service.update_ok(bvo);
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVo bvo) {
		
		return service.delete(bvo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
