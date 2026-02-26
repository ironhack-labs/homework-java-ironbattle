import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random r=new Random();

        Warrior p1=new Warrior("Warrior1",r.nextInt(101)+100,r.nextInt(41)+10,r.nextInt(10)+1);
        Wizard p2=new Wizard("Wizard1",r.nextInt(51)+50,r.nextInt(41)+10,r.nextInt(50)+1);

        System.out.println("BATTLE START: "+p1.getName()+" vs "+p2.getName());

        while(p1.isAlive()&&p2.isAlive()){
            System.out.println("\n--- Round ---");
            p1.attack(p2);
            p2.attack(p1);
            System.out.println(p1.getName()+" HP:"+p1.getHp()+" | "+p2.getName()+" HP:"+p2.getHp());
        }

        if(!p1.isAlive()&&!p2.isAlive()){
            System.out.println("\nTIE! Restarting battle...");
        }else{
            String winner=p1.isAlive()?p1.getName():p2.getName();
            System.out.println("\nWINNER: "+winner);
        }
    }
}
