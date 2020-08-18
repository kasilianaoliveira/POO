package tamagoshiPoo;

import java.util.Scanner;


class Tamagoshi {
    private int maxEnergia, maxSaciedade, maxLimpeza;
    private int energia, saciedade, limpeza;
    private int diamante;
    private int idade;
    private boolean taVivo;

    public Tamagoshi(int maxEnergia, int maxSaciedade, int maxLimpeza){
        this.maxEnergia = maxEnergia;
        this.maxSaciedade = maxSaciedade;
        this.maxLimpeza = maxLimpeza;
        this.energia = maxEnergia;
        this.saciedade = maxSaciedade;
        this.limpeza = maxLimpeza;
        this.diamante = 0;
        this.idade = 0;
        this.taVivo = true;
    }
  
    //get

    public boolean getIsAlive(){
        return taVivo;
    }
    public void play(){
        this.energia -= 2;
        this.saciedade -= 1;
        this.limpeza -= 3;
        this.diamante ++;
        this.idade ++;
        death();

    }

    public void eat(){
        this.energia -=1;
        this.limpeza -= 2;
            if(this.saciedade + 4 > this.maxSaciedade){ 
                this.saciedade = this.maxSaciedade;
            }else{
                this.saciedade +=4;
            }
        this.idade ++;
        death();
    }

    public void sleep(){
        if(this.energia > maxEnergia - 5){
            System.out.println("fail: nao esta com sono");
            
        }else{
            this.idade += this.maxEnergia - this.energia;
            this.energia = this.maxEnergia;
            this.saciedade --;

        }
    }

    
    public void clean() {

      this.limpeza = maxLimpeza;
      this.energia -= 3;
      this.saciedade -= 1;
      this.idade += 2;
      death();
  }   
    public void death(){

        if(energia <= 0){
            System.out.println("fail: pet morreu de fraqueza");
            energia = 0;
        }
        if(saciedade > maxSaciedade){
            saciedade = maxSaciedade;
        }else if(saciedade <= 0){
          System.out.println("fail: pet morreu de fome");
          saciedade = 0;
        }
        if(limpeza >maxLimpeza){
          limpeza = maxLimpeza;
        }else if(limpeza <= 0){
            System.out.println("fail: pet morreu de sujeira");
            limpeza = 0;
        }
    }
    public boolean verificarVida() {
        if (energia <= 0 || saciedade <= 0 || limpeza <= 0) {
            taVivo = false;
        }
            if (taVivo == false) {
                System.out.println("fail: pet esta morto");
                return false;
            }
        return true;
  }


  public String toString() {
        return ("E:" + this.energia + "/" + maxEnergia + ", " +
        "S:" + this.saciedade + "/" + maxSaciedade + ", " +
        "L:" + this.limpeza + "/" + maxLimpeza + ", " +
        "D:" + this.diamante + ", " + "I:" + this.idade);     
    }
}
public class Tamagotchi{
    public static void main(String[] args) {        
        Tamagoshi tamagoshi = new Tamagoshi(0, 0, 0);
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            
            if (ui[0].equals("end")) {
                break;

            }else if (ui[0].equals("init")) {
               tamagoshi = new Tamagoshi(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]));
            }else if (ui[0].equals("show")) {
                System.out.println(tamagoshi.toString());
            }else if (ui[0].equals("play")) {
                if(tamagoshi.verificarVida()) {
                    tamagoshi.play();
                }
            }else if(ui[0].equals("eat")){
                if(tamagoshi.verificarVida()) {
                    tamagoshi.eat();
                }
            }else if(ui[0].equals("sleep")){
                if(tamagoshi.verificarVida()) {
                    tamagoshi.sleep();
                }
            }else if(ui[0].equals("clean")){
                if(tamagoshi.verificarVida()) {
                    tamagoshi.clean();
                }

            }else{
                System.out.println("Invalid command");
            }  
        }

        scanner.close();

    }
    
}