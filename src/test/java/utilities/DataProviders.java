package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Taking Excel file from testData
        String path = ".\\testData\\Opencart_LoginData.xlsx";  //dot is representing current project location 

        // Creating object for ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        // Getting total rows and columns
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Creating two-dimensional array
        String logindata[][] = new String[totalrows][totalcols];

        // Reading data from Excel
        for (int i = 1; i <= totalrows; i++) {   //1 //read the data from xl storing in two dimewnsional array

            for (int j = 0; j < totalcols; j++) {  //0 1 is rows j is col

                logindata[i - 1][j] =
                        xlutil.getCellData("Sheet1", i, j);  //1,0
            }
        }

        // Returning two-dimensional array
        return logindata;
        
        // DataProvider 2
        
        // DataProvider 3
        
        // DataProvider 4
    }
}