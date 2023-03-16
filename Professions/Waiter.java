package Professions;

import Humans.Human;
import Items.*;

public class Waiter extends Profession{
    private Dish dish;
    private String request;
    public Waiter(Wallet wallet) {
        super(ProfessionsTypes.WAITER, wallet);
    }
    public void setRequest(String request){
        this.request = request;
    }
    public void askChef(Human chef){
        Chef chefProfession = ((Chef)(chef.getProfession(ProfessionsTypes.CHEF)));
        dish = (chefProfession.cook(request,chef.getName()));
    }
    public void serve(Table table){
        System.out.println("Официант поставил на стол "+request+", тем самым обслужив клиента ");
        table.place(dish);
    }
}
