package com.MaAlonsoA.practice1;

import java.util.Scanner;

public class Menu {

    private int selector;
    private final Manager manager;

    public Menu(Manager manager) {
        selector = 0;
        this.manager = manager;
    }

    private void print() {
        System.out.println("Welcome to your manager system!\n" +
                "1) Load from .txt file\n" +
                "2) Print loaded numbers\n" +
                "3) Add numbers\n" +
                "4) Add up all the numbers\n" +
                "5) Save entered values to a file\n" +
                "0) Exit");
    }

    private void select() {
        Scanner input = new Scanner(System.in);
        selector = input.nextInt();
        switch (selector) {
            case 1:
                manager.loadFromFile();
                break;
            case 2:
                manager.printNumbers();
                break;
            case 3:
                manager.addNewNumber();
                break;
            case 4:
                manager.addUpNumbers();
            case 5:
                manager.saveOnFile();
            case 0:
                manager.exit();
                break;
            default:
                break;
        }
    }

    public void run() {
        do {
            print();
            select();
        } while (selector != 0);

    }
}
