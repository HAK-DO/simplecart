/*
 * Created on Apr 1, 2005
 *
 */
package org.simplecart.shopcart.catalog;

import net.sf.hibernate.tool.hbm2ddl.SchemaExport;

import org.simplecart.persistence.HibernateUtility;

/**
 * @author Daniel Watrous
 *
 */
public class TestCase extends junit.framework.TestCase {

	public TestCase(String s) {
		super(s);
	}

	protected void runTest() throws Throwable {
		try {
			System.out.println("Running test...");
			super.runTest();
		} catch (Throwable e) {
			HibernateUtility.rollbackTransaction();
			throw e;
		} finally{
			HibernateUtility.closeSession();
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
		SchemaExport ddlExport = new SchemaExport(HibernateUtility.getConfiguration());
		ddlExport.create(true, true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		SchemaExport ddlExport = new SchemaExport(HibernateUtility.getConfiguration());
		ddlExport.drop(true, true);
	}
}
