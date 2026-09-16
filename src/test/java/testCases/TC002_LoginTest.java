package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
    @Test(groups={"Sanity", "Master"})  //master contains all the test cases if we have multiple groups we need to put them in curly braces
	public void verify_login()
	{
	    logger.info("****** Starting TC_002_LoginTest *****");

	    try
	    {
	        //HomePage
	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickLogin();

	        //Login
	        LoginPage lp = new LoginPage(driver);
	        lp.setEmail(p.getProperty("email"));
	        lp.setPassword(p.getProperty("password"));
	        lp.clickLogin();

	        //MyAccount
	        MyAccountPage macc = new MyAccountPage(driver);
	        boolean targetPage = macc.isMyAccountPageExists();

	        Assert.assertTrue(targetPage);    // Assert.assertEquals(targetPage, true, "Login failed");
	    }
	    catch(Exception e)
	    {
	    	Assert.fail();
	    }

	    logger.info("****** Finished TC_002_LoginTest *****");
	}
}