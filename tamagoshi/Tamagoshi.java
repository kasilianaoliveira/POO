package tamagoshi;

public class Tamagoshi {
    private int maxEnergia, maxSaciedade, maxLimpeza;
    private int energia, saciedade, limpeza;
    private int diamante;
    private int idade;
    private boolean taVivo;


    //constructor
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
        if(taVivo){
            System.out.println("Amo brincar \n");
            if(this.energia  -2 <= 0 || this.saciedade -1 <= 0 || this.limpeza -3 <=0) this.taVivo = false;
            this.energia -= 2;
            this.saciedade -= 1;
            this.limpeza -= 3;
            this.diamante ++;
            this.idade ++;

        }
    }

    public void eat(){
        if(taVivo){
            System.out.println("Huuuuum, comer é bom demais \n");
            if(this.energia  - 1 <= 0 || this.limpeza <=0) this.taVivo = false;
            this.energia --;
            this.limpeza -= 2;
            if(this.saciedade + 4 > this.maxSaciedade) this.saciedade = this.maxSaciedade;
            else this.saciedade +=4;
            this.idade ++;
        }
    }

    public void sleep(){
        if(taVivo){
            System.out.println("Hora de nanar \n");
            this.idade += this.maxEnergia - this.energia;
            this.energia = this.maxEnergia;
        }
    }

    public void clean(){
        if(taVivo){
            System.out.println("Banhooooo \n");
            if(this.energia -3 <= 0 || this.saciedade - 1 <= 0) this.taVivo = false;
            this.limpeza = this.maxLimpeza;
            this.energia -= 3;
            this.saciedade --;
            this.idade += 2;
        }
    }    

    void show() {
            System.out.println("Pet: " + 
            "E: " + this.energia + "/" + maxEnergia + ", " +
            "S: " + this.saciedade + "/" + maxSaciedade + ", " +
            "C: " + this.limpeza + "/" + maxLimpeza + ", " +
            "D: " + this.diamante + ", " + "A: " + this.idade);
    }
    

    public void death(){
        
        if(this.taVivo == false){

            if (this.energia <= 0){ 
                System.out.println("Morreu de cansaço" + " com "+this.idade+" dias de vida" + " e "+this.diamante+" diamantes");
            }else if(this.saciedade <= 0){
                System.out.println("Morreu de fome" + " com "+this.idade+" dias de vida" + " e "+this.diamante+" diamantes");
            }else if(this.limpeza <= 0){ 
                System.out.println("Morreu de sujeira" + " com "+this.idade+" dias de vida" + " e "+this.diamante+" diamantes");
            }

          
        }
    }

}
