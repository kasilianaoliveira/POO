package cine;

import java.util.ArrayList;
import java.util.Scanner;


class Cliente{
    String id;
    private String fone;

    public Cliente(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String toString() {
        return this.id + ":" + this.fone;
    }
}

class Sala {

    ArrayList<Cliente> cadeiras;
    int capacidade;

    public Sala(int capacidade) {
        cadeiras = new ArrayList<Cliente>();
        for (int i = 0; i < capacidade; i++) {
            cadeiras.add(null);
        this.capacidade = capacidade;
        }
    }

    public void reservar(String id, String fone, int posicao) {
        if(posicao >= capacidade || posicao < 0) {
			System.out.println("invalid position");
			return;
		}
		if(cadeiras.get(posicao) != null) {
			System.out.println("failure: cadeira ja esta ocupada");
			return;
		}
		for(Cliente different : cadeiras) {
			if(different!= null && id.equals(different.getId())) {
				System.out.println("failure: cliente ja esta no cinema");
				return;
			}
        }
        Cliente client = new Cliente(id, fone);
		cadeiras.set(posicao, client);
    }

    void cancelar(String id) {
        for (int i = 0; i < this.cadeiras.size(); i++) {
            Cliente cliente = this.cadeiras.get(i);
            if ((cliente != null) && (cliente.id.equals(id))) {
                this.cadeiras.set(i, null);
                return;
            }
        }System.out.println("failure: cliente nao esta no cinema");
    }
    
    public String toString() {
		String exit = "[ ";
		for(Cliente cliente : this.cadeiras) {
			if(cliente != null)
				exit += cliente + " ";
			else
				exit += "- ";
		}
		exit += "]";
		return exit;
	}
    
}


public class Main {
    public static void main(String[] args) {

        Sala sala = new Sala(0);

        Scanner scanner = new Scanner(System.in);
        
        
        while (true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            
            if (ui[0].equals("end")) {
                break;
            }else if (ui[0].equals("init")) {
                sala = new Sala(Integer.parseInt(ui[1])); 
            }else if (ui[0].equals("show")) {
                System.out.println(sala.toString());
            }else if (ui[0].equals("reservar")) {
                sala.reservar(ui[1],ui[2], Integer.parseInt(ui[3]));
            }else if(ui[0].equals("cancelar")){
                sala.cancelar(ui[1]);
            }else{
                System.out.println("Invalid command");
            }  
        }

        scanner.close();

    }
}