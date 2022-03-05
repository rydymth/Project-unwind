import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class obfuscation {
    public static String encrypt(String s) {
        char [] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
           c[i] = s.charAt(i);
        }
        for (int j = 0; j < s.length(); j++)
        {
            c[j] = (char)(int)(c[j] + 7);
        }
        String str = String.valueOf(c);
        return str;
    }

    public static String decrypt(String s) {
        char [] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
           c[i] = s.charAt(i);
        }
        for (int j = 0; j < s.length(); j++)
        {
            c[j] = (char)(int)(c[j] - 7);
        }
        String str = String.valueOf(c);
        return str;
    }

    public static void main (String [] args) throws Exception{
        FileInputStream fin = new FileInputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final.xlsx"));
        XSSFWorkbook wb1 = new XSSFWorkbook(fin);
        Sheet ws = wb1.getSheetAt(0);
        XSSFWorkbook wb2 = new XSSFWorkbook(new FileInputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited.xlsx")));
        Sheet ws2 = wb2.getSheetAt(0);
        // for (int i = 1; i < ws.getLastRowNum(); i++)
        // {
        //     String s = encrypt(ws.getRow(i).getCell(1).getStringCellValue());
        //     Cell c = ws.getRow(i).getCell(1);
        //     c.setCellValue(s);
        // }

        blankcellsvalue bcv = new blankcellsvalue();
        int [] dateind = bcv.dateind();

        for (int i = 0; i < dateind.length; i++)
        {
            String s = decrypt(ws2.getRow(dateind[i]).getCell(2).getStringCellValue());
            Cell c1 = ws2.getRow(dateind[i]).getCell(1);
            Cell c2 = ws2.getRow(dateind[i]).getCell(2);
            c1.setCellValue(s);
            c2.setCellValue(s);
        }

        // FileOutputStream fout1 = new FileOutputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final_1.xlsx"));
        // wb1.write(fout1);
        // FileOutputStream fout2 = new FileOutputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_1.xlsx"));
        // wb2.write(fout2);
        FileOutputStream fout2 = new FileOutputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_1.xlsx"));
        wb2.write(fout2);
        wb1.close();
        wb2.close();
}
}
