package com.st.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.st.utility.SnapTravelUtility;

public class SnapTravelHomePage extends BasePage {

	/****** Constructor *******/

	public SnapTravelHomePage(WebDriver driver) {

		super(driver);
	}

	/***** Web Elements *******/

	@FindBy(css = "input.omnisearch__input.outlined")
	private WebElement searchTextBox;

	@FindBy(className = "omnisearch__search-icon")
	private WebElement searchImgIcon;

	@FindBy(className = "omnisearch__close-icon")
	private WebElement closeSearchIcon;

	@FindBy(css = "a.ui.fluid.big.button.search-container__action-btn")
	private WebElement searchButton;

	@FindBy(xpath = "(//div[@class='src-omnisearch-OmniCarousel-___OmniCarousel__carousel__cell___BIDwa'])[1]")
	private WebElement searchListElement;

	@FindBy(xpath = "(//div[contains(.,'View Details')])[1]")
	private WebElement hotelListElement;

	@FindBy(xpath = "(//span[contains(@class,'hotel-desktop-item-name')])[1]")
	private WebElement hotelListElementName;

	public void navigateToHomepage() {
		driver.get(SnapTravelUtility.getValueByKey("url"));
	}
	
	/**
	 * Function to search the location 
	 * @param searchstring
	 */

	public void searchLocation(String searchstring) {
		closeSearchIcon.click();
		searchTextBox.clear();
		searchTextBox.sendKeys(searchstring);
		searchButton.click();
	}

	
	/** 
	 * Function to select the location 
	 */
	public void selectLocation() {
		waitForElementToAppear(searchListElement);
		searchListElement.click();
	}
	
	/**
	 * Function to select the hotel
	 */

	public void selectHotel() {
		waitForElementToAppear(hotelListElement);
		hotelListElement.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getLocationName() {
		return searchListElement.getText();
	}

	public String getHotelName() {
		return hotelListElementName.getText();
	}
}
