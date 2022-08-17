package kr.co.board_model.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.board_model.dao.BoardDao;
import kr.co.board_model.dto.BoardDto;

@Service
public class BoardCommand { // DB처리 및 각종 처리
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public String list(Model model) {
		
		// DB처리 및 각종 처리
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		ArrayList<BoardDto> list =  bdao.list();
		
		model.addAttribute("list",list);
		
		return "/list";
	}
	
	public String readnum(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		bdao.readnum(id);
		
		return "redirect:/content?id="+id;
	}
	
	public String content(HttpServletRequest request,Model model) {
		
		String id = request.getParameter("id");
		int chk = 0;
		
		if(request.getParameter("chk")!=null) // 비밀번호 오류 메세지
			chk = 1;
		
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		
		BoardDto bdto = bdao.content(id);
		bdto.setContent(bdto.getContent().replace("\r\n", "<br>"));
		model.addAttribute("bdto",bdto);
		model.addAttribute("chk",chk);
		
		return "/content";
	}
	
	public String update(HttpServletRequest request,Model model) {
		
		String id = request.getParameter("id");
		int chk=0;
		
		if(request.getParameter("chk")!=null) // 비밀번호 오류 메세지
			chk=1;
		
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		BoardDto bdto = bdao.update(id);
		model.addAttribute("bdto",bdto);
		model.addAttribute("chk",chk);
		
		return "/update";
	}
	
	/*public String update_ok(BoardDto bdto) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.update_ok(bdto);
		
		return "redirect:/content?id="+bdto.getId();
	}*/
	
	public String update_ok(BoardDto bdto) { // 비밀번호 체크 후 수정
		
		String dbpwd = dbpwd(bdto.getId());
		
		if(dbpwd.equals(bdto.getPwd())) {
			
			BoardDao bdao = sqlSession.getMapper(BoardDao.class);
			bdao.update_ok(bdto);
			
			return "redirect:/content?id="+bdto.getId();
		}
		else
			return "redirect:/update?id="+bdto.getId()+"&chk=1"; // 비밀번호 오류 메세지
		
	}
	
	/*public String delete(HttpServletRequest request) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.delete(request.getParameter("id"));
		
		return "redirect:/list";
	}*/
	
	public String delete(HttpServletRequest request) { // 비밀번호 체크 후 삭제
		
		String id = request.getParameter("id");
		String dbpwd = dbpwd(Integer.parseInt(id));
		String delpwd = request.getParameter("pwd");
	
		if(dbpwd.equals(delpwd)) {
			
			BoardDao bdao = sqlSession.getMapper(BoardDao.class);
			bdao.delete(id);
			
			return "redirect:/list";			
		}
		else
			return "redirect:/content?id="+id+"&chk=1"; // 비밀번호 오류 메세지
	}
	
	public String write_ok(BoardDto bdto) {
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		bdao.write_ok(bdto);
		
		return "redirect:/list";
	}
	
	public String dbpwd(int id) { // DB 비밀번호 가져오기
		
		BoardDao bdao = sqlSession.getMapper(BoardDao.class);
		String dbpwd = bdao.pwdSearch(id);
		
		return dbpwd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
