package test.java.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    static  String projectPath;
    static  HSSFWorkbook workbook;
    static HSSFSheet sheet;
    static File file;
    static FileInputStream inputStream;

    //constructor
    public ExcelUtils(String excelPath, String sheetName){

        try {
            //projectPath = System.getProperty("user.dir");
            file =new File(excelPath);
            inputStream = new FileInputStream(file);
            workbook =new HSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }

    public int getRowCount() {
        int rowCount=0;
        try {

            //get all rows in the sheet
            rowCount =sheet.getPhysicalNumberOfRows();
            int datarowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

            System.out.println("rowCount :"+rowCount);
            //System.out.println("datarowCount :"+datarowCount);
        }
        catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
        return rowCount;
    }

    public int getcolumnCount() {
        int colCount=0;
        try {
            //get all column count from the sheet
            colCount =sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("columnCount :"+colCount);
        }
        catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
        return colCount;
    }

    public  String getCellDataString(int rowNum, int colNum){
        String cellData=null;
        try {
            cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
           // System.out.println(cellData);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
    return cellData;
    }

    public  void getCellDataNumber(int rowNum, int colNum){
        try {
           double cellData =sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            //System.out.println(cellData);

        }catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
    }
}
