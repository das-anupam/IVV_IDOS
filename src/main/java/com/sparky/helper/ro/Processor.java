package com.sparky.helper.ro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sparky.model.ro.RO;

public class Processor {
	 List<RO> roList=null;
	 static LinkedHashMap<String,String> tcMap=null;
	 static String userid=null;
	 static String runTC=null;
	 @SuppressWarnings({ "rawtypes", "unused" })
	private static ArrayList userIdList;
	 public static String excelPath=System.getProperty("user.dir")+"/Source_Files/CmmiSparksoft.xlsx";
	  
	  public static HashMap<String,String> getAppIds()
		{
			try 
			{		
				userIdList=new ArrayList<String>();
				tcMap=new LinkedHashMap<String,String>();
				FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

		           
	            @SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

	            
	            XSSFSheet sheet = workbook.getSheetAt(0);

	           
					for(int q=1;q<=sheet.getLastRowNum();q++)
					{
						userid=sheet.getRow(q).getCell(0).getStringCellValue();
						
						runTC=sheet.getRow(q).getCell(3).getStringCellValue();
						//System.out.println("Thie Flow picked is :" +runTC);
						
						tcMap.put(userid, runTC);
					}
					
				
			}
				
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			return tcMap;
		}
	  
	  
	@SuppressWarnings("resource")
	public ArrayList<RO> getRoleFromArraylist(String userID) throws Exception
	{
		roList = new ArrayList<RO>();
		try
        {
          
            FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

           
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            
            XSSFSheet sheet = workbook.getSheetAt(0);            
           
                      for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
                    	  RO e= new RO();
                          Row ro=sheet.getRow(i);
                          for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
                              Cell ce = ro.getCell(j);
                              if(j==0){  
                                  e.setUserid(ce.getStringCellValue());
                                  userID=e.getUserid();
                                 System.out.println("The Users ID is: \t\n"+userID);
                              }
                              if(j==1){
                                  e.setPassword(ce.getStringCellValue());
                                  System.out.println("password: "+e.getPassword());
                              }
                              if(j==2){
                                  e.setRole(ce.getStringCellValue());
                                  System.out.println("role: "+e.getRole());
                              } 

                              if(j==3){
                                  e.setExecuteFlag(ce.getStringCellValue());
                                  System.out.println("execute flag: "+e.getExecuteFlag());
                              }
                          
                             
                            
                          }
                          roList.add(e);
                      }
           
        } catch (IOException ie)
        {
            ie.printStackTrace();
        }
		return (ArrayList<RO>) roList;
	}

}
