/*
 * Copyright(C) 2021, Pham Thi Huyen
 * J3.L.P0004
 * Digital news
 * 
 * Record of change:    
 * DATE          Version    AUTHOR      DESCRIPTION
 * 2021-05-14    1.0        HuyenPT     First Implement
 * 2021-05-17    2.0        HuyenPT     Second Implement
 * 2021-05-18    3.0        HuyenPT     Third Implement
 * 2021-05-20    4.0        HuyenPT     Four Inplement
 * 2021-05-23    5.0        HuyenPT     Five Inplement
 */
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import entity.Article;

/**
 * This class contains methods to get data from article table in database.
 * Before searching, the data has to normalized (removing spaces from both
 * ends). The method will return an object <code>java.sql.SQLException</code>
 * when any errors querying in the data.
 * <p>
 * Bugs: None
 *
 * @author Pham Thi Huyen
 */
public class ArticleDAOImpl extends DBContext implements dao.ArticleDAO {

    /**
     * This method gets an Article by id. The result contains an
     * <code>Article</code> object with id, title, description, image, author,
     * timePost, shortDes.
     *
     * @param id the id of article. It is an integer number
     * @return an Article, <code>Article</code> object
     * @throws Exception when any error occurs
     */
    @Override
    public Article getArticleByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM article WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Article(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7)
                );
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRs(rs);
            closePS(ps);
            closeCon(conn);
        }
        return null;
    }

    /**
     * This method gets the top most recent articles has sorted descending by
     * time post. The result contains an array list of <code>Article</code>
     * object with id, title, description, image, author, timePost, shortDes,
     * <code>java.util.ArrayList</code>
     * <p>
     * Bugs: None
     *
     * @param size size of list. It is an integer number.
     * @return an ArrayList of <code>Article</code> object,
     * <code>java.util.ArrayList</code>
     * @throws Exception when any error occurs
     */
    @Override
    public ArrayList<Article> getTopList(int size) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> list = new ArrayList<>();
        try {
            conn = getConnection();
            ps = conn.prepareCall("SELECT TOP (?) * FROM article ORDER BY timePost DESC");
            ps.setInt(1, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Article(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7))
                );
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRs(rs);
            closePS(ps);
            closeCon(conn);
        }
        return list;
    }

    /**
     * This method counts number of pages depend on the total Articles has found
     * with title contains keyword in database.
     * <p>
     * Bugs: None
     *
     * @param keyword the input that user has entered to find article.
     * <code> java.lang.String</code>
     * @param pageSize, number of articles will display each page. It is an
     * integer number.
     * @return number of pages that can be found. It is an integer number
     * @throws Exception when any error occurs
     */
    @Override
    public int getCountPage(String keyword, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT COUNT(*) FROM article\n"
                    + "WHERE title LIKE ?");
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            int num;
            while (rs.next()) {
                num = rs.getInt(1) / pageSize;
                if (rs.getInt(1) % pageSize == 0) {
                    return num;
                }
                return (num + 1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRs(rs);
            closePS(ps);
            closeCon(conn);
        }

        return 0;
    }

    /**
     * This method returns an array list of Articles has found from database
     * with title contains keyword.
     *
     * @param keyword, input that user has entered.
     * <code> java.lang.String</code>
     * @param pageSize, number of articles will display each page. It is an
     * integer number.
     * @param pageIndex, page index that user is stay in. It is an integer
     * number.
     * @return an ArrayList of <code>Article</code> object,
     * <code>java.util.ArrayList</code>
     * @throws Exception when any error occurs
     */
    @Override
    public ArrayList<Article> getListSearch(String keyword, int pageSize, int pageIndex) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM article \n"
                    + "WHERE title LIKE ?\n"
                    + "ORDER BY id\n"
                    + "OFFSET ?*?-? ROWS FETCH NEXT ? ROWS ONLY ");
            ps.setString(1, "%" + keyword + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageSize);
            ps.setInt(5, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Article(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7))
                );
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRs(rs);
            closePS(ps);
            closeCon(conn);
        }
        return list;
    }

    /**
     * This method format date.
     *
     * @param time, date to format <code> java.sql.Date </code>
     * @return a date formated, <code>java.lang.String</code>
     */
    public String getDateFormat(Date time) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy - hh:mmaaa");
        String date = sdf1.format(time).toLowerCase();
        return date;
    }

}
