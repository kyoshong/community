package kr.co.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.co.board.dto.ItBoard_Dto;

public class ItBoard_Dao extends SqlSessionDaoSupport   {

	//IT�Խ��� list��� + ����¡ +�˻�
	public List<ItBoard_Dto> getItCategoryList(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost",displayPost);
		data.put("postNum",postNum);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return getSqlSession().selectList("board.it_board",data);
	}
	
	//IT�� �ۼ�
	public int itCategoryWrite(ItBoard_Dto dto) throws Exception{
		return getSqlSession().insert("board.it_write",dto);
	}
	
	//IT�Խ��� ��ȸ
	public ItBoard_Dto itCategoryView(int postNo) throws Exception{
		return getSqlSession().selectOne("board.it_view",postNo);
	}
	
	//IT �� ����
	public int itCategoryUpdate(ItBoard_Dto dto) throws Exception {
		return getSqlSession().update("board.it_update",dto);
	}
	
	//IT �� ����
	public int itCategoryDelete(int postNo) throws Exception {
		return getSqlSession().delete("board.it_delete",postNo);
	}
	
	//It �Խù� �� ���� + �˻�
	public int itCategoryCount(String searchType, String keyword) throws Exception{
		
		HashMap<String,Object> data =new HashMap<>();
		
		data.put("searchType",searchType);
		data.put("keyword", keyword);
		
		return getSqlSession().selectOne("board.it_count",data);
	}
	//IT�Խ��� ��� ���� ����
	public int itCommentsCountUpdate(int postNo, int commentsCount) throws Exception {
		
		HashMap<String,Object> data =new HashMap<>();
		data.put("postNo", postNo);
		data.put("commentsCount", commentsCount);
		
		return getSqlSession().update("board.it_commentsCount_update",data);
		
	}
	

}
