package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Error implements menuStrategy {
    public String showOptionMessage() {
        return "";

    }

    public void executeOption(Library library, int selectedOption) {
        List options = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        if (!options.contains(selectedOption)) {
            System.out.println("Please select a valid option");
        }
    }
}


