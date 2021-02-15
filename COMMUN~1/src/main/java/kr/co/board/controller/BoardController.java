package kr.co.board.controller;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.board.dto.ItBoard_Dto;
import kr.co.board.service.BoardService;
import kr.co.board.utils.Page;
import kr.co.boardReply.dto.ItBoardReply_Dto;
import lombok.Setter;

@Controller
@RequestMapping("board")
public class BoardController {
	@Setter
	@Autowired
	BoardService service;
			
	//ITCategory �Խ��� +����¡
	@RequestMapping(value="/itCategory", method=RequestMethod.GET) 
	public String getItCategoryList(
		Model model, @RequestParam(defaultValue="1") int num,
		@RequestParam(value="searchType", required= false, defaultValue = "postTitle") String searchType,
		@RequestParam(value="keyword", required = false, defaultValue="") String keyword
		) throws Exception {
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.itCategoryCount(searchType,keyword));  //�Խù� �Ѱ��� + �˻���� 
		page.setSearchType(searchType); //�˻� Ÿ�� 
		page.setKeyword(keyword); //�˻���
		
        List<ItBoard_Dto> list = service.getItCategoryList(page.getDisplayPost(),page.getPostNum(), searchType, keyword);
		
		model.addAttribute("itList", list);
		
		model.addAttribute("page",page);
		model.addAttribute("select", num);
								
		return "board/list/it-list";
	}
	
	//it�۾��� �������� �̵�
	@RequestMapping(value="/itCategoryWrite", method = RequestMethod.GET) 
	public String getItCategoryWrite() throws Exception{
		return "board/write/it-write";
	}
	
	//it�۾���
	@RequestMapping(value="/itCategoryWrite", method = RequestMethod.POST) 
	public String itCategoryWrite(ItBoard_Dto dto) throws Exception{
				
		Date currentTime =new Date();
		dto.setPostDate(currentTime);
				
		service.itCategoryWrite(dto);
		return "redirect:/board/itCategory";
	}
	
	//it �� ��ȸ ������ �̵�
	@RequestMapping(value="/itCategoryView",method = RequestMethod.GET)
	public String itCategoryView(@RequestParam("postNo") int postNo, Model model) throws Exception{
		
		ItBoard_Dto dto = service.itCategoryView(postNo);
		
		model.addAttribute("view", dto);
		
		//�ش� �� ��� ��ȸ
		List<ItBoardReply_Dto> reply = null;
		reply = service.itReplyList(postNo);
		
		model.addAttribute("comment",reply);
		
		return "board/view/it-view";
	}
	
	//it �� ���� ������ �̵�
	@RequestMapping(value="/itCategoryUpdate",method = RequestMethod.GET)
	public String getItCategoryModify(@RequestParam("postNo") int postNo, Model model) throws Exception{
		
		ItBoard_Dto dto = service.itCategoryView(postNo);
		
		model.addAttribute("view", dto);
		
		return "board/update/it-update";
	}
	
	//it �� ����
	@RequestMapping(value="/itCategoryUpdate",method = RequestMethod.POST)
	public String itCategoryUpdate(ItBoard_Dto dto) throws Exception{
		Date currentTime =new Date();
		dto.setPostDate(currentTime);
		
		service.itCategoryUpdate(dto);
		
		return "redirect:/board/itCategoryView?postNo="+dto.getPostNo();
	}
	
	//it �� ����
	@RequestMapping(value="/itCategoryDelete", method = RequestMethod.GET)
	public String itCategoryDelete(@RequestParam("postNo") int postNo) throws Exception {
		
		service.itCategoryDelete(postNo);
		
		return "redirect:/board/itCategory";
	}
	
	//it�� ��� �ޱ�
	@RequestMapping(value="/itCommentReply", method = RequestMethod.POST )
	public String itReplyWrite(ItBoardReply_Dto dto) throws Exception{
		Date currentTime =new Date();
		dto.setPostDate(currentTime);
	    				
		service.itReplyWrite(dto);
		
		int postNo = dto.getPostNo();
		int commentsCount = service.itReplyCount(postNo);//��� ���̺� ����� �˾Ƴ��� ���
		
		service.itCommentsCountUpdate(postNo, commentsCount); //��� ���� ����
		
		return "redirect:/board/itCategoryView?postNo="+dto.getPostNo();
	}
	
	//it�� ��� ����
	@RequestMapping(value="/itCommentDelete", method= RequestMethod.GET)
	public String itReplyDelete(@RequestParam("postNo") int postNo, @RequestParam("commentsNo") int commentsNo) throws Exception {
		
		service.itReplyDelete(postNo, commentsNo);
		
        int commentsCount = service.itReplyCount(postNo);//��� ���̺� ����� �˾Ƴ��� ���
		service.itCommentsCountUpdate(postNo, commentsCount); //��� ���� ����
		
		
		return "redirect:/board/itCategoryView?postNo="+postNo;
	}

}
