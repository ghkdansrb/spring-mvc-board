package com.ksmart.hmk.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String BOARD_NS = "com.ksmart.hmk.BoardMapper";
	
	@Override
	public int insertBoard(Board board) {
		return sqlSession.insert(BOARD_NS+".boardAdd",board);
	}

	@Override
	public int selectTotalBoardCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(BOARD_NS+".selectTotalBoardCount");
	}

	@Override
	public List<Board> selectBoardListPerPage(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(BOARD_NS+".selectBoardListPerPage", map);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update(BOARD_NS+".updateBoard",board);
	}

	@Override
	public Board selectBoardByKey(int boardNo) {
		// TODO Auto-generated method stub		
		return sqlSession.selectOne(BOARD_NS+".selectBoardByKey",boardNo);
		
	}

	@Override
	public int deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.delete(BOARD_NS+".boardRemove",board);
	}
}
