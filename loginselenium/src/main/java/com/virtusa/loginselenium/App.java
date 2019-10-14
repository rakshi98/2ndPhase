package com.virtusa.loginselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.virtusa.loginselenium.models.Topic;
/**
 * Hello world!
 *
 */
public class App 
{
public static void readExcel(String filePath,String fileName,String sheetName) throws IOException
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
	
	int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	
	DataFormatter dataFormatter=new DataFormatter();
	
	Topic topic=null;
	
	for(int i=0;i< rowCount+1; i++)
	{
		Row row=sheet.getRow(i);
		topic=new Topic();
	
		
		for(int j=0;j<row.getLastCellNum();j++)
		{
			if(row.getCell(j).getCellType().equals(CellType.STRING))
			{
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			if(row.getCell(j).getCellType().equals(CellType.NUMERIC))
			{
				System.out.println(row.getCell(j).getNumericCellValue()+"||");
			}
			 
		}
     
	}
	
}


    public static void main( String[] args ) throws IOException
    {
          readExcel("C:\\Users\\Admin\\Desktop","addTopic.xlsx","Sheet1");
    	System.setProperty("webdriver.chrome.driver", "E:\\Virtusa Project\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        
        //launching the site
        webDriver.get("http://localhost:6061/login");
        //webDriver.findElement(By.xpath("/html/body/header/div/button")).click();
        webDriver.findElement(By.id("username")).sendKeys("102");
        webDriver.findElement(By.id("password")).sendKeys("admin@123");
       webDriver.findElement(By.xpath("/html/body/form/button")).click();
       webDriver.findElement(By.xpath("/html/body/header/div/a[2]")).click();
      // webDriver.findElement(By.id("topicName"))
       
        
    }
}
