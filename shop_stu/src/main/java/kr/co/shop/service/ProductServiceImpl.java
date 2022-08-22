package kr.co.shop.service;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.shop.mapper.ProductMapper;
import kr.co.shop.vo.DaeVo;
import kr.co.shop.vo.JungVo;
import kr.co.shop.vo.ProductVo;
import kr.co.shop.vo.SoVo;

@Service
@Qualifier("ps")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper mapper;
	
	@Override
	public String pro_write(Model model) {
		
		ArrayList<DaeVo> list = mapper.pro_write();
		model.addAttribute("list",list);
		
		return "/product/pro_write";
	}
	
	@Override
	public void getJung(PrintWriter out, HttpServletRequest request) {
		
		ArrayList<JungVo> list = mapper.getJung(request.getParameter("daecode"));
		
		// option 태그를 생성해서 전달
		
		String str= "<option>"+URLEncoder.encode("선택")+"</option>";
		
		// ArrayList = > list.get(0)
		
		for(int i=0;i<list.size();i++) {
			
			JungVo jvo = list.get(i);
		
			str = str + "<option value='"+jvo.getCode()+"'>" + URLEncoder.encode(jvo.getTitle()) + "</option>";
						// <option value="01">야채류</option>
						
		}
	
		out.print(str);
		
	}
	
	@Override
	public void getSo(PrintWriter out, HttpServletRequest request) {
		
		ArrayList<SoVo> list = mapper.getSo(request.getParameter("daejung"));
		
		String str = "<option>"+URLEncoder.encode("선택")+"</option>";
		
		for(int i=0;i<list.size();i++) {
			
			SoVo svo = list.get(i);
			
			str = str + "<option value='"+svo.getCode()+"'>" + URLEncoder.encode(svo.getTitle()) + "</option>";
			
		}
		
		out.print(str);
		
	}
	
	
}

























































