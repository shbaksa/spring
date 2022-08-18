package kr.co.board_model3.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.board_model3.mapper.BoardMapper;
import kr.co.board_model3.vo.BoardVO;

@Service
@Qualifier("bs")
public class BoardServiceImpl implements BoardService {
   
	@Autowired
	private BoardMapper mapper;

	@Override
	public String list(Model model) {
		// board테이블에 있는 내용을 읽어오는 처리
		// 내용을 읽어오고 난 후 model을 통해 view에 전달
		//ArrayList<BoardVO> list=mapper.list();
		//model.addAttribute("list",list);
		model.addAttribute("list",mapper.list());
		// view의 값을 리턴
		return "/list";
	}

	@Override
	public String readnum(HttpServletRequest request) {
		String id=request.getParameter("id");
		mapper.readnum(id);
		return "redirect:/content?id="+id;
	}

	@Override
	public String content(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		model.addAttribute("bvo",mapper.content(id));
		return "/content";
	}

	@Override
	public String delete(BoardVO bvo) {
		String dbpwd=mapper.getPwd(bvo.getId());
		if(dbpwd.equals(bvo.getPwd()))
		{
			mapper.delete(bvo.getId());
			return "redirect:/list";
		}
		else
		{
			return "redirect:/content?id="+bvo.getId();
		}
		
	}

	@Override
	public String update(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		model.addAttribute("bvo",mapper.update(id));
		return "/update";
	}

	@Override
	public String update_ok(BoardVO bvo) {
		String dbpwd=mapper.getPwd(bvo.getId());
		if(dbpwd.equals(bvo.getPwd()))
		{
			mapper.update_ok(bvo);
			return "redirect:/content?id="+bvo.getId();
		}
		else
		{
			return "redirect:/update?id="+bvo.getId();
		}
		
	}

	@Override
	public String write_ok(BoardVO bvo) {
		mapper.write_ok(bvo);
		return "redirect:/list";
	}

	
	
	
	
	/*@Override
	public ArrayList<BoardVO> list2() {
		
		ArrayList<BoardVO> list=mapper.list(); 
		return list;
	}*/
	
	// 메소드를 실행한 후 제어권이 컨트롤러로 넘어간다.
	// return에 view를 전달하자
}









