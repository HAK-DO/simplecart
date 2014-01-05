/*
 * Created on Apr 1, 2005
 *
 */
package org.simplecart.shopcart.catalog;

import org.junit.Test;
import org.simplecart.dao.InternetProductCategoryDAO;
import org.simplecart.dao.InternetProductDAO;
import org.simplecart.dao.InternetProductOptionDAO;

/**
 * @author Daniel
 */

public class TestCaseWithData  extends TestCase{

	public TestCaseWithData(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	// Testing is limited to implementations, not interfaces
	// create instances of Product Categories
	InternetProductCategory chocolate;
	InternetProductCategory bakingChocolate;
	InternetProductCategory chocolateTreats;
	InternetProductCategory biteSize;

	// create instances of Products
	InternetProduct whiteChocChips;
	InternetProduct darkChocChips;
	InternetProduct millionDollarBar;
	InternetProduct chocoChuncks;
    InternetProduct hiddenChuncks;
	InternetProduct hotChocolate;

	// create instances of Product Options
	InternetProductOption whiteChips12oz;
	InternetProductOption whiteChips24oz;
	InternetProductOption darkChips12oz;
	InternetProductOption darkChips24oz;
	InternetProductOption millionBarRegular;
	InternetProductOption millionBarKingSize;
	InternetProductOption chocoChuncks6oz;	// this doubles for darkChocChips and chocoChuncks
	InternetProductOption chocoChuncks12oz;	// this doubles for darkChocChips and chocoChuncks
	InternetProductOption hotChocolate20Scoops;
	InternetProductOption hotChocolate50Scoops;

	

    /**
     * Create test data.
     *
     * @throws Exception
     */
	@Test
    public void initData()  {
        // create DAOs
        InternetProductDAO productDAO = new InternetProductDAO(); 
        InternetProductOptionDAO optionDAO = new InternetProductOptionDAO(); 
        InternetProductCategoryDAO categoryDAO = new InternetProductCategoryDAO();
        
        // create categories
        initCategories();
        
        // create associations between categories
        chocolate.associate(bakingChocolate);
        chocolate.associate(chocolateTreats);
        
        // create products
        initProducts();
        
        // create associations between products and categories
        chocolate.associate(hotChocolate);
        bakingChocolate.associate(whiteChocChips);
        bakingChocolate.associate(darkChocChips);
        chocolateTreats.associate(millionDollarBar);
        chocolateTreats.associate(chocoChuncks);
        // TODO: make this test work
        //chocolateTreats.associate(chocoChuncks);    // duplicate to ensure that each Product is associated only once per category
        chocolateTreats.associate(hiddenChuncks);
        biteSize.associate(chocoChuncks);
        biteSize.associate(whiteChocChips);
        biteSize.associate(darkChocChips);
        
        // create options
        initOptions();
        
        // create associations between options and products
    	whiteChocChips.associate(whiteChips12oz);
    	whiteChocChips.associate(whiteChips24oz);
    	darkChocChips.associate(darkChips12oz);
    	darkChocChips.associate(darkChips24oz);
    	darkChocChips.associate(chocoChuncks6oz);
    	darkChocChips.associate(chocoChuncks12oz);
    	millionDollarBar.associate(millionBarRegular);
    	millionDollarBar.associate(millionBarKingSize);
    	chocoChuncks.associate(chocoChuncks6oz);
    	chocoChuncks.associate(chocoChuncks12oz);
        //hiddenChuncks.associate();	// nothing to associate
    	hotChocolate.associate(hotChocolate20Scoops);
    	hotChocolate.associate(hotChocolate50Scoops);

        // persist categories
        //categoryDAO.makePersistent(chocolate);
        //categoryDAO.makePersistent(biteSize);
        
    }
    
    public void initCategories() {
        chocolate = new InternetProductCategory ();
        ((BaseCatalogItem) chocolate).setName("Chocolate");
        ((BaseCatalogItem) chocolate).setDescription("All things chocolate!");
        ((BaseCatalogItem) chocolate).setConsumerVisible(true);
        bakingChocolate = new InternetProductCategory ();
        ((BaseCatalogItem) bakingChocolate).setName("Baking Chocolate");
        ((BaseCatalogItem) bakingChocolate).setDescription("All things for Baking Chocolate");
        ((BaseCatalogItem) bakingChocolate).setConsumerVisible(false);
        chocolateTreats = new InternetProductCategory ();
        ((BaseCatalogItem) chocolateTreats).setName("Chocolate Treats");
        ((BaseCatalogItem) chocolateTreats).setDescription("All things related to Chocolate Treats");
        ((BaseCatalogItem) chocolateTreats).setConsumerVisible(true);
        biteSize = new InternetProductCategory ();
        ((BaseCatalogItem) biteSize).setName("Bite Size");
        ((BaseCatalogItem) biteSize).setConsumerVisible(true);
        ((BaseCatalogItem) biteSize).setDescription("All things that are Bite Size");
    }
    
    public void initProducts() {
        whiteChocChips = new InternetProduct();
        ((BaseCatalogItem) whiteChocChips).setName("White Choc Chips");
        ((BaseCatalogItem) whiteChocChips).setDescription("All kinds of White Choc Chips");
        ((BaseCatalogItem) whiteChocChips).setConsumerVisible(true);
        darkChocChips = new InternetProduct();
        ((BaseCatalogItem) darkChocChips).setName("Dark Choc Chips");
        ((BaseCatalogItem) darkChocChips).setDescription("All kinds of Dark Choc Chips");
        ((BaseCatalogItem) darkChocChips).setConsumerVisible(true);
        millionDollarBar = new InternetProduct();
        ((BaseCatalogItem) millionDollarBar).setName("Million Dollar Bar");
        ((BaseCatalogItem) millionDollarBar).setDescription("All kinds of Million Dollar Bar");
        ((BaseCatalogItem) millionDollarBar).setConsumerVisible(true);
        chocoChuncks = new InternetProduct();
        ((BaseCatalogItem) chocoChuncks).setName("Choco Chuncks");
        ((BaseCatalogItem) chocoChuncks).setDescription("All kinds of Choco Chuncks");
        ((BaseCatalogItem) chocoChuncks).setConsumerVisible(true);
        hiddenChuncks = new InternetProduct();
        ((BaseCatalogItem) hiddenChuncks).setName("Hidden Chuncks");
        ((BaseCatalogItem) hiddenChuncks).setDescription("All kinds of Hidden Chuncks");
        ((BaseCatalogItem) hiddenChuncks).setConsumerVisible(false);
        hotChocolate = new InternetProduct();
        ((BaseCatalogItem) hotChocolate).setName("Hot Chocolate");
        ((BaseCatalogItem) hotChocolate).setDescription("All kinds of Hot Chocolate");
        ((BaseCatalogItem) hotChocolate).setConsumerVisible(true);
    }
    
    public void initOptions() {
    	whiteChips12oz = new InternetProductOption();
    	((BaseCatalogItem) whiteChips12oz).setName("whiteChips12oz");
    	((BaseCatalogItem) whiteChips12oz).setDescription("whiteChips12oz");
    	((BaseCatalogItem) whiteChips12oz).setConsumerVisible(true);
    	whiteChips24oz = new InternetProductOption();
    	((BaseCatalogItem) whiteChips24oz).setName("whiteChips24oz");
    	((BaseCatalogItem) whiteChips24oz).setDescription("whiteChips24oz");
    	((BaseCatalogItem) whiteChips24oz).setConsumerVisible(true);
    	darkChips12oz = new InternetProductOption();
    	((BaseCatalogItem) darkChips12oz).setName("darkChips12oz");
    	((BaseCatalogItem) darkChips12oz).setDescription("darkChips12oz");
    	((BaseCatalogItem) darkChips12oz).setConsumerVisible(true);
    	darkChips24oz = new InternetProductOption();
    	((BaseCatalogItem) darkChips24oz).setName("darkChips24oz");
    	((BaseCatalogItem) darkChips24oz).setDescription("darkChips24oz");
    	((BaseCatalogItem) darkChips24oz).setConsumerVisible(true);
    	millionBarRegular = new InternetProductOption();
    	((BaseCatalogItem) millionBarRegular).setName("millionBarRegular");
    	((BaseCatalogItem) millionBarRegular).setDescription("millionBarRegular");
    	((BaseCatalogItem) millionBarRegular).setConsumerVisible(true);
    	millionBarKingSize = new InternetProductOption();
    	((BaseCatalogItem) millionBarKingSize).setName("millionBarKingSize");
    	((BaseCatalogItem) millionBarKingSize).setDescription("millionBarKingSize");
    	((BaseCatalogItem) millionBarKingSize).setConsumerVisible(true);
    	chocoChuncks6oz = new InternetProductOption(); // this doubles for darkChocChips and chocoChuncks
    	((BaseCatalogItem) chocoChuncks6oz).setName("chocoChuncks6oz");
    	((BaseCatalogItem) chocoChuncks6oz).setDescription("chocoChuncks6oz");
    	((BaseCatalogItem) chocoChuncks6oz).setConsumerVisible(true);
    	chocoChuncks12oz = new InternetProductOption();	// this doubles for darkChocChips and chocoChuncks
    	((BaseCatalogItem) chocoChuncks12oz).setName("chocoChuncks12o");
    	((BaseCatalogItem) chocoChuncks12oz).setDescription("chocoChuncks12o");
    	((BaseCatalogItem) chocoChuncks12oz).setConsumerVisible(false);
    	hotChocolate20Scoops = new InternetProductOption();
    	((BaseCatalogItem) hotChocolate20Scoops).setName("hotChocolate20Scoops");
    	((BaseCatalogItem) hotChocolate20Scoops).setDescription("hotChocolate20Scoops");
    	((BaseCatalogItem) hotChocolate20Scoops).setConsumerVisible(true);
    	hotChocolate50Scoops = new InternetProductOption();
    	((BaseCatalogItem) hotChocolate50Scoops).setName("hotChocolate50Scoops");
    	((BaseCatalogItem) hotChocolate50Scoops).setDescription("hotChocolate50Scoops");
    	((BaseCatalogItem) hotChocolate50Scoops).setConsumerVisible(true);
    }

}
