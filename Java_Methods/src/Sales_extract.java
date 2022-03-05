import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Sales_extract {



    // What we need are the following 
    // Date
    // Client Name
    // Address
    // Valve Family
    // Quantity   
    // Selling price

//   public String valvefamily(String s) {
//       char [] a = new char[s.length()];
//       if(a[0] == 'L') 
//       {
//           return "Ball Valve";
//       }
//
//       for ( int i = 0; i < a.length; i++)
//       {
//           if ((a[i] == 'I' && a[i+1] == 'B') || (a[i] == 'I' && a[i+1] == 'W' && a[i+2] == 'N'))
//           {
//               return "Butterfly Valve";
//           }
//           if(i == a.length - 2)
//           {
//               break;
//           }
//       }
//
//       for ( int i = 0; i < a.length; i++)
//       {
//           if (a[i] == 'B' && a[i+1] == 'V')
//           {
//               return "Gate Valve";
//           }
//       }
//       
//       if(s.contains("EXPERT"))
//       {
//           return "Expert Non-Slam Valve";
//       }
//
//       for (int i = 0; i < a.length; i++)
//           {
//           if(a[i] == '0' || a[i] == '1' || a[i] == '2' || a[i] == '3' || a[i] == '4' || a[i] == '5' || a[i] == '6' || a[i] == '7' || a[i] == '8' || a[i] == '9')
//           {
//               return "Butterfly Valve";
//           }
//           }
//       return "Something else";
//   }

    public static void main(String [] args) throws Exception
    {
        valvefamily vf = new valvefamily();
        FileInputStream fin = new FileInputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final.xlsx"));
        XSSFWorkbook wb1 = new XSSFWorkbook(fin);
        XSSFWorkbook wb2 = new XSSFWorkbook();

        //Client sheet
        Sheet ws = wb2.createSheet("Client");
        for (int i = 0; i < wb1.getSheetAt(0).getLastRowNum(); i++)
        {
            Row r = ws.createRow(i);
            if (i == 0){
                for (int j = 0; j < 7; j++)
            {
                Cell c = r.createCell(j);
                switch (j)
                {
                    case 0:
                        c.setCellValue("Date");
                        break;
                    case 1:
                        c.setCellValue("Client Name");
                        break;
                    case 2:
                        c.setCellValue("Address");
                        break;
                    case 3:
                        c.setCellValue("Name of valve");
                        break;
                    case 4:
                        c.setCellValue("Valve Family");
                        break;
                    case 5:
                        c.setCellValue("Quantity");
                        break;
                    case 6:
                       c.setCellValue("Selling Price");
                        break;
                }
            }          
            continue;
        }
        Cell Date = r.createCell(0);
        Cell Name = r.createCell(1);
        Cell Address = r.createCell(2);
        Cell Valve = r.createCell(3);
        Cell Valfam = r.createCell(4);
        Cell Quantity = r.createCell(5);
        Cell SP = r.createCell(6);
        
        Date.setCellValue(wb1.getSheetAt(0).getRow(i).getCell(0).getDateCellValue());
        Name.setCellValue(wb1.getSheetAt(0).getRow(i).getCell(1).getStringCellValue());
        Address.setCellValue(wb1.getSheetAt(0).getRow(i).getCell(5).getStringCellValue());
        Valve.setCellValue(wb1.getSheetAt(0).getRow(i).getCell(2).getStringCellValue());
        Quantity.setCellValue(wb1.getSheetAt(0).getRow(i).getCell(3).getNumericCellValue());
        SP.setCellValue(wb1.getSheetAt(0).getRow(i).getCell(4).getNumericCellValue());
        Valfam.setCellValue(vf.valveclass(Valve.toString()));
    }

            FileOutputStream fout = new FileOutputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final2.xlsx"));
            wb2.write(fout);
            wb1.close();
            wb2.close();
    
    }
}
