package ac.yongin.cs.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.yongin.cs.board.dao.BoardDao;
import ac.yongin.cs.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;

	public void insertBoard(BoardVO vo) {
		boardDao.insertBoard(vo);
	}
	public void updateBoard(BoardVO vo) {
		boardDao.updateBoard(vo);
	}
	public void deleteBoard(BoardVO vo) {
		boardDao.deleteBoard(vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		return boardDao.getBoard(vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo){
		return boardDao.getBoardList(vo);
	}
}
