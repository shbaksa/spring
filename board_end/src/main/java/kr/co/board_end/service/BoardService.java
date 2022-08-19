package kr.co.board_end.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.board_end.vo.BoardVO;

public interface BoardService {
   public String list(Model model,HttpServletRequest request);
   public String readnum(HttpServletRequest request);
   public String content(HttpServletRequest request,Model model);
}
