package com.st.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.st.pages.HotelHomePage;
import com.st.pages.SnapTravelHomePage;
import com.st.utility.SnapTravelUtility;

public class SnapTravelTest extends BaseTest{

	 @Test
	    public void homepageTests() {
	        SnapTravelHomePage sp = new SnapTravelHomePage(getDriver());
	        HotelHomePage hp = new HotelHomePage(getDriver());
	        sp.navigateToHomepage();
	        Assert.assertTrue(sp.getPageTitle().equalsIgnoreCase(SnapTravelUtility.getValueByKey("pagetitle")), "The user is not landed on the SnapTravel homepage");
	        sp.searchLocation(SnapTravelUtility.getValueByKey("location"));
	        Assert.assertTrue(sp.getLocationName().contains(SnapTravelUtility.getValueByKey("location")), "The given location has been displayed in the search result");
	        sp.selectLocation();
	        sp.selectHotel();
	        hp.select_ReserveRoom();
	        hp.enterGuestDetails();
	        hp.enterPaymentDetails();
	        
	    }
	
}
