package com.company;

public class Main {

    public static void main(String[] args) {

        // Create Elements Customer & their Plays

        Customer customer = new Customer("BigCo");

        Play[] p = {
                new Play("Hamlet", "tragedy", 55),
                new Play("As You Like It", "comedy", 35),
                new Play("Othello", "tragedy", 40)
        };

        for (Play child : p) {
            customer.addPlay(child);
        }

        // Calculate & Print result

        customer.calculate();

        System.out.println(customer.getResult());
    }
}
