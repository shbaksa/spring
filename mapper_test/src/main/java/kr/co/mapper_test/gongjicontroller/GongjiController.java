package kr.co.mapper_test.gongjicontroller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mapper_test.gongjidao.GongjiDao;
import kr.co.mapper_test.gongjidto.GongjiDto;

@Controller
public class GongjiController {

	@Autowired
	private SqlSession sqlSession2;
	
	@RequestMapping("/gongji/list")
	public String list(Model model)
	{
		GongjiDao gdao=sqlSession2.getMapper(GongjiDao.class);
		ArrayList<GongjiDto> list=gdao.list();
		model.addAttribute("list",list);
		return "/gongji/list";
	}
}



