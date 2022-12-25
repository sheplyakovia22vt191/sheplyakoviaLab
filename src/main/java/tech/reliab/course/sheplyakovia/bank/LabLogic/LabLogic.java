package tech.reliab.course.sheplyakovia.bank.LabLogic;

import java.util.Scanner;

public class LabLogic {

    private final Scanner scanner = new Scanner(System.in);

    public void run() {

        var choose = -1;
        while (choose != 0) {
            System.out.println("Choose a lab job(1 - 4)");
            choose = scanner.nextInt();

            switch (choose) {
                case 1 -> this.lab1();
                case 2 -> this.lab2();
                case 3 -> this.lab3();
                case 4 -> this.lab4();
            }
        }

    }


    private  void lab1() {
        Lab1 lab1 = new Lab1();
        lab1.run();
    }

    private void lab2() {
        Lab2 lab2 = new Lab2();
        lab2.run();
    }

    private void lab3() {
        Lab3 lab3 = new Lab3();
        lab3.run();
    }

    private void lab4() {
        System.out.println("Lab 4");
    }
}
