package kr.co.qulifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("s1")
public class StudentImpl implements Student {
	 // 구현클래스 : 인터페이스의 추상메소드를 사용할수 있게  메소드의 내용을 재정의하여 사용하는것
	@Override
	public String output() 
	{
		return "output";
	}
  
	
}
