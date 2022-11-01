package com.board.dao;

import com.board.domain.BoardVo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            pstmt = connection.prepareStatement(
                    "INSERT INTO `board`.posts(title, content, author) VALUES (?, ?, ?)");
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

    public BoardVo selectByNo(int no) throws SQLException {
        Map<String, String> env = System.getenv();
        Connection connection = DriverManager.getConnection(env.get("DB_HOST"),
                env.get("DB_USER"),
                env.get("DB_PASSWORD"));

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardVo boardVo = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT * FROM `board`.`posts` WHERE no = ?");
            pstmt.setInt(1, no);

            rs = pstmt.executeQuery();
            rs.next();
            boardVo = new BoardVo();
            boardVo.setNo(rs.getInt("no"));
            boardVo.setTitle(rs.getString("title"));
            boardVo.setTitle(rs.getString("content"));
            boardVo.setAuthor(rs.getString("author"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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
        return boardVo;
    }

    public List<BoardVo> selectAll() throws SQLException {
        List<BoardVo> postList = new ArrayList<>();
        Map<String, String> env = System.getenv();
        Connection connection = DriverManager.getConnection(env.get("DB_HOST"),
                env.get("DB_USER"),
                env.get("DB_PASSWORD"));

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement("SELECT * FROM `board`.`posts` ORDER BY no DESC;");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int no = rs.getInt("no");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String author = rs.getString("author");
                BoardVo post = new BoardVo(no, title, content, author);
                postList.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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
        return postList;
    }


    public static void main(String[] args) {
    }
}
