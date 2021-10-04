package com.MaAlonsoA.practice1;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {

    private int selector;

    private final ArrayList<Integer> data;


    public Manager() {
        this.selector = -1;
        this.data = new ArrayList<>();

    }

    public void loadFromFile() {
        File file;
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        if (!data.isEmpty()){
            return;
        }
        try {
            file = new File ("res/practice1.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                data.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileReader){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printNumbers() {
        if (!data.isEmpty()) {
            for (int i = 0; i < data.size(); i++){
                if (i == data.size() - 1){
                    System.out.print(data.get(i) + "\n");
                } else {
                    System.out.print(data.get(i) + "," + " ");
                }
            }
        } else {
            System.out.println("Not data loaded");
        }
    }

    public void addNewNumber() {
        int newNumber;
        System.out.println("Enter new number separated by new line. Press any key to finish");
        Scanner input = new Scanner(System.in);
        while (true){
            try {
                newNumber = input.nextInt();
                data.add(newNumber);
            }catch (InputMismatchException e){
                System.out.println("Saved data!");
                break;
            }
        }
    }

    public void addUpNumbers() {
        int sum = 0;
        if (!data.isEmpty()) {
            for (var elem : data) sum += elem;
        }
        System.out.println(sum);
    }

    public void saveOnFile() {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("res/practice1.txt");
            printWriter = new PrintWriter(fileWriter);

            for (var elem : data)
                printWriter.println(elem);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileWriter){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void exit() {
        System.out.println("¡Me las piro vampiro!");
    }

    private void printMenu() {
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
        try {
            selector = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        switch (selector) {
            case 1:
                loadFromFile();
                break;
            case 2:
                printNumbers();
                break;
            case 3:
                addNewNumber();
                break;
            case 4:
                addUpNumbers();
                break;
            case 5:
                saveOnFile();
                break;
            case 0:
                exit();
                break;
            default:
                break;
        }
    }

    public void run() {
        do {
            printMenu();
            select();
        } while (selector != 0);
    }
}
