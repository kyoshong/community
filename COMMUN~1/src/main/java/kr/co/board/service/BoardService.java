package kr.co.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.board.dao.ItBoard_Dao;
import kr.co.board.dto.ItBoard_Dto;
import kr.co.boardReply.dao.ItBoardReply_Dao;
import kr.co.boardReply.dto.ItBoardReply_Dto;
import lombok.Setter;

@Service
public class BoardService {
	
	@Setter
	@Autowired
	private ItBoard_Dao dao;
	
	@Setter
	@Autowired
	private ItBoardReply_Dao replyDao;
	
	//IT�Խ��� list��� + ����¡
	public List<ItBoard_Dto> getItCategoryList(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		
		
		return dao.getItCategoryList(displayPost, postNum, searchType, keyword);
	}
	
	//It �Խ��� �� �ۼ�
	public int itCategoryWrite(ItBoard_Dto dto) throws Exception {
		return dao.itCategoryWrite(dto);
	}
	
	//It �Խ��� �� ��ȸ
	public ItBoard_Dto itCategoryView(int postNo) throws Exception {
		return dao.itCategoryView(postNo);
	}
	
	//It �� ����
	public int itCategoryUpdate(ItBoard_Dto dto) throws Exception{
		return dao.itCategoryUpdate(dto);
	}
	
	//It �� ����
	public int itCategoryDelete(int postNo) throws Exception{
		return dao.itCategoryDelete(postNo);
	}
	
	//It �Խù� �� ���� + �˻�
	public int itCategoryCount(String searchType, String keyword) throws Exception{
		return dao.itCategoryCount(searchType, keyword);
	}
	
	//IT�Խ��� ��� ���� ����
	public int itCommentsCountUpdate(int postNo, int commentsCount) throws Exception{
		return dao.itCommentsCountUpdate(postNo, commentsCount);
	}
	
	//IT��� ��ȸ
    public List<ItBoardReply_Dto> itReplyList(int postNo) throws Exception{
    	return replyDao.itReplyList(postNo);
    }
    
    //IT��� �ۼ�
  	public int itReplyWrite(ItBoardReply_Dto dto) throws Exception {
  		return replyDao.itReplyWrite(dto);
  	}
  	
  	//IT��� ����
  	public int itReplyUpdate(ItBoardReply_Dto dto) throws Exception {
  		return replyDao.itReplyUpdate(dto);
  	}
  	
  	//IT��� ����
  	public int itReplyDelete(int postNo, int commentsNo) throws Exception {
  		return replyDao.itReplyDelete(postNo, commentsNo);
  	}
  	
    //IT �ϳ��� �ۿ� ���� ��� ��  ��ȸ
  	public int itReplyCount(int postNo) throws Exception {
  		return replyDao.itReplyCount(postNo);
  	}

}
