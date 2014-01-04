/*
 * InitializeDatabaseAction.java
 *
 * Created on May 6, 2005, 3:12 PM
 */

package org.simplecart.webapp.actions;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import net.sf.hibernate.tool.hbm2ddl.SchemaExport;

import org.simplecart.persistence.HibernateUtility;

import org.simplecart.dao.*;
import org.simplecart.base.Address;
import org.simplecart.shopcart.catalog.*;
import org.simplecart.administration.Administrator;
import org.simplecart.account.Customer;
import org.simplecart.contract.salesorder.InternetSalesOrder;
import org.simplecart.contract.salesorder.SalesOrderLineItem;

/**
 *
 * @author Daniel Watrous
 */
public class InitializeDatabaseAction extends Action {
        
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // call HibernateUtil to initialize Hibernate
        // new HibernateUtil();
        
        /*
         */
        SchemaExport myDatabaseSchema = new SchemaExport(HibernateUtility.getConfiguration());
        myDatabaseSchema.drop(true,true);
        myDatabaseSchema.create(true,true);

        HibernateUtility.beginTransaction();
        
        AdministratorDAO dao = new AdministratorDAO();
        SalesOrderDAO sdao = new SalesOrderDAO();
        CustomerDAO cdao = new CustomerDAO();
        InternetProductCategoryDAO catdao = new InternetProductCategoryDAO();
        InternetProductDAO proddao = new InternetProductDAO();
        InternetProductOptionDAO optdao = new InternetProductOptionDAO();

        
        // create a test user for login to the administration section
        Address generalAddress = new Address ();
        generalAddress.setStreetLine1("123 first street");
        generalAddress.setStreetLine2("apt. a");
        generalAddress.setCity("SLC");
        generalAddress.setState("UT");
        generalAddress.setPostalCode("84102");
        
        Address customerAddress = new Address ();
        customerAddress.setStreetLine1("123 another street");
        customerAddress.setStreetLine2("apt. b");
        customerAddress.setCity("SLC");
        customerAddress.setState("UT");
        customerAddress.setPostalCode("84103");

        Address orderAddress = new Address ();
        orderAddress.setStreetLine1("123 some street");
        orderAddress.setStreetLine2("apt. c");
        orderAddress.setCity("SLC");
        orderAddress.setState("UT");
        orderAddress.setPostalCode("84104");

        Administrator newAdmin = new Administrator();
        newAdmin.setNameFirst("Test");
        newAdmin.setNameLast("User");
        newAdmin.setUsername("test");
        newAdmin.setPassword("testpass");
        newAdmin.setEmailAddress("test@simplecart.org");
        
        // associate objects
        newAdmin.setAddress(generalAddress);

        dao.makePersistent(newAdmin);
        
        // create a sample customer
        Customer customer = new Customer();
        customer.setAddress(customerAddress);
        customer.setCompanyName("XYZ Corp.");
        customer.setEmailAddress("jim@xyzcorp.com");
        customer.setNameFirst("Jim");
        customer.setNameLast("Smith");
        customer.setUsername("jimmy");
        customer.setPassword("testpass");
        
        // create a searchDetails object
        SearchUtility searchDetails = new SearchUtility();
        searchDetails.setSearchMetaAuthor("daniel");
        searchDetails.setSearchMetaCopyright("daniel");
        searchDetails.setSearchMetaDate("today");
        searchDetails.setSearchMetaDescription("cool");
        searchDetails.setSearchMetaKeywords("daniel");
        
        // create a category
        InternetProductCategory category = new InternetProductCategory();
        category.setConsumerVisible(true);
        category.setName("Test Category");
        category.setDescription("Test Category");
        category.setSearchDetails(searchDetails);

        // create a product
        InternetProduct product = new InternetProduct();
        product.setConsumerVisible(true);
        product.setName("Test Product");
        product.setDescription("Test Product");
        product.setSearchDetails(searchDetails);

        // create an option
        InternetProductOption option1 = new InternetProductOption();
        option1.setConsumerVisible(true);
        option1.setDescription("fake option");
        option1.setName("faker option");
        option1.setStockKeepingUnitIdentifier("FAKE0");
        option1.setUnitPriceActualRetail((float)4.56);
        option1.setUnitPriceManufacturerSuggestedRetail((float)6.74);
        option1.setUnitWeightInOunces(2);
        option1.setSearchDetails(searchDetails);
        
        // create an option
        InternetProductOption option2 = new InternetProductOption();
        option2.setConsumerVisible(true);
        option2.setDescription("fake option");
        option2.setName("faker option");
        option2.setStockKeepingUnitIdentifier("FAKE1");
        option2.setUnitPriceActualRetail((float)4.56);
        option2.setUnitPriceManufacturerSuggestedRetail((float)6.74);
        option2.setUnitWeightInOunces(2);
        option2.setSearchDetails(searchDetails);

        // associate category, product and option
        category.associate(product);
        product.associate(option1);
        product.associate(option2);
        
        // persist option
        // TODO: I should be able to make a single call to save the category
        optdao.makePersistent(option1);
        optdao.makePersistent(option2);
        proddao.makePersistent(product);
        catdao.makePersistent(category);
        
        // create a sample order
        InternetSalesOrder salesOrder = new InternetSalesOrder();
        salesOrder.setAddress(orderAddress);
        salesOrder.setNotes("TEST NOTES!");
        salesOrder.setPlacedOn(new Date());
        salesOrder.addLineItem(new SalesOrderLineItem((float)3,(float)3.64,"line 1",option1));
        salesOrder.addLineItem(new SalesOrderLineItem((float)6,(float)4.91,"line 2",option2));

        // associate order
        customer.addOrder(salesOrder);
        
        cdao.makePersistent(customer);
        sdao.makePersistent(salesOrder);

        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();

        return mapping.findForward("success");
    }

}