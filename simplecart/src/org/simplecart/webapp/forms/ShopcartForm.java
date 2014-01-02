/*
 * ShopcartForm.java
 *
 * Created on February 21, 2005, 3:42 PM
 */

package org.simplecart.webapp.forms;

import org.apache.struts.validator.ValidatorActionForm;
/**
 *
 * @author Daniel Watrous
 */
public class ShopcartForm extends ValidatorActionForm {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2502164941647760995L;
	private Long optionId;
    private int itemIndex;
    private float amount;
    private String activity;
    
    /** Creates a new instance of ShopcartForm */
    public ShopcartForm() {
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
}
