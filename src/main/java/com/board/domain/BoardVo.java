package com.board.domain;

public class BoardVo {
    private String no;
    private String title;
    private String content;
    private String author;

    public BoardVo(String  no, String title, String content, String author) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String  getNo() {
        return no;
    }

    public void setNo(String  no) {
        this.no = no;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
