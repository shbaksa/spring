package kr.co.board_model1.dao;

import java.util.ArrayList;

import kr.co.board_model1.dto.BoardDto;

public interface BoardDao {
   public ArrayList<BoardDto> list();
   public void readnum(String id);
   public BoardDto content(String id);
   public void write_ok(BoardDto bdto);
   public String getPwd(int id);
   public void delete(int id);
   public void update_ok(BoardDto bdto);
}
