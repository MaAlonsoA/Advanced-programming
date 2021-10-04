package com.MaAlonsoA.practice1;

public class Manager {

    Menu menu = new Menu(this);

    public Manager() {
    }

    public void loadFromFile() {
        System.out.println("Loaded");
    }

    public void printNumbers() {
        System.out.println("Print");
    }

    public void addNewNumber() {
        System.out.println("Add");
    }

    public void addUpNumbers() {
        System.out.println("Add Up");
    }

    public void saveOnFile() {
        System.out.println("Save");
    }

    public void exit() {
        System.out.println("Hasta ahora caracola!");
    }

    public void run() {
        menu.run();
    }
}
