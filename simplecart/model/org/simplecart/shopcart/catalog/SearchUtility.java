/*
 * @(#)SearchUtility.java $LastChangedRevision: 59 $ $LastChangedDate: 2005-04-06 13:52:56 +0900 (수, 06 4월 2005) $
 * Created on April 1, 2005
 *
 * Copyright (c) 2005, Daniel Watrous
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or 
 * without modification, are governed by the license found in
 * the following places:
 * license.txt included with this distribution, or
 * http://www.simplecart.org/license.html
 * 
 */
package org.simplecart.shopcart.catalog;

/**
 * Helper class to contain all Meta Tag values for display
 * in final HTML for search engines.
 * 
 * @version     $LastChangedRevision: 59 $ $LastChangedDate: 2005-04-06 13:52:56 +0900 (수, 06 4월 2005) $
 * @author      Daniel Watrous
 *
 */
public class SearchUtility {

    private String searchMetaAuthor;
    private String searchMetaKeywords;
    private String searchMetaDescription;
    private String searchMetaDate;
    private String searchMetaCopyright;

    /**
     * Default no args constructor 
     */
    public SearchUtility() {
    }
    
    /**
     * Full constructor
     * @param searchMetaAuthor
     * @param searchMetaKeywords
     * @param searchMetaDescription
     * @param searchMetaDate
     * @param searchMetaCopyright
     */
    public SearchUtility(
            String searchMetaAuthor,
            String searchMetaKeywords,
            String searchMetaDescription,
            String searchMetaDate,
            String searchMetaCopyright) {
        this.searchMetaAuthor = searchMetaAuthor;
        this.searchMetaKeywords = searchMetaKeywords;
        this.searchMetaDescription = searchMetaDescription;
        this.searchMetaDate = searchMetaDate;
        this.searchMetaCopyright = searchMetaCopyright;
    }

    // JavaBean style accessors/mutators
    public String getSearchMetaCopyright() {
        return searchMetaCopyright;
    }

    public void setSearchMetaCopyright(String searchMetaCopyright) {
        this.searchMetaCopyright = searchMetaCopyright;
    }

    public String getSearchMetaDate() {
        return searchMetaDate;
    }

    public void setSearchMetaDate(String searchMetaDate) {
        this.searchMetaDate = searchMetaDate;
    }

    public String getSearchMetaAuthor() {
        return searchMetaAuthor;
    }

    public void setSearchMetaAuthor(String searchMetaTitle) {
        this.searchMetaAuthor = searchMetaTitle;
    }

    public String getSearchMetaKeywords() {
        return searchMetaKeywords;
    }

    public void setSearchMetaKeywords(String searchMetaKeywords) {
        this.searchMetaKeywords = searchMetaKeywords;
    }

    public String getSearchMetaDescription() {
        return searchMetaDescription;
    }

    public void setSearchMetaDescription(String searchMetaDescription) {
        this.searchMetaDescription = searchMetaDescription;
    }
}
