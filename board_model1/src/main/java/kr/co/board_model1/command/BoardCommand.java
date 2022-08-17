package kr.co.board_model1.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model1.dao.BoardDao;
import kr.co.board_model1.dto.BoardDto;

 
@Service
public class BoardCommand {
	@Autowired
    private SqlSession sqlSession;
	
	public String list(Model model)
	{
		// DB처리및 각종 처리
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> list=bdao.list();
		model.addAttribute("list",list);
		return "/list";
	}
	
	public String readnum(HttpServletRequest request)
	{
		String id=request.getParameter("id");
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		bdao.readnum(id);
		
		return "redirect:/content?id="+id;
	}
	
	public String content(HttpServletRequest request,Model model)
	{
		String id=request.getParameter("id");
		
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		BoardDto bdto=bdao.content(id);
		bdto.setContent(bdto.getContent().replace("\r\n", "<br>"));
		model.addAttribute("bdto",bdto);
		return "/content";
	}
	
	public String write_ok(BoardDto bdto)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		bdao.write_ok(bdto);
		return "redirect:/list";
	}
	
	public String delete(BoardDto bdto)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		String dbpwd=bdao.getPwd(bdto.getId()); // db에 있는 pwd
		if(dbpwd.equals(bdto.getPwd()))
		{
			bdao.delete(bdto.getId());
			return "redirect:/list";
		}
		else
		{
			return "redirct:/content?id="+bdto.getId();
		}
		
	}
	
	public String update(HttpServletRequest request,Model model)
	{
		String id=request.getParameter("id");
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		BoardDto bdto=bdao.content(id); 
		model.addAttribute("bdto",bdto);
		return "/update";
	}
	
	public String update_ok(BoardDto bdto)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		String dbpwd=bdao.getPwd(bdto.getId());
		if(dbpwd.equals(bdto.getPwd()))
		{
			 bdao.update_ok(bdto);
			 return "redirect:/content?id="+bdto.getId();
		}
		else
		{
			 return "redirect:/update?id="+bdto.getId();
		}
	}
}
