/*
 * @(#)Product.java $LastChangedRevision: 95 $ $LastChangedDate: 2005-04-29 11:54:40 +0900 (금, 29 4월 2005) $
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

import java.util.Collection;

/**
 * A Product is responsible for keeping track of its 
 * ProductOptions and its owning ProductCategory.
 *  
 * @version     $LastChangedRevision: 95 $ $LastChangedDate: 2005-04-29 11:54:40 +0900 (금, 29 4월 2005) $
 * @author      Daniel Watrous
 *
 */
public interface Product extends CatalogItem {

	public Collection getProductCategoryAssociations();
	public Collection getProductOptionAssociations();
    /**
     * return all associated ProductOptions
     * @return ProductOption[]
     */
    public ProductOption[] getProductOptionsArray();

    /**
     * return all consumer visible associated ProductOptions
     * @return ProductOption[]
     */
	public ProductOption[] getConsumerVisibleProductOptions();
    
    /**
     * associate will link the ProductOption passed in 
     * as a parameter with this Product. 
     * @param ProductOption productOption
     */
    public void associate(ProductOption productOption);
    
    /**
     * if the productOption passed in as a parameter is 
     * contained in the set of ProductOption(s) associated 
     * with this Product it will be dissociated from it.
     * @param ProductOption productOption
     */
    public void dissociate(ProductOption productOption);
    
    /**
     * return the all ProductCategory(s) to which 
     * this Product has been assigned. 
     * @return ProductCategory[]
     */
    public ProductCategory[] getProductCategoriesArray();
	
    /**
     * return the all consumer visible ProductCategory(s) 
     * to which this Product has been assigned. 
     * @return ProductCategory[]
     */
    public ProductCategory[] getConsumerVisibleProductCategories();
    
    /**
     * associate will link the ProductCategory passed in 
     * as a parameter with this Product. 
     * @param ProductCategory productCategory
     */
    //public void associate(ProductCategory productCategory);
    
    /**
     * if the productCategory passed in as a parameter is 
     * contained in the set of ProductCategory(s) associated 
     * with this Product it will be dissociated from it.
     * @param ProductCategory productCategory
     */
    //public void dissociate(ProductCategory productCategory);
    
    
    /**
     * locates and returns the lowest priced ProductOption
     * contained in the set of consumer visible
     * Product Options.
     * @return ProductOption
     */
    public ProductOption getLowestPriceOption();
    
    /**
     * locates and returns the highest priced ProductOption
     * contained in the set of consumer visible
     * Product Options.
     * @return ProductOption
     */
	public ProductOption getHighestPriceOption();
    
    /**
     * locates and returns the most popular ProductOption 
     * contained in the set of consumer visible 
     * ProductOptions.
     * @return ProductOption
     */
	public ProductOption getPopularOption();
    
    /**
     * return the total number of ProductOption(s) that
     * are associated with this Product
     * @return
     */
    public int getCountAssociatedProductOptions();

    /**
     * return the total number of consumer visible
     * ProductOption(s) that are associated with 
     * this Product
     * @return
     */
    public int getCountConsumerVisibleAssociatedProductOptions();

    /**
     * return the total number of ProductCategory(s) that
     * are associated with this Product
     * @return
     */
    public int getCountAssociatedProductCategories();

    /**
     * return the total number of consumer visible
     * ProductCategory(s) that are associated with 
     * this Product
     * @return
     */
    public int getCountConsumerVisibleAssociatedProductCategories();
}
