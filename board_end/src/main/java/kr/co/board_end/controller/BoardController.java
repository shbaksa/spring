package kr.co.board_end.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_end.service.BoardService;
import kr.co.board_end.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("bs")
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request)
	{
		// page의 값을 받아여 페이지 처리 : request
		return  service.list(model,request);
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request)
	{
		return service.readnum(request);
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,Model model)
	{
		return service.content(request,model);
	}
}









