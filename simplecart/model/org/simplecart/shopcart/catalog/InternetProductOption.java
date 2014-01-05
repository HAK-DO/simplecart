/*
 * @(#)InternetProductOption.java $LastChangedRevision: 67 $ $LastChangedDate: 2005-04-07 13:15:22 +0900 (목, 07 4 2005) $
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
 * 
 * @version     $LastChangedRevision: 67 $ $LastChangedDate: 2005-04-07 13:15:22 +0900 (목, 07 4 2005) $
 * @author      Daniel Watrous
 *
 */
public class InternetProductOption extends BaseCatalogItem implements ProductOption {

	private String stockKeepingUnitIdentifier;
	private float unitPriceManufacturerSuggestedRetail;
	private float unitPriceActualRetail;
	private float unitWeightInOunces;
	private Collection productAssociations;

	/**
	 * Default no args constructor 
	 */
	public InternetProductOption() {
	}
	
	/**
	 * Full constructor
	 */
	public InternetProductOption(
	        String name,
	        String description,
	        String SKUIdentifier,
	        float unitPriceMSRP,
	        float unitPriceActual,
	        float unitWeightOunces) {
	    this.setName(name);
	    this.setDescription(description);
	    this.stockKeepingUnitIdentifier = SKUIdentifier;
	    this.unitPriceManufacturerSuggestedRetail = unitPriceMSRP;
	    this.unitPriceActualRetail = unitPriceActual;
	    this.unitWeightInOunces = unitWeightOunces;
	    
	}

	// JavaBean style accessors/mutators
    public String getStockKeepingUnitIdentifier() {
		return stockKeepingUnitIdentifier;
	}

    public void setStockKeepingUnitIdentifier(String SKUIdentifier) {
		stockKeepingUnitIdentifier = SKUIdentifier;
	}

	public float getUnitPriceManufacturerSuggestedRetail() {
		return unitPriceManufacturerSuggestedRetail;
	}

	public void setUnitPriceManufacturerSuggestedRetail(float unitPriceManufacturerSuggestedRetail) {
		this.unitPriceManufacturerSuggestedRetail = unitPriceManufacturerSuggestedRetail;
	}

	public float getUnitPriceActualRetail() {
		return unitPriceActualRetail;
	}

	public void setUnitPriceActualRetail(float unitPriceActualRetail) {
		this.unitPriceActualRetail = unitPriceActualRetail;
	}

	public float getUnitWeightInOunces() {
		return unitWeightInOunces;
	}

	public void setUnitWeightInOunces(float unitWeightInOunces) {
		this.unitWeightInOunces = unitWeightInOunces;
	}

	public Collection getProductAssociations() {
		return productAssociations;
	}

	// below are ProductOption implemented methods
    // TODO: implement this method
    public Product[] getProductsArray () {
        return null;
    }
    
    // TODO: implement this method
    public Product[] getConsumerVisibleProducts () {
        return null;
    }
    
    // TODO: implement this method
    public float getSellingPrice () {
        return (float) 0.0;
    }
    
    // TODO: implement this method
    public float getQuantityAvailableForSale () {
        return (float) 0.0;
    }

    // TODO: implement this method
    public int getFulfillmentTimeInDays () {
        return 0;
    }

}