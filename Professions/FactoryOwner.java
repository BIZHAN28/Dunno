package Professions;

import Exceptions.ProfessionException;
import Humans.Human;
import Items.Item;
import Items.Wallet;
import Locations.Barn;

public class FactoryOwner extends Profession{
    private Barn factory;
    private String name;
    public FactoryOwner(Wallet wallet, String name) {
        super(ProfessionsTypes.FACTORYOWNER, wallet);
        this.name = name;
    }
    public void setFactory(Barn factory){
        this.factory = factory;
    }
    public void createFactory(Barn factory){
        this.factory = factory;
        System.out.println(name + " основал завод");
    }
    public void addTool(Item tool){
        System.out.println(name + " установил "+ tool.getName());
        factory.inventoryAddItem(tool);
    }
    public void setWorkers(Human human) throws ProfessionException {
        human.setProfession(ProfessionsTypes.FACTORYWORKER);
        System.out.println(name + " нанял "+ human.getName() + " на роль рабочего");
    }
    public void setDeliveryman(Human human) throws ProfessionException {
        human.setProfession(ProfessionsTypes.DELIVERYMAN);
        System.out.println(name + " нанял "+ human.getName() + " на роль доставщика");
    }
}
