package com.ksmart.hmk.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksmart.hmk.service.Board;
import com.ksmart.hmk.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.POST)
	public String deleteBoard(Board board){
		int result = boardService.deleteBoard(board);
		if(result == 1){
			return "redirect:/board/boardList";
		}else{
			return "redirect:/board/boardRemove?boardNo="+board.getBoardNo();
		}
	}
	
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.GET)
	public String deleteBoard(){
		return "/board/boardRemove";
	}
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public String boardUpdate(Board board){
		int result = boardService.updateBoard(board);
		if(result == 1){
			return "redirect:/board/boardView?boardNo="+board.getBoardNo();
		}else{
			return "redirect:/board/boardModify?boardNo="+board.getBoardNo();
		}
	}
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)
	public String boardUpdate(Model model,
			@RequestParam(value="boardNo")int boardNo){
		model.addAttribute("board", boardService.selectBoardByKey(boardNo));		
		return "/board/boardModify";
	}
	
	@RequestMapping(value="/board/boardView", method=RequestMethod.GET)
	public String selectBoardByKey(Model model, 
			@RequestParam(value="boardNo") int boardNo){
		System.out.println(boardNo);
		model.addAttribute("board", boardService.selectBoardByKey(boardNo));
		return "/board/boardView";
		
	}
	
	@RequestMapping(value="/board/boardList")
	public String boardList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap 
			= boardService.getBoardListCurrentPerPage(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "/board/boardList";
		
	}
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board){
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		return "/board/boardAdd"; //forward
	}

}
