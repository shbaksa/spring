package kr.co.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    
	@RequestMapping("/write")
	public String write()
	{
		return "/write";
	}
	
	/*@RequestMapping("/write_ok")
	public String write_ok(HttpServletRequest request) throws Exception
	{
		BoardDao bdao=new BoardDao();
		bdao.write_ok(request);
		
		return "redirect:/list";
	}*/
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardDto bdto) throws Exception
	{
		BoardDao bdao=new BoardDao();
		return bdao.write_ok(bdto);
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception
	{
		BoardDao bdao=new BoardDao();
		return bdao.list(model);
		
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) throws Exception
	{
		BoardDao bdao=new BoardDao();
		return bdao.readnum(request);
		
	} // 요청의 문서와  return의 문서가 틀리면 무조건  redirect:를 적어준다
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model) throws Exception
	{
		// 하나의 레코드를 읽어오는 부분
		BoardDao bdao=new BoardDao();
		return bdao.content(request,model);
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception
	{
		BoardDao bdao=new BoardDao();
		return bdao.delete(request);
	  
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model) throws Exception
	{
		BoardDao bdao=new BoardDao();
		return bdao.update(request,model);
 		
	}
	@RequestMapping("/update_ok")
	public String update_ok(BoardDto bdto) throws Exception
	{ 
		BoardDao bdao=new BoardDao();
		return bdao.update_ok(bdto); 
		
	}
}










