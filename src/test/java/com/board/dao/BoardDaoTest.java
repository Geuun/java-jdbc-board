package com.board.dao;

import com.board.domain.BoardVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

class BoardDaoTest {

    BoardVo post1;
    BoardVo post2;
    BoardVo post3;

    @BeforeEach
    void setUp() {

        this.post1 = new BoardVo(1,"글 제목 1", "글 내용 1234", "김재근");
        this.post2 = new BoardVo(2,"글 제목 2", "글 내용 3456", "김재근");
        this.post3 = new BoardVo(3, "글 제목 2", "글 내용 6789", "가가가");
        System.out.println("BeforeEach");
    }

    @Test
    @DisplayName("Insert가 잘 되는지 테스트하는 메소드")
    void insertTest() throws SQLException {

        BoardDao boardDao = new BoardDao();

        boardDao.insert(post1);
        boardDao.insert(post2);
        boardDao.insert(post3);

        /**
         * Todo: id를 지정 안했을 때 getter를 사용하지 못하는 문제 해결해보기
         * -> 우선 id 값 없이 다 불러올 수 있는 selectAll 을 구현해보기
         */
//        BoardVo post = boardDao.selectByNo(post1.getNo(post1));
    }

    @Test
    @DisplayName("selectAll 메서드 Test")
    void selectAllTest() throws SQLException {

        BoardDao boardDao = new BoardDao();
        List<BoardVo> postList = boardDao.selectAll();
        System.out.println(postList.getClass().getName()); // arraylist 라고나옴...
        System.out.println(postList);

//        [com.board.domain.BoardVo@41200e0c, com.board.domain.BoardVo@40f33492, com.board.domain.BoardVo@4fbdc0f0]

    }
}