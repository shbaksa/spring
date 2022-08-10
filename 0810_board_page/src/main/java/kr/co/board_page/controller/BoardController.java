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
		
		if(request.getParameter("page")==null)
			page=1;
		else
			page=Integer.parseInt(request.getParameter("page"));
		
		if(request.getParameter("pcnt")==null)
			pcnt=10;
		else
			pcnt=Integer.parseInt(request.getParameter("pcnt"));
		
		
		index = (page-1)*pcnt;		
		
		pstart = page/10;
		
		if(page%10 == 0)
			pstart--;
		
		pstart = pstart*10+1;
		pend = pstart+9;
			
		chong = bdao.getPage(pcnt); // 총페이지수 
		
		if(pend>chong)
			pend=chong;
		
	
		ArrayList<BoardDto> list = bdao.list(index,pcnt);
		model.addAttribute("list",list);
		model.addAttribute("pend",pend);
		model.addAttribute("pstart",pstart);
		model.addAttribute("page",page);
		model.addAttribute("chong",chong);
		model.addAttribute("pcnt",pcnt);
		
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
	
}
