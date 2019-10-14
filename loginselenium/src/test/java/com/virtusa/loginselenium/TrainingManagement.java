package com.virtusa.loginselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TrainingManagement 
{
	private WebDriver webDriver;
	
	@BeforeClass
	public void setEnvironment()
	{
		 System.setProperty("webdriver.chrome.driver", "E:\\Virtusa Project\\chromedriver.exe");
	     webDriver=new ChromeDriver();
	}
	
		  @DataProvider(name="credentails") 
	  public Object[][] dataDrivenTest() {
	  Object[][] dataProvider=null; try {
	  dataProvider=getData("C:\\Users\\Admin\\Desktop","addTopic.xlsx","Sheet1"); }
	  catch (IOException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  return dataProvider; }
	  
	  @Test(dataProvider="credentails")
	  public void addTopic(String topicName,String employeeId) {
	  
	  webDriver.get("http://localhost:6061/addtopic");
	  webDriver.findElement(By.name("topicName")).sendKeys(topicName);
	  webDriver.findElement(By.name("employeeId")).sendKeys(employeeId);
	  webDriver.findElement(By.xpath("/html/body/form/fieldset/button[1]")).click();
	 // webDriver.get("http://localhost:6061/addtopic"); 
	  
	 
	  }
	  @Test
		public void loginTest()
		{
			 	
		        webDriver.get("http://localhost:6061/home");
		        webDriver.findElement(By.xpath("/html/body/header/div/button")).click();
		        webDriver.findElement(By.id("username")).sendKeys("103");
		        webDriver.findElement(By.name("password")).sendKeys("pm@123");
		}
	
	public static String[][] getData(String filePath,String fileName,String sheetName) throws IOException
	{
		File file=new File(filePath+"\\"+fileName);
		
		FileInputStream inputStream=new FileInputStream(file);
		
		Workbook workbook=null;
		
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx"))
		{
			workbook=new XSSFWorkbook(inputStream);
		}
		
		else if(fileExtensionName.equals(".xls"))
		{
			workbook=new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet=workbook.getSheet(sheetName);
		
		//find number of rows in excel file
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum(); 
		
		String[][] data=new String[rowCount+1][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0;i<rowCount+1; i++)
		{
			Row row=sheet.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				if(row.getCell(j).getCellType().equals(CellType.STRING))
				{
					
					data[i][j]=row.getCell(j).getStringCellValue();
				}
				if(row.getCell(j).getCellType().equals(CellType.NUMERIC))
				{
					data[i][j]=row.getCell(j).toString();
				}
				
		}
	     
		
		
		}
		return data;
		
	}
	/*
	 * @AfterClass public void afterMethod() { webDriver.quit(); }
	 */
}
	
	


