package kr.co.folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping("/board/list")
	public String list()
	{
		return "/board/list";
	}
	@RequestMapping("/board/content")
	public String content()
	{
		return "/board/content";
	}
	@RequestMapping("/board/update")
	public String update()
	{
		return "/board/update";
	}
	@RequestMapping("/board/write")
	public String write()
	{
		return "/board/write";
	}
}
