package com.twu.biblioteca;

import java.util.Scanner;

class ReturnBook implements menuStrategy {
    public String showOptionMessage() {
        return "3. Return book";

    }

    public void executeOption(Library library, int selectedOption) {
        if (selectedOption == 3) {
            Scanner readerId = new Scanner(System.in);
            System.out.println("Please enter your library number");
            String libraryNumber = readerId.next();
            System.out.println("Please enter your password");
            String password = readerId.next();
            library.setLoggedUser(library.validateUser(libraryNumber, password));
            if (library.getLoggedUser() != null) {
                library.returnBookToTheLibrary(library.getLoggedUser());
            }
        }
    }
}
