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
package entity;

import java.sql.Date;

/**
 * This class describe data fields of <code>Article</code> object.
 *
 * @author Pham Thi Huyen
 */
public class Article {

    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private Date timePost;
    private String shortDes;

    /**
     * Empty constructor
     */
    public Article() {
    }

    /**
     * Full constructor
     *
     * @param id is an integer number
     * @param title <code>java.lang.String</code>
     * @param description <code>java.lang.String</code>
     * @param image <code>java.lang.String</code>
     * @param author <code>java.lang.String</code>
     * @param timePost <code>java.sql.Date</code>
     * @param shortDes, short description <code>java.lang.String</code>
     */
    public Article(int id, String title, String description, String image, String author, Date timePost, String shortDes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDes = shortDes;
    }

    /**
     * Get id of article
     *
     * @return id is an integer number
     */
    public int getId() {
        return id;
    }

    /**
     * Set id of article
     *
     * @param id is an integer number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get title of article
     *
     * @return title <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title of article
     *
     * @param title <code>java.lang.String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get description of article
     *
     * @return description <code>java.lang.String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of article
     *
     * @param description <code>java.lang.String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get image of article
     *
     * @return image <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image of article
     *
     * @param image <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get author of article
     *
     * @return author <code>java.lang.String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author of article
     *
     * @param author <code>java.lang.String</code>
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get time post of article
     *
     * @return time post <code>java.sql.Date</code>
     */
    public Date getTimePost() {
        return timePost;
    }

    /**
     * Set time post of article
     *
     * @param timePost, time post <code>java.sql.Date</code>
     */
    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    /**
     * Get short description of article
     *
     * @return short description <code>java.lang.String</code>
     */
    public String getShortDes() {
        return shortDes;
    }

    /**
     * Set short description of article
     *
     * @param shortDes, short description <code>java.lang.String</code>
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }
}
