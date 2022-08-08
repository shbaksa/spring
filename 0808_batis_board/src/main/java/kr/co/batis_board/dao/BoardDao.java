package kr.co.batis_board.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.co.batis_board.dto.BoardDto;

public interface BoardDao {
	
	public ArrayList<BoardDto> list();
	
	public void write_ok(BoardDto bdto);
	
	public void readnum(String id);
	// 가끔 String 매개변수가 하나일때 오류가 나는 경우가 있다.
	// xml 에서 param1이 아닌 value로 받는다.
	
	public BoardDto content(String id); 
	
	public BoardDto update(String id);
				
	public void update_ok(BoardDto bdto);
	
	public void delete(BoardDto bdto);
	
	public String pwdSearch(String id);
}
