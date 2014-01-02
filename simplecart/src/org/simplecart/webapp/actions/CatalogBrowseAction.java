/*
 * CatalogBrowse.java
 *
 * Created on February 18, 2005, 2:58 PM
 */

package org.simplecart.webapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.dao.InternetProductCategoryDAO;
import org.simplecart.dao.InternetProductDAO;
import org.simplecart.dao.InternetProductOptionDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.Product;
import org.simplecart.shopcart.catalog.ProductCategory;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
public class CatalogBrowseAction extends DispatchAction {
    
    @SuppressWarnings("unused")
	private InternetProductOptionDAO odao;
    private InternetProductDAO pdao;
    private InternetProductCategoryDAO cdao;
    private ActionMessages errors;
    private CatalogItemForm viewForm;
    private static org.apache.log4j.Category cat = org.apache.log4j.Category.getInstance(CatalogBrowseAction.class.getName());
    
    /**
     * this activity should load products for a given categoryId
     * and place them in the request to be displayed on the 
     * listing view.
     */
    public ActionForward listing(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        errors = new ActionMessages();
        viewForm = (CatalogItemForm) form;
        
        cat.debug("Category ID is: " + viewForm.getCategoryId());

        // create DAO instance
        cdao = new InternetProductCategoryDAO();
        if (cdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find product objects and attach to request
        ProductCategory category = (ProductCategory) cdao.findById(viewForm.getCategoryId(),false);
        
        cat.debug("Category object is: " + category);
        cat.debug("Category object contains " + category.getConsumerVisibleProducts().length + " products ");

        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_PRODUCT_KEY, category.getConsumerVisibleProducts());

        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward("listing");
    }
    
    /**
     * this activity should load a single product to display
     * on the product detail view.
     */
    public ActionForward detail(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        errors = new ActionMessages();
        viewForm = (CatalogItemForm) form;
        
        // create DAO instance
        pdao = new InternetProductDAO();
        if (pdao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        
        // find product objects and attach to request
        Product product = (Product) pdao.findById(viewForm.getProductId(),false);

        // now add this collection to the request
        request.setAttribute(Constants.OBJECT_PRODUCT, product);
        
        cat.debug("Product object is: " + product);
        cat.debug("Product object contains " + product.getConsumerVisibleProductOptions().length + " options ");

        // now add the options to the request too
        request.setAttribute(Constants.COLLECTION_OPTION_KEY, product.getConsumerVisibleProductOptions());
        
        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward("detail");
    }
    
}
