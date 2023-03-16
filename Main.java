import Exceptions.ProfessionException;
import Humans.Human;
import Items.*;
import Locations.*;
import Professions.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ProfessionException {
        //локации
        Room kitchen = new Room("кухня", 10, 10, new Inventory());
        Room terrace = new Room("веранда", 10, 10, new Inventory());
        Room additionRoom = new Room("пристройка", 10, 10, new Inventory());
        Table table = new Table("стол", 1);
        Table tableWithSign = new Table("стол с табличкой 'продажа соли'", 1);
        Restaurant restaurant = new Restaurant("Пищезаправочная станция", new Inventory());
        restaurant.inventoryAddItem(table);

        Shore shore = new Shore("берег моря");

        Barn barn = new Barn("сарай", new Inventory());

        //толпы
        List<Human> crowd1 = new ArrayList<>();
        List<Human> crowd2 = new ArrayList<>();
        List<Human> factoryWorkers = new ArrayList<>();
        List<Human> factoryDeliveryman = new ArrayList<>();
        List<Human> factoryDeliverymanShore = new ArrayList<>();

        //генерация людей в толпе
        for (int i = 0; i < 1; i++) {
            crowd1.add(new Human("Человек" + i, new Inventory(), 50));
        }
        for (int i = 0; i < 1; i++) {
            crowd2.add(new Human("Человек А" + i, new Inventory(), 50));
        }
        for (int i = 0; i < 6; i++) {
            factoryWorkers.add(new Human("Человек Б" + i, new Inventory(), 50));
        }
        for (int i = 0; i < 3; i++) {
            factoryDeliveryman.add(new Human("Человек В" + i, new Inventory(), 50));
        }
        for (int i = 0; i < 3; i++) {
            factoryDeliverymanShore.add(new Human("Человек Г" + i, new Inventory(), 50));
        }

        //генерация города
        List<Human> city = new ArrayList<>();
        city.addAll(crowd1);
        city.addAll(crowd2);
        city.addAll(factoryWorkers);

        //еда
        List<Dish> recipes = new ArrayList<>();
        String[] dishNames = {"суп", "борщ", "щи", "макароны", "оладьи", "картофель", "жаренные кабачки", "каша"};
        for (String dish : dishNames) {
            recipes.add(new Dish(dish, false, true, 1));
        }

        //действующие лица
        //Пончик
        FactoryOwner ponchikFactoryOwner = new FactoryOwner(new Wallet("Кошелёк Пончика", 0), "Пончик") {
            @Override
            public void createFactory(Barn factory) {
                setFactory(factory);
                System.out.println("Пончик основал завод в сарае");
            }
        };
        List<ProfessionsTypes> ponchikProfessions = new ArrayList<>();
        ponchikProfessions.add(ProfessionsTypes.DEALER);
        ponchikProfessions.add(ProfessionsTypes.SALTGRINDER);
        Salt ponchikSalt = new Salt(100, 1);
        Human ponchik = new Human("Пончик");
        ponchik.receiveItem(ponchikSalt);
        ponchik.setProfessions(ponchikProfessions);
        //Официант
        Human waiter = new Human("Официант");
        waiter.setProfession(ProfessionsTypes.WAITER);
        Waiter waiterPro = ((Waiter) (waiter.getProfession(ProfessionsTypes.WAITER)));
        //Повар
        Human chef = new Human("Повар");
        chef.setProfession(ProfessionsTypes.CHEF);
        ((Chef) (chef.getProfession(ProfessionsTypes.CHEF))).setRecipes(recipes);
        //хозяйка
        Human owner = new Human("Хозяйка");
        owner.setProfession(ProfessionsTypes.RESTAURATEUR);
        ((Restaurateur) owner.getProfession(ProfessionsTypes.RESTAURATEUR)).setRestaurant(restaurant);
        //сюжет
        ponchik.tell("том, что соль надо употреблять в небольших количествах, иначе вкус от нее теряется, и уж ни в каком случае нельзя есть соль в чистом виде.", crowd1);

        //тут они покупают, пробуют и едят

        for (Human human : crowd1) {
            human.buy(new Salt(7, ponchikSalt.getCost()), ponchikSalt.getCost(), ponchik);
            for (String dishName : dishNames) {
                human.want("попробовать еду с солью");
                human.demand(dishName, waiter);
                waiterPro.setRequest(dishName);
                waiterPro.askChef(chef);
                waiterPro.serve(table);
                human.takeItem(table.getItem(dishName), table);
                Dish dish = (Dish) human.getInventory().getItem(dishName);
                human.salt(dish, 1);
                human.eat(dish);
            }
        }

        ponchik.goTo(shore);
        ((SaltGrinder) ponchik.getProfession(ProfessionsTypes.SALTGRINDER)).grindSalt(ponchik.getInventory(), 10, 0);
        ((SaltGrinder) ponchik.getProfession(ProfessionsTypes.SALTGRINDER)).crushSalt(ponchik.getInventory());
        ponchik.goTo(restaurant);
        ((Restaurateur) owner.getProfession(ProfessionsTypes.RESTAURATEUR)).addFurniture(tableWithSign);
        ponchik.sit(tableWithSign);
        for (Human human : crowd2) {
            human.buy(new Salt(7, ponchikSalt.getCost()), ponchikSalt.getCost(), ponchik);
            for (String dishName : dishNames) {
                human.demand(dishName, waiter);
                ponchik.demand(dishName, waiter);
                waiterPro.setRequest(dishName);
                waiterPro.setRequest(dishName);
                waiterPro.askChef(chef);
                waiterPro.askChef(chef);
                waiterPro.serve(table);
                waiterPro.serve(tableWithSign);
                human.takeItem(table.getItem(dishName), table);
                ponchik.takeItem(tableWithSign.getItem(dishName), tableWithSign);
                Dish dish = (Dish) human.getInventory().getItem(dishName);
                Dish pdish = (Dish) ponchik.getInventory().getItem(dishName);
                human.salt(dish, 1);
                ponchik.salt(pdish, 1);
                human.eat(dish);
                ponchik.eat(pdish);
            }
        }
        crowd1.get(0).discussLocation(restaurant, city);
        ((Restaurateur) owner.getProfession(ProfessionsTypes.RESTAURATEUR)).improveRoom(kitchen, 5, 5);
        ((Restaurateur) owner.getProfession(ProfessionsTypes.RESTAURATEUR)).improveRoom(terrace, 5, 5);
        ((Restaurateur) owner.getProfession(ProfessionsTypes.RESTAURATEUR)).addRoom(additionRoom);
        ((Restaurateur) owner.getProfession(ProfessionsTypes.RESTAURATEUR)).order("устроить навес из брезента");
        owner.negotiate("покупке соли", ponchik);
        ponchik.setProfession(ponchikFactoryOwner);
        ponchikFactoryOwner.createFactory(barn);
        for (int i = 0; i < 6; i++) {
            SaltMachineTool saltMachineTool = new SaltMachineTool("медная ступка" + i, 0);
            ponchikFactoryOwner.addTool(saltMachineTool);
            ponchikFactoryOwner.setWorkers(factoryWorkers.get(i));
        }
        for (int i = 0; i < 3; i++) {
            ponchikFactoryOwner.setDeliveryman(factoryDeliveryman.get(i));
        }
        for (int i = 0; i < 3; i++) {
            ponchikFactoryOwner.setDeliveryman(factoryDeliverymanShore.get(i));
        }
    }
}
