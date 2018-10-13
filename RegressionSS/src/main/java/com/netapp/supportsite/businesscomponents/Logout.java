package com.netapp.supportsite.businesscomponents;
/**
 * Class : Logout
 * @author : UST Global
 */

import com.netapp.supportsite.base.LogoutBase;

public class Logout extends LogoutBase{
	
	/**
	 * @Method	: logout
	 * @Description : To click Logout  
	 * @author : Salba Balakrishnan  
	 * @date : 7-Feb-2017
	 */
	public void logout(){
		waitForPageReady();
		clickLogout();
		
		//waitForPageReady();
		
	}

}
