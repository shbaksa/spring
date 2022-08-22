package kr.co.shop.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.shop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	@Qualifier("ps")
	private ProductService service;
	
	@RequestMapping("/product/pro_write")
	public String pro_write(Model model) {
		
		// 대분류의 내용은 읽어온다
		
		return service.pro_write(model);
	}
	
	@RequestMapping("/product/getJung")
	public void getJung(PrintWriter out, HttpServletRequest request ) {
		
		service.getJung(out,request);
		
		//out.print();
	}
	
	@RequestMapping("/product/getSo")
	public void getSo(PrintWriter out, HttpServletRequest request) {
		
		service.getSo(out, request);
	}
}






















































