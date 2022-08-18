package kr.co.board_model3.mapper;

import java.util.ArrayList;

import kr.co.board_model3.vo.BoardVO;

public interface BoardMapper {
   // list를 읽어오는 추상메소드
	public ArrayList<BoardVO>  list();
	public void readnum(String id);
	public BoardVO content(String id);
	public void delete(int id);
	public BoardVO update(String id);
	public void update_ok(BoardVO bvo);
	public void write_ok(BoardVO bvo);
	
	public String getPwd(int id);
}
