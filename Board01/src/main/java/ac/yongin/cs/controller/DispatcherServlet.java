package ac.yongin.cs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ac.yongin.cs.board.dao.BoardDao;
import ac.yongin.cs.board.dao.BoardDaoImpl;
import ac.yongin.cs.board.vo.BoardVO;
import ac.yongin.cs.user.dao.UserDao;
import ac.yongin.cs.user.dao.UserDaoImpl;
import ac.yongin.cs.user.vo.UserVO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");

			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDao dao = new UserDaoImpl();
			UserVO user = dao.getUser(vo);
			
			if(user != null) {
				System.out.println("로그인성공");
				response.sendRedirect("getBoardList.do");
			}
			else {
				System.out.println("로그인실패");
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			HttpSession session=request.getSession();
			session.invalidate();
			
			response.sendRedirect("login.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDao dao = new BoardDaoImpl();
			dao.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDao dao = new BoardDaoImpl();
			dao.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDao dao = new BoardDaoImpl();
			dao.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상제조회 처리");
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDao boardDao = new BoardDaoImpl();
			BoardVO board = boardDao.getBoard(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			BoardVO vo = new BoardVO();
			BoardDao boardDao = new BoardDaoImpl();
			List<BoardVO> boardList = boardDao.getBoardList(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		} 
	}

}
