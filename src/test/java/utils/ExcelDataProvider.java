package test.java.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

//    @Test(dataProvider = "test1data")
//    public void test1(String username,String password){
//        System.out.println(username+" | "+password);
//    }


  @DataProvider(name="test1data")
public Object[][] getData(){

    String excelPath="C:/Users/parthi/IdeaProjects/seleniumPageObj/TestData/Data.xls";
    Object data[][]=testData(excelPath,"Sheet1");
    return data;
}

    public  Object[][] testData(String excelPath,String sheetName) {

        //ExcelUtils excel = new ExcelUtils(projectPath+"/TestData/Data.xls","Sheet1");
        ExcelUtils excel = new ExcelUtils(excelPath,sheetName);

        int rowCount =excel.getRowCount();
        int columnCount =excel.getcolumnCount();

        Object data[][] = new Object[rowCount-1][columnCount];

       for(int i=1; i<rowCount;i++){
           for(int j=0; j<columnCount;j++){

               String cellData =excel.getCellDataString(i,j);
              // System.out.print(cellData+" | ");
               data[i-1][j] = cellData;
           }
         //   System.out.println();
       }return data;
    }
}
