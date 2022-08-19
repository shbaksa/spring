package kr.co.page.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.page.vo.PageVo;

public interface PageService {

	public String list(HttpServletRequest request, Model model);
	
	public String readnum(PageVo pvo);
	
	public String content(HttpServletRequest request, Model model);
	
	public String update(HttpServletRequest request, Model model);
	
	public String update_ok(PageVo pvo);
	
	public String delete(PageVo pvo);
	
	public String write_ok(PageVo pvo);
}
