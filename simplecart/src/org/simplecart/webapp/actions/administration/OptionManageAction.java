/*
 * ManageOption.java
 *
 * Created on February 12, 2005, 2:51 PM
 */

package org.simplecart.webapp.actions.administration;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.dao.InternetProductDAO;
import org.simplecart.dao.InternetProductOptionDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.ProductOption;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
@SuppressWarnings("rawtypes")
public class OptionManageAction extends DispatchAction  {
    
    private InternetProductOptionDAO dao;
    private InternetProductDAO pdao;
    private ActionMessages errors;
    private CatalogItemForm optionForm;
    
    /**
     * Retrieves a collection of <em>ProductOption</em> objects and
     * stores them in a collection, then forward along to
     * the display page.
     */

	public ActionForward display(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new InternetProductOptionDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find option objects and attach to request
        Collection options = dao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_OPTION_KEY, options);
        
        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward(Constants.DISPLAY_PAGE_KEY);
        
    }
    
    /**
     * Forward along to the view with a form containing
     * fields to add a new <em>ProductOption</em>.  This leaves
     * each field blank.
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // create a optionForm from a CatalogItemForm
        optionForm = (CatalogItemForm) form;
        
        // set activity field in form-bean
        optionForm.setActivity(Constants.ENTER_PAGE_KEY);
        
        // create DAO instance
        pdao = new InternetProductDAO();
        if (pdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find option objects and attach to request
        Collection products = pdao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_PRODUCT_KEY, products);
        
        // go to display page
        return mapping.findForward(Constants.ENTER_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>ProductOption</em> and foward
     * along to a view containing a form with fields to edit an
     * existing ProductOption.
     */
    public ActionForward edit(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("optionId"));
        
        // get ProductOption object
        ProductOption option = loadOption(id);
        
        // create a optionForm from a CatalogItemForm
        optionForm = (CatalogItemForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(optionForm, option);
        PropertyUtils.copyProperties(optionForm, option.getSearchDetails());
        optionForm.setActivity(Constants.EDIT_PAGE_KEY);
        optionForm.setId(option.getId());
        
        // create DAO instance
        pdao = new InternetProductDAO();
        if (pdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find option objects and attach to request
        Collection products = pdao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_PRODUCT_KEY, products);
        
        // go to display page
        return mapping.findForward(Constants.EDIT_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>ProductOption</em> and foward along
     * to a view containing a form with fields to delete an
     * existing ProductOption.
     */
    public ActionForward delete(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("optionId"));
        
        // get ProductOption object
        ProductOption option = loadOption(id);
        
        // create a optionForm from a CatalogItemForm
        optionForm = (CatalogItemForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(optionForm, option);
        PropertyUtils.copyProperties(optionForm, option.getSearchDetails());
        optionForm.setActivity(Constants.DELETE_PAGE_KEY);
        optionForm.setId(option.getId());
        
        // create DAO instance
        pdao = new InternetProductDAO();
        if (pdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find option objects and attach to request
        Collection products = pdao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_PRODUCT_KEY, products);
        
        // go to display page
        return mapping.findForward(Constants.DELETE_PAGE_KEY);
        
    }
    
    /**
     * Load a given <em>ProductOption</em> from datasource in order
     * to populate a form object to be returned to a view.
     */
    public ProductOption loadOption(Long id) {
        // get the object for errors
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new InternetProductOptionDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.database"));
            return null;
        }
        
        ProductOption option = null;
        
        try {
            // find stake objects and attach to request
            option = dao.findById(id, false);
            Hibernate.initialize(option.getSearchDetails());
            
            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
        }
        
        // return the stake object
        return option;
    }
    
}
