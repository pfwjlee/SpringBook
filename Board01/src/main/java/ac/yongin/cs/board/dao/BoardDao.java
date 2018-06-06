package ac.yongin.cs.board.dao;

import java.util.List;

import ac.yongin.cs.board.vo.BoardVO;

public interface BoardDao {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

}