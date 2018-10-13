package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.LoginBase;
import com.ust.sarf.utils.Config;

/**
 * Class : Login
 * @author : UST Global
 */

public class Login extends LoginBase 
{

	/********************************************************************************************************************
	* Method : login
	* Description: To set the username, password and login the user 
	* Author:Tony George
	* Date: Jan-17-2017
	********************************************************************************************************************/
	public void login()
	{
			
			
			getDriver().manage().deleteAllCookies();
			String url = Config.getConfig("AplicationURL");
			getDriver().navigate().to(url); 
			waitForPageReady();
			//verifyTitle();
			navigateToLoginPage();
			enterCredentials();
			submit();
			waitForPageReady();
			

	}
}
