import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Dipendenti d=new Dipendenti();
        Impiegato giovanni=new Impiegato("giovanni",'M',"viaverdi","nomeufficio");
        Impiegato giovannino=new Impiegato("giovannino",'M',"viaverdi","nomeufficio");
        Docente folli=new Docente("daniele",'M',"viaantonio","profteoria","tepsit");
        Docente memoli=new Docente("christian",'M',"vianverdi","no","informatica");
        Docente groppi=new Docente("enrica",'F',"vianazionale","ITP","informatica");
        d.addDipendente(giovanni);
        d.addDipendente(giovannino);
        d.addDipendente(memoli);
        d.addDipendente(folli);
        d.addDipendente(groppi);
        d.stampaDipendenti();
        System.out.println("inserisci nome di chi vuoi modificare?");
        String nome=sc.nextLine();
        System.out.println("con che indirizzo?");
        String indirizzo=sc.nextLine();
        d.cambiaIndirizzoNome(nome,indirizzo);
        System.out.println("chi vuoi eliminare?");
        String nomeelimina=sc.nextLine();
        d.rimuoviDipendente(nomeelimina);
        d.stampaDocenti();
        d.stampaImpiegati();
        d.stampaDipendenti();


    }
}