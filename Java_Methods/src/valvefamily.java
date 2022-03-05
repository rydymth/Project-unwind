//import java.io.FileOutputStream;

/**
* valvefamily
*/
public class valvefamily {

    public String valveclass(String s) {
        char [] a = s.toCharArray();

        if(s.contains("BALL VALVE")) return "Ball Valve";
        
        if(s.contains("BUTTERFLY")) return "Butterfly Valve";

        if(s.contains("GATE")) return "Gate valve";

        if(s.contains("GLOBE")) return "Globe valve";

        if(s.contains("CHECK")) return "Check Valve";

        if(s.contains("PISTON")) return "Piston valve";

        if(a[0] == 'L') 
        {
            return "Ball Valve";
        }

        if(a[0] == '2' && a[1] == 'I' && a[2] == 'W') return "Butterfly Valve";

        if((a[0] == '0' || a[0] == '1' || a[0] == '2' || a[0] == '3')) return "Gate Valve";

        if((a[0] == '5' && a[3] == '-')) return "Check valve";

        if( a[0] == '4' || a[0] == '5' || a[0] == '6' || a[0] == '7' || a[0] == '8' || a[0] == '9')  return "Globe Valve";

        for ( int i = 0; i < a.length; i++)
        {
            if (a[0] == 'B' && a[1] == 'V')
            {
                return "Ball Valve";
            }
        }
        
        for ( int i = 0; i < a.length; i++)
        {
            if ((a[i] == 'I' && a[i+1] == 'B') || (a[i] == 'I' && a[i+1] == 'W' && a[i+2] == 'N'))
            {
                return "Butterfly Valve";
            }
            if(i == a.length - 2)
            {
                break;
            }
        }

        if(s.contains("EXPERT"))
        {
            return "Expert Non-Slam Valve";
        }

//       for (int i = 0; i < a.length; i++)
//           {
//           if(a[i] == '0' || a[i] == '1' || a[i] == '2' || a[i] == '3' || a[i] == '4' || a[i] == '5' || a[i] == '6' || a[i] == '7' || a[i] == '8' || a[i] == '9')
//           {
//               return "Globe Valve";
//           }
//           }
//



        return "Something else";
    }

    /*
    public static void main (String [] s) throws Exception 
    {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("/Users/rudra/Documents/College/project/datastructuring/sales_edited_final.xlsx")));
        Sheet ws = wb.getSheetAt(0);
        for (int i = 1; i < ws.getLastRowNum(); i++)
        {
            System.out.println(ws.getRow(i).getCell(2).toString() + "\t |" + valveclass(ws.getRow(i).getCell(2).toString()) + "\n");
        }
    }
    */
}
