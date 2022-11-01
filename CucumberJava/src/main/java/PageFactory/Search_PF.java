package PageFactory;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

public class Search_PF {

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;


	@FindBy(id="nav-search-submit-button")
	private WebElement enter;

	@FindBy(xpath="//li[@id='p_n_feature_seven_browse-bin/1480900031']/span/a/div/label/input")
	private WebElement displaytype;

	@FindBy(xpath="//li[@id='p_89/Titan']/span/a/div/label/input")
	private WebElement brandtype;

	@FindBy(xpath="//span[(@class='a-size-base a-color-base a-text-bold') and text()='Titan']")
	private WebElement brandtext;

	@FindBy(xpath="//span[(@class='a-size-base a-color-base a-text-bold') and text()='Analogue']")
	private WebElement displaytext;

	@FindBy(xpath="//li[@id='p_n_material_browse/1480907031']/span/a/div/label/input")
	private WebElement materialtype;

	@FindBy(xpath="//span[(@class='a-size-base a-color-base a-text-bold') and text()='Leather']")
	private WebElement materialtext;

	@FindBy(xpath="//li[@id='p_n_pct-off-with-tax/2665400031']/span/a")
	private WebElement discounttype;

	@FindBy(xpath="//span[(@class='a-size-base a-color-base a-text-bold') and text()='25% Off or more']")
	private WebElement discounttext;
	
	@FindBy(xpath="(//span[@class='rush-component'])[7]")
	private WebElement element_5;
	
	@FindBy(xpath="(//span[@class='rush-component'])[7]/a")
	private WebElement element_5_link;
	
	@FindBy(xpath="(//span[@class='rush-component'])[12]")
	private WebElement element_10;
	
	@FindBy(xpath="(//span[@class='rush-component'])[12]/a")
	private WebElement element_10_link;
	

	@FindBy(xpath="(//span[@class='rush-component'])[17]")
	private WebElement element_15;
	
	@FindBy(xpath="(//span[@class='rush-component'])[17]/a")
	private WebElement element_15_link; 

	@FindBy(id="checkout")
	private WebElement cart_checkout;
	public boolean flag = true; 

	private WebDriver driver;

	public Search_PF(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
		PageFactory.initElements(ajax,this);
	}


	public boolean input_searchbox(String item) {
		if(searchbox.isDisplayed()) {
			searchbox.sendKeys(item);
			enter.click();
			return flag;
		}
		return false;
	}

	public String selectdisplay(String display) {
		try {
		if(displaytype.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", displaytype);
			//displaytype.click();
		}
		if (displaytext.isDisplayed())
			return displaytext.getText();
	}

		catch(Exception e){
			e.printStackTrace();
		}
		return "nomatch";
	}

	public String selectmaterial(String material) {
		try {
		if(materialtype.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", materialtype);
		}
		if (materialtype.isDisplayed())
			return materialtext.getText();
		}

		catch(Exception e){
			e.printStackTrace();
		}
		return "nomatch";
	}
	public String selectdiscount(String discount) {
		try {
			if(discounttype.isDisplayed()) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", discounttype);
			}
			if (discounttext.isDisplayed())
				return discounttext.getText();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "nomatch";
	}

public String selectbrand(String brand) {
	try {
		if(brandtype.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", brandtype);
		}
		if (brandtext.isDisplayed())
			return brandtext.getText();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return "nomatch";
}

public Product_5_PF navigate_5thsearch() {
	if(element_5.isDisplayed()) {
		element_5_link.click();
		switchWindowHandle();
	return new Product_5_PF(Driverfactory.getDriver());
	}
	return null;
}	

public void switchWindowHandle() {
	String originalWindow = driver.getWindowHandle();
	for (String windowHandle : driver.getWindowHandles()) {
	    if(!originalWindow.contentEquals(windowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}
}

public Product_10_PF navigate_10thsearch() {
	if(element_10.isDisplayed()) {
		element_10_link.click();
		switchWindowHandle();
	return new Product_10_PF(Driverfactory.getDriver());
	}
	return null;
}

public Product_15_PF navigate_15thsearch() {
	if(element_15.isDisplayed()) {
		element_15_link.click();
		switchWindowHandle();
	return new Product_15_PF(Driverfactory.getDriver());
	}
	return null;
}

public String check_cartURL()
{
	return Driverfactory.getDriver().getCurrentUrl();
}


}
