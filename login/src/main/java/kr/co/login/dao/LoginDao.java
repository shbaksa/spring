package kr.co.login.dao;

import kr.co.login.dto.LoginDto;

public interface LoginDao {
   public int userid_check(String userid);
   public void member_input_ok(LoginDto ldto);
   public LoginDto login_ok(LoginDto ldto);
   public String userid_search_ok(LoginDto ldto);
   public String pwd_search_ok(LoginDto ldto);
}
