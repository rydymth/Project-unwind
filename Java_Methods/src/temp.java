import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class temp {
    //public void show_all() throws Exception{
        /*XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("D:\\Rudra_testing\\sales_edited.xlsx")));
        Sheet ws = wb.getSheetAt(0);
        for (int i = 0; i < ws.getLastRowNum(); i++)
        {
            Row row = ws.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++)
            {
                Cell cell = row.getCell(j);
                if(cell.getCellTypeEnum() == CellType.BLANK)
                    System.out.print("      \t");
                else if(cell.getCellTypeEnum() == CellType.NUMERIC)
                    System.out.print(cell.getNumericCellValue() + "\t");
                else if(cell.getCellTypeEnum() == CellType.STRING)
                    System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println("");
        }
        wb.close();
    }*/
    public static void main(String [] args) throws Exception 
    {

        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final2.xlsx")));
        // imp_functions imp = new imp_functions();
        // imp.show_row(wb, 0);
        //Sheet ws = wb.getSheetAt(0);
        

        /*
        for (int i = 0; i < ws.getLastRowNum(); i++)
        {
            Row row = ws.getRow(i);
            
            /*
            if (((row.getCell(1).getCellTypeEnum() == CellType.STRING) || 
               (row.getCell(11).getCellTypeEnum() == CellType.NUMERIC)) &&
               (row.getCell(0).getCellTypeEnum() == CellType.BLANK)) 
               {
                     Cell c = row.getCell(11);
                     Cell c1 = row.getCell(1);
                     if (c.getCellTypeEnum() == CellType.NUMERIC)
                         System.out.println(i + "\t" + c1.getStringCellValue() + "\t" + c.getNumericCellValue());
                     else if (c.getCellTypeEnum() == CellType.STRING)
                         System.out.println(i + "\t" + c1.getStringCellValue() + "\t" + c.getStringCellValue());
            } 
            
        } */
        /*
        blankcellsvalue blk = new blankcellsvalue();
        int k = 0;
        int [] ind = blk.index();
        for (int i : ind){
            if (k > 50)
                break;
            System.out.println(ws.getRow(i).getCell(12));
            k++;
        }
        */
        // blankcellsvalue bcv = new blankcellsvalue();
        // int [] values = bcv.NoOfCells();
        // int itr = 0;
        // for ( int i : values)
        // {
        //     if (itr >= 35)
        //         break;
        //     System.out.println(i);
        //     itr++;
        // }
        //imp_functions imp = new imp_functions();
        //blankcellsvalue bcv = new blankcellsvalue();
        //int [] ind = bcv.NoOfCells();
        //System.out.print(ind.length);
        String [] s = new String[0];
        frequency f = new frequency();
        for (int i = 1; i < wb.getSheetAt(0).getLastRowNum(); i++)
        {
            s = f.setS(s,wb.getSheetAt(0).getRow(i).getCell(1).toString());
        }

        int [] freq = f.probability(s,wb);
        for (int i = 0; i < freq.length; i++)
            System.out.println(s[i] + "\t || " + freq[i]);


        System.out.println("\n\n-------------------------------");


        for (String a : s)
        {
            int [] prob = f.permonth(a,wb);
            for (int i = 0; i < prob.length; i++)
                System.out.println("Client name : " + a + "\n" + "Month " + (i + 1) + "\n" + "Freq " + prob[i]);
            System.out.println("\n");
         }

//       Calendar c1 = Calendar.getInstance();
//       c1.setTime(wb.getSheetAt(0).getRow(1).getCell(0).getDateCellValue());
//      for (int i = 1; i < wb.getSheetAt(0).getLastRowNum(); i++)
//      {
//          Date d = wb.getSheetAt(0).getRow(i).getCell(0).getDateCellValue(); 
//          Calendar c = Calendar.getInstance(); 
//          c.setTime(d);
//          if (c.get(Calendar.MONTH) > c1.get(Calendar.MONTH))
//               System.out.println(c.get(Calendar.MONTH));
//               c1.setTime(wb.getSheetAt(0).getRow(i).getCell(0).getDateCellValue());
//      }
        
        wb.close();
}
}
