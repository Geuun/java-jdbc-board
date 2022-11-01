package com.board.dao;

import com.board.domain.BoardVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BoardDaoTest {

    BoardVo post1;
    BoardVo post2;
    BoardVo post3;

    @BeforeEach
    void setUp() {

        this.post1 = new BoardVo("글 제목 1", "글 내용 1234", "김재근");
        this.post2 = new BoardVo( "글 제목 2", "글 내용 3456", "김재근");
        this.post3 = new BoardVo( "글 제목 2", "글 내용 6789", "가가가");
        System.out.println("BeforeEach");
    }

    @Test
    @DisplayName("Insert가 잘 되는지 테스트하는 메소드")
    void insertTest() throws SQLException {

        BoardDao boardDao = new BoardDao();

        boardDao.insert(post1);
        boardDao.insert(post2);
        boardDao.insert(post3);
    }
}