package com.twu.biblioteca;

class QuitApp implements menuStrategy {
    public String showOptionMessage() {
        return "7. Quit";

    }

    public void executeOption(Library library, int selectedOption) {
        if (selectedOption == 7) {
            System.exit(0);
        }
    }
}
