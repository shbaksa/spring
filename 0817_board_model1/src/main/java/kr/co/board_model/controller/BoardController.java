package kr.co.board_model.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model.command.BoardCommand;
import kr.co.board_model.dto.BoardDto;

@Controller
public class BoardController { // 맵핑만 담당
	
	@Autowired
	private BoardCommand bCommand;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		return bCommand.list(model);
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) {
		
		return bCommand.readnum(request);
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,Model model) {
		
		return bCommand.content(request,model);
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model) {
		
		return bCommand.update(request,model);
	}
	
	@RequestMapping("/update_ok")
	public String updatd_ok(BoardDto bdto) {
		
		return bCommand.update_ok(bdto);
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		return bCommand.delete(request);
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("write_ok")
	public String write_ok(BoardDto bdto) {
		
		return bCommand.write_ok(bdto);
	}
}































