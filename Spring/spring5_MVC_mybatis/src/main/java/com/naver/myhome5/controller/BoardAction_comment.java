package com.naver.myhome5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome5.dao.BoardDAOImpl;
import com.naver.myhome5.model.BoardBean;

//@Controller
public class BoardAction_comment {
	
	@Autowired
	private BoardDAOImpl boardService;
	
	//�Խ��� �۾��� ��
	@RequestMapping(value = "/board_write.nhn")
	public String board_write() {
		return "board/board_write";
	}
	
	//�Խ��� ����
	@RequestMapping(value = "/board_write_ok.nhn", method = RequestMethod.POST)
	public String board_write_ok(BoardBean board) throws Exception {
		boardService.insertBoard(board); //���� �޼��� ȣ��
		return "redirect:/board_list.nhn";
	}
	
	//�Խ��� ���
	@RequestMapping(value = "/board_list.nhn")
	public ModelAndView board_list(
			@RequestParam(value="page", defaultValue="1")int page
	) throws Exception {
		
		List<BoardBean> boardlist = new ArrayList<BoardBean>();
		
		//�ʱ�ȭ
		int limit = 10; //�� ȭ�鿡 ����� ���ڵ� ����
		
		int listcount = boardService.getListCount(); //�� ����Ʈ ���� ��ȯ
		
		//�� ������ ��
		int maxpage = (listcount + limit - 1) / limit;
		
		//���� �������� ������ ���� ������ ��(1, 11, 21 �� ...)
		int startpage = ((page-1) / 10) * 10 + 1;
		
		//���� �������� ������ ������ ������ ��(10, 20, 30 �� ...)
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		if (endpage < page) page = endpage;
		
		boardlist = boardService.getBoardList(page); //����Ʈ�� �޾ƿɴϴ�
		
		ModelAndView boardListM =
				new ModelAndView("board/board_list");
		boardListM.addObject("page", page);
		boardListM.addObject("maxpage", maxpage);
		boardListM.addObject("startpage", startpage);
		boardListM.addObject("endpage", endpage);
		boardListM.addObject("listcount", listcount);
		boardListM.addObject("boardlist", boardlist);
		
		return boardListM;
	}
	
	//�Խ��� ���뺸��, ������, ������, �亯����
	@RequestMapping(value = "/board_cont.nhn")
	public ModelAndView board_cont(
			@RequestParam("board_num") int board_num, 
			@RequestParam("page") int page, 
			@RequestParam("state") String state, 
			HttpServletResponse response) throws Exception {
		// �ʹ�ȣ
		// @RequestParam("page") int page
		// �ǹ�
		// int page = Integer.parseInt(request.getparameter("page"));
		
		// ���а� ����. ���뺸�� cont, ������ edit, ������ del, �亯���� reply
		// @RequestParam("state") String state
		// �ǹ�
		// String state = request.getParameter("state");
		
		// ���� ��û�� �Ķ������ ���� ���ų� ������ Ÿ������ ��ȯ�� �� ���� ��� �������� ��Ʈ�ѷ���
		// �޼��带 �������� �ʰ� 400���� �߻��մϴ�.
		// ��û�� �Ķ���Ͱ� �ʼ��� �ƴ϶�� @RequestParam �ֳ����̼��� required �Ӽ�����
		// false�� ������ �ָ� �˴ϴ�.
		// @RequestParam(value="page", required=false) int page
		// �̷��� �ϸ� ��û �Ķ���� "page"�� �������� ������ null���� �����մϴ�.
		
		// defaultValue �Ӽ��� ����ϸ� null ��� �ٸ� ���� ������ �� �ֽ��ϴ�.
		// @RequestParam(value="page", defaultValue="1") int page
		
		if(state.equals("cont")) { // ���뺸���϶���
			boardService.boardHit(board_num);
		}
		BoardBean board = boardService.getBoardCont(board_num);
		
		ModelAndView contM = new ModelAndView();
		contM.addObject("bcont", board);
		contM.addObject("page", page);
		
		if(state.equals("cont")) { // ���뺸���϶�
			contM.setViewName("board/board_cont"); // ���뺸�� ������ ����
		} else if(state.equals("edit")) { // ������
			contM.setViewName("board/board_edit"); 
		} else if(state.equals("del")) { // ������
			contM.setViewName("board/board_del");
		} else if(state.equals("reply")) { // �亯�ޱ� ��
			contM.setViewName("board/board_reply");
		}
		
		return contM;
	}
}
