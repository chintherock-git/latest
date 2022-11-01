package StepDefination;


import org.openqa.selenium.WebDriver;

import Driver.Driverfactory;

import static org.junit.Assert.*;

import PageFactory.Search_PF;
import PageFactory.Product_10_PF;
import PageFactory.Product_15_PF;
import PageFactory.Product_5_PF;


import io.cucumber.java.en.*;

import java.util.Properties;

public class Cart_withBackground {

	public static  WebDriver driver;
	public Product_10_PF p_10_pf;
	public Product_15_PF p_15_pf;
	public Product_5_PF p_5_pf;
	public Search_PF search_pf;
	
	public String config_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"src/main/java/Utilities/config.properties";
	public static String URL="https://www.amazon.in/";
	public static Properties prop;



	@Given("user has opened website")
	public void user_has_opened_website() {
		System.out.println("User is in login page "+Driverfactory.getDriver().getCurrentUrl());
		assertEquals(Cart_withBackground.URL,Driverfactory.getDriver().getCurrentUrl());
	}

	@Then("searches for {string}")
	public void searches_for(String product) {

		try {
			search_pf= new Search_PF(Driverfactory.getDriver());
			search_pf.input_searchbox(product);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Then("selects Brand as {string}")
	public void selects_Brand_as(String brand) {

		try {
			String brand_actual=search_pf.selectbrand(brand);
			assertEquals(brand,brand_actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@And("selects Display as {string}")
	public void selects_Display_as(String display) {

		try {
			String display_actual=search_pf.selectdisplay(display);
			assertEquals(display,display_actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@And("select Brand Material as {string}")
	public void select_Brand_Material_as(String material) {
		String material_actual=search_pf.selectmaterial(material);
		assertEquals(material,material_actual);
	}


	@And("selects Discount as {string}")
	public void selects_Discount_as(String discount) {
		String discount_actual=search_pf.selectdiscount(discount);
		assertEquals(discount,discount_actual);
	}
	
	@Given("fetch element5 from the search")
	public void fetch_element5_from_the_search() {
			p_5_pf=search_pf.navigate_5thsearch();
	}

	
	@Then("store the product5 details in file")
	public void store_the_product5_details_in_file() {
		p_5_pf.store_product5_details();
	}
	   
	    @Then("validate product5 type {string}")
		public void validate_product5_type(String type) {
	    	assertTrue(p_5_pf.validate_type(type));
		}
	    
	    @Then("validate product5 material {string}")
		public void validate_product5_material(String material) {
	    	assertTrue(p_5_pf.validate_material(material));
		}
	    
	   
	    @Then("validate product5 brand {string}")
		public void validate_product5_brand(String brand) {
	    	assertTrue(p_5_pf.validate_brand(brand));
		}
	    
	    @Then("validate product5 discount {int}")
		public void validate_product5_discount(int discount) {
	    	assertTrue(p_5_pf.validate_discount(discount));
		}
	    
	    @Then("validate product5 delivery {string}")
	 		public void validate_product5_delivery(String delivery) {
	    	assertTrue(p_5_pf.validate_delivery(delivery));
	 		}
	 	    
	    @And("validate product5 order {string} by amazon")
	    public void validate_product5_order_by_amazon(String fulfill) {
	    	assertTrue(p_5_pf.validate_fulfillment(fulfill));
 		}
	    
	    @Given("fetch element10 from the search")
		public void fetch_element10_from_the_search() {
				p_10_pf=search_pf.navigate_10thsearch();
		}

		
		@Then("store the product10 details in file")
		public void store_the_product10_details_in_file() {
			p_10_pf.store_product10_details();
		}
		   
		    @Then("validate product10 type {string}")
			public void validate_product10_type(String type) {
		    	assertTrue(p_10_pf.validate_type(type));
			}
		    
		    @Then("validate product10 material {string}")
			public void validate_product10_material(String material) {
		    	assertTrue(p_10_pf.validate_material(material));
			}
		    
		   
		    @Then("validate product10 brand {string}")
			public void validate_product10_brand(String brand) {
		    	assertTrue(p_10_pf.validate_brand(brand));
			}
		    
		    @Then("validate product10 discount {int}")
			public void validate_product10_discount(int discount) {
		    	assertTrue(p_10_pf.validate_discount(discount));
			}
		    
		    @Then("validate product10 delivery {string}")
		 		public void validate_product10_delivery(String delivery) {
		    	assertTrue(p_10_pf.validate_delivery(delivery));
		 		}
		 	    
		    @And("validate product10 order {string} by amazon")
		    public void validate_product10_order_by_amazon(String fulfill) {
		    	assertTrue(p_10_pf.validate_fulfillment(fulfill));
	 		}

		    @Given("fetch element15 from the search")
			public void fetch_element15_from_the_search() {
		    	p_15_pf=search_pf.navigate_15thsearch();
			}

			
			@Then("store the product15 details in file")
			public void store_the_product15_details_in_file() {
				p_15_pf.store_product15_details();
			}
			   
			    @Then("validate product15 type {string}")
				public void validate_product15_type(String type) {
			    	assertTrue(p_15_pf.validate_type(type));
				}
			    
			    @Then("validate product15 material {string}")
				public void validate_product15_material(String material) {
			    	assertTrue(p_15_pf.validate_material(material));
				}
			    
			   
			    @Then("validate product15 brand {string}")
				public void validate_product15_brand(String brand) {
			    	assertTrue(p_15_pf.validate_brand(brand));
				}
			    
			    @Then("validate product15 discount {int}")
				public void validate_product15_discount(int discount) {
			    	assertTrue(p_15_pf.validate_discount(discount));
				}
			    
			    @Then("validate product15 delivery {string}")
			 		public void validate_product15_delivery(String delivery) {
			    	assertTrue(p_15_pf.validate_delivery(delivery));
			 		}
			 	    
			    @And("validate product15 order {string} by amazon")
			    public void validate_product15_order_by_amazon(String fulfill) {
			    	assertTrue(p_15_pf.validate_fulfillment(fulfill));
		 		}
	 

}


