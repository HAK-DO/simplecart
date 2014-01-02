/*
 * @(#)InternetProductCategory.java $LastChangedRevision: 74 $ $LastChangedDate: 2005-04-10 03:15:30 +0900 (일, 10 4월 2005) $
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
 * An internet oriented implementation of the interface
 * ProductCategory.
 * @version $LastChangedRevision: 74 $ $LastChangedDate: 2005-04-10 03:15:30 +0900 (일, 10 4월 2005) $
 * @author Daniel Watrous
 * 
 */
public class InternetProductCategory extends BaseCatalogItem implements
        ProductCategory {
    private Collection productAssociations = new HashSet();
    private Collection childProductCategories = new HashSet();
    private ProductCategory parentCategory;
    
    /**
     * Default no args constructor
     */
    public InternetProductCategory() {
    }
    
    /**
     * constructor with parent category
     */
    public InternetProductCategory(ProductCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    // JavaBean style accessors/mutators
    public Collection getProductAssociations() {
        return productAssociations;
    }

    public Collection getChildProductCategories() {
        return childProductCategories;
    }

    public ProductCategory getParentCategory() {
        return parentCategory;
    }
    
    public void setParentCategory(ProductCategory parentCategory) {
        this.parentCategory = parentCategory;
    }
    
    /*
     * Implement ProductCatalog interface methods
     */ 
    public Product[] getProductsArray() {
        return (Product[]) getProductsCollection().toArray(new Product[getProductsCollection().size()]);
    }
    
    // this method extracts Products from the productAssociation field
    private Collection getProductsCollection() {
        Iterator prodAssociationsCollection = this.productAssociations.iterator();
        Collection productsCollection = new HashSet();
        InternetAssociatedProduct currentAssociation;
        while (prodAssociationsCollection.hasNext()) {
            currentAssociation = (InternetAssociatedProduct) prodAssociationsCollection.next(); 
            productsCollection.add(currentAssociation.getProduct());
        }
        return productsCollection; 
    }

    public Product[] getConsumerVisibleProducts () {
        Collection consumerVisibleProducts = getConsumerVisibleProductsCollection();
        return (Product[]) consumerVisibleProducts.toArray(new Product[consumerVisibleProducts.size()]);
    }
    
    /* 
     * this method extracts only Consumer Visible Products
     * contained in the productAssociation field
     */
    private Collection getConsumerVisibleProductsCollection() {
        Iterator productList = getProductsCollection().iterator();
        Collection consumerVisibleProducts = new HashSet();
        Product currentProduct;
        
        while (productList.hasNext()) {
            currentProduct = (Product) productList.next();
            if (currentProduct.isConsumerVisible()) {
                consumerVisibleProducts.add(currentProduct);
            }
        }
        return consumerVisibleProducts;
    }
    
    public ProductCategory[] getChildProductCategoriesArray () {
        return (ProductCategory[]) this.childProductCategories.toArray(new ProductCategory[this.childProductCategories.size()]);
    }

    public ProductCategory[] getConsumerVisibleChildProductCategories () {
        Collection consumerVisibleChildCategories = getConsumerVisibleChildProductCategoriesCollection();
        return (ProductCategory[]) consumerVisibleChildCategories.toArray(new ProductCategory[consumerVisibleChildCategories.size()]);
    }
    
    private Collection getConsumerVisibleChildProductCategoriesCollection() {
        Iterator productCategoryList = this.childProductCategories.iterator();
        Collection consumerVisibleProductCategories = new HashSet();
        ProductCategory currentProductCategory;
        
        while (productCategoryList.hasNext()) {
            currentProductCategory = (ProductCategory) productCategoryList.next();
            if (currentProductCategory.isConsumerVisible()) {
                consumerVisibleProductCategories.add(currentProductCategory);
            }
        }        
        return consumerVisibleProductCategories;
    }
 
    public void associate(Product product) {
        InternetAssociatedProduct associatedProduct = new InternetAssociatedProduct(this, product);
        if (!this.childProductCategories.contains(associatedProduct)) {
            this.productAssociations.add(associatedProduct);
        }
    }
    
    public void dissociate (Product product) {
        InternetAssociatedProduct checkProduct = new InternetAssociatedProduct(this, product);
        if (productAssociations.contains(checkProduct)) productAssociations.remove(checkProduct);
    }

    
    public void associate (ProductCategory childProductCategory) {
        if (!this.childProductCategories.contains(childProductCategory)) {
            this.childProductCategories.add(childProductCategory);
            childProductCategory.setParentCategory(this);
        }
    }
    
    public void dissociate (ProductCategory childProductCategory) {
        if (this.childProductCategories.contains(childProductCategory)) {
            this.childProductCategories.remove(childProductCategory);
            childProductCategory.setParentCategory(null);
        }
    }
    
    public int getCountAssociatedChildProductCategories() {
        return this.childProductCategories.size();
    }
    
    public int getCountConsumerVisibleAssociatedChildProductCategories() {
        return getConsumerVisibleChildProductCategoriesCollection().size();
    }
    
    public int getCountAssociatedProducts() {
        return this.productAssociations.size();
    }
    
    public int getCountConsumerVisibleAssociatedProducts() {
        return this.getConsumerVisibleProductsCollection().size();
    }

}
