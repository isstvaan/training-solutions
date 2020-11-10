package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b;
      //  System.out.println(b); //Nem megy
        b = false;

        int a = 2;
        int i = 3, j = 4;
        int k = i;

      //  System.out.println(tmp); //Hibát dob

        String s = "Hello world";
        String t = s;

        {
            int x = 0;
            System.out.println(s);//Megy
        }

  //      System.out.println(x);  //Nem megy

    }
}
