package kr.co.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.web.dao.Customer_Login_dao;
import kr.co.web.dao.Customer_SignUp_dao;
import kr.co.web.dto.Customer_dto;
import lombok.Setter;

@Service
public class Customer_service {
	@Setter
	@Autowired
	Customer_SignUp_dao md;
	@Setter
	@Autowired
	Customer_Login_dao ld;
	
	// ȸ������
	public int main_signup(Customer_dto dto) {
		String email_num = dto.getCustomerEmail_1() + "@" + dto.getCustomerEmail_2();
		dto.setCustomerEmail(email_num);
		return md.main_signup(dto);
	}

	// ȸ������ ���̵� �ߺ�üũ
	public String main_signup_userid(String customerId) {
		return md.main_signup_userid(customerId);
	}

	// ȸ������ �г��� �ߺ�üũ
	public String main_signup_user_nickname(String customerNickname) {
		return md.main_signup_user_nickname(customerNickname);
	}

	// ȸ������ �̸��� �ߺ�üũ
	public String main_signup_user_Email(Customer_dto dto) {
		String email_num = dto.getCustomerEmail_1() + "@" + dto.getCustomerEmail_2();
		dto.setCustomerEmail(email_num);
		return md.main_signup_user_Email(dto);
	}
	
	// �α��� ���̵� �˻�
	public String main_login_user_id(String customerId) {
		return ld.main_login_user_id(customerId);
	}
	
	// �α��� ��й�ȣ �˻� �� �α��� ����
	public Customer_dto main_login_user(String customerId) {
		return ld.main_login_user(customerId);
	}
}