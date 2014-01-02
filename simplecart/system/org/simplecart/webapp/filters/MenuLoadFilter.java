/*
 * MenuLoadFilter.java
 *
 * Created on February 18, 2005, 3:36 PM
 */

package org.simplecart.webapp.filters;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.simplecart.dao.InternetProductCategoryDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.webapp.Constants;

/**
 *
 * @author Daniel Watrous
 */
public class MenuLoadFilter implements Filter {
    
    private static org.apache.log4j.Category cat = org.apache.log4j.Category.getInstance(MenuLoadFilter.class.getName());
    
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        try {
            // create DAO instance
            InternetProductCategoryDAO dao = new InternetProductCategoryDAO();

            // find category objects and attach to request
            Collection categories = dao.findAll();

            // now add this collection to the request
            req.setAttribute(Constants.COLLECTION_MENU_KEY, categories);

            // commit Hibernate transaction and close Session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
            
        } catch (HibernateException e) {
            cat.error("Failed to load categories for menu");
        }

        // move along in workflow
        chain.doFilter(req, response);
    }
    
    public void destroy() {
    }
}
