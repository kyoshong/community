package kr.co.mail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.web.service.Customer_service;

@Controller
public class UserController {
	@Autowired
	Customer_service ms;

	@RequestMapping("email_Authentication")
	public String main() throws Exception {
		return "/service/email_Authentication/email_Authentication_main";
	}

	@Inject
	JavaMailSender mailSender;

	@RequestMapping("email_Authentication_check")
	@ResponseBody
	public int mailSending(HttpServletRequest request) throws IOException {
		Random r = new Random();
		int dice = r.nextInt(4589362) + 49311; // �̸��Ϸ� �޴� �����ڵ� �κ�
		String setfrom = "kjm.test.sts@gmail.com";
		String tomail = request.getParameter("e_mail"); // �޴� ��� �̸���
		String title = "ȸ������ ���� �̸��� �Դϴ�."; // ����
		String content = System.getProperty("line.separator") + "�ȳ��ϼ��� ȸ���� ���� Ȩ�������� ã���ּż� �����մϴ�" +
						 System.getProperty("line.separator") +
						 System.getProperty("line.separator") + "������ȣ�� " + dice + " �Դϴ�. ";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
			messageHelper.setTo(tomail); // �޴»�� �̸���
			messageHelper.setSubject(title); // ���������� ������ �����ϴ�
			messageHelper.setText(content); // ���� ����

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		return dice;
	}
}
