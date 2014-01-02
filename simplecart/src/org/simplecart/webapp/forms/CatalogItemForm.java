/*
 * CatalogItemForm.java
 *
 * Created on February 11, 2005, 4:09 PM
 */

package org.simplecart.webapp.forms;

import org.apache.struts.validator.ValidatorActionForm;

/**
 *
 * @author Daniel Watrous
 */
public class CatalogItemForm extends ValidatorActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 9085387247883139408L;

	/**
     * activity is used to tell DispatchAction which 
     * method to call on the Action(s).
     */
    private String activity;
    
    /**
     * identifier value for use with persistence
     */
    private Long id;
    
    /**
     * identifier values used to associate 
     * products to categories and options to products
     */
    private Long categoryId;
    private Long productId;

    /**
     * begin base and inherited class values
     */
    private String name;
    private String description;
    private String stockKeepingUnitIdentifier;
    private float unitPriceManufacturerSuggestedRetail;
    private float unitPriceActualRetail;
    private float unitWeightInOunces;
    
    /**
     * begin associated class SearchUtility values
     */
    private String searchMetaAuthor;
    private String searchMetaKeywords;
    private String searchMetaDescription;
    private String searchMetaDate;
    private String searchMetaCopyright;
    
    /** Creates a new instance of CatalogItemForm */
    public CatalogItemForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStockKeepingUnitIdentifier() {
        return stockKeepingUnitIdentifier;
    }

    public void setStockKeepingUnitIdentifier(String skuIdentifier) {
        this.stockKeepingUnitIdentifier = skuIdentifier;
    }

    public float getUnitPriceManufacturerSuggestedRetail() {
        return unitPriceManufacturerSuggestedRetail;
    }

    public void setUnitPriceManufacturerSuggestedRetail(float dollarValueMSRP) {
        this.unitPriceManufacturerSuggestedRetail = dollarValueMSRP;
    }

    public float getUnitPriceActualRetail() {
        return unitPriceActualRetail;
    }

    public void setUnitPriceActualRetail(float dollarValueActualPrice) {
        this.unitPriceActualRetail = dollarValueActualPrice;
    }

    public float getUnitWeightInOunces() {
        return unitWeightInOunces;
    }

    public void setUnitWeightInOunces(float weightInOunces) {
        this.unitWeightInOunces = weightInOunces;
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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
}
