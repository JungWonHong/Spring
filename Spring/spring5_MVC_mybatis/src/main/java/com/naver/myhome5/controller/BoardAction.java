package com.naver.myhome5.controller;

import java.io.PrintWriter;
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

@Controller
public class BoardAction {

	@Autowired
	private BoardDAOImpl boardService;

	// 게시판 글쓰기 폼
	@RequestMapping(value = "/board_write.nhn")
	public String board_write() {
		return "board/board_write";
	}

	// 게시판 저장
	@RequestMapping(value = "/board_write_ok.nhn", method = RequestMethod.POST)
	public String board_write_ok(BoardBean board) throws Exception {
		boardService.insertBoard(board); // 저장 메서드 호출
		return "redirect:/board_list.nhn";
	}

	// 게시판 목록
	@RequestMapping(value = "/board_list.nhn")
	public ModelAndView board_list(@RequestParam(value = "page", defaultValue = "1") int page) throws Exception {

		List<BoardBean> boardlist = new ArrayList<BoardBean>();

		// 초기화
		int limit = 10; // 한 화면에 출력할 레코드 갯수

		int listcount = boardService.getListCount(); // 총 리스트 수를 반환

		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등 ...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		if (endpage < page)
			page = endpage;

		boardlist = boardService.getBoardList(page); // 리스트를 받아옵니다

		ModelAndView boardListM = new ModelAndView("board/board_list");
		boardListM.addObject("page", page);
		boardListM.addObject("maxpage", maxpage);
		boardListM.addObject("startpage", startpage);
		boardListM.addObject("endpage", endpage);
		boardListM.addObject("listcount", listcount);
		boardListM.addObject("boardlist", boardlist);

		return boardListM;
	}

	// 게시판 내용보기, 삭제폼, 수정폼, 답변글폼
	@RequestMapping(value = "/board_cont.nhn")
	public ModelAndView board_cont(@RequestParam("board_num") int board_num, @RequestParam("page") int page,
			@RequestParam("state") String state, HttpServletResponse response) throws Exception {

		if (state.equals("cont")) { // 내용보기일때만
			boardService.boardHit(board_num);
		}
		BoardBean board = boardService.getBoardCont(board_num);

		ModelAndView contM = new ModelAndView();
		contM.addObject("bcont", board);
		contM.addObject("page", page);

		if (state.equals("cont")) { // 내용보기일때
			contM.setViewName("board/board_cont"); // 내용보기 페이지 선택
		} else if (state.equals("edit")) { // 수정폼
			contM.setViewName("board/board_edit");
		} else if (state.equals("del")) { // 삭제폼
			contM.setViewName("board/board_del");
		} else if (state.equals("reply")) { // 답변달기 폼
			contM.setViewName("board/board_reply");
		}

		return contM;
	}

	/* 게시판 수정 */
	@RequestMapping(value = "/board_edit_ok.nhn", method = RequestMethod.POST)
	public String board_edit_ok(
			BoardBean b, 
			@RequestParam("page") String page, 
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;chaset=UTF-8");
		PrintWriter out = response.getWriter();// 출력스트림 생성

		// 번호를 기준으로 DB 내용을 가져옵니다.
		BoardBean board = boardService.getBoardCont(b.getBoard_num());

		if (!board.getBoard_pass().equals(b.getBoard_pass())) {
			out.println("<script>");
			out.println("alert('비번이 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// 비번이 같다면
			boardService.boardEdit(b);
			return "redirect:/board_cont.nhn?board_num=" + b.getBoard_num() + "&page=" + page + "&state=cont";
		}
		return null;
	}

	/* 게시판 삭제 */
	@RequestMapping(value = "/board_del_ok.nhn", method = RequestMethod.POST)
	public String board_del_ok(
			@RequestParam("board_num") int board_num, 
			@RequestParam("page") int page,
			@RequestParam("pwd") String board_pass, 
			HttpServletResponse response) throws Exception {

		// 웹상에 보이는 언어코딩 타입을 지정
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();// 출력 스트림 객체생성
		BoardBean board = boardService.getBoardCont(board_num);

		if (!board.getBoard_pass().equals(board_pass)) {
			out.println("<script>");
			out.println("alert('비번이 다릅니다!')");
			out.println("history.go(-1)");
			out.println("</script>");
		} else {
			boardService.boardDelete(board_num);
			return "redirect:/board_list.nhn?page=" + page;
		}
		return null;
	}

	/* 게시판 답변달기 저장 */
	@RequestMapping(value = "/board_reply_ok.nhn", method = RequestMethod.POST)
	public String board_reply_ok(
			BoardBean b, 
			@RequestParam("page") String page) throws Exception {
		boardService.refEdit(b);
		b.setBoard_re_lev(b.getBoard_re_lev() + 1);
		b.setBoard_re_seq(b.getBoard_re_seq() + 1);
		
		boardService.boardReplyOk(b);
		
		return "redirect:/board_list.nhn?page=" + page;
	}

}
