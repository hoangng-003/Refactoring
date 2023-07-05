package com.company;

public class Play {

    private String name;
    private String type;
    private int audiance;
    private int amount;

    public void calPlayAmount() {
        switch (type) {
            case "tragedy":
                amount = 40000;
                if (this.getAudiance() > 30) {
                    amount += 1000 * (this.getAudiance() - 30);
                }
                break;
            case "comedy":
                amount = 30000;
                if (this.getAudiance() > 20) {
                    amount += 1000 + 500 * (this.getAudiance() - 20);
                }
                amount += 300 * this.getAudiance();
                break;
            default:
                // throw Exception
        }
    }

    //
    // ------------------ Constructer , Getter , Setter --------------------------

    public Play(String name, String type, int audiance) {
        this.audiance = audiance;
        this.name = name;
        this.type = type;
        this.amount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAudiance(int audiance) {
        this.audiance = audiance;
    }

    public int getAudiance() {
        return audiance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
