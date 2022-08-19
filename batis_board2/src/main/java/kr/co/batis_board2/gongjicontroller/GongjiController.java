package kr.co.batis_board2.gongjicontroller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.batis_board2.gongjidao.GongjiDao;
import kr.co.batis_board2.gongjidto.GongjiDto;

@Controller
public class GongjiController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/gongji/list")
	public String list(Model model)
	{
		GongjiDao gdao=sqlSession.getMapper(GongjiDao.class);
		ArrayList<GongjiDto> list=gdao.list();
		model.addAttribute("list",list);
		return "/gongji/list";
	}
}



