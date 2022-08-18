package kr.co.board_model3.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.board_model3.mapper.BoardMapper;
import kr.co.board_model3.vo.BoardVO;

@Service
@Qualifier("bs2")
public class BoardServiceImpl2 implements BoardService2 {
   
	@Autowired
	private BoardMapper mapper;

	@Override
	public ArrayList<BoardVO> list() {
		ArrayList<BoardVO> list=mapper.list();
		return list;
	}

	@Override
	public void readnum(String id) {
		mapper.readnum(id);
	}

	@Override
	public BoardVO content(String id) {
		BoardVO bvo=mapper.content(id); 
		return bvo;
	}

	@Override
	public void delete(int id) {
		mapper.delete(id);
	}

	@Override
	public BoardVO update(String id) {
		BoardVO bvo=mapper.update(id);
		return bvo;
	}

	@Override
	public void update_ok(BoardVO bvo) {
		mapper.update_ok(bvo);
	}

	@Override
	public void write_ok(BoardVO bvo) {
		 mapper.write_ok(bvo);
	}

	@Override
	public String getPwd(int id)
	{
		String dbpwd=mapper.getPwd(id);
	    return dbpwd;
	}

	 
}









