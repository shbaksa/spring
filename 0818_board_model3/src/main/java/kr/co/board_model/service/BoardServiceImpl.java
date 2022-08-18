package kr.co.board_model.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.board_model.mapper.BoardMapper;
import kr.co.board_model.vo.BoardVo;

@Service
@Qualifier("bs")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public String list(Model model) {
		
		//ArrayList<BoardVo> list =  mapper.list();
		//model.addAttribute("list",list);
		
		model.addAttribute("list",mapper.list());
		
		return "/list";
	}
	
	@Override
	public String write_ok(BoardVo bvo) {
		
		mapper.write_ok(bvo);
		
		return "redirect:/list";
	}
	
	@Override
	public String readnum(HttpServletRequest request) {
		
		mapper.readnum(request.getParameter("id"));
		
		return "redirect:/content?id="+request.getParameter("id");
	}
	
	@Override
	public String content(HttpServletRequest request,Model model) {
		
		int chk=0;
		if(request.getParameter("chk")!=null)
			chk=1;	
		
		BoardVo bvo = mapper.content(request.getParameter("id"));
		bvo.setContent( bvo.getContent().replace("\r\n", "<br>") );
		model.addAttribute("bvo",bvo);
		model.addAttribute("chk",chk);
		
		return "/content";
	}
	
	public String getPwd(int id) {
		
		String dbpwd = mapper.getPwd(id);
		
		return dbpwd;
	}
	
	@Override
	public String update(HttpServletRequest request, Model model) {
		
		int chk=0;
		if(request.getParameter("chk")!=null)
			chk=1;
		
		BoardVo bvo = mapper.update(request.getParameter("id"));
		model.addAttribute("bvo",bvo);
		model.addAttribute("chk",chk);
		
		return "/update";
	}
	
	/*@Override
	public String update_ok(BoardVo bvo) {
		
		mapper.update_ok(bvo);
		
		return "redirect:/content?id="+bvo.getId();
	}
	
	@Override
	public String delete(HttpServletRequest request) {
		
		mapper.delete(request.getParameter("id"));
		
		return "redirect:/list";
	}*/
	
	@Override
	public String update_ok(BoardVo bvo) {
		
		String dbpwd = getPwd(bvo.getId());
		String pwd = bvo.getPwd();
		
		if(pwd.equals(dbpwd)) {
			
			mapper.update_ok(bvo);
			
			return "redirect:/content?id="+bvo.getId();
		}
		else
			return "redirect:/update?id="+bvo.getId()+"&chk=1";	
		
	}
	
	@Override
	public String delete(BoardVo bvo) {
		
		String dbpwd = getPwd(bvo.getId());
		String pwd = bvo.getPwd();
		
		if(pwd.equals(dbpwd)) {
			
			mapper.delete(bvo.getId());
			
			return "redirect:/list";
		}
		else
			return "redirect:/content?id="+bvo.getId()+"&chk=1";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
