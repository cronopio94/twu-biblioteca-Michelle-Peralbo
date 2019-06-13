package com.twu.biblioteca;

class ListMovie implements menuStrategy {

    public String showOptionMessage() {
        return "4. List movies";

    }

    public void executeOption(Library library, int selectedOption) {
        if (selectedOption == 4) {
            library.printMovies();
        }
    }
}
