package utilities;


import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws Exception {

        String path = System.getProperty("user.dir")
                + "\\src\\test\\resources\\TestData\\Selenium.xlsx";

        return ExcelUtility.getExcelData(path, "Sheet1");
    }
}