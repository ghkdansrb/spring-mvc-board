package com.ksmart.hmk.service;

import java.util.Map;

public interface BoardService {
	public int addBoard(Board board);
	Map<String, Object> getBoardListCurrentPerPage(int currentPage);
	public int updateBoard(Board board);
	public Board selectBoardByKey(int boardNo);
	public int deleteBoard(Board board);
	
}
