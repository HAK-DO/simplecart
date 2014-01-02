/*
 * @(#)InternetProduct.java $LastChangedRevision$ $LastChangedDate$
 * Created on Apr 9, 2005
 *
 * Copyright (c) 2005, Daniel Watrous
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or 
 * without modification, are governed by the license found in
 * the following places:
 * license.txt included with this distribution, or
 * http://www.simplecart.org/license.html
 * 
 */
package org.simplecart.shopcart.catalog;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @version $LastChangedRevision$ $LastChangedDate$
 * @author Daniel Watrous
 */

public class AllTests {

    public static Test suite() {

        TestSuite suite = new TestSuite();

        suite.addTest(InternetProductCategoryTest.suite());
        suite.addTest(InternetProductTest.suite());

        return suite;
    }

    public static void main(String args[]) {
        TestRunner.run(suite());
    }

}