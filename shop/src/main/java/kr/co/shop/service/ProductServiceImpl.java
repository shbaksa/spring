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
import kr.co.shop.vo.DaeVO;
import kr.co.shop.vo.JungVO;
import kr.co.shop.vo.SoVO;

@Service
@Qualifier("ps")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper mapper;
	
	@Override
	public String pro_write(Model model) {
		// dae테이블을 읽어와서 view에 전달
		ArrayList<DaeVO> list=mapper.pro_write();
		model.addAttribute("list",list);
		return "/product/pro_write";
	}

	@Override
	public void getjung(HttpServletRequest request, PrintWriter out) {
		String daecode=request.getParameter("daecode");
		ArrayList<JungVO> list=mapper.getjung(daecode);
		// option태그를 생성해도 전달
		String str="";
	    // ArrayList => list.get(0)....  
		for(int i=0;i<list.size();i++)
		{
			JungVO jvo=list.get(i);
			// 문자열과 변수는 +연산을 통해 연결			 
			str=str+"<option value='"+jvo.getCode()+"'>"+URLEncoder.encode(jvo.getTitle())+"</option>";
			         // <option value='01'> 야채류 </option>
		}
		
		out.print(str);
	}

	@Override
	public void getso(HttpServletRequest request, PrintWriter out) {
		 String daejung=request.getParameter("daejung");
		 ArrayList<SoVO> list=mapper.getso(daejung);
		 String str="";
	 	 for(int i=0;i<list.size();i++)
		 {
			SoVO svo=list.get(i);
			str=str+"<option value='"+svo.getCode()+"'>"+URLEncoder.encode(svo.getTitle())+"</option>";
		 }
			
			out.print(str);
	}

}
