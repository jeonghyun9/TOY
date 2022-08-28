package com.board.app.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("Board")
public class Board {

     private int bno;
     private String title;
     private String content;
     private String id;
     private Date reg_date;
     private Date up_date;
     private int hits;

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
                ", hits=" + hits +
                '}';
    }

    public Board() {
    }

    public Board(int bno, String title, String content, String id, Date reg_date, Date up_date, int hits) {
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.id = id;
        this.reg_date = reg_date;
        this.up_date = up_date;
        this.hits = hits;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
