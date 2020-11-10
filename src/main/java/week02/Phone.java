package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("iPhone", 256);
        Phone phone2 = new Phone("iPhone W", 1024);

        System.out.println("Phone1: type: " + phone1.getType() + " mem:" + phone1.getMem());
        System.out.println("Phone2: type: " + phone2.getType() + " mem:" + phone2.getMem());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a telfon típusát:");
        String type = scanner.nextLine();
        System.out.println("Adja meg a telfon memóráját:");
        int mem = scanner.nextInt();

        Phone cunstomPhone = new Phone(type, mem);
        System.out.println("Custom phone: type: " + cunstomPhone.getType() + " mem:" + cunstomPhone.getMem());

        System.out.println(0.2+0.1);
    }
}
