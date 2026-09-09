package utilities;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public static Object[][] getExcelData(String path, String sheetName) throws Exception {

        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet(sheetName);

        int lastRow = sheet.getLastRowNum();

        Object[][] data = new Object[1][2];

        for (int i = 1; i <= lastRow; i++) {

            Row row = sheet.getRow(i);

            if (row == null
                    || row.getCell(0) == null
                    || row.getCell(0).toString().trim().isEmpty()) {
                continue;
            }

            data[0][0] = row.getCell(0).toString().trim(); // Email
            data[0][1] = row.getCell(1).toString().trim(); // Password

            break;
        }

        workbook.close();
        file.close();

        return data;
    }
}