package kr.co.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;

import kr.co.kakao.KakaoController;
import kr.co.naver.NaverLoginBO;
import kr.co.web.dto.Customer_dto;
import kr.co.web.service.Customer_service;
import lombok.Setter;

@Controller
public class Customer_controller {
	@Setter
	@Autowired
	private Customer_service ms;
	@Setter
	@Autowired
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
	
	// ����ȭ�� �̵�
	@RequestMapping("main")
	public String main() throws Exception {
		return "main";
	}
	// �α���
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView memberLoginForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// ������ URL�� 'naverAuthUrl'�� ����
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        // ������ URL�� 'kakaoUrl'�� ����
        String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		// naverAuthUrl ����� URL�� 'naver_url'��� KEY ���� ��Ƽ� �𵨷� ����
		mav.addObject("naver_url", naverAuthUrl);
		// kakaoUrl ����� URL�� 'kakao_url'��� KEY ���� ��Ƽ� �𵨷� ����
		mav.addObject("kakao_url", kakaoUrl); 
		mav.setViewName("service/login");
		return mav;
	}
/* ȸ������ */
	// ���ɻ� list�� ����� �޼ҵ�
	private void referenceData(Model m) {
		String[] interest = { "����", "����", "����", "��Ÿ" };
		m.addAttribute("signup_interest", interest);
	}
	// ȸ������ �̵�
	@RequestMapping("signup")
	public String signup(Model m) throws Exception {
		referenceData(m);
		return "service/signup";
	}
	// ȸ������ insert
	@RequestMapping(value = "success_signup", method = RequestMethod.POST)
	public String success_signup(Customer_dto dto) throws Exception {
		// Jasypt �������� DB ���� ��ȣȭ
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("somePassword");
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		String encStr = encryptor.encrypt(dto.getCustomerPW()); // ��й�ȣ ��ȣȭ
		dto.setCustomerPW(encStr);
		ms.main_signup(dto);
		return "main";
	}
	// ���̵� �ߺ�Ȯ��
	@RequestMapping("user_id_check")
	@ResponseBody
	public String main_signup_userid(String customerId) throws Exception {
		return ms.main_signup_userid(customerId);
	}
	// �г��� �ߺ�Ȯ��
	@RequestMapping("user_nickname_check")
	@ResponseBody
	public String main_signup_user_nickname(String customerNickname) throws Exception {
		return ms.main_signup_user_nickname(customerNickname);
	}
	// �̸��� �ߺ�Ȯ��
	@RequestMapping("user_email_check")
	@ResponseBody
	public String main_signup_user_Email(Customer_dto customerEmail) throws Exception {
		return ms.main_signup_user_Email(customerEmail);
	}
/* �α��� �� �α׾ƿ� */
	//�α���
	@RequestMapping(value="user_login_chk")
	public String main_login_user(HttpSession session,
			String customerId, String customerPW) throws Exception {
		// Jasypt �������� DB ���� ��ȣȭ
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		if(session.getAttribute("login") !=null) {
			session.removeAttribute("login");
	    } // �α��� ���� ���� ����
		try {
			String user_id = ms.main_login_user_id(customerId);
			Customer_dto list = ms.main_login_user(user_id);
			encryptor.setPassword("somePassword");
			encryptor.setAlgorithm("PBEWithMD5AndDES");
			String decStr = encryptor.decrypt(list.getCustomerPW()); // ��й�ȣ ��ȣȭ
			if(decStr.equals(customerPW)) {
				session.setAttribute("login", list);
				return "main";
			} else {
		        session.setAttribute("fail", user_id);
				return "service/login";
			}
		} catch (Exception e) {
			session.setAttribute("fail", "null");
		}
		return "service/login";
	}
	// īī�� �α���
	@RequestMapping(value = "kakaologin", method = { RequestMethod.GET, RequestMethod.POST })
	public String kakaoLogin(@RequestParam("code") String code, Customer_dto list,
			HttpServletResponse response, HttpSession session) throws Exception {
		if(session.getAttribute("login") !=null) {
			session.removeAttribute("login");
	    } // �α��� ���� ���� ����
		JsonNode node = KakaoController.getAccessToken(code); // accessToken�� ������� �α����� ��� ������ ����ִ�.
		JsonNode accessToken = node.get("access_token"); // ������� ����
		JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
		JsonNode properties = userInfo.path("properties");
		list.setCustomerEmail("īī�� �α���"); // īī�� �α����� �̸����� �������ɴϴ�.
		list.setCustomerId(properties.path("nickname").asText()); // īī�� �α��� �̸� �����´�.
		session.setAttribute("login", list); 
		return "redirect:main";
	}
	// ���̹� �α���
    @RequestMapping(value = "naverlogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model m, @RequestParam String code, Customer_dto list,
    		@RequestParam String state, HttpSession session) throws IOException {
    	if(session.getAttribute("login") !=null) {
			session.removeAttribute("login");
	    } // �α��� ���� ���� ����
    	OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
        	obj = parser.parse(apiResult);
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        JSONObject jsonobj = (JSONObject) obj;
        JSONObject response = (JSONObject) jsonobj.get("response");
        list.setCustomerId((String) response.get("name")); // ���̹� �α��� �̸� ������
        list.setCustomerEmail("���̹� �α���"); // ���̹� �α��� �̸��� �����´�.
        session.setAttribute("login", list);
        m.addAttribute("result", apiResult);
        return "redirect:main";
    }
	// �α׾ƿ�
 	@RequestMapping(value="logout", method = RequestMethod.GET)
 	   public String logout(HttpSession session) throws Exception{
 	      session.invalidate();
 	      return "redirect:main";
 	}
 	/* ������ �� ��й�ȣ ���� */
 	@RequestMapping(value="user-details", method = RequestMethod.GET)
    public String main_user_details(Model m, HttpSession session) {
 		if(session.getAttribute("login") == null) {
			return "login";
	    } else {
	    	String id = ((Customer_dto) session.getAttribute("login")).getCustomerId();
	 		Customer_dto list = ms.main_login_user(id);
	 		session.setAttribute("login", list);
	    }
		return "service/details";
 	}
}