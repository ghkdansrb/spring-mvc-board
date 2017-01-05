package com.ksmart.hmk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int addBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board);
	}

	@Override
	public Map<String, Object> getBoardListCurrentPerPage(int currentPage) {
		// pagePerRow, beginRow
		
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;

		// totalCount
		int totalRowCount = boardDao.selectTotalBoardCount();
		
		// lastPage
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }

		// boardList
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Board> list = boardDao.selectBoardListPerPage(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		return returnMap;
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(board);
	}

	@Override
	public Board selectBoardByKey(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardByKey(boardNo);
	}

	@Override
	public int deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(board);
	}

}
