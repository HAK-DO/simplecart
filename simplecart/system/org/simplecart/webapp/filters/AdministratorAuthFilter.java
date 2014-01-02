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

import org.simplecart.administration.Administrator;
import org.simplecart.webapp.Constants;

/**
 *
 * @author Daniel Watrous
 */
public class AdministratorAuthFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(); // get the session or create it
        Administrator admin = (Administrator) session.getAttribute(Constants.LOGGED_IN_ADMIN_KEY);
        if (admin == null) {
            // redirect to the login page
            res.sendRedirect(req.getContextPath() + "/AdministratorLogin.do");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}