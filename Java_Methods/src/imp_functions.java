import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
public class imp_functions {
    public void show_table(XSSFWorkbook wb) 
    {
        Sheet ws = wb.getSheetAt(0);
        for (int i = 0; i < ws.getLastRowNum(); i++)
        {
            Row r = ws.getRow(i);
            for (int j = 0; j < r.getLastCellNum(); j++)
            {
                Cell c = r.getCell(j);
                System.out.print(c + "\t\t");
            }
            System.out.println("");
        }
    }
    public void show_row(XSSFWorkbook wb, int a)
    {
        Sheet ws = wb.getSheetAt(0);
        for (int i = 0; i < ws.getRow(a).getLastCellNum(); i++)
            {
                Cell c = ws.getRow(a).getCell(i);
                System.out.println(c);
            }
    }
    public void show_col(XSSFWorkbook wb, int a)
    {
        Sheet ws = wb.getSheetAt(0);
        for (int i = 0; i < ws.getLastRowNum(); i++)
            {
                Cell c = ws.getRow(i).getCell(a);
                System.out.println(c);
            }
    }
}
