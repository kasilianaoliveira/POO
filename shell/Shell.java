package shell;

import java.util.Scanner;

public class Shell {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float num = 0.0F;
        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);

            
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("show")) {
                System.out.printf("%.2f\n", num);

            } else if (ui[0].equals("add")) {
                num += Float.parseFloat(ui[1]);
               
            } else if (ui[0].equals("mult")) {
                num *= Float.parseFloat(ui[1]);

            } else if (ui[0].equals("div")) {
                float numer = Float.parseFloat(ui[1]);
                if(numer == 0.0F){
                    System.out.println("fail: division by zero"); 
                }else{
                    num /= numer;
                }
            } else if (ui[0].equals("addm")) {
                for(int i = 1; i<ui.length; i++)
                    num += Float.parseFloat(ui[i]);
            } else {
                System.out.println("Comando invalido");
            }
        }

        scanner.close();
    }
    
}