package kr.co.shop.mapper;

import java.util.ArrayList;

import kr.co.shop.vo.DaeVo;
import kr.co.shop.vo.JungVo;
import kr.co.shop.vo.ProductVo;
import kr.co.shop.vo.SoVo;

public interface ProductMapper {
	
	public ArrayList<DaeVo> pro_write();
	
	public ArrayList<JungVo> getJung(String daecode);
	
	public ArrayList<SoVo> getSo(String daejung);
	

}
