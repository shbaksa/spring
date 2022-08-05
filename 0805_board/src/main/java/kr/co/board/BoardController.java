package kr.co.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

	
	@RequestMapping("/")
	public String home() {
		
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		
		BoardDao bdao = new BoardDao();
		return bdao.list(model);

		
	}
	
	
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	/*@RequestMapping("/write_ok")
	public String write_ok(HttpServletRequest request , BoardDao bdao) throws Exception {

		bdao.write_ok(request);
		
		return "redirect:/list";
	}*/
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardDto bdto) throws Exception {
		
		BoardDao bdao = new BoardDao();
		return bdao.write_ok(bdto);
		
		//return "redirect:/list";
	}
	
	/*@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) throws Exception{
		
		BoardDao bdao = new BoardDao();
		bdao.readnum(request);
		
		return "redirect:/content?id="+request.getParameter("id"); // 요청의 문서와 return의 문서가 틀리면 무조건 "redirect : 를 적어준다
	}*/
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) throws Exception{
		
		BoardDao bdao = new BoardDao();
		return bdao.readnum(request);
		
		//// return "redirect:/content?id="+request.getParameter("id"); // 요청의 문서와 return의 문서가 틀리면 무조건 "redirect : 를 적어준다
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model) throws Exception {
		
		BoardDao bdao = new BoardDao();
		
		return bdao.content(request,model);

	}
	
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) throws Exception{
		
		BoardDao bdao = new BoardDao();
		return bdao.update(request, model);
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(BoardDto bdto,HttpServletRequest request) throws Exception{
		
		BoardDao bdao = new BoardDao();
		return bdao.update_ok(bdto);
		
		//return "redirect:/content?id="+request.getParameter("id");
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception{
		
		BoardDao bdao = new BoardDao();
		return bdao.delete(request); 
		
		//return "redirect:/list";
	}
}

























