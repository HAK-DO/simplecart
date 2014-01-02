/*
 * PersistAdministrator.java
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
import org.simplecart.administration.Administrator;
import org.simplecart.base.Address;
import org.simplecart.dao.AdministratorDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.PartyForm;

/**
 *
 * @author Daniel Watrous
 */
public class AdministratorPersistAction  extends DispatchAction {
    
    private AdministratorDAO dao;
    private static Category cat = Category.getInstance(AdministratorPersistAction.class.getName());
    
    /**
     * Receives a populated PartyForm and creates
     * a new <em>Stake</em> which it then persists
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        PartyForm administratorForm = (PartyForm) form;
        
        // copy form-bean values to new Stake and Address objects
        Address newAddress = new Address();
        PropertyUtils.copyProperties(newAddress, administratorForm);
        Administrator newAdministrator = new Administrator();
        PropertyUtils.copyProperties(newAdministrator, administratorForm);
        
        // attache the address to this new administrator
        newAdministrator.setAddress(newAddress);
        
        // get a DAO for the new Stake
        dao = new AdministratorDAO();
        
        // store the new Stake
        dao.makePersistent(newAdministrator);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * Receives a populated PartyForm and loads an
     * existing <em>Stake</em> object which it then
     * updates and persists
     */
    public ActionForward edit(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        PartyForm administratorForm = (PartyForm) form;
        
        // get a DAO for the new Stake
        dao = new AdministratorDAO();
        
        Administrator administrator = null;
        
        try {
            // find administrator objects and attach to request
            administrator = dao.findById(administratorForm.getId(), false);
            
            // copy form-bean values to new Stake and Address objects
            // NOTE: PropertyUtils will not work in this situation since there
            //       is an ID field which is different for Stake and Address
            administrator.setNameFirst(administratorForm.getNameFirst());
            administrator.setNameLast(administratorForm.getNameLast());
            administrator.setUsername(administratorForm.getUsername());
            administrator.setPassword(administratorForm.getPassword());
            administrator.setEmailAddress(administratorForm.getEmailAddress());
            administrator.getAddress().setStreetLine1(administratorForm.getStreetLine1());
            administrator.getAddress().setStreetLine2(administratorForm.getStreetLine2());
            administrator.getAddress().setCity(administratorForm.getCity());
            administrator.getAddress().setState(administratorForm.getState());
            administrator.getAddress().setPostalCode(administratorForm.getPostalCode());
            
            // update the Stake
            dao.makePersistent(administrator);
            
            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
            cat.info("An exception occured: " + e.toString());
        }
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
    
    /**
     * Receives a populated PartyForm and uses the id
     * field to delete a <em>Stake</em> object and persist
     * the deletion.
     */
    public ActionForward delete(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        PartyForm administratorForm = (PartyForm) form;
        
        // copy form-bean values to new Stake objects
        Administrator administrator = new Administrator();
        PropertyUtils.copyProperties(administrator, administratorForm);
        
        // get a DAO for the new Stake
        dao = new AdministratorDAO();
        
        // store the new Stake
        dao.makeTransient(administrator);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        return mapping.findForward(Constants.SUCCESS_KEY);
    }
}
