package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.List;
//Importing required classes
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

import Driver.Driverfactory;

public class Product_5_PF {

	@FindBy(xpath="(//span[@class='a-price-symbol'])[1]")
	private WebElement pricesymbol;

	@FindBy(xpath="//a[contains(text(),'Free Delivery')]")
	private WebElement delivery_type;

	@FindBy(xpath="//span[@id='productTitle']")
	private WebElement title;

	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	private WebElement price;

	@FindBy(xpath="//div[@id='feature-bullets']/ul/li/span")
	private List<WebElement> productdetails;

	@FindBy(xpath="(//div[@id='feature-bullets']/ul/li/span)[2]")
	private WebElement material_details;

	@FindBy(xpath="//div[@id='merchant-info']")
	private WebElement fulfillment;
	
	@FindBy(xpath="//span[@class='a-size-large a-color-price savingPriceOverride aok-align-center reinventPriceSavingsPercentageMargin savingsPercentage']")
	private WebElement discount_text;
	
	
	public boolean flag = true; 
	BufferedWriter f_writer;

	private WebDriver driver;

	public Product_5_PF(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
		PageFactory.initElements(ajax,this);
	}


	public 	void  store_product5_details() {
		try {
			
			File f_new = new File(System.getProperty("user.dir")+"/target/Output/product_5.txt");
			FileWriter f_wr= new FileWriter(f_new,false);
			
			f_writer=new BufferedWriter (f_wr);
			f_writer.write("Product % details are \n");
			if (title.isDisplayed()) {
				f_writer.write("Title: ");
				f_writer.write(title.getText());
				f_writer.write("\n");
			}
			if (pricesymbol.isDisplayed()) {
				f_writer.write("Price: ");
				f_writer.write(pricesymbol.getText()+" ");
				f_writer.write(price.getText());
				f_writer.write("\n");
			}

				f_writer.write("Product Details: ");
				for (WebElement e :productdetails) {
					if (e.isDisplayed()) {
					f_writer.write(e.getText()+"\n");
				}
			}
			f_writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public boolean validate_brand(String brand) {
		if(title.isDisplayed()) {
			String[] list_words = title.getText().split(" ");
			for (String   text: list_words) {
				if(text.equalsIgnoreCase(brand))
					break;
			}
			return flag;
		}
		return false;
	}

	public boolean validate_type(String type) {
		if(title.isDisplayed()) {
			String[] list_words = title.getText().split(" ");
			for (String   text: list_words) {
				if(text.equalsIgnoreCase(type))
					break;
			}
			return flag;
		}
		return false;
	}

	public boolean validate_material(String material) {
		if(material_details.isDisplayed()) {
			String[] list_words = material_details.getText().split(" ");
			for (String   text: list_words) {
				if(text.equalsIgnoreCase(material))
					break;
			}
			return flag;
		}
		return false;
	}

	public boolean validate_delivery(String delivery) {
		
		
		if(delivery_type.isDisplayed()) 
			if(delivery_type.getText().equals(delivery))
				return flag;
		System.out.println(delivery_type.getText());
		return false;
	}



	public boolean validate_discount(int discount) {
		if(discount_text.isDisplayed()) {
			String dis=discount_text.getText().replaceAll("-", "");
			String dis_value=dis.replaceAll("%", "");
			if((Integer.parseInt(dis_value)>discount) || (Integer.parseInt(dis_value)>=discount))
				return flag;
		}
		return false;
	}
	
	public boolean validate_fulfillment(String fulfill) {
		flag=true;
		if(fulfillment.isDisplayed()) 
			System.out.println(fulfillment.getText());
			if(fulfillment.getText().contains(fulfill)||(fulfillment.getText().contains("Delivered")))
				return flag;
		return false;
	}



}
