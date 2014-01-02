/*
 * @(#)Party.java $LastChangedRevision: 64 $ $LastChangedDate: 2005-04-07 09:24:13 +0900 (목, 07 4월 2005) $
 * Created on Apr 6, 2005
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
package org.simplecart.base;

/**
 * 
 * @version     $LastChangedRevision: 64 $ $LastChangedDate: 2005-04-07 09:24:13 +0900 (목, 07 4월 2005) $
 * @author      Daniel Watrous
 *
 */
public abstract class Party implements Persistent {

    private Long id;
    private String nameFirst;
    private String nameLast;
    private String username;
    private String password;
    private String emailAddress;
    private Address address;

	/**
	 * Default no args constructor
	 */
    public Party() {        
    } 

    public Long getId() {
        return id;
    }
    public String getNameFirst() {        
        return nameFirst;
    } 

    public void setNameFirst(String nameFirst) {        
        this.nameFirst = nameFirst;
    } 

    public String getNameLast() {        
        return nameLast;
    } 

    public void setNameLast(String nameLast) {        
        this.nameLast = nameLast;
    } 

    public String getUsername() {        
        return username;
    } 

    public void setUsername(String username) {        
        this.username = username;
    } 

    public String getPassword() {        
        return password;
    } 

    public void setPassword(String password) {        
        this.password = password;
    } 

    public String getEmailAddress() {        
        return emailAddress;
    } 

    public void setEmailAddress(String emailAddress) {        
        this.emailAddress = emailAddress;
    } 

    public Address getAddress() {        
        return address;
    } 

    public void setAddress(Address address) {        
        this.address = address;
    } 
 }
