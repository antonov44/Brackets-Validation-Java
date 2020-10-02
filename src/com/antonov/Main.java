package com.antonov;

import com.antonov.brackets.BracketsValidator;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough command line arguments were passed! " +
                    "Try to start the program again. " +
                    "And do not forget to pass TWO arguments: source file and config file");
            return;
        }

        File sourceFile = new File(args[0]);
        File configFile = new File(args[1]);

        BracketsValidator bv = new BracketsValidator(sourceFile, configFile);

        try {
            bv.run();
        } catch (IOException e) {
            System.out.println("Something went wrong with reading files that you have passed to the program! " +
                    "First, check if files are exist and then try to start program again!");
        }
    }
}
