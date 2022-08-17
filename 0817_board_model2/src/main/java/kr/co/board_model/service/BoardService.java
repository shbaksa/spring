package kr.co.board_model.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.board_model.dto.BoardDto;

public interface BoardService {
	
	public String list(Model model);
	
	public String readnum(HttpServletRequest request);
	
	public String content(HttpServletRequest request,Model model);
	
	public String getPwd(int id);
	
	public String update(HttpServletRequest request,Model model);
	
	public String update_ok(HttpServletRequest request,BoardDto bdto);
	
	public String delete(HttpServletRequest request);
	
	public String write_ok(BoardDto bdto);

}
