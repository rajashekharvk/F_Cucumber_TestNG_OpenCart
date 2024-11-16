package StepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginDDTExcel {
	     WebDriver driver;
	     HomePage hp;
	     LoginPage lp;
	     MyAccountPage macc;
	  
	     List<HashMap<String, String>> datamap; //Data driven
	   
	    //*******   Data Driven test **************
	    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
	    {
	        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

	        int index=Integer.parseInt(rows)-1;
	        String email= datamap.get(index).get("username");
	        String pwd= datamap.get(index).get("password");
	        String exp_res= datamap.get(index).get("res");

	        lp=new LoginPage(BaseClass.getDriver());
	        lp.setEmail(email);
	        lp.setPassword(pwd);

	        lp.clickLogin();
	        macc=new MyAccountPage(BaseClass.getDriver());
	        try
	        {
	            boolean targetpage=macc.isMyAccountPageExists();
	            System.out.println("target page: "+ targetpage);
	            if(exp_res.equalsIgnoreCase("Valid"))
	            {
	                if(targetpage==true)
	                {
	                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(exp_res.equalsIgnoreCase("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    macc.clickLogout();
	                    Assert.assertTrue(false);
	                }
	                else
	                {
	                    Assert.assertTrue(true);
	                }
	            }


	        }
	        catch(Exception e)
	        {

	            Assert.assertTrue(false);
	        }
	      }
}




 

