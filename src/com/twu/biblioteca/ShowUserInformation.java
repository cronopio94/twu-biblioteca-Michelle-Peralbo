package com.twu.biblioteca;

class ShowUserInformation implements menuStrategy {
    public String showOptionMessage() {
        return "6. Show user information";

    }

    public void executeOption(Library library, int selectedOption) {
        if (selectedOption == 6) {
            if (library.getLoggedUser() == null) {
                System.out.println("You are not logged in");
            } else {
                System.out.println(library.getLoggedUser().toString());
            }
        }
    }
}
