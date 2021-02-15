package kr.co.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.co.web.dto.Customer_dto;

public class Customer_SignUp_dao extends SqlSessionDaoSupport {
	// ȸ������
	public int main_signup(Customer_dto dto) {
		return getSqlSession().insert("customer.main_signup", dto);
	}

	// ���̵� �ߺ�üũ
	public String main_signup_userid(String customerId) {
		return getSqlSession().selectOne("customer.main_signup_user_id", customerId);
	}

	// �г��� �ߺ�üũ
	public String main_signup_user_nickname(String customerNickname) {
		return getSqlSession().selectOne("customer.main_signup_user_nickname", customerNickname);
	}
	
	// �г��� �ߺ�üũ
	public String main_signup_user_Email(Customer_dto customerEmail) {
		return getSqlSession().selectOne("customer.main_signup_user_email", customerEmail);
	}
}
