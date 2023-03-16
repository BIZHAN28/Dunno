package Items;

public class SaltMachineTool extends Item{
    String name;
    public SaltMachineTool(String name, int cost){
        super(name, cost);
        this.name = name;
    }
    private class Mortar{
        public void crush(){
            System.out.println("соль добыта с использовнием " + name);
        }
    }
    public static class Cover{
        public void open(){
            System.out.println("Крышка открыта");
        }

        public void close() {
            System.out.println("Крышка закрыта");
        }
    }
    public void crush(Salt salt){
        Mortar mortar = new Mortar();
        mortar.crush();
        salt.setRaw(false);
    }
}
