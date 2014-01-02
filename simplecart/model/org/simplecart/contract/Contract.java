package org.simplecart.contract;

import java.util.Date;

/** 
 *  A Contract represents the details of an agreement between two people.  In the case of this application a Contract represents a Sales Order, Return or similar transaction.  The details of the Contract may include LineItems, Shipping Information and Billing Terms.
 */
public interface Contract {
  /* {src_lang=Java}*/


  /** 
   *   
   *    The Effective Date is the date that this contract is officially in force.  In the case of a Sales Order it would be the time that the Customer commits to purchase.  For a Return it is the date that an authorized representative approves the Return and issues a Return Merchandise Authorization (RMA) number.
   */
  public Date getEffectiveDate();
}