package kr.co.board_page.dao;

import java.util.ArrayList;

import kr.co.board_page.dto.BoardDto;

public interface BoardDao {

	public ArrayList<BoardDto> list(int index,int pcnt);
	
	public int getPage(int pcnt);
}
