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
package dao;

import java.util.ArrayList;
import entity.Article;

/**
 * This class is interface class contains interface functions to get data from
 * article table in the database.
 * <p>
 * Bugs: None
 *
 * @author Pham Thi Huyen
 */
public interface ArticleDAO {

    /**
     * This method gets the top list most recent articles has sorted descending
     * by time post. The result contains an array list of <code>Article</code>
     * object with id, title, description, image, author, timePost, shortDes,
     * <code>java.util.ArrayList</code>
     *
     * @param size size of list. It is an integer number.
     * @return an ArrayList of <code>Article</code> object,
     * <code>java.util.ArrayList</code>
     * @throws Exception when any exception occurs
     * <code>java.lang.Exception</code>
     */
    public ArrayList<Article> getTopList(int size) throws Exception;

    /**
     * This method gets an Article by id
     *
     * @param id the id of article. It is an integer number.
     * @return an Article, <code>Article</code> object
     * @throws Exception when any exception occurs
     * <code>java.lang.Exception</code>
     */
    public Article getArticleByID(int id) throws Exception;

    /**
     * This method counts number of pages depend on the total Articles has found
     *
     * @param keyword, the input that user has entered.
     * <code>java.lang.String</code>
     * @param pageSize, number of articles will display in each page. It is an
     * integer number.
     * @return number of pages that can be found. It is an integer number.
     * @throws Exception when any exception occurs
     * <code>java.lang.Exception</code>
     */
    public int getCountPage(String keyword, int pageSize) throws Exception;

    /**
     * This method returns an array list of articles has found from database
     * with title contains keyword.
     *
     * @param keyword, input that user has entered.
     * <code>java.lang.String</code>
     * @param pageSize, number of articles will display each page. It is an
     * integer number.
     * @param pageIndex, index of page that user is stay in. It is an integer
     * number.
     * @return an ArrayList of <code>Article</code> object,
     * <code>java.util.ArrayList</code>
     * @throws Exception when any exception occurs
     * <code>java.lang.Exception</code>
     */
    public ArrayList<Article> getListSearch(String keyword, int pageSize, int pageIndex) throws Exception;

}
