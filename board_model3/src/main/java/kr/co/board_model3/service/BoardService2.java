package kr.co.board_model3.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.board_model3.vo.BoardVO;

public interface BoardService2 {
   public ArrayList<BoardVO> list(); 
   public void readnum(String id);
   public BoardVO content(String id);
   public void delete(int id);
   public BoardVO update(String id);
   public void update_ok(BoardVO bvo);
   public void write_ok(BoardVO bvo);
   public String getPwd(int id);
   
}
