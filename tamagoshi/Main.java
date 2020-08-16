package tamagoshi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {        
        System.out.println("#######################");
        System.out.println("Welcome to Tamagoshi");
        System.out.println("####################### \n");
        System.out.println("Your options are:");
        System.out.println("show -> shows your pet's initial state");
        System.out.println("play -> you play => -2 energy, -1 satiety, -3 cleanliness, +1 diamond, +1 age");
        System.out.println("eat -> eating => -1 energy, +4 satiety, -2 cleaning, +0 diamond, +2 age");
        System.out.println("sleep -> increases energy and age");
        System.out.println("clean -> -3 energy, -1 satiety, MAX in cleaning, +0 diamonds, +2 in age.\n");

        Tamagoshi tamagoshi = new Tamagoshi(20,10,15);
        Scanner scanner = new Scanner(System.in);

        while (tamagoshi.getTaVivo()) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            
            if (ui[0].equals("end")) {
                break;
            }else if (ui[0].equals("show")) {
                tamagoshi.show();
            }else if (ui[0].equals("play")) {
                tamagoshi.play();
            }else if(ui[0].equals("eat")){
                tamagoshi.eat();
            }else if(ui[0].equals("sleep")){
                tamagoshi.sleep();
            }else if(ui[0].equals("clean")){
                tamagoshi.clean();

            }else{
                System.out.println("Invalid command");
            }  
        }
        tamagoshi.death();

        scanner.close();

    }
}