package kr.co.page.service;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.page.mapper.PageMapper;
import kr.co.page.vo.PageVo;

@Service
@Qualifier("bs")
public class PageServiceImpl implements PageService {

	@Autowired
	private PageMapper mapper;
	
	@Override
	public String list(HttpServletRequest request,Model model) {
		
		int page=1, pcnt=10 , pstart,pend,chong,index;
		String sel="";
		String sword="";
	
		if(request.getParameter("pcnt")!=null)
			pcnt=Integer.parseInt(request.getParameter("pcnt"));
		
		if(request.getParameter("page")!=null)
			page=Integer.parseInt(request.getParameter("page"));
	
		if(request.getParameter("sel")==null || request.getParameter("sel").equals("0")) {			
			sel="id";
			sword="";
		}
		else {
			sel=request.getParameter("sel");		
			sword=request.getParameter("sword");
		}

		
		index = (page-1)*pcnt;
		
		pstart = page/10;
		if(page%10 == 0)
			pstart--;
		
		pstart = pstart*10+1;
		pend = pstart+9;
		
		chong = mapper.getChong(pcnt,sel,sword);
		
		if(pend>chong)
			pend=chong;
		
		model.addAttribute("list",mapper.list(sel,sword,index,pcnt));
		model.addAttribute("page",page);
		model.addAttribute("pstart",pstart);
		model.addAttribute("pend",pend);
		model.addAttribute("chong",chong);
		model.addAttribute("pcnt",pcnt);
		model.addAttribute("sword",sword);
		if(sel.equals("id"))
			sel="0";
		model.addAttribute("sel",sel);
		return "/list";
	}

	@Override
	public String readnum(PageVo pvo) {
		
		mapper.readnum(pvo.getId());
		String sword = pvo.getSword();
		sword = URLEncoder.encode(sword);

		return "redirect:/content?id="+pvo.getId()+"&pcnt="+pvo.getPcnt()+"&page="+pvo.getPage()+"&sel="+pvo.getSel()+"&sword="+sword;
	}
	
	@Override
	public String content(HttpServletRequest request, Model model) {
		
		int chk=0;
		if(request.getParameter("chk")!=null)
			chk=1;
		
		PageVo pvo = mapper.content(request.getParameter("id"));
		pvo.setPage(Integer.parseInt(request.getParameter("page")));
		pvo.setPcnt(Integer.parseInt(request.getParameter("pcnt")));
		pvo.setSel(request.getParameter("sel"));
		pvo.setSword(request.getParameter("sword"));
		pvo.setContent(pvo.getContent().replace("\r\n", "<br>"));
		
		model.addAttribute("pvo",pvo);
		model.addAttribute("chk",chk);
		
		return "/content";
	}
	
	@Override
	public String update(HttpServletRequest request, Model model) {
				
		int chk=0;
		if(request.getParameter("chk")!=null)
			chk=1;
		
		PageVo pvo = mapper.update(request.getParameter("id"));
		pvo.setPage(Integer.parseInt(request.getParameter("page")));
		pvo.setPcnt(Integer.parseInt(request.getParameter("pcnt")));
		pvo.setSel(request.getParameter("sel"));
		pvo.setSword(request.getParameter("sword"));
		
		model.addAttribute("pvo",pvo);
		model.addAttribute("chk",chk);
		
		return "/update";
	}
	
	public String getDBPwd(int id) {
		
		String dbpwd = mapper.getDBPwd(id);
		
		return dbpwd;
	}
	
	/*@Override
	public String update_ok(PageVo pvo) {
		
		mapper.update_ok(pvo);
		
		return "redirect:/content?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword();
	}
	
	@Override
	public String delete(PageVo pvo) {

		mapper.delete(pvo.getId());
		
		return "redirect:/list?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword();
	}
	*/
	
	@Override
	public String update_ok(PageVo pvo) {
		
		String pwd = pvo.getPwd();
		String dbpwd = getDBPwd(pvo.getId());
		
		if(pwd.equals(dbpwd)) {
			
			mapper.update_ok(pvo);
			
			return "redirect:/content?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword();
		}
		else
			return "redirect:/update?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword()+"&chk=1";
		
	}
	
	@Override
	public String delete(PageVo pvo) {
		
		String pwd = pvo.getPwd();
		String dbpwd = getDBPwd(pvo.getId());
		
		if(pwd.equals(dbpwd)) {
			
			mapper.delete(pvo.getId());
			return "redirect:/list?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword();
		}
		else
			return "redirect:/content?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword()+"&chk=1";
		
	}
	
	@Override
	public String write_ok(PageVo pvo) {
		
		mapper.write_ok(pvo);
		
		return "redirect:/list?id="+pvo.getId()+"&page="+pvo.getPage()+"&pcnt="+pvo.getPcnt()+"&sel="+pvo.getSel()+"&sword="+pvo.getSword();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
