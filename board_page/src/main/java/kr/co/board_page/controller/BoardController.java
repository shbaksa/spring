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
	public String list(Model model,HttpServletRequest request)
	{
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		int page,start;
		
		
		// 한 페이지의 레코드 갯수를 구하여 변수에 저장
		int pcnt;
		if(request.getParameter("pcnt")==null)
		    pcnt=10;
		else
			pcnt=Integer.parseInt(request.getParameter("pcnt"));
		
		// 원하는 페이지의 시작 인덱스값을 구하기
		if(request.getParameter("page")==null)
			page=1;
		else
			page=Integer.parseInt(request.getParameter("page"));
		
		start=(page-1)*pcnt;
				
		
		// 사용자가 페이지를 이동하기 위해 출력하는 범위
		// pstart, pend
		int pstart,pend;
		
		pstart=page/10; 
		if(page%10 == 0)
			pstart--;
		
		pstart=pstart*10+1;
		pend=pstart+9;
		
		// 총페이지를 구한후 view에 전달
		int chong=bdao.getChong(pcnt);
		
		// 총페이지보다 pend가 크다면  값을 변경
		if(chong < pend)
			pend=chong;
			
		ArrayList<BoardDto> list=bdao.list(start,pcnt);
		model.addAttribute("list",list);
		model.addAttribute("page",page); // 현재 페이지
		model.addAttribute("pstart",pstart);
		model.addAttribute("pend",pend);
		model.addAttribute("chong",chong); // 총페이지
		model.addAttribute("pcnt",pcnt);  // 페이지당 레코드 갯수
		return "/list";
	}
}
