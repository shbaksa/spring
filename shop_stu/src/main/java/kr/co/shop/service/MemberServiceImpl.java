package kr.co.shop.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ms1")
public class MemberServiceImpl implements MemberService {

}
