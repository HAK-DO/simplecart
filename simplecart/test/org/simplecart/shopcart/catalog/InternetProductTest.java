/*
 * @(#)InternetProduct.java $LastChangedRevision$ $LastChangedDate$
 * Created on Apr 9, 2005
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

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @version     $LastChangedRevision$ $LastChangedDate$
 * @author      Daniel Watrous
 */

public class InternetProductTest extends TestCaseWithData {

    /**
     * Constructor for InternetProductTest.
     * @param arg0
     */
    public InternetProductTest(String arg0) {
        super(arg0);
    }

	public static Test suite() {
		return new TestSuite(InternetProductTest.class);
	}

    public void testGetProductCategoryAssociations()throws Exception {
        initData();
        //  millionDollarBar should belong to only 1 category
        assertEquals(1,millionDollarBar.getProductCategoryAssociations().size());
        // chocoChuncks should belong to 2 categories
        assertEquals(2,chocoChuncks.getProductCategoryAssociations().size());
    }

    public void testGetProductOptionAssociations()throws Exception {
        //TODO Implement getProductOptionAssociations().
    }

    public void testGetProductOptionsArray()throws Exception {
        //TODO Implement getProductOptionsArray().
    }

    public void testGetConsumerVisibleProductOptions()throws Exception {
        //TODO Implement getConsumerVisibleProductOptions().
    }

    public void testAssociate()throws Exception {
        //TODO Implement associate().
    }

    public void testDissociate()throws Exception {
        //TODO Implement dissociate().
    }

    public void testGetProductCategoriesArray()throws Exception {
        //TODO Implement getProductCategoriesArray().
    }

    public void testGetConsumerVisibleProductCategories()throws Exception {
        //TODO Implement getConsumerVisibleProductCategories().
    }

    public void testGetLowestPriceOption()throws Exception {
        //TODO Implement getLowestPriceOption().
    }

    public void testGetHighestPriceOption()throws Exception {
        //TODO Implement getHighestPriceOption().
    }

    public void testGetPopularOption() throws Exception {
        //TODO Implement getPopularOption().
    }

    public void testGetCountAssociatedProductOptions() throws Exception {
        //TODO Implement getCountAssociatedProductOptions().
    }

    public void testGetCountConsumerVisibleAssociatedProductOptions() throws Exception {
        //TODO Implement getCountConsumerVisibleAssociatedProductOptions().
    }

    public void testGetCountAssociatedProductCategories() throws Exception {
        //TODO Implement getCountAssociatedProductCategories().
    }

    public void testGetCountConsumerVisibleAssociatedProductCategories() throws Exception {
        //TODO Implement getCountConsumerVisibleAssociatedProductCategories().
    }

}
