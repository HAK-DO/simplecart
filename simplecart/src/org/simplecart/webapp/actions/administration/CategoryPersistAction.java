/*
 * PersistCategory.java
 *
 * Created on February 12, 2005, 2:50 PM
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
import org.simplecart.dao.InternetProductCategoryDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.InternetProductCategory;
import org.simplecart.shopcart.catalog.ProductCategory;
import org.simplecart.shopcart.catalog.SearchUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
public class CategoryPersistAction  extends DispatchAction {
    
    private InternetProductCategoryDAO dao;
    private static Category cat = Category.getInstance(CategoryPersistAction.class.getName());
    
    /**
     * Receives a populated CatalogItemForm and creates
     * a new <em>Stake</em> which it then persists
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        CatalogItemForm categoryForm = (CatalogItemForm) form;
        
        // copy form-bean values to new Stake and Address objects
        SearchUtility searchDetails = new SearchUtility();
        PropertyUtils.copyProperties(searchDetails, categoryForm);
        InternetProductCategory newCategory = new InternetProductCategory();
        PropertyUtils.copyProperties(newCategory, categoryForm);
        
        // attach the address to this new category
        newCategory.setSearchDetails(searchDetails);
        
        // get a DAO for the new Category
        dao = new InternetProductCategoryDAO();
        
        // store the new Stake
        dao.makePersistent(newCategory);
        
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
        CatalogItemForm categoryForm = (CatalogItemForm) form;
        
        // get a DAO for the new Stake
        dao = new InternetProductCategoryDAO();
        
        ProductCategory category = null;
        
        try {
            // find category objects and attach to request
            category = (ProductCategory) dao.findById(categoryForm.getId(), false);
            
            // copy form-bean values to new Stake and Address objects
            // NOTE: PropertyUtils will not work in this situation since there
            //       is an ID field which is different for Stake and Address
            category.setName(categoryForm.getName());
            category.setDescription(categoryForm.getDescription());
            category.getSearchDetails().setSearchMetaAuthor(categoryForm.getSearchMetaAuthor());
            category.getSearchDetails().setSearchMetaKeywords(categoryForm.getSearchMetaKeywords());
            category.getSearchDetails().setSearchMetaDescription(categoryForm.getSearchMetaDescription());
            
            // update the Stake
            dao.makePersistent(category);
            
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
        CatalogItemForm categoryForm = (CatalogItemForm) form;
        
        // copy form-bean values to new Stake objects
        InternetProductCategory category = new InternetProductCategory();
        PropertyUtils.copyProperties(category, categoryForm);
        
        // get a DAO for the new Stake
        dao = new InternetProductCategoryDAO();
        
        // store the new Stake
        dao.makeTransient(category);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
}
