/*
 * ShopcartManage.java
 *
 * Created on February 18, 2005, 3:25 PM
 */

package org.simplecart.webapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.dao.InternetProductOptionDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.Shopcart;
import org.simplecart.shopcart.ShopcartItem;
import org.simplecart.shopcart.SimpleShopcart;
import org.simplecart.shopcart.SimpleShopcartItem;
import org.simplecart.shopcart.catalog.ProductOption;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.ShopcartForm;

/**
 *
 * @author Daniel Watrous
 */
public class ShopcartManageAction  extends DispatchAction {
    
    private InternetProductOptionDAO odao;
    private ShopcartForm cartForm;
    private Shopcart shopcart;
    private ActionMessages errors;

    /**
     * this activity locates or creates a shopcart for this session
     * and places options into it.
     */
    public ActionForward addItem(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        errors = new ActionMessages();
        HttpSession session = request.getSession();
        cartForm = (ShopcartForm) form;
        
        // *** retrieve or create shopcart object and associate with session
        shopcart = (Shopcart) session.getAttribute(Constants.SHOPCART);
        if (shopcart == null) {
            shopcart = new SimpleShopcart();
            session.setAttribute(Constants.SHOPCART, shopcart);
        }
        
        // *** load ProductOption using DAO
        // create DAO instance
        odao = new InternetProductOptionDAO();
        if (odao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        System.out.println(cartForm.getOptionId());
        System.out.println(cartForm.getOptionId());
        System.out.println(cartForm.getOptionId());
        System.out.println(cartForm.getOptionId());
        System.out.println(cartForm.getOptionId());
        // find product objects and attach to request
        ProductOption option = odao.findById(cartForm.getOptionId(),false);

        // *** create a new ShopcartItem for this ProductOption and amount
        ShopcartItem item = 
                new SimpleShopcartItem(
                option.getId(), 
                cartForm.getAmount(),
                option.getName(),
                option.getDescription(),
                option.getDescription(),
                option.getUnitPriceActualRetail());
        shopcart.addItem(item);
        
        // *** commit and close Hibernate session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // *** forward to success page
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * this activity locates or creates a shopcart for this session
     * and removes an option from it.
     */
    public ActionForward removeItem(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        errors = new ActionMessages();
        HttpSession session = request.getSession();
        cartForm = (ShopcartForm) form;
        
        // *** retrieve or create shopcart object and associate with session
        shopcart = (Shopcart) session.getAttribute(Constants.SHOPCART);
        if (shopcart == null) {
            shopcart = new SimpleShopcart();
            session.setAttribute(Constants.SHOPCART, shopcart);
        }
        
        shopcart.removeItem(cartForm.getItemIndex());
        
        // *** forward to success page
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * display shopcart page
     */
    public ActionForward display(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // *** forward to success page
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
        
}
