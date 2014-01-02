/*
 * ManageCategory.java
 *
 * Created on February 12, 2005, 2:50 PM
 */

package org.simplecart.webapp.actions.administration;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
//import net.sf.hibernate.Hibernate;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.dao.InternetProductCategoryDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.ProductCategory;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
public class CategoryManageAction  extends DispatchAction {
    
    private InternetProductCategoryDAO dao;
    private ActionMessages errors;
    private CatalogItemForm categoryForm;
    
    /**
     * Retrieves a collection of <em>Category</em> objects and
     * stores them in a collection, then forward along to 
     * the display page.
     */
    @SuppressWarnings("rawtypes")
	public ActionForward display (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        errors = new ActionMessages();
        
        // create DAO instance
        dao = new InternetProductCategoryDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find category objects and attach to request
        Collection categorys = dao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_CATEGORY_KEY, categorys);
        
        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward(Constants.DISPLAY_PAGE_KEY);
        
    }
    
    /**
     * Forward along to the view with a form containing
     * fields to add a new <em>Category</em>.  This leaves 
     * each field blank.
     */
    public ActionForward enter (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // create a categoryForm from a CatalogItemForm
        categoryForm = (CatalogItemForm) form;
        
        // set activity field in form-bean
        categoryForm.setActivity(Constants.ENTER_PAGE_KEY);
        
        // go to display page
        return mapping.findForward(Constants.ENTER_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>Category</em> and foward
     * along to a view containing a form with fields to edit an
     * existing Category.
     */
    public ActionForward edit (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("categoryId"));
        
        // get Category object
        ProductCategory category = loadCategory(id);
        
        // create a categoryForm from a CatalogItemForm
        categoryForm = (CatalogItemForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(categoryForm, category);
        PropertyUtils.copyProperties(categoryForm, category.getSearchDetails());
        categoryForm.setActivity(Constants.EDIT_PAGE_KEY);
        categoryForm.setId(category.getId());
        
        // go to display page
        return mapping.findForward(Constants.EDIT_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>Category</em> and foward along
     * to a view containing a form with fields to delete an
     * existing Category.
     */
    public ActionForward delete (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("categoryId"));
        
        // get Category object
        ProductCategory category = loadCategory(id);
        
        // create a categoryForm from a CatalogItemForm
        categoryForm = (CatalogItemForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(categoryForm, category);
        PropertyUtils.copyProperties(categoryForm, category.getSearchDetails());
        categoryForm.setActivity(Constants.DELETE_PAGE_KEY);
        categoryForm.setId(category.getId());
        
        // go to display page
        return mapping.findForward(Constants.DELETE_PAGE_KEY);
        
    }
    
    /**
     * Load a given <em>Category</em> from datasource in order
     * to populate a form object to be returned to a view.
     */
    public ProductCategory loadCategory (Long id) {
        // get the object for errors
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new InternetProductCategoryDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.database"));
            return null;
        }
        
        ProductCategory category = null;

        try {
            // find a category object and attach to request
            category = (ProductCategory) dao.findById(id, false);
            //Hibernate.initialize(category.getProducts());

            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
        }
        
        // return the stake object
        return category;
    }
    
}
