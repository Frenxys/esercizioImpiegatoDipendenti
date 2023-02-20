import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Dipendenti d=new Dipendenti();
        //Impiegato giovanni=new Impiegato(1989,11,23,"giovanni",'M',1500,3,"ufficiosegreto");// 3 è il livello
        //ImpiegatoStraordinario luca=new ImpiegatoStraordinario(1980,1,3,"albe",'M',1500,3,"ufficioauguri",34); //34 sono le ore straordinarie
        //Docente sandra=new Docente(1956,3,12,"sandradocente",'F',2900,45,"ITP","tepsit"); //45 sono le ore e 2900 il mensile
        //d.rimuoviDipendente("giliberta");
        int input=0;
        d.leggiDocenti();
        d.leggiImpiegati();
        d.leggiImpiegati2();
        do{
            System.out.println("cosa vuoi fare?:");
            System.out.println("1)stampa Docenti");
            System.out.println("2)stampa Impiegati");
            System.out.println("3)stampa ImpiegatiStraordinari");
            System.out.println("4)rimuovi Dipendente");
            System.out.println("5)stampa Dipendenti");
            input=sc.nextInt();
            switch(input){
                case 1: d.stampaDocenti();
                case 2:d.stampaImpiegati();
                case 3:d.stampaImpiegatiplus();
                case 4:
                    System.out.println("inserisci nome Dipendente:");
                    d.rimuoviDipendente(sc.nextLine());
                case 5:d.stampaDipendenti();
            }
        }while(input!=0);


        //d.stampaDocenti();
        //d.stampaImpiegati();
        //d.stampaImpiegatiplus();
        //d.stampaDipendenti();


    }
}