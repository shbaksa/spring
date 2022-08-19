package kr.co.mapper_test.tourcontroller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mapper_test.tourdao.TourDao;
import kr.co.mapper_test.tourdto.TourDto;

@Controller
public class TourController {

	@Autowired
	private SqlSession sqlSession3;
	
	@RequestMapping("/tour/list")
	public String list(Model model)
	{
		TourDao tdao=sqlSession3.getMapper(TourDao.class);
		ArrayList<TourDto> list=tdao.list();
		model.addAttribute("list",list);
		return "/tour/list";
	}
}
