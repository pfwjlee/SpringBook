package ac.yongin.cs.board.service;

import java.util.List;

import ac.yongin.cs.board.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

}