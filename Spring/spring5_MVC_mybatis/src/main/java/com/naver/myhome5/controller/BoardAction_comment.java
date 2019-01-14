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
	
	//게시판 글쓰기 폼
	@RequestMapping(value = "/board_write.nhn")
	public String board_write() {
		return "board/board_write";
	}
	
	//게시판 저장
	@RequestMapping(value = "/board_write_ok.nhn", method = RequestMethod.POST)
	public String board_write_ok(BoardBean board) throws Exception {
		boardService.insertBoard(board); //저장 메서드 호출
		return "redirect:/board_list.nhn";
	}
	
	//게시판 목록
	@RequestMapping(value = "/board_list.nhn")
	public ModelAndView board_list(
			@RequestParam(value="page", defaultValue="1")int page
	) throws Exception {
		
		List<BoardBean> boardlist = new ArrayList<BoardBean>();
		
		//초기화
		int limit = 10; //한 화면에 출력할 레코드 갯수
		
		int listcount = boardService.getListCount(); //총 리스트 수를 반환
		
		//총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;
		
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등 ...)
		int startpage = ((page-1) / 10) * 10 + 1;
		
		//현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등 ...)
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		if (endpage < page) page = endpage;
		
		boardlist = boardService.getBoardList(page); //리스트를 받아옵니다
		
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
	
	//게시판 내용보기, 삭제폼, 수정폼, 답변글폼
	@RequestMapping(value = "/board_cont.nhn")
	public ModelAndView board_cont(
			@RequestParam("board_num") int board_num, 
			@RequestParam("page") int page, 
			@RequestParam("state") String state, 
			HttpServletResponse response) throws Exception {
		// 쪽번호
		// @RequestParam("page") int page
		// 의미
		// int page = Integer.parseInt(request.getparameter("page"));
		
		// 구분값 저장. 내용보기 cont, 수정폼 edit, 삭제폼 del, 답변글폼 reply
		// @RequestParam("state") String state
		// 의미
		// String state = request.getParameter("state");
		
		// 만약 요청한 파라미터의 값이 없거나 지정한 타입으로 변환할 수 없는 경우 스프링은 컨트롤러의
		// 메서드를 실행하지 않고 400에러 발생합니다.
		// 요청한 파라미터가 필수가 아니라면 @RequestParam 애노테이션의 required 속성값을
		// false로 지정해 주면 됩니다.
		// @RequestParam(value="page", required=false) int page
		// 이렇게 하면 요청 파라미터 "page"가 존재하지 않으면 null값을 리턴합니다.
		
		// defaultValue 속성을 사용하면 null 대신 다른 값을 설정할 수 있습니다.
		// @RequestParam(value="page", defaultValue="1") int page
		
		if(state.equals("cont")) { // 내용보기일때만
			boardService.boardHit(board_num);
		}
		BoardBean board = boardService.getBoardCont(board_num);
		
		ModelAndView contM = new ModelAndView();
		contM.addObject("bcont", board);
		contM.addObject("page", page);
		
		if(state.equals("cont")) { // 내용보기일때
			contM.setViewName("board/board_cont"); // 내용보기 페이지 선택
		} else if(state.equals("edit")) { // 수정폼
			contM.setViewName("board/board_edit"); 
		} else if(state.equals("del")) { // 삭제폼
			contM.setViewName("board/board_del");
		} else if(state.equals("reply")) { // 답변달기 폼
			contM.setViewName("board/board_reply");
		}
		
		return contM;
	}
}
