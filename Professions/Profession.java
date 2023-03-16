package Professions;

import Items.Wallet;

public abstract class Profession {
    private final ProfessionsTypes profession;

    private final Wallet wallet;
    public Profession(ProfessionsTypes profession, int money) {
        this.profession = profession;
        wallet = new Wallet("кошелёк", money);
    }
    public Profession(ProfessionsTypes profession, Wallet wallet) {
        this.profession = profession;
        this.wallet = wallet;
    }
    public void work(int cost){
        wallet.addMoney(cost);
    }
    public void takeMoney(int cost){
        wallet.removeMoney(cost);
    }
    public int getMoney(){
        return wallet.getMoney();
    }

    public ProfessionsTypes getType(){
        return profession;
    }
    //equals and hashCode and toString methods
    @Override
    public String toString() {
        return "Professions.Profession{" +
                "profession=" + profession +
                ", money=" + wallet.getMoney() +
                '}';
    }
    @Override
    public int hashCode() {
        return profession.hashCode() + wallet.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession)o;
        return profession == that.profession &&
                wallet.equals(that.wallet);
    }

    public Wallet getWallet() {
        return wallet;
    }
}
