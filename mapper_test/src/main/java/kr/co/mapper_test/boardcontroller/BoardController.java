package kr.co.mapper_test.boardcontroller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mapper_test.boarddao.BoardDao;
import kr.co.mapper_test.boarddto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/board/list")
	public String list(Model model)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> list=bdao.list();
		model.addAttribute("list",list);
		return "/board/list";
	}
}
