package kr.co.board_page.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_page.dao.BoardDao;
import kr.co.board_page.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		int page,index,pstart,pend,chong,pcnt;
		
		
		
		if(request.getParameter("pcnt")==null)
			pcnt=10;
		else
			pcnt=Integer.parseInt(request.getParameter("pcnt"));
		
		if(request.getParameter("page")==null)
			page=1;
		else
			page=Integer.parseInt(request.getParameter("page"));
		
		// list를 가져올때 검색필드와 검색단어를 같이 전달한다
		
		/*if(request.getParameter("sel")==null && request.getParameter("sword")==null) {
			sel=" ";
			sword=" ";
		}
		else {
			sel = "where "+request.getParameter("sel");
			sword = "like '%"+request.getParameter("sword")+"%'";
		}*/
		
		String sel="";
		String sword="";
		if(request.getParameter("sel")==null) {
			model.addAttribute("sel",0);
			sel = "title";			
		}
		else {
			sel = request.getParameter("sel");
			model.addAttribute("sel",sel);
		}
		if(request.getParameter("sword")==null)
			sword = "";
		else
			sword = request.getParameter("sword");
		
		
		index = (page-1)*pcnt;		
		
		pstart = page/10;
		
		if(page%10 == 0)
			pstart--;
		
		pstart = pstart*10+1;
		pend = pstart+9;
			
		chong = bdao.getPage(pcnt,sel,sword); // 총페이지수 
		
		if(pend>chong)
			pend=chong;
		
		// list를 가져올때 검색필드와 검색단어를 같이 전달한다
		
		/*if(request.getParameter("sel")==null && request.getParameter("sword")==null) {
			sel=" ";
			sword=" ";
		}
		else {
		sel = "where "+request.getParameter("sel");
		sword = "like '%"+request.getParameter("sword")+"%'";
		}*/
		
		
		
	
		ArrayList<BoardDto> list = bdao.list(sel,sword,index,pcnt);
		model.addAttribute("list",list);
		model.addAttribute("pend",pend);
		model.addAttribute("pstart",pstart);
		model.addAttribute("page",page);
		model.addAttribute("chong",chong);
		model.addAttribute("pcnt",pcnt);
		model.addAttribute("sword",sword);
		
		return "/list";
	}
	
	
	
	// 기존
	
	/*@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		int page,index,pstart,pend,chong,pcnt;
		
		if(request.getParameter("page")==null)
			page=1;
		else
			page=Integer.parseInt(request.getParameter("page"));
		
		
		
		
		index = (page-1)*10;		
		pstart = page/10;
		
		if(page%10 == 0)
			pstart--;
		
		pstart = pstart*10+1;
		pend = pstart+9;
			
		chong = bdao.getPage();
		if(pend>chong)
			pend=chong;
		
	
		ArrayList<BoardDto> list = bdao.list(index);
		model.addAttribute("list",list);
		model.addAttribute("pend",pend);
		model.addAttribute("pstart",pstart);
		model.addAttribute("page",page);
		model.addAttribute("chong",chong);
		
		return "/list";
	}
	*/
	
	@RequestMapping("/test")
	public String test() {
		
		return "/test";
	}
	
	@RequestMapping("/test_ok")	
	public String test_ok(Model model) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		int num = bdao.getCheck();
		model.addAttribute("num",num);
		return "/test_ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
