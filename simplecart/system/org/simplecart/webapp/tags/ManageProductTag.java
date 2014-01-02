/*
 * EditStakeTag.java
 *
 * Created on February 4, 2005, 5:34 PM
 */

package org.simplecart.webapp.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.config.ModuleConfig;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.MessageResources;
import org.simplecart.shopcart.catalog.Product;

/**
 *
 * @author Daniel Watrous
 */
public class ManageProductTag  extends TagSupport {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2281760440989160574L;

	private String page = null;
    
    private String name = "product";
    
    private String activity = "edit";
    
    protected static MessageResources messages =
            MessageResources.getMessageResources
            ("org.onugjournal.wardlistapp.webapp.actions.ApplicationResources");
    
    public String getPage() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
     public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
   public int doStartTag() throws JspException {
        
        // Generate the URL to be encoded
        ModuleConfig config = (ModuleConfig) pageContext.getRequest()
        .getAttribute(org.apache.struts.Globals.MODULE_KEY);
        HttpServletRequest request =
                (HttpServletRequest) pageContext.getRequest();
        StringBuffer url = new StringBuffer(request.getContextPath());
        url.append(config.getPrefix());
        url.append(page);
        url.append(".do");
        Product product = null;
        try {
            product = (Product) pageContext.findAttribute(name);
        } catch (ClassCastException e) {
            product = null;
        }
        if (product == null && !this.activity.equals("enter"))
            throw new JspException
                    (messages.getMessage("error.generalMessage", name));
        if (page.indexOf("?") < 0)
            url.append("?");
        else
            url.append("&");
        url.append("activity=");
        url.append(this.activity);
        if (!this.activity.equals("enter")) {
            url.append("&productId=");
            url.append(TagUtils.getInstance().filter(product.getId().toString()));
        }
        
        // Generate the hyperlink start element
        HttpServletResponse response =
                (HttpServletResponse) pageContext.getResponse();
        StringBuffer results = new StringBuffer("<a href=\"");
        results.append(response.encodeURL(url.toString()));
        results.append("\">");
        
        // Print this element to our output writer
        JspWriter writer = pageContext.getOut();
        try {
            writer.print(results.toString());
        } catch (IOException e) {
            throw new JspException
                    (messages.getMessage("error.generalMessage", e.toString()));
        }
        
        // Evaluate the body of this tag
        return (EVAL_BODY_INCLUDE);
    }
    
    public int doEndTag() throws JspException {
        
        // Print the ending element to our output writer
        JspWriter writer = pageContext.getOut();
        try {
            writer.print("</a>");
        } catch (IOException e) {
            throw new JspException
                    (messages.getMessage("link.io", e.toString()));
        }
        
        return (EVAL_PAGE);
        
    }
    
    public void release() {
        
        super.release();
        this.page = null;
        this.name = "product";
        
    }

}
