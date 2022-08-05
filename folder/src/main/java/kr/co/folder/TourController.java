package kr.co.folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tour")
@Controller
public class TourController {


	@RequestMapping("/list")
	public String list()
	{
		return "/tour/list";
	}
	
	@RequestMapping("/content")
	public String content()
	{
		return "/tour/content";
	}
	
	@RequestMapping("/update")
	public String update()
	{
		return "/tour/update";
	}
	
	@RequestMapping("/write")
	public String write()
	{
		return "/tour/write";
	}
}
