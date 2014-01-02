/*
 * @(#)InternetProduct.java $LastChangedRevision$ $LastChangedDate$
 * Created on Apr 6, 2005
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

public class InternetProductCategoryTest extends TestCaseWithData {

    /**
     * Constructor for InternetProductCategoryTest.
     * @param arg0
     */
    public InternetProductCategoryTest(String arg0) {
        super(arg0);
    }

	public static Test suite() {
		return new TestSuite(InternetProductCategoryTest.class);
	}

    public void testGetProductAssociations() throws Exception {
        initData();
        // there should be 1 product in chocolate category
        assertEquals(chocolate.getProductAssociations().size(),1);
        // there should be 3 products in biteSize category
        assertEquals(biteSize.getProductAssociations().size(),3);
    }

    public void testGetChildProductCategories() throws Exception {
        initData();
        // there should be 2 sub categories in chocolate
        assertEquals(chocolate.getChildProductCategories().size(),2);
        // there should be 0 sub categories in bakingChocolate
        assertEquals(bakingChocolate.getChildProductCategories().size(),0);
    }

    public void testGetParentCategory() throws Exception {
        initData();
        // there should be no parent category to chocolate
        assertNull(chocolate.getParentCategory());
        // bakingChocolate should have parent category chocolate
        assertEquals(bakingChocolate.getParentCategory(),chocolate);
    }

    public void testGetProductsArray() throws Exception {
        initData();
        // verify correct data type
        assertTrue(chocolate.getProductsArray() instanceof Product[]);
        // biteSize length should be 3, for 3 products
        assertEquals(biteSize.getProductsArray().length,3);
    }

    public void testGetConsumerVisibleProducts() throws Exception {
        initData();
        // verify correct data type
        assertTrue(chocolateTreats.getConsumerVisibleProducts() instanceof Product[]);
        // chocolateTreats should have only 2 consumer visible products
        assertEquals(chocolateTreats.getConsumerVisibleProducts().length,2);
        // but it should have three products
        assertEquals(chocolateTreats.getProductsArray().length,3);
    }

    public void testGetChildProductCategoriesArray() throws Exception {
        initData();
        // verify correct data type
        assertTrue(chocolate.getChildProductCategoriesArray() instanceof ProductCategory[]);
        // chocolate should contain 2 child categories
        assertEquals(chocolate.getChildProductCategoriesArray().length,2);
    }

    public void testGetConsumerVisibleChildProductCategories() throws Exception {
        initData();
        // verify correct data type
        assertTrue(chocolate.getConsumerVisibleChildProductCategories() instanceof ProductCategory[]);
        // chocolate should contain 1 consumer visible child category
        assertEquals(chocolate.getConsumerVisibleChildProductCategories().length,1);
    }

    /*
     * Class under test for void associate(Product)
     */
    public void testAssociateProduct() throws Exception {
        initData();
        // bakingChocolate should have 2 products to begin with
        assertEquals(bakingChocolate.getProductAssociations().size(),2);
        // now associate another product
        bakingChocolate.associate(chocoChuncks);
        // verify that it now has 3
        assertEquals(bakingChocolate.getProductAssociations().size(),3);
    }

    /*
     * Class under test for void dissociate(Product)
     */
    public void testDissociateProduct() throws Exception {
        initData();
        // bakingChocolate should have 2 products to begin with
        assertEquals(bakingChocolate.getProductAssociations().size(),2);
        // now dissociate darkChocChips product
        bakingChocolate.dissociate(darkChocChips);
        // verify that it now has 1
        assertEquals(bakingChocolate.getProductAssociations().size(),1);
    }

    /*
     * Class under test for void associate(ProductCategory)
     */
    public void testAssociateProductCategory() throws Exception {
        initData();
        // chocolate should have 2 child categories to begin with
        assertEquals(chocolate.getChildProductCategories().size(),2);
        // now add another category
        chocolate.associate(biteSize);
        // verify that it now has 3
        assertEquals(chocolate.getChildProductCategories().size(),3);
    }

    /*
     * Class under test for void dissociate(ProductCategory)
     */
    public void testDissociateProductCategory() throws Exception {
        initData();
        // chocolate should have 2 products to begin with
        assertEquals(chocolate.getChildProductCategories().size(),2);
        // now dissociate darkChocChips product
        chocolate.dissociate(bakingChocolate);
        // verify that it now has 1
        assertEquals(chocolate.getChildProductCategories().size(),1);
    }

    public void testGetCountAssociatedChildProductCategories() throws Exception {
        initData();
        // chocolate should have 2 child categories
        assertEquals(chocolate.getCountAssociatedChildProductCategories(),2);
        // biteSize should have no child categories
        assertEquals(biteSize.getCountAssociatedChildProductCategories(),0);
    }

    public void testGetCountConsumerVisibleAssociatedChildProductCategories() throws Exception {
        initData();
        // chocolate should have only 1 consumer visible child category
        assertEquals(chocolate.getCountConsumerVisibleAssociatedChildProductCategories(),1);
    }

    public void testGetCountAssociatedProducts() throws Exception {
        initData();
        // chocolate should have 1 associated product
        assertEquals(chocolate.getCountAssociatedProducts(),1);
        // chocolateTreats should have 3 associated products
        assertEquals(chocolateTreats.getCountAssociatedProducts(),3);
    }

    public void testGetCountConsumerVisibleAssociatedProducts() throws Exception {
        initData();
        // chocolateTreats should have only 2 consumer visible associated products
        assertEquals(chocolateTreats.getCountConsumerVisibleAssociatedProducts(),2);
    }

}
