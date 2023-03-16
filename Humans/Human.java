package Humans;

import Exceptions.ProfessionException;
import Items.*;
import Locations.Location;
import Professions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Action, Speakable, Cooking{
    private final String name;
    //list array of professions
    private List<Profession> professions = new ArrayList<Profession>();
    private Inventory inventory;
    private final ProfessionsFactory professionsFactory = new ProfessionsFactory();
    final private Wallet wallet;
    public boolean isHeardAboutRestaurant;
    public Human(String name, Inventory inventory, int money) {
        this.name = name;
        this.inventory = inventory;
        this.wallet = new Wallet("кошелёк", money);
    }
    public Human(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.wallet = new Wallet("кошелёк", 0);
    }
    public String getName(){
        return name;
    }

    public void setProfessions(List<ProfessionsTypes> professions) throws ProfessionException {
        for (ProfessionsTypes profession : professions) {
            this.professions.add(ProfessionsFactory.createProfession(profession, wallet, inventory,name));
        }
    }
    public void setProfession(ProfessionsTypes profession) throws ProfessionException {
        try {
            this.professions.add(ProfessionsFactory.createProfession(profession, wallet, inventory, name));
        } catch (ProfessionException e){
            System.out.println(e.getMessage());
        }
    }
    public void setProfession(Profession profession) {
        this.professions.add(profession);
    }
    public Profession getProfession(ProfessionsTypes type){
        for (Profession profession: professions){
            if (profession.getType()== type){
                return profession;
            }
        }
        return null;
    }


    public void goTo(Location location) {
        System.out.println(name + " пришел в " + location.getName());
    }

    public void eat(Dish dish) {
        inventory.removeItem(dish);
        System.out.println(name + " съел " + dish.getName());
    }

    public void want(String something){
        System.out.println(name + " захотел "+ something);
    }

    public void discussLocation(Location location, List<Human> humans) {
        System.out.println(name + " рассказал о " + location.getName());
        for (Human human : humans){
            human.NowHeardAboutRestaurant();
        }
    }
    public void tell(String words, List<Human> humans){
        StringBuilder names = new StringBuilder();
        for (Human human : humans){
            names.append(human.getName()).append(" ");
        }
        System.out.println(name + " рассказал о " + words + "Следующим людям:" + names);
    }
    public void negotiate(String words, Human human){
        System.out.println(name + " договорился с " + human.getName() + " о " + words);
    }
    private void NowHeardAboutRestaurant() {
        System.out.println(name+ " узнал о необычных блюдах на пищезаправочной станции");
        isHeardAboutRestaurant = true;
    }
    private boolean permission (){
        //Random random = new Random();
        //return random.nextBoolean();
        return true;
    }
    public boolean giveItem(Item item){
        if (permission() && inventory.hasItem(item)){
            inventory.removeItem(item);
            return true;
        }
        return false;
    }
    public void receiveItem(Item item){
        inventory.addItem(item);
    }
    public void takeItem(Item item,Table table){
        table.take(item);
        System.out.println(name + " взял со стола " + item.getName());
        receiveItem(item);
    }
    public void buy(Item item, int cost, Human trader){
        Dealer dealer = (Dealer)(trader.getProfession(ProfessionsTypes.DEALER));
        if (dealer.sell(item,cost,trader.getName(),this.name) && (wallet.getMoney() >= cost)){
            wallet.removeMoney(cost);
            receiveItem(item);
            System.out.println(this.name + " удалось купить " + item.getName());
        } else {
            System.out.println("Купить" + item + "не удалось");
        }

    }
    public void demand(String thing, Human human) {
        System.out.println(name + " потребовал " + thing + " у " + human.getName());
    }
    public void sit(Table table){
        System.out.println(name + " сел за" + table.getName());
    }
    public void salt(Dish dish, int saltWeight) {
        Item salt = inventory.getItem("соль");
        ((Salt) salt).setWeight(((Salt) salt).getWeight()-saltWeight);
        dish.salt();
        System.out.println(name + " посолил " + dish.getName());
    }
    public void salt(Dish dish) {
        Item salt = inventory.getItem("соль");
        ((Salt) salt).setWeight(((Salt) salt).getWeight()-1);
        if (((Salt) salt).getWeight() == 0){
            inventory.removeItem(salt);
        }
        dish.salt();
        System.out.println(name + " посолил " + dish.getName());
    }

    public void boil(Dish dish) {
        dish.cook();
        System.out.println(name + " приготовил " + dish);
    }
    public Inventory getInventory(){
        return inventory;
    }

    //override toString, equals and hashCode methods
    @Override
    public String toString() {
        return "Humans.Human{" +
                "name='" + name + '\'' +
                ", professions=" + professions +
                ", inventory=" + inventory +
                ", wallet=" + wallet +
                ", isHeardAboutRestaurant=" + isHeardAboutRestaurant +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return isHeardAboutRestaurant == human.isHeardAboutRestaurant &&
                Objects.equals(name, human.name) &&
                Objects.equals(professions, human.professions) &&
                Objects.equals(inventory, human.inventory) &&
                Objects.equals(wallet, human.wallet);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, professions, inventory, wallet, isHeardAboutRestaurant);
    }
}
