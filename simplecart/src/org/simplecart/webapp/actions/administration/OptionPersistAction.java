/*
 * PersistOption.java
 *
 * Created on February 12, 2005, 2:51 PM
 */

package org.simplecart.webapp.actions.administration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Category;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.dao.InternetProductDAO;
import org.simplecart.dao.InternetProductOptionDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.InternetProductOption;
import org.simplecart.shopcart.catalog.Product;
import org.simplecart.shopcart.catalog.SearchUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
public class OptionPersistAction  extends DispatchAction {
    
    private InternetProductOptionDAO dao;
    private InternetProductDAO pdao;
    private static Category cat = Category.getInstance(OptionPersistAction.class.getName());
    
    /**
     * Receives a populated CatalogItemForm and creates
     * a new <em>Stake</em> which it then persists
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        cat.info("Begin processing Enter!");
        
        // cast my form to a useful Type
        CatalogItemForm optionForm = (CatalogItemForm) form;
        
        // copy form-bean values to new Stake and Address objects
        SearchUtility searchDetails = new SearchUtility();
        PropertyUtils.copyProperties(searchDetails, optionForm);
        InternetProductOption newOption = new InternetProductOption();
        PropertyUtils.copyProperties(newOption, optionForm);
        
        // attache the address to this new option
        newOption.setSearchDetails(searchDetails);
        
        // get a DAO for the new Stake
        dao = new InternetProductOptionDAO();
        
        // store the new ProductOption
        dao.makePersistent(newOption);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * Receives a populated CatalogItemForm and loads an
     * existing <em>Stake</em> object which it then
     * updates and persists
     */
    public ActionForward edit(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        CatalogItemForm optionForm = (CatalogItemForm) form;
        
        // get a DAO for the new Stake
        pdao = new InternetProductDAO();
        dao = new InternetProductOptionDAO();
        
        InternetProductOption option = null;
        
        try {
            // find option objects and attach to request
            option = dao.findById(optionForm.getId(), false);
            
            Product product = pdao.findById(optionForm.getProductId(),false);
            
            // copy form-bean values to new Stake and Address objects
            // NOTE: PropertyUtils will not work in this situation since there
            //       is an ID field which is different for Stake and Address
            option.setName(optionForm.getName());
            option.setDescription(optionForm.getDescription());
            option.setStockKeepingUnitIdentifier(optionForm.getStockKeepingUnitIdentifier());
            option.setUnitPriceManufacturerSuggestedRetail(optionForm.getUnitPriceManufacturerSuggestedRetail());
            option.setUnitPriceActualRetail(optionForm.getUnitPriceActualRetail());
            option.setUnitWeightInOunces(optionForm.getUnitWeightInOunces());
            option.getSearchDetails().setSearchMetaAuthor(optionForm.getSearchMetaAuthor());
            option.getSearchDetails().setSearchMetaKeywords(optionForm.getSearchMetaKeywords());
            option.getSearchDetails().setSearchMetaDescription(optionForm.getSearchMetaDescription());
            option.getSearchDetails().setSearchMetaDate(optionForm.getSearchMetaDate());
            option.getSearchDetails().setSearchMetaCopyright(optionForm.getSearchMetaCopyright());
            product.associate(option);
            
            // update the Stake
            dao.makePersistent(option);
            
            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
            cat.info("An exception occured: " + e.toString());
        }
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * Receives a populated CatalogItemForm and uses the id
     * field to delete a <em>Stake</em> object and persist
     * the deletion.
     */
    public ActionForward delete(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        CatalogItemForm optionForm = (CatalogItemForm) form;
        
        // copy form-bean values to new Stake objects
        InternetProductOption option = new InternetProductOption();
        PropertyUtils.copyProperties(option, optionForm);
        
        // get a DAO for the new Stake
        dao = new InternetProductOptionDAO();
        
        // store the new Stake
        dao.makeTransient(option);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
}
