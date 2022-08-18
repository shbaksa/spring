package kr.co.board_model3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model3.service.BoardService2;
import kr.co.board_model3.vo.BoardVO;
@Controller
public class BoardController2 {

    @Autowired
    @Qualifier("bs2")
    private BoardService2 service2;
    
    @RequestMapping("/list2")
    public String list2(Model model)
    {
    	ArrayList<BoardVO> list=service2.list();
    	model.addAttribute("list",list);
    	return "/list2";
    }
    
    @RequestMapping("/readnum2")
    public String readnum2(HttpServletRequest request)
    {
    	String id=request.getParameter("id");
    	service2.readnum(id);
    	return "redirect:/content2?id="+id;
    }
    
    @RequestMapping("/content2")
    public String content2(HttpServletRequest request,Model model)
    {
        String id=request.getParameter("id");
        BoardVO bvo=service2.content(id);
        model.addAttribute("bvo",bvo);
    	return "/content2";
    }
    
    @RequestMapping("/delete2")
    public String delete2(BoardVO bvo)
    {
    	String dbpwd=service2.getPwd(bvo.getId());
    	if(dbpwd.equals(bvo.getPwd()))
    	{
    		service2.delete(bvo.getId());
    		return "redirect:/list2";
    	}
    	else
    	{
    		return "redirect:/content2?id="+bvo.getId();
    	}
    }
    
    @RequestMapping("/update2")
    public String update2(HttpServletRequest request,Model model)
    {
    	String id=request.getParameter("id");
    	BoardVO bvo=service2.update(id);
    	model.addAttribute("bvo",bvo);
    	return "/update2";
    }
    
    @RequestMapping("/update_ok2")
    public String update_ok2(BoardVO bvo)
    {
    	String dbpwd=service2.getPwd(bvo.getId());
    	if(dbpwd.equals(bvo.getPwd()))
    	{
    		service2.update_ok(bvo);
    		return "redirect:/content2?id="+bvo.getId();
    	}
    	else
    	{
    		return "redirect:/update2?id="+bvo.getId();
    	}
    }
    
    @RequestMapping("/write2")
    public String write2()
    {
    	return "/write2";
    }
    
    @RequestMapping("/write_ok2")
    public String write_ok2(BoardVO bvo)
    {
    	service2.write_ok(bvo);
    	return "redirect:/list2";
    }
}





