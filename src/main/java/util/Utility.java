package util;

import java.awt.Desktop.Action;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Utility extends TestBase {

	public static final String[][] getData = null;
	public static String[][] getData;
	public static void switchToMainFrame() {
		driver.switchTo().frame("minpanel");
		
	}
	
	public static void mouseOver(WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
		
	}
	//dropdown
	public static void selectDropDown(WebElement element, String dropdown) {
		Select sel = new Select(element) {
			sel.selectByVisibleText(dropDownName);
		}
		
	public static [][] getData() {
		HSSFSheet sheet;
			try {
			FileInputStream file = new FileInputStream("D:\\1. Speedways 11.04.2022\\4. Frame Work\\Xls file\\EmpData.XLS.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheet("data");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			int rows = sheet.getLastRowNum();
			
			System.out.println(rows);
			
			int column = sheet.getRow(0).getLastCellNum();
			
			String data [][]  = new String[rows][column];
			
			for(int i=0;i<rows;i++)//rows
			{			
				for(int j=0; j<column; j++)//column
				{
					data [i][j]= sheet.getRow(i).getCell(j).toString();
		
				}
			return data;}
			return data;

		}
}}
