package com.board.app.controller;

import com.board.app.domain.Board;
import com.board.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService service;

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String boardList(Model model) {
//        List list = null;
//        System.out.println(list);
//        list = service.boardList();
//        System.out.println(list);
//        model.addAttribute(list);
//        model.addAttribute("hello", "HIru~~");
//        return "board/list";
//    }

    /** 게시판 목록 **/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void boardList(Model model) throws Exception {
        List<?> list = null;
        System.out.println("[BEFORE LIST] = " + list);
        list = service.boardList();
        System.out.println("[AFTER LIST] = " + list);
        model.addAttribute("list", list);

    }

    /** 게시판 상세보기 **/
    @RequestMapping(value = "/view")
    public void boardView(@RequestParam int bno, Model model) {
        Board board = new Board();
        board = service.boardView(bno);
        model.addAttribute(board);
    }

    /** 게시글 글쓰기 **/
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String boardWrite(Board board, Model model) throws Exception {
        int rowCnt = service.boardWrite(board);
        System.out.println("#############################");
        System.out.println("### [Insert DATA] = " + rowCnt + " ###");
        System.out.println("#############################");
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public void boardWrite() {
    }

    /** 게시판 글 삭제 **/
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String boardDel(@RequestParam int bno,Board board,Model model) {
        int rowCnt = service.boardDel(bno);
        model.addAttribute("bno",board.getBno());
        System.out.println("#############################");
        System.out.println("### [Delete DATA] = " + rowCnt +"###");
        System.out.println("#############################");
        return "redirect:/board/list";
    }

    /** 게시판 글 수정 **/
//    @RequestMapping(value = "/modify", method = RequestMethod.POST)
//    public String boardModify(Board board, Model model) {
//        int rowCnt = service.boardModify(board);
//        System.out.println("#############################");
//        System.out.println("### [Modify DATA] = " + rowCnt +"###");
//        System.out.println("#############################");
////        model.addAttribute(board);
//        return "redirect:/board/view?bno="+board.getBno();
//    }
//    @RequestMapping(value = "/modify", method = RequestMethod.GET)
//    public void boardModify(@RequestParam("bno") int bno, Model model) {
//        Board board = service.boardView(bno);
//        model.addAttribute(board);
//    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String postModify(Board board) throws Exception {

        service.boardModify(board);

        return "redirect:/board/view?bno=" + board.getBno();
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {

        Board board = service.boardView(bno);

        model.addAttribute("board", board);
    }

}
