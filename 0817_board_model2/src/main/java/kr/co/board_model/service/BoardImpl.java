package kr.co.board_model.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.board_model.dao.BoardDao;
import kr.co.board_model.dto.BoardDto;

@Service
@Qualifier("bs")
public class BoardImpl implements BoardService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String list(Model model){
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		ArrayList<BoardDto> list = bdao.list();
		model.addAttribute("list",list);
		
		return "/list";
	}
	
	@Override
	public String readnum(HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		bdao.readnum(request.getParameter("id"));
		
		return "redirect:/content?id="+request.getParameter("id");
	}
	
	@Override
	public String content(HttpServletRequest request,Model model) {
		
		int chk=0;
		if(request.getParameter("chk")!=null)
			chk=1;
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);		
		BoardDto bdto = bdao.content(request.getParameter("id"));		
		bdto.setContent(bdto.getContent().replace("\r\n", "<br>"));
		model.addAttribute("bdto",bdto);
		model.addAttribute("chk",chk);
		
		return "/content";
	}
	
	@Override
	public String getPwd(int id) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		String dbpwd = bdao.getPwd(id);
		
		return dbpwd;
	}
	
	@Override
	public String update(HttpServletRequest request,Model model) {
		
		int chk=0;
		if(request.getParameter("chk")!=null)
			chk=1;
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		BoardDto bdto = bdao.update(request.getParameter("id"));
		model.addAttribute("bdto",bdto);
		model.addAttribute("chk",chk);
		
		return "/update";
	}
	
	@Override
	public String update_ok(HttpServletRequest request,BoardDto bdto) {
		
		String id = request.getParameter("id");
		String dbpwd = getPwd(Integer.parseInt(id));
		String pwd = request.getParameter("pwd");
				
		if(pwd.equals(dbpwd)) {
			BoardDao bdao = sqlSession.getMapper(BoardDao.class);
			bdao.update_ok(bdto);
			return "redirect:/content?id="+id;
		}
		else
			return "redirect:/update?id="+id+"&chk=1";
	}
	
	@Override
	public String delete(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String dbpwd = getPwd(Integer.parseInt(id));
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals(dbpwd)) {
			BoardDao bdao = sqlSession.getMapper(BoardDao.class);
			bdao.delete(id);
			return "redirect:/list";
		}
		else
			return "redirect:/content?id="+id+"&chk=1";
	}
	
	@Override
	public String write_ok(BoardDto bdto) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.write_ok(bdto);
		
		return "redirect:/list";
	}
}
















