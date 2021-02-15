package kr.co.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;


import kr.co.web.dto.Customer_dto;

public class Customer_Login_dao extends SqlSessionDaoSupport {
	// ȸ������
	public int main_signup(Customer_dto dto) {
		return getSqlSession().insert("customer.main_signup", dto);
	}

	// ���̵� �˻�
	public String main_login_user_id(String customerId) {
		return getSqlSession().selectOne("customer.main_login_user_id", customerId);
	}

	// ��й�ȣ �˻� �� �α��� ����
	public Customer_dto main_login_user(String customerId) {
		return getSqlSession().selectOne("customer.main_login_user", customerId);
	}
}