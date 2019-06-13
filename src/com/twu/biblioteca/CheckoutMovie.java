package com.twu.biblioteca;

import java.util.Scanner;

class CheckoutMovie implements menuStrategy {

    public String showOptionMessage() {
        return "5. Checkout movie";

    }

    public void executeOption(Library library, int selectedOption) {
        if (selectedOption == 5) {
            System.out.println("Please select the id of the movie to checkout");
            library.printMovies();
            Scanner readerId = new Scanner(System.in);
            int idMovie = readerId.nextInt();
            library.checkOutMovie(idMovie);
        }
    }
}
