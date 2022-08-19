package kr.co.board_end.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.co.board_end.vo.BoardVO;

public interface BoardMapper {
   public ArrayList<BoardVO> list(String sel, String sword,int index);
   public int getChong(String sel, String sword);
   public void readnum(String id);
   public BoardVO content(String id);
}
