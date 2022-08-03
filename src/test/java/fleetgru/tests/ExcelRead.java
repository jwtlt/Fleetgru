package fleetgru.tests;

import org.apache.poi.xssf.usermodel.*;
import org.junit.*;

import java.io.*;

public class ExcelRead {

    @Test
    public void readExcelFile() throws IOException {

        String path = "spartan.xlsx";

        File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Worksheet");

        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        System.out.println("sheet.getRow(10).getCell(0) = " + sheet.getRow(10).getCell(0));

        System.out.println("sheet.getRow(10).getCell(2) = " + sheet.getRow(10).getCell(2));

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        //find  Dita on Excel dynamically
        for(int rowNum=0 ; rowNum<usedRows ; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Dita")) {
                System.out.println("sheet.getRow(rowNum).getCell(0) = " + sheet.getRow(rowNum).getCell(0));
            }
        }

        for (int rowNum=0 ; rowNum<usedRows ; rowNum++){
            if(sheet.getRow(rowNum).getCell(1).toString().equalsIgnoreCase("female")){
                System.out.println("sheet.getRow(rowNum).getCell(0) = " + sheet.getRow(rowNum).getCell(0));
            }
        }

    }
}
