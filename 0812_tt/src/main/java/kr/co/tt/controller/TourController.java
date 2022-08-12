package kr.co.tt.controller;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
//import	org.springframework.web.multipart.MultipartRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import kr.co.tt.dao.TourDao;
import kr.co.tt.dto.TourDto;

@Controller
public class TourController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);
		ArrayList<TourDto> list = tdao.list();
		model.addAttribute("list",list);
		
		
		return "/list";
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(HttpServletRequest request) throws Exception {
		
		String path = request.getRealPath("resources/img");
		int size = 1024*1024*30;
		
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		System.out.println(title+content);
		System.out.println(multi.toString());
		
		Enumeration file = multi.getFileNames();
		
		String fname="";
		
		while(file.hasMoreElements())
			fname = fname + multi.getFilesystemName(file.nextElement().toString())+ ",";
		
		fname=fname.replace("null,","");
		
		System.out.println(fname);
		
		TourDto tdto = new TourDto();
		tdto.setContent(content);
		tdto.setTitle(title);
		tdto.setFname(fname);
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);
		
		tdao.write_ok(tdto);
		
		//tdao.write_ok(title,content,fname);
		
		
		return "redirect:/list";
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) {
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);
		tdao.readnum(request.getParameter("id"));
		
		return "redirect:/content?id="+request.getParameter("id");
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model) {
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);
		TourDto tdto = tdao.content(request.getParameter("id"));
		tdto.setContent(tdto.getContent().replace("\r\n", "<br>"));
		tdto.setTemp(tdto.getFname().split(","));
		tdto.setTemp2(tdto.getFname());
		
		model.addAttribute("tdto",tdto);
		
		return "/content";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception {
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);

		String path = request.getRealPath("resources/img");
		String[] fname = request.getParameter("fname").split(",");
		
		for(int i=0; i<fname.length; i++) {
			File file = new File(path + "/" + fname[i]);
			if(file.exists())
				file.delete();
		}
		
		tdao.delete(request.getParameter("id"));
		
		return "redirect:/list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) {
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);
		TourDto tdto = tdao.update(request.getParameter("id"));
		tdto.setTemp(tdto.getFname().split(","));
		
		model.addAttribute("tdto",tdto);
		
		return "/update";
	}
	
	@RequestMapping("update_ok")
	public String update_ok(HttpServletRequest request) throws Exception {
		
		String path = request.getRealPath("resources/img");
		int size = 1024*1024*30;
		
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		String[] del = multi.getParameter("del").split(",");
		
		for(int i=0;i<del.length;i++) {
			File file = new File(path +"/"+del[i]); // 삭제 file
			if(file.exists())
				file.delete();
		}
		
		String str = multi.getParameter("str");
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		String fname = "";
		
		Enumeration file = multi.getFileNames(); // 추가 이미지 file
		
		while(file.hasMoreElements()) {
			fname = fname + multi.getFilesystemName(file.nextElement().toString()) + ",";
		}
		
		fname=fname.replace("null,", "");
		fname = str + fname;
		
		
		TourDto tdto = new TourDto();
		tdto.setContent(content);
		tdto.setTitle(title);
		tdto.setFname(fname);
		tdto.setId(Integer.parseInt(multi.getParameter("id")));
		
		TourDao tdao = sqlSession.getMapper(TourDao.class);
		tdao.update_ok(tdto);
		
		return "redirect:/content?id="+multi.getParameter("id");
	}
}


























