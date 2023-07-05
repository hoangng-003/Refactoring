package com.company;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Main {

    static String formatUSD(int i) {
        Locale usa = new Locale("en", "US");
        Currency dollars = Currency.getInstance(usa);
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
        return dollarFormat.format(i);
    }

    static double lamTron(int i) {
        return (double) Math.round(i * 10) / 10;
    }

    public static void main(String[] args) {
        // write your code here

        Customer customer = new Customer("BigCo");

        Play p1 = new Play("Hamlet", "tragedy", 55);
        Play p2 = new Play("As You Like It", "comedy", 35);
        Play p3 = new Play("Othello", "tragedy", 40);
        customer.addPlay(p1);
        customer.addPlay(p2);
        customer.addPlay(p3);

        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + customer.getName() + "\n";

        for (Play child : customer.getPlayList()) {
            int thisAmount = 0;
            switch (child.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (child.getAudiance() > 30) {
                        thisAmount += 1000 * (child.getAudiance() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (child.getAudiance() > 20) {
                        thisAmount += 1000 + 500 * (child.getAudiance() - 20);
                    }
                    thisAmount += 300 * child.getAudiance();
                    break;
                default:
                    // throw error
            }

            volumeCredits += Math.max(child.getAudiance() - 30, 0);
            if (child.getType() == "comedy") {
                // lam tron ..
                volumeCredits += lamTron(child.getAudiance() / 5);

            }
            totalAmount += thisAmount;

            result += child.getName() + ":" + formatUSD(thisAmount / 100) + child.getAudiance() + " seats \n";

        }

        result += "Amount owed is " + formatUSD(totalAmount / 100) + "\n";
        result += "You earned " + volumeCredits + " credits \n";
        System.out.println(result);
    }
}
