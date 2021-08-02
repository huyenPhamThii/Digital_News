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
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * This class pushes top 1, top 5 and current news to Home page, display a detail
 * article in page, Servlet will switch to 'Error.jsp' page when any error
 * occurs
 *
 * <p>
 * Bugs: None
 *
 * @author Pham Thi Huyen
 */
public class HomeController extends HttpServlet {

    /**
     * This method gets the most recent article and send them to home page. Get
     * article by link (the article display in top 5 most recent). In case
     * article's id null means user doesn't click to any article's link in top
     * 5. So, auto display the most recent article. Otherwise, get article by
     * id.
     *
     * @param request is an interface and extends the ServletRequest interface.
     * It able to allow request information for HTTP Servlets. Get id's article
     * from user's browser. <code> javax.servlet.http.HttpServletRequest </code>
     * @param response is where the servlet can write information about the data
     * it will send back. Send top5MostRecent, mostRecentArticle, timePost, error
     * to user's browser <code> javax.servlet.http.HttpServletResponse </code>
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArticleDAO articleDAO = new ArticleDAOImpl();

            //get top 6 most recents sort by time port
            int sizeList = 6;
            ArrayList<Article> listTop6 = articleDAO.getTopList(sizeList);
            request.setAttribute("top5MostRecent", listTop6);

            //get current news
            String idArticleByLink = request.getParameter("id");
            Article mostRecentArticle;
            if (idArticleByLink == null) {
                mostRecentArticle = listTop6.get(0);
            } else {
                mostRecentArticle = articleDAO.getArticleByID(Integer.parseInt(idArticleByLink));
            }
            request.setAttribute("mostRecentArticle", mostRecentArticle);

            //format time post
            Date timePost = mostRecentArticle.getTimePost();
            SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy - hh:mmaaa");
            String timePostFormat = sdf1.format(timePost).toLowerCase();
            request.setAttribute("timePost", timePostFormat);

            //go to home page
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
