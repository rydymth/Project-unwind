
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

import java.io.File;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileOutputStream;


public class Data_cleaning {

   public static void main(String[] args) throws Exception {
    
        /* 
        Now that we have number of blankspaces, let us use it to make 
        the new desired workbook(wb)

        the wb should look as follows:


        | date | Client name | valve | quantity | ....
        | D1   | C1          | V1    |  Q1      | ....
        | D1   | C1          | V2    |  Q2      | ....
        ...
        ...
        ...
        
        */
        
        //importing the blankspace array amd making a blankspace ctr
        
       
        //getting the old workbook
        XSSFWorkbook wboriginal = new XSSFWorkbook(new FileInputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited.xlsx")));
        Sheet ws = wboriginal.getSheetAt(0);

        //Creating new workbook
        XSSFWorkbook wb2 = new XSSFWorkbook();
        Sheet ws2 = wb2.createSheet();
        
        /*
        To implement this we need to go to column number 11 where the number of valves bought
        are given. 
        This value will directly give us the valve name.
        At every 11th column if the row is not empty, then in that very row the 2nd column will give us
        the valve name.
        */

        /*We should be clear on what columns we need in our new table
        date
        Consignee/Buyer
        Valve
        Quantity
        Cost/valve
        Address
        Voucher no. 
        Voucher ref.
        Narration
        Order no. and date
        Terms of payment
        Terms of delivery
        */

        //let us make the columns
        Row row = ws2.createRow(0);
        for (int i = 0; i < 11; i++)
        {
            Cell c = row.createCell(i);
            switch (i) {
                case 0:
                    c.setCellValue("Date");
                    break;
                case 1:
                    c.setCellValue("Consignee/Buyer");
                    break;
                case 2:
                    c.setCellValue("Valve");
                    break;
                case 3:
                    c.setCellValue("Quantity");
                    break;
                case 4:
                    c.setCellValue("Cost per Valve");
                    break;
                case 5:
                    c.setCellValue("Address");
                    break;
                case 6:
                    c.setCellValue("Voucher Number");
                    break;
                case 7:
                    c.setCellValue("Voucher ref");
                    break;
                case 8:
                    c.setCellValue("Narration");
                    break;
                case 9:
                    c.setCellValue("Order number and date");
                    break;
                case 10:
                    c.setCellValue("Terms of payment");
                    break;
                case 11:
                    c.setCellValue("Terms of delivery");
                    break;
            }
        }
        
        /*Now we set the rest of the data. We set 2 counters for our new excel file
        one for row and one for column */

        //We already know what column number need to be inserted
        blankcellsvalue bcv = new blankcellsvalue();
        int [] ind = bcv.index();
        int [] dtind = bcv.dateind();
        int [] noofreps = bcv.NoOfCells();
        int reps = 0;
        int indctr = 0;
        int rowinc = 1;
        for (int i = 0; i < dtind.length; i++)
        {
            Row r = ws.getRow(dtind[i]);
            if (reps == noofreps.length - 1)
                    break;
            for (int j = 0; j < noofreps[reps]; j++)
            {
                Row r2 = ws2.createRow(rowinc);
                for (int k = 0; k < ws2.getRow(0).getLastCellNum(); k++)
                {
                    Cell c = r2.createCell(k);
            switch (k) {
                case 0:
                    c.setCellValue(r.getCell(0).getDateCellValue());
                    break;
                case 1:
                    c.setCellValue(r.getCell(2).getStringCellValue());
                    break;
                case 2:
                    c.setCellValue(ws.getRow(ind[indctr]).getCell(1).getStringCellValue());
                    break;
                case 3:
                    c.setCellValue(ws.getRow(ind[indctr]).getCell(11).getNumericCellValue());
                    break;
                case 4:
                    c.setCellValue(ws.getRow(ind[indctr]).getCell(12).getNumericCellValue());
                    break;
                case 5:
                    c.setCellValue(r.getCell(3).getStringCellValue());
                    break;
                case 6:
                    c.setCellValue(r.getCell(4).getStringCellValue());
                    break;
                case 7:
                    c.setCellValue(r.getCell(5).getStringCellValue());
                    break;
                case 8:
                    c.setCellValue(r.getCell(6).getStringCellValue());
                    break;
                case 9:
                    c.setCellValue(r.getCell(7).getStringCellValue());
                    break;
                case 10:
                    c.setCellValue(r.getCell(8).getStringCellValue());
                    break;
                case 11:
                    c.setCellValue(r.getCell(10).getStringCellValue());
                    break;
            }     
        }
        indctr++;
        rowinc++;
            }
            reps++;
        }
        
        //Now we write this workbook with an output stream
        FileOutputStream fout = new FileOutputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final.xlsx"));
        wb2.write(fout);
        wboriginal.close();
        wb2.close();
        }
        
    
    
    }
