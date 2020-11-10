package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " is even: " + operators.isEven(i));
        }

        int num1 = 16;
        num1 = num1 >> 1;
        System.out.println(num1);

        num1 = 16;
        num1 = num1 << 1;
        System.out.println(num1);


        int num2 = 13;
        num2 = num2 >> 1;
        System.out.println(num2);

        num2 = 13;
        num2 = num2 << 1;
        System.out.println(num2);


        System.out.println(operators.multiplyByPowerOfTwo(16, 2));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Integer.parseInt(s, 2);   //passz
        //int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);

        System.out.println(0333);//0 az oktális számrendszertjelenti
    }
}
