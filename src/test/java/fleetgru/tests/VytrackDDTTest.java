package fleetgru.tests;

import fleetgru.pages.*;
import fleetgru.utilities.*;
import org.apache.poi.xssf.usermodel.*;
import org.junit.*;
import org.openqa.selenium.support.ui.*;

import java.io.*;

public class VytrackDDTTest {
    VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
    VytrackDashboard vytrackDashboard = new VytrackDashboard();

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrackUrl"));
    }

    @After
    public void teardown() {
        Driver.closeBrowser();
    }

    @Test
    public void loginDDTTest() throws IOException {

        String filePath = "vytrack.xlsx";

        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            String userName = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstname = sheet.getRow(i).getCell(2).toString();
            String lastname = sheet.getRow(i).getCell(3).toString();

            vytrackLoginPage.login(userName, password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(vytrackDashboard.fullName));

            String actualFullName = vytrackDashboard.fullName.getText();

            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstname) && actualFullName.contains(lastname)) {
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
                System.out.println("actualFullName = " + actualFullName);
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
                System.out.println("actualFullName = " + actualFullName);
            }

            vytrackDashboard.logOut();

        }

        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();




    }

}
