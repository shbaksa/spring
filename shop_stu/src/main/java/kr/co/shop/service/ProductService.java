package kr.co.shop.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ProductService {
	
	public String pro_write(Model model);
	
	public void getJung(PrintWriter out, HttpServletRequest request);
	
	public void getSo(PrintWriter out, HttpServletRequest request);
	
	
	
	
}
