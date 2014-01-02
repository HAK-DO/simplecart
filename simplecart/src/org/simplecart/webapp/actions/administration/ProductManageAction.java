/*
 * ManageProduct.java
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
import org.simplecart.dao.InternetProductDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.Product;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
@SuppressWarnings("rawtypes")
public class ProductManageAction extends DispatchAction  {
    
    private InternetProductDAO dao;
    private InternetProductCategoryDAO cdao;
    private ActionMessages errors;
    private CatalogItemForm productForm;
    
    /**
     * Retrieves a collection of <em>Product</em> objects and
     * stores them in a collection, then forward along to 
     * the display page.
     */
    public ActionForward display (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        errors = new ActionMessages();
        
        // create DAO instance
        dao = new InternetProductDAO();
        
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find product objects and attach to request
        Collection products = dao.findAll();
        
        // now add these collections to the request
        request.setAttribute(Constants.COLLECTION_PRODUCT_KEY, products);
        
        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward(Constants.DISPLAY_PAGE_KEY);
        
    }
    
    /**
     * Forward along to the view with a form containing
     * fields to add a new <em>Product</em>.  This leaves 
     * each field blank.
     */
    public ActionForward enter (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // create a productForm from a CatalogItemForm
        productForm = (CatalogItemForm) form;
        
        // set activity field in form-bean
        productForm.setActivity(Constants.ENTER_PAGE_KEY);
        
        // need categories to choose a parent for this product
        cdao = new InternetProductCategoryDAO();
        if (cdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find product objects and attach to request
        Collection categories = cdao.findAll();

        // now add these collections to the request
        request.setAttribute(Constants.COLLECTION_CATEGORY_KEY, categories);

        // go to display page
        return mapping.findForward(Constants.ENTER_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>Product</em> and foward
     * along to a view containing a form with fields to edit an
     * existing Product.
     */
    public ActionForward edit (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("productId"));
        
        // get Product object
        Product product = loadProduct(id);
        
        // create a productForm from a CatalogItemForm
        productForm = (CatalogItemForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(productForm, product);
        PropertyUtils.copyProperties(productForm, product.getSearchDetails());
        productForm.setActivity(Constants.EDIT_PAGE_KEY);
        productForm.setId(product.getId());
        //productForm.setCategoryId(product.getCategory().getId());
        
        // need categories to choose a parent for this product
        cdao = new InternetProductCategoryDAO();
        if (cdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find product objects and attach to request
        Collection categories = cdao.findAll();

        // now add these collections to the request
        request.setAttribute(Constants.COLLECTION_CATEGORY_KEY, categories);

        // go to display page
        return mapping.findForward(Constants.EDIT_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>Product</em> and foward along
     * to a view containing a form with fields to delete an
     * existing Product.
     */
    public ActionForward delete (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("productId"));
        
        // get Product object
        Product product = loadProduct(id);
        
        // create a productForm from a CatalogItemForm
        productForm = (CatalogItemForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(productForm, product);
        PropertyUtils.copyProperties(productForm, product.getSearchDetails());
        productForm.setActivity(Constants.DELETE_PAGE_KEY);
        productForm.setId(product.getId());
        
        // need categories to choose a parent for this product
        cdao = new InternetProductCategoryDAO();
        if (cdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find product objects and attach to request
        Collection categories = cdao.findAll();

        // now add these collections to the request
        request.setAttribute(Constants.COLLECTION_CATEGORY_KEY, categories);

        // go to display page
        return mapping.findForward(Constants.DELETE_PAGE_KEY);
        
    }
    
    /**
     * Load a given <em>Product</em> from datasource in order
     * to populate a form object to be returned to a view.
     */
    public Product loadProduct (Long id) {
        // get the object for errors
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new InternetProductDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.database"));
            return null;
        }
        
        Product product = null;

        try {
            // find stake objects and attach to request
            product = dao.findById(id, false);
            //Hibernate.initialize(product.getOptions());

            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
        }
        
        // return the stake object
        return product;
    }
    
}
