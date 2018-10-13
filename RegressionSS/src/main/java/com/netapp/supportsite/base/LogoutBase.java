package com.netapp.supportsite.base;

import com.ust.sarf.testdata.TestDataManage;


/**
 * Class : LogoutBase
 * @author : UST Global
 */

public class LogoutBase extends Base{

	/**
	 * @Method	: clickLogout
	 * @Description : To click Logout  
	 * @author : Salba Balakrishnan 
	 * modified:Sreejith 
	 * @Description : added more time to wait element
	 * @date : 7-Feb-2017
	 */
	public void clickLogout(){
		waitForElement(TestDataManage.getObjectProperty("Logout_Link"));
		click("Logout_Link");
	}

}
