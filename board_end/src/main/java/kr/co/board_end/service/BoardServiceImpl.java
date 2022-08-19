package kr.co.board_end.service;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.board_end.mapper.BoardMapper;
import kr.co.board_end.vo.BoardVO;

@Service
@Qualifier("bs")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public String list(Model model,HttpServletRequest request) {
		// DB관련, 처리등을 여기서 한다.
		// view에 전달할 값은 model을 통해 전달
		
		// 페이징 처리 추가
		// 1. 페이지에 해당하는 레코드를 가져오기 => limit에 사용될 index값을 구해서 전달 : limit 시작인덱스 , 레코드갯수
        int page=Integer.parseInt(request.getParameter("page"));		
		int index=(page-1)*10;
		
		// 2. 사용자에게 보여줄 링크를 처리하기 위한 값 구하기 => pstart, pend, chong 
		int pstart,pend,chong;
		
		pstart=page/10;
		if(page%10 == 0)
			pstart=pstart-1;
		
		pstart=pstart*10+1;
	    pend=pstart+9;
	    
	    // 검색할 필드와 검색단어를 쿼리에 넘겨주기
	    // null값이 오는 경우
	    String sel,sword;
	    if(request.getParameter("sel")==null)
	    {
	    	sel="id";
	    	sword="";
	    }
	    else
	    {
	    	sel=request.getParameter("sel");
	    	sword=request.getParameter("sword");
	    }

	    // 총페이지값 구하기
	    chong=mapper.getChong(sel,sword);
	    
	    // pend이 총페이지보다 크다면
	    if(pend > chong)
	    {
	    	pend=chong;
	    }
		
		ArrayList<BoardVO> list=mapper.list(sel,sword,index);
		model.addAttribute("list",list);
		model.addAttribute("pstart",pstart);
		model.addAttribute("pend",pend);
		model.addAttribute("chong",chong);
		model.addAttribute("page",page);
		model.addAttribute("sel",sel);
		model.addAttribute("sword",sword);
		// view의 값을 전달
		return "/list";
	}

	@Override
	public String readnum(HttpServletRequest request) {
		String id=request.getParameter("id");
		String page=request.getParameter("page");
		String sel=request.getParameter("sel");
		String sword=request.getParameter("sword");
		sword=URLEncoder.encode(sword);
		mapper.readnum(id);
		System.out.println(sword);
		return "redirect:/content?id="+id+"&page="+page+"&sel="+sel+"&sword="+sword;
	}

	@Override
	public String content(HttpServletRequest request,Model model) {
		String id=request.getParameter("id");
		String page=request.getParameter("page");
		String sel=request.getParameter("sel");
		String sword=request.getParameter("sword");
		
		model.addAttribute("bvo",mapper.content(id));
		model.addAttribute("page",page);
		model.addAttribute("sel",sel);
		model.addAttribute("sword",sword);
		System.out.println(sword);
		return "/content";
	}

}





