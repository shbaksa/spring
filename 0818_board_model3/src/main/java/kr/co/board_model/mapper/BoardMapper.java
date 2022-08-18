package kr.co.board_model.mapper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.co.board_model.vo.BoardVo;

public interface BoardMapper {

	public ArrayList<BoardVo> list();
	
	public void write_ok(BoardVo bvo);
	
	public void readnum(String id);
	
	public BoardVo content(String id);
	
	public BoardVo update(String id);
	
	public void update_ok(BoardVo bvo);
	
	public void delete(int id);
	
	public String getPwd(int id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
