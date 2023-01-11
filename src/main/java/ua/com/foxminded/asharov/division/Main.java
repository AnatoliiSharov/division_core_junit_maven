package ua.com.foxminded.asharov.division;

import java.util.Scanner;

import ua.com.foxminded.asharov.division.logic.EngineDivision;
import ua.com.foxminded.asharov.division.presentatoin.Plotter;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dividend(must be integer):");
        String dividend = scanner.nextLine();
        System.out.println("Enter divider:");
        
        String divider = scanner.nextLine();
        EngineDivision ed = new EngineDivision();
        Plotter plotter = new Plotter();
        
        System.out.println(plotter.drawDivision(ed.makeDivision(dividend, divider)));
    }

}
