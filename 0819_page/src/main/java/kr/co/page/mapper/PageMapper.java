package kr.co.page.mapper;

import java.util.ArrayList;

import kr.co.page.vo.PageVo;

public interface PageMapper {

	public int getChong(int pcnt,String sel,String sword);
	
	public ArrayList<PageVo> list(String sel,String sword,int index,int pcnt);
	
	// public ArrayList<PageVo> list(@Param("index") int index,@Param("pcnt") int pcnt);
	
	public void readnum(int id);
	
	public PageVo content(String id);
	
	public PageVo update(String id);
	
	public void update_ok(PageVo pvo);
	
	public void delete(int id);
	
	public String getDBPwd(int id);
	
	public void write_ok(PageVo pvo);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
