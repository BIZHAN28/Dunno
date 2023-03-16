package Professions;

import Items.Salt;
import Items.SaltMachineTool;
import Items.Wallet;

public class FactoryWorker extends Profession{
    public FactoryWorker(Wallet wallet) {
        super(ProfessionsTypes.FACTORYWORKER, wallet);
    }
    public void work(SaltMachineTool saltMachineTool, Salt salt){
        System.out.println("Рабочий приступил за работу");
        SaltMachineTool.Cover cover = new SaltMachineTool.Cover();
        cover.open();
        saltMachineTool.crush(salt);
        cover.close();
        System.out.println("Рабочий окончил работу");
    }
}
