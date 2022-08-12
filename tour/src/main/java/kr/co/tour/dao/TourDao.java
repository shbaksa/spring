package kr.co.tour.dao;

import java.util.ArrayList;

import kr.co.tour.dto.TourDto;

public interface TourDao {
   public void write_ok(TourDto tdto);
   public ArrayList<TourDto> list();
   public void readnum(String id);
   public TourDto content(String id);
   public TourDto update(String id);
   public void update_ok(TourDto tdto);
}
