package testCases;

/*
Data is valid - login success - test pass - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail - logout
Data is invalid -- login failed - test pass
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="dataDriven")
    // getting data provider from different class
    // we have to provide the location because data provider is in utility package
    // so we have to write this statement if that package belongs to other package

    public void verify_LoginDDT(String email, String pwd, String exp) {

    	try
    	{
        // HomePage
        HomePage hp = new HomePage(driver);

        hp.clickMyAccount();
        hp.clickLogin();


        // Login

        LoginPage lp = new LoginPage(driver);

        lp.setEmail(email);
        lp.setPassword(pwd);
        lp.clickLogin();


        // MyAccount

        MyAccountPage macc = new MyAccountPage(driver);

        boolean targetPage = macc.isMyAccountPageExists();


        /*
        Data is valid - login success - test pass - logout
        Data is valid -- login failed - test fail

        Data is invalid - login success - test fail - logout
        Data is invalid -- login failed - test pass
        */


        // If expected result is Valid

        if (exp.equalsIgnoreCase("Valid")) {

            // If login is successful, My Account page should be displayed

            if (targetPage == true) {

                // Login successful
                // Test should PASS
                // Logout from My Account page

                macc.clickLogout();

                Assert.assertTrue(true);

            } else {

                // Login failed
                // Test should FAIL

                Assert.assertTrue(false);
            }
        }


        // If expected result is Invalid

        if (exp.equalsIgnoreCase("Invalid")) {

            // If login is successful, My Account page should NOT be displayed

            if (targetPage == true) {

                // Login successful but data was Invalid
                // Test should FAIL
                // Logout from My Account page

                macc.clickLogout();

                Assert.assertTrue(false);

            } else {

                // Login failed as expected
                // Test should PASS

                Assert.assertTrue(true);
            }
        }
        
    	}catch(Exception e)
    	{
    		Assert.fail();
    	}
        logger.info("***** Finished TC003_LoginDDT *****");
        
    }
}