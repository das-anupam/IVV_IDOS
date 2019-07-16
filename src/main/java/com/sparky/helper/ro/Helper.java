package com.sparky.helper.ro;

import java.util.ArrayList;
import com.sparky.model.ro.RO;

public class Helper {
	public static String appRole; public static String userID; public static String passWord;

	public String isNewMeasuresEnabled(ArrayList<RO> roList)
	{

		
		if(roList!=null && roList.size()>0)
		{
			for( RO d : roList)
			{
				if(d.getExecuteFlag().equalsIgnoreCase("Y"))
				
				{
					//isEnabled=true;
					appRole=d.getRole();
					userID=d.getUserid();
					passWord=d.getPassword();
					System.out.println("Flag is ENABLED for user: "+appRole+"\n"+userID+"\n"+passWord+"\n");
					//break;
				}
			}
		}
		return appRole+":"+userID+":"+passWord;
	}

	
}
