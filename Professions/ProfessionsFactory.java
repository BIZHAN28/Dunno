package Professions;

import Exceptions.ProfessionNullException;
import Exceptions.ProfessionException;
import Items.Inventory;
import Items.Wallet;

public class ProfessionsFactory {

    public static Profession createProfession(ProfessionsTypes type) throws ProfessionException {
        Wallet wallet = new Wallet("кошелёк",0);
        return getProfession(type, wallet);
    }
    private static Profession getProfession(ProfessionsTypes type, Wallet wallet) throws ProfessionException, ProfessionNullException {
        if (type == null) throw new ProfessionNullException("ProfessionsTypes не может быть null");
        switch (type) {
            case DEALER:
                Inventory inventory = new Inventory();
                return new Dealer(wallet, inventory);
            case SALTGRINDER:
                return new SaltGrinder(wallet);
            case RESTAURATEUR:
                return new Restaurateur(wallet);
            case FACTORYOWNER:
                return new FactoryOwner(wallet, "Владелец");
            case FACTORYWORKER:
                return new FactoryWorker(wallet);
            case DELIVERYMAN:
                return new Deliveryman(wallet);
            case CHEF:
                return new Chef(wallet);
            case WAITER:
                return new Waiter(wallet);
            default:
                throw new ProfessionException("Такой Рабооты не существует");
        }
    }

    public static Profession createProfession(ProfessionsTypes type, Wallet wallet) throws ProfessionException {
        return getProfession(type, wallet);
    }
    public static Profession createProfession(ProfessionsTypes type, Wallet wallet, Inventory inventory, String name) throws ProfessionException, ProfessionNullException {
        if (type == null) throw new ProfessionNullException("ProfessionsTypes не может быть null");
        switch (type) {
            case DEALER:
                return new Dealer(wallet, inventory);
            case SALTGRINDER:
                return new SaltGrinder(wallet);
            case RESTAURATEUR:
                return new Restaurateur(wallet);
            case FACTORYOWNER:
                return new FactoryOwner(wallet, name);
            case FACTORYWORKER:
                return new FactoryWorker(wallet);
            case DELIVERYMAN:
                return new Deliveryman(wallet);
            case CHEF:
                return new Chef(wallet);
            case WAITER:
                return new Waiter(wallet);
            default:
                throw new ProfessionException("Такой Рабооты не существует");
        }
    }

}

