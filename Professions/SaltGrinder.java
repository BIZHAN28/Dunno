package Professions;

import Items.Inventory;
import Items.Salt;
import Items.Wallet;

public class SaltGrinder extends Profession {
    public SaltGrinder(Wallet wallet) {
        super(ProfessionsTypes.SALTGRINDER, wallet);
    }
    public void grindSalt(Inventory inventory, int weight, int salary){
        System.out.println("Рабочий добыл соли");
        work(salary);
        Salt salt = new Salt(weight,true,1);
        inventory.addItem(salt);
    }
    public void crushSalt(Inventory inventory){
        System.out.println("Рабочий натолок соли");
        ((Salt)inventory.getItem("соль")).setRaw(false);
    }
}
