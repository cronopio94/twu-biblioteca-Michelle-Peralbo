package com.twu.biblioteca;

class ListBooks implements menuStrategy {

    public String showOptionMessage() {
        return "1. List of Books";

    }

    public void executeOption(Library library, int selectedOption) {
        if (selectedOption == 1) {
            library.printBooks();
        }
    }
}
