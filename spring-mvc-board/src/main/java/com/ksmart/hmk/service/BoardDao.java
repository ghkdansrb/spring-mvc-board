package com.ksmart.hmk.service;

import java.util.List;
import java.util.Map;

public interface BoardDao{
	public int insertBoard(Board board);
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
	public int updateBoard(Board board);
	public Board selectBoardByKey(int boardNo);
	public int deleteBoard(Board board);
}
