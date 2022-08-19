package kr.co.batis_board.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.batis_board.dao.BoardDao;
import kr.co.batis_board.dto.BoardDto;

@Controller
public class BoardController {
   
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> list=bdao.list();
		
		model.addAttribute("list",list);
		return "/list";
	}
	
	@RequestMapping("/write")
	public String write()
	{
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardDto bdto)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		bdao.write_ok(bdto);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request)
	{
		String id=request.getParameter("id");
	    // 조회수 증가 동작
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		bdao.readnum(id);
		
		return "redirect:/content?id="+id;
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,Model model)
	{
		String id=request.getParameter("id");
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		BoardDto bdto=bdao.content(id);
		bdto.setContent(bdto.getContent().replace("\r\n", "<br>"));
		// 하나의 레코드를 model에 추가
		model.addAttribute("bdto",bdto);
		
		return "/content";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardDto bdto)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		String dbpwd=bdao.getpwd(bdto.getId());
		if(bdto.getPwd().equals(dbpwd))
		{
			bdao.delete(bdto);
			
			return "redirect:/list";
		}
		else
		{
			return "redirect:/content?id="+bdto.getId();
		}
		
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model)
	{
		String id=request.getParameter("id");
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		BoardDto bdto=bdao.update(id);
		model.addAttribute("bdto",bdto);
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(BoardDto bdto)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);	
		// db에 있는 비밀번호 가져오기
		String dbpwd=bdao.getpwd(bdto.getId());
		if(bdto.getPwd().equals(dbpwd))  // 폼에입력비밀번호  == db에 있는 비밀번호
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










