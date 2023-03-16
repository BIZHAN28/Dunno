package Professions;

import Items.Dish;
import Items.Item;
import Items.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Chef extends Profession{
    private List<Dish> recipes = new ArrayList<>();
    public Chef(Wallet wallet) {
        super(ProfessionsTypes.CHEF, wallet);
    }
    public void setRecipes(List<Dish> recipes){
        this.recipes = recipes;
    }
    public Dish cook(String dishName, String chefName){
        Dish dish;
        class Appliance extends Item {
            public Appliance(String name, int cost) {
                super(name, cost);
            }
        }
        Appliance appliance = new Appliance("приборы", 10);
        for (Dish recipe: recipes){
            if (Objects.equals(recipe.getName(), dishName)){
                dish = recipe;
                System.out.println(chefName + " приготовил " + dish.getName()+ ", используя "+ appliance.getName());
                return new Dish(dish.getName(), dish.isSalted(), dish.isCooked(), dish.getCost());
            }
        }
        return null;
    }
}
