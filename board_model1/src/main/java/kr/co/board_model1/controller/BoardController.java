package kr.co.board_model1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model1.command.BoardCommand;
import kr.co.board_model1.dao.BoardDao;
import kr.co.board_model1.dto.BoardDto;

@Controller
public class BoardController {
	
    @Autowired
	private BoardCommand bCommand;
    
	@RequestMapping("/list")
	public String list(Model model)
	{
		return bCommand.list(model);
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request)
	{
		return bCommand.readnum(request);
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model)
	{
		return bCommand.content(request,model);
	}
	
	@RequestMapping("/write")
	public String write()
	{
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardDto bdto)
	{
		return bCommand.write_ok(bdto);
	}
	
	@RequestMapping("/delete")
	public String delete(BoardDto bdto)
	{
		return bCommand.delete(bdto);
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model)
	{
		return bCommand.update(request,model);
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(BoardDto bdto)
	{
		return bCommand.update_ok(bdto);
	}
}
