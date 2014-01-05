/*
 * @(#)InternetProduct.java $LastChangedRevision: 152 $ $LastChangedDate: 2006-11-07 09:59:35 +0900 (화, 07 11 2006) $
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
import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * @version     $LastChangedRevision: 152 $ $LastChangedDate: 2006-11-07 09:59:35 +0900 (화, 07 11 2006) $
 * @author      Daniel Watrous
 *
 */
public class InternetProduct extends BaseCatalogItem implements Product {

	private Collection productOptionAssociations = new HashSet();
	private Collection productCategoryAssociations = new HashSet();

	/**
	 * Default no args constructor 
	 */
	public InternetProduct() {
	}

	// JavaBean style accessors
	public Collection getProductCategoryAssociations() {
		return productCategoryAssociations;
	}

	public Collection getProductOptionAssociations() {
		return productOptionAssociations;
	}

	// implement methods for Product interface
    public ProductOption[] getProductOptionsArray() {
        return (ProductOption[]) getOptionsCollection().toArray(new ProductOption[getOptionsCollection().size()]);
    }
    
    // this method extracts Options from the productAssociation field
    private Collection getOptionsCollection() {
        Iterator optAssociationsCollection = this.productOptionAssociations.iterator();
        Collection optionsCollection = new HashSet();
        InternetAssociatedOption currentAssociation;
        while (optAssociationsCollection.hasNext()) {
            currentAssociation = (InternetAssociatedOption) optAssociationsCollection.next(); 
            optionsCollection.add(currentAssociation.getProduct());
        }
        return optionsCollection; 
    }

    public ProductOption[] getConsumerVisibleProductOptions() {
        Collection consumerVisibleOptions = getConsumerVisibleOptionsCollection();
        return (ProductOption[]) consumerVisibleOptions.toArray(new ProductOption[consumerVisibleOptions.size()]);
    }

    /* 
     * this method extracts only Consumer Visible Options
     * contained in the productOptionAssociations field
     */
    private Collection getConsumerVisibleOptionsCollection() {
        Iterator optionList = getOptionsCollection().iterator();
        Collection consumerVisibleOptions = new HashSet();
        ProductOption currentOption;
        
        while (optionList.hasNext()) {
            currentOption = (ProductOption) optionList.next();
            if (currentOption.isConsumerVisible()) {
                consumerVisibleOptions.add(currentOption);
            }
        }
        return consumerVisibleOptions;
    }
    
    public void associate(ProductOption productOption) {
        InternetAssociatedOption associatedOption = new InternetAssociatedOption(this, productOption);
        this.productOptionAssociations.add(associatedOption);
    }

    public void dissociate(ProductOption productOption) {
        InternetAssociatedOption checkOption = new InternetAssociatedOption(this, productOption);
        if (productOptionAssociations.contains(checkOption)) productOptionAssociations.remove(checkOption);
    }

    public ProductCategory[] getProductCategoriesArray() {
        return (ProductCategory[]) getCategoriesCollection().toArray(new ProductCategory[getCategoriesCollection().size()]);
    }
    
    // this method extracts Products from the productAssociation field
    private Collection getCategoriesCollection() {
        Iterator catAssociationsCollection = this.productCategoryAssociations.iterator();
        Collection categoriesCollection = new HashSet();
        InternetAssociatedProduct currentAssociation;
        while (catAssociationsCollection.hasNext()) {
            currentAssociation = (InternetAssociatedProduct) catAssociationsCollection.next(); 
            categoriesCollection.add(currentAssociation.getProductCategory());
        }
        return categoriesCollection; 
    }

    public ProductCategory[] getConsumerVisibleProductCategories() {
        Collection consumerVisibleCategories = getConsumerVisibleCategoriesCollection();
        return (ProductCategory[]) consumerVisibleCategories.toArray(new ProductCategory[consumerVisibleCategories.size()]);
    }
    
    /* 
     * this method extracts only Consumer Visible ProductCategory(s)
     * contained in the productCategoryAssociations field
     */
    private Collection getConsumerVisibleCategoriesCollection() {
        Iterator categoryList = getCategoriesCollection().iterator();
        Collection consumerVisibleCategories = new HashSet();
        ProductCategory currentCategory;
        
        while (categoryList.hasNext()) {
            currentCategory = (ProductCategory) categoryList.next();
            if (currentCategory.isConsumerVisible()) {
                consumerVisibleCategories.add(currentCategory);
            }
        }
        return consumerVisibleCategories;
    }

    // TODO: implement this method
    public ProductOption getLowestPriceOption() {
        return null;
    }
    
    // TODO: implement this method
    public ProductOption getHighestPriceOption() {
        return null;
    }

    // TODO: implement this method
    public ProductOption getPopularOption() {
        return null;
    }
    
    public int getCountAssociatedProductOptions() {
        return this.productOptionAssociations.size();
    }
    
    public int getCountConsumerVisibleAssociatedProductOptions() {
        return this.getConsumerVisibleOptionsCollection().size();
    }
    
    public int getCountAssociatedProductCategories() {
        return this.productCategoryAssociations.size();
    }
    
    public int getCountConsumerVisibleAssociatedProductCategories() {
        return this.getConsumerVisibleCategoriesCollection().size();
    }

}