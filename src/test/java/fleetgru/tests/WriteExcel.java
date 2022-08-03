package fleetgru.tests;

import org.apache.poi.xssf.usermodel.*;
import org.junit.*;

import java.io.*;

public class WriteExcel {


    @Test
    public void writeExcelFile() throws IOException {

        String path = "spartan.xlsx";

        File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Worksheet");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(152000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(210000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(125600);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(114000);

        XSSFCell salary5 = sheet.getRow(5).createCell(3);
        salary5.setCellValue(243000);

        XSSFCell salary6 = sheet.getRow(6).createCell(3);
        salary6.setCellValue(125000);

        XSSFCell salary7 = sheet.getRow(7).createCell(3);
        salary7.setCellValue(124000);

        XSSFCell salary8 = sheet.getRow(8).createCell(3);
        salary8.setCellValue(152000);

        XSSFCell salary9 = sheet.getRow(9).createCell(3);
        salary9.setCellValue(156200);

        XSSFCell salary10 = sheet.getRow(10).createCell(3);
        salary10.setCellValue(121000);

        for(int rowNum=0;rowNum<sheet.getLastRowNum();rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equalsIgnoreCase("cacilia")){
                sheet.getRow(rowNum).getCell(1).setCellValue("Male");
            }
        }

        FileOutputStream outputStream = new FileOutputStream(file);

        //save and write changes to the workbook
        workbook.write(outputStream);

        //close all
        outputStream.close();
        workbook.close();
        fileInputStream.close();

    }

}
