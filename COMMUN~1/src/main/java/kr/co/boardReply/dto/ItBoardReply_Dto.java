package kr.co.boardReply.dto;

import java.util.Date;

public class ItBoardReply_Dto {
	private int commentsNo; //��� ��ȣ
	private int postNo; //��� �ٴ� �� ��ȣ
	private String customerNickname; //��� �ۼ���
	private int customerNo; //�ۼ��� ���� ��ȣ
	private String comments; //����
	private Date postDate; //�ۼ���
	public int getCommentsNo() {
		return commentsNo;
	}
	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getCustomerNickname() {
		return customerNickname;
	}
	public void setCustomerNickname(String customerNickname) {
		this.customerNickname = customerNickname;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
