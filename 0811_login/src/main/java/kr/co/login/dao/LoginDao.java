package kr.co.login.dao;

import kr.co.login.dto.LoginDto;

public interface LoginDao {

	
	public LoginDto login_ok(LoginDto ldto);
	
	public int userid_check(String userid);
	
	public void member_input(LoginDto ldto);
	
	/*public String userid_search(LoginDto ldto); db연결
	
	public String pwd_search(LoginDto ldto);*/
	
	// public LoginDto userid_search(String name , String phone); // 아작스
	
	public String userid_search(LoginDto ldto);
	
	public LoginDto pwd_search(String userid , String name, String phone);
}
