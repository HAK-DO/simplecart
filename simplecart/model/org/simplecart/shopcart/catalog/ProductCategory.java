/*
 * @(#)ProductCategory.java $LastChangedRevision: 74 $ $LastChangedDate: 2005-04-10 03:15:30 +0900 (일, 10 4월 2005) $
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
 * A ProductCategory is responsible for keeping track of 
 * its Products and child ProductCategories.
 * 
 * @version     $LastChangedRevision: 74 $ $LastChangedDate: 2005-04-10 03:15:30 +0900 (일, 10 4월 2005) $
 * @author      Daniel Watrous
 *
 */
public interface ProductCategory extends CatalogItem {
    public ProductCategory getParentCategory ();
    public void setParentCategory (ProductCategory parentCategory);
	/**
     * return all Products associated with this ProductCategory
     * as an array of Products
     * @return Product[]
	 */
    public Product[] getProductsArray ();
    
    /**
     * return all consumer visible Products associated with 
     * this ProductCategory as an array of Products
     * @return Product[]
     */
    public Product[] getConsumerVisibleProducts ();

    /**
     * return all child ProductCategory(s) as an array of
     * ProductCategorys
     * @return ProductCategory[]
     */
    public ProductCategory[] getChildProductCategoriesArray ();

    /**
     * return all consumer visible child ProductCategory(s)
     * as an array
     * @return ProductCategory[]
     */
    public ProductCategory[] getConsumerVisibleChildProductCategories ();
    
    /**
     * associate will link the Product passed in 
     * as a parameter with this ProductCategory. 
     * @param Product product
     */
    public void associate (Product product); 
    
    /**
     * if product is contained in the set of Product(s) 
     * associated with this ProductCategory it will 
     * be dissociated from it.
     * @param Product product
     */
    public void dissociate (Product product);
    
    /**
     * associate will link the ProductCategory pass in 
     * as a parameter with this ProductCategory.  The 
     * productCategory parameter will assume a child role
     * in the association. 
     * @param ProductCategory childProductCategory
     */
    public void associate (ProductCategory childProductCategory);

    /**
     * if the childProductCategory passed in as a parameter 
     * is contained in the set of ProductCategory(s) 
     * associated with this ProductCategory it will 
     * be dissociated from it.
     * @param ProductCategory childProductCategory
     */
    public void dissociate (ProductCategory childProductCategory);
    
    /**
     * return the total number of child ProductCategory(s) that
     * are associated with this ProductCategory
     * @return
     */
    public int getCountAssociatedChildProductCategories();

    /**
     * return the total number of consumer visible child
     * ProductCategory(s) that are associated with 
     * this ProductCategory
     * @return
     */
    public int getCountConsumerVisibleAssociatedChildProductCategories();
    
    /**
     * return the total number of Product(s) that
     * are associated with this ProductCategory
     * @return
     */
    public int getCountAssociatedProducts();

    /**
     * return the total number of consumer visible
     * Product(s) that are associated with 
     * this ProductCategory
     * @return
     */
    public int getCountConsumerVisibleAssociatedProducts();
}
