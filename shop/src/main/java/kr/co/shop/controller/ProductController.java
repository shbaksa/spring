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
	public String pro_write(Model model)
	{
		// 대분류의 내용은 읽어온다..
		return service.pro_write(model);
	}
	
	@RequestMapping("/product/getjung")
	public void getjung(HttpServletRequest request,PrintWriter out)
	{
		service.getjung(request,out);
	}
	
	@RequestMapping("/product/getso")
	public void getso(HttpServletRequest request,PrintWriter out)
	{
		service.getso(request,out);
	}
}
