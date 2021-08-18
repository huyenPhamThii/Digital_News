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
 * 2021-05-20    4.0        HuyenPT     Four Implement
 * 2021-05-23    5.0        HuyenPT     Five Implement
 */
package controller;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Article;

/**
 * This class contains doGet and doPost methods to handle data when user
 * searching. Servlet will switch to 'Error.jsp' page when any error occurs.
 *
 * <p>
 * Bugs: None
 *
 * @author Pham Thi Huyen
 */
public class SearchController extends HttpServlet {

    /**
     * This method pushes data to page when user changes to another page.
     *
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request is an interface and extends the ServletRequest interface.
     * It able to allow request information for HTTP Servlets. Get keyword,
     * pageIndex from user's browser.
     * <code> javax.servlet.http.HttpServletRequest </code>
     * @param response is where the servlet can write information about the data
     * it will send back. Send pageNumber, listSearch, keyword , pageIndex,
     * top5MostRecent, mostRecentArticle, error to user's browser.
     * <code> javax.servlet.http.HttpServletResponse </code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword").trim();
        ArticleDAO articleDAO = new ArticleDAOImpl();

        //number of article in each page
        int PAGE_SIZE = 3;

        try {
            //left side
            int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));

            int pageNumber = articleDAO.getCountPage(keyword, PAGE_SIZE);
            request.setAttribute("pageNumber", pageNumber);

            ArrayList<Article> listSearch = articleDAO.getListSearch(keyword, PAGE_SIZE, pageIndex);
            request.setAttribute("listSearch", listSearch);

            request.setAttribute("keyword", keyword);
            request.setAttribute("pageIndex", pageIndex);

            //right side
            int LIST_SIZE = 6;
            ArrayList<Article> listTop6 = articleDAO.getTopList(LIST_SIZE);
            request.setAttribute("top5MostRecent", listTop6);

            Article mostRecentArticle = listTop6.get(0);
            request.setAttribute("mostRecentArticle", mostRecentArticle);

            //go to search page
            request.getRequestDispatcher("view/Search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("keyword", keyword);
            request.setAttribute("error", ex);
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
        }
    }

    /**
     * This method pushes data to page when user has clicked to button search.
     *
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request is an interface and extends the ServletRequest interface.
     * It able to allow request information for HTTP Servlets. Get keyword,
     * pageIndex from user's browser.
     * <code> javax.servlet.http.HttpServletRequest </code>
     * @param response is where the servlet can write information about the data
     * it will send back. Send pageNumber, keyword, listSearch, pageIndex,
     * top5MostRecent, mostRecentArticle, mostRecentArticle to user's browser.
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleDAO articleDAO = new ArticleDAOImpl();
        int PAGE_SIZE = 3;

        String keyword = request.getParameter("keyword").trim();
        if (!keyword.isEmpty()) {
            String pageIndexRaw = request.getParameter("pageIndex");
            //if user dosen't choose page index -> auto go to first page
            int pageIndex = 1;
            if (pageIndexRaw != null) {
                pageIndex = Integer.parseInt(pageIndexRaw);
            }

            try {
                //left side
                int pageNumber = articleDAO.getCountPage(keyword, PAGE_SIZE);
                request.setAttribute("pageNumber", pageNumber);

                //right side
                int LIST_SIZE = 6;
                ArrayList<Article> listTop6 = articleDAO.getTopList(LIST_SIZE);
                request.setAttribute("top5MostRecent", listTop6);

                Article mostRecentArticle = listTop6.get(0);
                request.setAttribute("mostRecentArticle", mostRecentArticle);

                ArrayList<Article> listSearch = articleDAO.getListSearch(keyword, PAGE_SIZE, pageIndex);
                //in case not found
                if (listSearch.isEmpty()) {
                    request.setAttribute("keyword", keyword);
                    request.setAttribute("error", "Not Found!!!!");
                    request.getRequestDispatcher("view/Error.jsp").forward(request, response);
                } else {
                    request.setAttribute("listSearch", listSearch);

                    request.setAttribute("keyword", keyword);
                    request.setAttribute("pageIndex", pageIndex);

                    //go to search page
                    request.getRequestDispatcher("view/Search.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                request.setAttribute("error", ex);
                request.getRequestDispatcher("view/Error.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
