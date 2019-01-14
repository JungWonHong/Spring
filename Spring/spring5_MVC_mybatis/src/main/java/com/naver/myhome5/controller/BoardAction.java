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

	// �Խ��� �۾��� ��
	@RequestMapping(value = "/board_write.nhn")
	public String board_write() {
		return "board/board_write";
	}

	// �Խ��� ����
	@RequestMapping(value = "/board_write_ok.nhn", method = RequestMethod.POST)
	public String board_write_ok(BoardBean board) throws Exception {
		boardService.insertBoard(board); // ���� �޼��� ȣ��
		return "redirect:/board_list.nhn";
	}

	// �Խ��� ���
	@RequestMapping(value = "/board_list.nhn")
	public ModelAndView board_list(@RequestParam(value = "page", defaultValue = "1") int page) throws Exception {

		List<BoardBean> boardlist = new ArrayList<BoardBean>();

		// �ʱ�ȭ
		int limit = 10; // �� ȭ�鿡 ����� ���ڵ� ����

		int listcount = boardService.getListCount(); // �� ����Ʈ ���� ��ȯ

		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ ��(1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ ��(10, 20, 30 �� ...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		if (endpage < page)
			page = endpage;

		boardlist = boardService.getBoardList(page); // ����Ʈ�� �޾ƿɴϴ�

		ModelAndView boardListM = new ModelAndView("board/board_list");
		boardListM.addObject("page", page);
		boardListM.addObject("maxpage", maxpage);
		boardListM.addObject("startpage", startpage);
		boardListM.addObject("endpage", endpage);
		boardListM.addObject("listcount", listcount);
		boardListM.addObject("boardlist", boardlist);

		return boardListM;
	}

	// �Խ��� ���뺸��, ������, ������, �亯����
	@RequestMapping(value = "/board_cont.nhn")
	public ModelAndView board_cont(@RequestParam("board_num") int board_num, @RequestParam("page") int page,
			@RequestParam("state") String state, HttpServletResponse response) throws Exception {

		if (state.equals("cont")) { // ���뺸���϶���
			boardService.boardHit(board_num);
		}
		BoardBean board = boardService.getBoardCont(board_num);

		ModelAndView contM = new ModelAndView();
		contM.addObject("bcont", board);
		contM.addObject("page", page);

		if (state.equals("cont")) { // ���뺸���϶�
			contM.setViewName("board/board_cont"); // ���뺸�� ������ ����
		} else if (state.equals("edit")) { // ������
			contM.setViewName("board/board_edit");
		} else if (state.equals("del")) { // ������
			contM.setViewName("board/board_del");
		} else if (state.equals("reply")) { // �亯�ޱ� ��
			contM.setViewName("board/board_reply");
		}

		return contM;
	}

	/* �Խ��� ���� */
	@RequestMapping(value = "/board_edit_ok.nhn", method = RequestMethod.POST)
	public String board_edit_ok(
			BoardBean b, 
			@RequestParam("page") String page, 
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;chaset=UTF-8");
		PrintWriter out = response.getWriter();// ��½�Ʈ�� ����

		// ��ȣ�� �������� DB ������ �����ɴϴ�.
		BoardBean board = boardService.getBoardCont(b.getBoard_num());

		if (!board.getBoard_pass().equals(b.getBoard_pass())) {
			out.println("<script>");
			out.println("alert('����� �ٸ��ϴ�!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// ����� ���ٸ�
			boardService.boardEdit(b);
			return "redirect:/board_cont.nhn?board_num=" + b.getBoard_num() + "&page=" + page + "&state=cont";
		}
		return null;
	}

	/* �Խ��� ���� */
	@RequestMapping(value = "/board_del_ok.nhn", method = RequestMethod.POST)
	public String board_del_ok(
			@RequestParam("board_num") int board_num, 
			@RequestParam("page") int page,
			@RequestParam("pwd") String board_pass, 
			HttpServletResponse response) throws Exception {

		// ���� ���̴� ����ڵ� Ÿ���� ����
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();// ��� ��Ʈ�� ��ü����
		BoardBean board = boardService.getBoardCont(board_num);

		if (!board.getBoard_pass().equals(board_pass)) {
			out.println("<script>");
			out.println("alert('����� �ٸ��ϴ�!')");
			out.println("history.go(-1)");
			out.println("</script>");
		} else {
			boardService.boardDelete(board_num);
			return "redirect:/board_list.nhn?page=" + page;
		}
		return null;
	}

	/* �Խ��� �亯�ޱ� ���� */
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
