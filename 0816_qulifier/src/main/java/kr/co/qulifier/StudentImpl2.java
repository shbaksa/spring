package kr.co.qulifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("s2")
public class StudentImpl2 implements Student {

	@Override
	public String output() {
		
		return "하하하";
	}
	

}
