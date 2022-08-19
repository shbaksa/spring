package kr.co.board_model.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.board_model.vo.BoardVo;

public interface BoardService {

	public String list(Model model);
	
	public String write_ok(BoardVo bvo);
	
	public String readnum(HttpServletRequest request);
	
	public String content(HttpServletRequest request,Model model);
	
	public String update(HttpServletRequest request,Model model);
	
	public String update_ok(BoardVo bvo);
	
	public String delete(BoardVo bvo);
	

	
	
	
	
	
	
}
