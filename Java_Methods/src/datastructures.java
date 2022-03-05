public class datastructures {
    //updates the given array with the new value
    public int [] add(int [] array, int numadd) {
        int [] ret = new int[array.length + 1];
        int k = 0;
        for (int i : array) {
            ret[k] = i;
            k++;
        }
        ret[k] = numadd;
        return ret;
    } //updates the given double array with a new integer
    public int [][] addd(int [][] a, int numadd) {
        int [][] ret = new int[2][a[0].length + 1];
        int k = 0;
        for (int i : a[0]){
            ret[0][k] = i;
            k++;
        }
        ret[0][k] = numadd;
        return ret;
    }

    //adds all the given elements of array 
    public int sum(int [][] a) {
        int sum = 0;
        for (int i = 0; i < a[0].length; i ++)
            sum += a[0][i];
        return sum;
    }

    //Adds additional character to a string
    public static String [] stradd(String [] strarr, String s) {
        String [] ret = new String[strarr.length + 1];
        int k = 0;
        for (String i : strarr) {
            ret[k] = i;
            k++;
        }
        ret[k] = s;
        return ret;
    }

    //checks if the given string is inside the given string array
    public boolean inn(String [] Str, String s)
    {
        for (String a : Str)
        {
            if( a.equals(s))
                break;
            else
                return true;
        }
        return false;
    }

    //Adds float values to the array
    public float [] addf(float [] array, float numadd) {
        float [] ret = new float[array.length + 1];
        int k = 0;
        for (float i : array) {
            ret[k] = i;
            k++;
        }
        ret[k] = numadd;
        return ret;
    }
}
