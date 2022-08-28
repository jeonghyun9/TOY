package com.board.app.dao;

import com.board.app.domain.Board;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    SqlSessionTemplate template;

    private static String namespace = "com.board.app.dao.boardMapper.";
    public List boardList() {
        List list = template.selectList(namespace + "boardList");
        return list;
    }

    public Board boardView(int bno) {
        Board board = template.selectOne(namespace + "boardView", bno);
        return board;
    }

    public int boardWrite(Board board) {
        return template.insert(namespace + "boardWrite", board);

    }

    public int boardDel(int bno) {
        return template.delete(namespace + "boardDel", bno);
    }

    public int boardModify(Board board) {
        int rowCnt = template.update(namespace + "boardModify", board);
        return rowCnt;
    }
}
