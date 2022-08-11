package kr.co.login.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.login.dao.LoginDao;
import kr.co.login.dto.LoginDto;

@Controller
public class LoginController {

	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/main")
	public String main() {
		
		return "/main";
	}
	
	@RequestMapping("/login") // login form
	public String login(Model model,HttpServletRequest request) {
		
		/*
		if(request.getParameter("useridSearch")!=null)
			model.addAttribute("useridSearch",request.getParameter("useridSearch")); // 아이디찾기
		
		if(request.getParameter("pwdSearch")!=null)
			model.addAttribute("pwdSearch",request.getParameter("pwdSearch")); // 비밀번호 찾기
		*/
		if(request.getParameter("chk")!=null)
			model.addAttribute("chk",request.getParameter("chk")); // 로그인정보 틀렸을때
		
		return "/login";
	}
	
	@RequestMapping("/login_ok") // db select
	public String login_ok(LoginDto ldto, HttpSession session) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		
		LoginDto ldto2 = ldao.login_ok(ldto);
		
		/*System.out.println(ldtoo.getNum());
		System.out.println(ldtoo.getUserid());
		System.out.println(ldtoo.getName());*/
		
		if(ldto2.getNum()==1) {
			
			session.setAttribute("userid", ldto2.getUserid());
			session.setAttribute("name", ldto2.getName());
			return "redirect:/main"; // 로그인정보 맞음
		}
		else
			return "redirect:/login?chk=1"; // 로그인정보 틀림
	}
	
	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping("/member_input") // 회원가입 form
	public String member_input() {
		
		return "/member_input";
	}
	
	@RequestMapping("/userid_check") // 아작스 맵핑
	public void userid_check(PrintWriter out,HttpServletRequest request) {
		
		String userid = request.getParameter("userid");
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		int num = ldao.userid_check(userid);
		
		out.print(num);
	}
	
	@RequestMapping("/member_input_ok") // db insert
	public String member_input_ok(LoginDto ldto) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		ldao.member_input(ldto);
		
		return "/login";
	}
	
	/*@RequestMapping("/userid_search") // db select userid
	public String userid_search(LoginDto ldto) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		String useridSearch = ldao.userid_search(ldto);
		
		System.out.println(useridSearch);
		
				
		return "redirect:/login?useridSearch="+useridSearch;
	}
	
	@RequestMapping("/pwd_search") // db select pwd
	public String pwd_search(LoginDto ldto) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		String pwdSearch = ldao.pwd_search(ldto);
		
		return "redirect:/login?pwdSearch="+pwdSearch;
	}*/
	
	/*@RequestMapping("/userid_search") // 아작스 userid search
	public void userid_search(PrintWriter out, HttpServletRequest request) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		LoginDto ldto = ldao.userid_search(request.getParameter("name"),request.getParameter("phone"));
		
		if(ldto.getNum()==0) 
			out.print(0);					
		else
			out.print(ldto.getUserid());
		
		
	}*/
	
	@RequestMapping("/userid_search") // 아작스 userid search
	public void userid_search(PrintWriter out, LoginDto ldto) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		String userid = ldao.userid_search(ldto);
		
		if(userid==null)
			userid="0";
		
		out.print(userid);

	}
	
	
	
	@RequestMapping("/pwd_search") // 아작스 pwd search
	public void pwd_search(PrintWriter out, HttpServletRequest request) {
		
		LoginDao ldao = sqlSession.getMapper(LoginDao.class);
		LoginDto ldto = ldao.pwd_search(request.getParameter("userid") , request.getParameter("name"), request.getParameter("phone"));
		
		if(ldto.getNum()==0)
			out.print(0);
		else
			out.print(ldto.getPwd());
		
	}
	
}
