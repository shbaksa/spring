package kr.co.board_model3.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.board_model3.vo.BoardVO;

public interface BoardService {
   public String list(Model model);
/*   public ArrayList<BoardVO> list2();*/
   public String readnum(HttpServletRequest request);
   public String content(HttpServletRequest request,Model model);
   public String delete(BoardVO bvo);
   public String update(HttpServletRequest request,Model model);
   public String update_ok(BoardVO bvo);
   public String write_ok(BoardVO bvo);
   
}
