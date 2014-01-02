/*
 * AuthenticationFilter.java
 *
 * Created on February 11, 2005, 5:46 PM
 */

package org.simplecart.webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.simplecart.account.Customer;
import org.simplecart.webapp.Constants;

/**
 *
 * @author Daniel Watrous
 */
public class CustomerAuthFilter implements Filter { 

    private static Category cat = Category.getInstance(CustomerAuthFilter.class.getName());

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        cat.info ("Execute CustomerAuthFilter ... ");

        HttpSession session = req.getSession(); // get the session or create it
        Customer customer = (Customer) session.getAttribute(Constants.LOGGED_IN_USER_KEY);
        if (customer == null) {
            cat.info ("customer object is null; was not found in the session under key " + Constants.LOGGED_IN_USER_KEY);
            // redirect to the login page
            res.sendRedirect(req.getContextPath() + "/public/CustomerLogin.do");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}