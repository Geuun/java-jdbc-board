package com.board.dao;

import com.board.domain.BoardVo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class BoardDao {
    /**
     * Insert 메소드
     * 게시물을 Insert하기 위한 메소드
     */
    public void insert(BoardVo boardVo) throws SQLException {
        Map<String, String> env = System.getenv();
        Connection connection = DriverManager.getConnection(env.get("DB_HOST"),
                env.get("DB_USER"),
                env.get("DB_PASSWORD"));

        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("INSERT INTO `board`.posts(title, content, author) VALUES (?, ?, ?)");
            pstmt.setString(1, boardVo.getTitle());
            pstmt.setString(2, boardVo.getContent());
            pstmt.setString(3, boardVo.getAuthor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
