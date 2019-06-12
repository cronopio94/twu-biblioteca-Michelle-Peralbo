package com.twu.biblioteca;

abstract class ListBooks implements menuStrategy {

    private Library library;

    public ListBooks() {
        library = new Library();
    }


    public String showOptionMessage() {
        return "1. List of Books";

    }

    public void executeOption(int selectedOption) {
        library.printBooks();
    }
}

abstract class CheckoutBook implements menuStrategy {
    public String showOptionMessage() {
        return "2.Checkout book";

    }

    public void executeOption() {

    }
}

abstract class ReturnBook implements menuStrategy {
    public String showOptionMessage() {
        return "3.Return book";

    }

    public void executeOption() {

    }
}

abstract class ListMovie implements menuStrategy {
    public String showOptionMessage() {
        return "4. List movies";

    }

    public void executeOption() {

    }
}

abstract class CheckoutMovie implements menuStrategy {
    public String showOptionMessage() {
        return "5. Checkout book";

    }

    public void executeOption() {

    }
}

abstract class ShowUserInformation implements menuStrategy {
    public String showOptionMessage() {
        return "6. Show user information";

    }

    public void executeOption() {

    }
}

abstract class QuitApp implements menuStrategy {
    public String showOptionMessage() {
        return "7. Quit";

    }

    public void executeOption(int menu) {

    }
}
