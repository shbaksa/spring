package kr.co.board_page.dao;

import java.util.ArrayList;

import kr.co.board_page.dto.BoardDto;

public interface BoardDao {
   public ArrayList<BoardDto> list(int start,int pcnt);
   public int getChong(int pcnt);
}
