package com.st.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.st.utility.SnapTravelUtility;

public class HotelHomePage extends BasePage {

	/****** Constructor *******/

	public HotelHomePage(WebDriver driver) {
		super(driver);
	}

	/***** Web Elements *******/

	@FindBy(css = "div.src-hotel_cards-ComparisonHeader-___ComparisonHeader__button___2gwDL")
	private WebElement selectRoomButton;

	@FindBy(xpath = "(//div[contains(@class,'test-button')])[1]")
	private WebElement reserveButton;

	@FindBy(xpath = "//div[contains(@class,'hotelcard-hotel-name')]")
	private WebElement hotelname;

	@FindBy(id = "first-name")
	private WebElement firstNameInput;

	@FindBy(id = "last-name")
	private WebElement lastNameInput;

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "phone-number")
	private WebElement phoneNumberInput;

	@FindBy(id = "btn-next-to-payment")
	private WebElement nextButton;

	@FindBy(id = "pan")
	private WebElement cardNumberInput;

	@FindBy(id = "expiry-year")
	private WebElement expiryDateInput;

	@FindBy(id = "cvv")
	private WebElement cvvInput;

	@FindBy(id = "billing-name")
	private WebElement nameOnCardInput;

	@FindBy(id = "billing-address")
	private WebElement billingAddressInput;

	@FindBy(css = "li.geosuggest__item")
	private WebElement selectFirstAddressOfList;

	@FindBy(id = "submit-payment")
	private WebElement completeBookingButton;

	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Function to select and reserve the room in a hotel
	 */
	public void select_ReserveRoom() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		waitForElementToAppear(selectRoomButton);
		selectRoomButton.click();
		waitForElementToAppear(reserveButton);
		je.executeScript("arguments[0].scrollIntoView(true);", reserveButton);
		reserveButton.click();
	}

	/**
	 * Function to enter the details of the guest for booking
	 */
	public void enterGuestDetails() {
		waitForElementToAppear(firstNameInput);
		setFirstName(SnapTravelUtility.getValueByKey("firstname"));
		setLastName(SnapTravelUtility.getValueByKey("lastname"));
		setEmail(SnapTravelUtility.getValueByKey("email"));
		setPhone(SnapTravelUtility.getValueByKey("phone"));
		nextButton.click();

	}

	/**
	 * Function to enter the payment details for booking
	 */
	public void enterPaymentDetails() {
		driver.switchTo().frame("iframe");
		setCardNumber(SnapTravelUtility.getValueByKey("cardnumber"));
		driver.switchTo().defaultContent();
		setCardExpiry(SnapTravelUtility.getValueByKey("cardexpiry"));
		setCvv(SnapTravelUtility.getValueByKey("cvv"));
		setNameOnCard(SnapTravelUtility.getValueByKey("nameoncard"));
		setBillingAddress(SnapTravelUtility.getValueByKey("billingaddress"));
		waitForElementToAppear(selectFirstAddressOfList);
		selectFirstAddressOfList.click();
		completeBookingButton.click();
	}

	public void setFirstName(String firstname) {
		try {
			waitForElementToAppear(firstNameInput);
			firstNameInput.clear();
			firstNameInput.sendKeys(firstname);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setLastName(String lastname) {
		try {
			lastNameInput.clear();
			lastNameInput.sendKeys(lastname);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setEmail(String email) {
		try {
			emailInput.clear();
			emailInput.sendKeys(email);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setPhone(String phone) {
		try {
			phoneNumberInput.clear();
			phoneNumberInput.sendKeys(phone);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setCardNumber(String cardnumber) {
		try {
			waitForElementToAppear(cardNumberInput);
			cardNumberInput.clear();
			cardNumberInput.sendKeys(cardnumber);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setCardExpiry(String cardexpiry) {
		try {
			expiryDateInput.clear();
			expiryDateInput.sendKeys(cardexpiry);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setCvv(String cvv) {
		try {
			cvvInput.clear();
			cvvInput.sendKeys(cvv);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setNameOnCard(String nameoncard) {
		try {
			nameOnCardInput.clear();
			nameOnCardInput.sendKeys(nameoncard);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setBillingAddress(String billingaddress) {
		try {
			billingAddressInput.clear();
			billingAddressInput.sendKeys(billingaddress);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

}
