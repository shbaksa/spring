package kr.co.mapper_test.boarddao;

import java.util.ArrayList;

import kr.co.mapper_test.boarddto.BoardDto;

public interface BoardDao {
   public ArrayList<BoardDto> list();
}
