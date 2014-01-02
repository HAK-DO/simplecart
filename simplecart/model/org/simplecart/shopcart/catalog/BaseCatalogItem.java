/*
 * @(#)BaseCatalogItem.java $LastChangedRevision: 63 $ $LastChangedDate: 2005-04-07 09:09:37 +0900 (목, 07 4월 2005) $
 * Created on February 10, 2005, 8:33 PM
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
 * 
 * @version $LastChangedRevision: 63 $ $LastChangedDate: 2005-04-07 09:09:37 +0900 (목, 07 4월 2005) $
 * @author Daniel Watrous
 */
public abstract class BaseCatalogItem implements CatalogItem {
    private Long id;
    private SearchUtility searchDetails;
    private String name;
    private String description;
    private boolean consumerVisible;

    /**
     * Default no args constructor
     */
    public BaseCatalogItem() {
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SearchUtility getSearchDetails() {
        return searchDetails;
    }

    public void setSearchDetails(SearchUtility searchDetails) {
        this.searchDetails = searchDetails;
    }
    
    public void setConsumerVisible(boolean consumerVisible) {
        this.consumerVisible = consumerVisible;
    }
    
    // below are CatalogItem method(s)
    public boolean isConsumerVisible() {
        return consumerVisible;
    }
}