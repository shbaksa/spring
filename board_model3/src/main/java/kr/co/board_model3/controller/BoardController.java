package kr.co.board_model3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board_model3.service.BoardService;
import kr.co.board_model3.vo.BoardVO;

@Controller
public class BoardController {
	
    @Autowired
    @Qualifier("bs")
    private BoardService service;
    
    @RequestMapping("/list")
    public String list(Model model)
    {
    	// 테이블의 내용을 읽어오는것
    	// 내용을 view에전달 (model)
    	// return을 통해 view를 전달
    	return service.list(model);
    }
    
    @RequestMapping("/readnum")
    public String readnum(HttpServletRequest request)
    {
    	return service.readnum(request);
    }
    
    @RequestMapping("/content")
    public String content(HttpServletRequest request,Model model)
    {
        return service.content(request,model);	
    }
    
    @RequestMapping("/delete")
    public String delete(BoardVO bvo)
    {
    	return service.delete(bvo);
    }
    
    @RequestMapping("/update")
    public String update(HttpServletRequest request,Model model)
    {
    	return service.update(request,model);
    }
    
    @RequestMapping("/update_ok")
    public String update_ok(BoardVO bvo)
    {
    	return service.update_ok(bvo);
    }
    
    @RequestMapping("/write")
    public String write()
    {
    	return "/write";
    }
    
    @RequestMapping("/write_ok")
    public String write_ok(BoardVO bvo)
    {
    	return service.write_ok(bvo);
    }
 
}
