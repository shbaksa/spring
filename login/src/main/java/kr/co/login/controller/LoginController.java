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
	public String main()
	{
		return "/main";
	}
	
	@RequestMapping("/member_input")
	public String member_input()
	{
		return "/member_input";
	}
	
	@RequestMapping("/userid_check")
	public void userid_check(PrintWriter out,HttpServletRequest request)
	{
		String userid=request.getParameter("userid");
		// 사용자의 아이디를 가지고 테이블을 조회하여 아이디의 존재여부를 알려준다
		// 쿼리문의 결과값을 count()함수를 통해 숫자로서 가져온다..
		LoginDao ldao=sqlSession.getMapper(LoginDao.class);
		int chk=ldao.userid_check(userid);
		out.print(chk);
		/*
		if(아이디가 존재한다면)
		    out.print("1");  // 아이디 존재
		else
			out.print("0");  // 아이디 없음
		*/
	}
	
	@RequestMapping("/member_input_ok")
	public String member_input_ok(LoginDto ldto)
	{
		LoginDao ldao=sqlSession.getMapper(LoginDao.class);
		ldao.member_input_ok(ldto);
		
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model)
	{
		String chk=request.getParameter("chk");
		model.addAttribute("chk",chk);
		return "/login";
	}
	
	@RequestMapping("/login_ok")
	public String login_ok(LoginDto ldto,HttpSession session)
	{
		LoginDao ldao=sqlSession.getMapper(LoginDao.class);
		LoginDto ldto2=ldao.login_ok(ldto);
		
		if(ldto2!=null)
		{
			session.setAttribute("userid", ldto2.getUserid());
			session.setAttribute("name", ldto2.getName());
			
			return "redirect:/main";
		}
		else  // 아이디 or 비밀번호가 틀릴경우
		{
			return "redirect:/login?chk=1";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping("/userid_search_ok")
	public void userid_search_ok(LoginDto ldto,PrintWriter out)
	{
		LoginDao ldao=sqlSession.getMapper(LoginDao.class);
		String userid=ldao.userid_search_ok(ldto);
		if(userid==null)
			userid="0";
		out.print(userid);
	}
	
	@RequestMapping("/pwd_search_ok")
	public void pwd_search_ok(LoginDto ldto,PrintWriter out)
	{
		LoginDao ldao=sqlSession.getMapper(LoginDao.class);
		String pwd=ldao.pwd_search_ok(ldto);
		if(pwd==null)
			pwd="0";
		out.print(pwd);
		
	}
}





