package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Customer {
    private ArrayList<Play> playList = new ArrayList<Play>();
    private String name;
    private int totalAmount;
    private int volumeCredits;
    private String result;

    // -------- Key Methods -----------------------------

    public void calculate() {
        for (Play child : this.getPlayList()) {

            calTotalAmount(child);

            calVolumeCredits(child);

        }

        result += "Amount owed is " + formatUSD(this.getTotalAmount() / 100) + "\n";
        result += "You earned " + this.getVolumeCredits() + " credits \n";
    }

    private void calVolumeCredits(Play child) {
        volumeCredits += Math.max(child.getAudiance() - 30, 0);

        if (child.getType() == "comedy") {
            volumeCredits += rounding(child.getAudiance() / 5);
        }
    }

    private void calTotalAmount(Play child) {

        child.calPlayAmount();

        totalAmount += child.getAmount();

        result += child.getName() + ":" + formatUSD(child.getAmount() / 100) + child.getAudiance() + " seats \n";
    }

    // ----- Support function -----------------------

    private double rounding(int i) {
        return (double) Math.round(i * 10) / 10;
    }

    private String formatUSD(int i) {
        Locale usa = new Locale("en", "US");
        Currency dollars = Currency.getInstance(usa);
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
        return dollarFormat.format(i);
    }

    // 
    // ------ Constructer , Getter , Setter --------

    public Customer(String name) {
        this.name = name;
        this.totalAmount = 0;
        this.volumeCredits = 0;
        this.result = "Statement for " + name + "\n";
    }

    public ArrayList<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(Collection<Play> p) {

        this.playList.clear();
        if (p != null) {
            this.playList.addAll(p);
        }
    }

    public void addPlay(Play p) {
        this.playList.add(p);
    }

    public void removePlay(Play p) {
        this.playList.remove(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }

    public void setVolumeCredits(int volumeCredits) {
        this.volumeCredits = volumeCredits;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
