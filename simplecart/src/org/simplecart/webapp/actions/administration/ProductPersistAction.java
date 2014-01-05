/*
 * PersistProduct.java
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
import org.simplecart.dao.InternetProductDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.InternetProduct;
import org.simplecart.shopcart.catalog.Product;
import org.simplecart.shopcart.catalog.ProductCategory;
import org.simplecart.shopcart.catalog.SearchUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.CatalogItemForm;

/**
 *
 * @author Daniel Watrous
 */
public class ProductPersistAction extends DispatchAction {
    
    private InternetProductDAO dao;
    private InternetProductCategoryDAO cdao;
    private static Category cat = Category.getInstance(ProductPersistAction.class.getName());
    
    /**
     * Receives a populated CatalogItemForm and creates
     * a new <em>Product</em> which it then persists
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        CatalogItemForm productForm = (CatalogItemForm) form;
        
        System.out.println(form);
        // copy form-bean values to new Stake and Address objects
        SearchUtility searchDetails = new SearchUtility();
        PropertyUtils.copyProperties(searchDetails, productForm);
        InternetProduct newProduct = new InternetProduct();
        PropertyUtils.copyProperties(newProduct, productForm);
        
        // attache the searchDetails to this new product
        newProduct.setSearchDetails(searchDetails);
        
        // get a DAO for the Category
        dao = new InternetProductDAO();
        
        // store the new Product
        dao.makePersistent(newProduct);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * Receives a populated CatalogItemForm and loads an
     * existing <em>Product</em> object which it then
     * updates and persists
     */
    public ActionForward edit(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        CatalogItemForm productForm = (CatalogItemForm) form;
        
        // get a DAO for the Product and Category
        dao = new InternetProductDAO();
        cdao = new InternetProductCategoryDAO();
        
        Product product = null;
        
        try {
            // find product object for editing
            product = dao.findById(productForm.getId(), false);
            
            // find category object for attachement
            ProductCategory category = cdao.findById(productForm.getCategoryId(),false);
            
            // copy form-bean values to new Stake and Address objects
            // NOTE: PropertyUtils will not work in this situation since there
            //       is an ID field which is different for Stake and Address
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.getSearchDetails().setSearchMetaAuthor(productForm.getSearchMetaAuthor());
            product.getSearchDetails().setSearchMetaKeywords(productForm.getSearchMetaKeywords());
            product.getSearchDetails().setSearchMetaDescription(productForm.getSearchMetaDescription());
            category.associate(product);
            
            // update the Stake
            dao.makePersistent(product);
            
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
     * field to delete a <em>Product</em> object and persist
     * the deletion.
     */
    public ActionForward delete(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        CatalogItemForm productForm = (CatalogItemForm) form;
        
        // copy form-bean values to new Stake objects
        InternetProduct product = new InternetProduct();
        PropertyUtils.copyProperties(product, productForm);
        
        // get a DAO for the new Stake
        dao = new InternetProductDAO();
        
        // store the new Stake
        dao.makeTransient(product);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
}
