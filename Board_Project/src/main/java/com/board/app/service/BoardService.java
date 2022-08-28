package com.board.app.service;

import com.board.app.dao.BoardDao;
import com.board.app.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;
    public List<Board> boardList() {
        List list = boardDao.boardList();
        return list;
    }

    public Board boardView(int bno) {
        Board board = boardDao.boardView(bno);
        return board;
    }

    public int boardWrite(Board board) {
        int rowCnt = boardDao.boardWrite(board);
        return rowCnt;
    }

    public int boardDel(int bno) {
        int rowCnt = boardDao.boardDel(bno);
        return rowCnt;
    }

    public int boardModify(Board board) {
        int rowCnt =  boardDao.boardModify(board);
        return rowCnt;
    }
}
