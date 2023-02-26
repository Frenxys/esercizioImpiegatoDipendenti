import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static Scanner sc2=new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        Dipendenti d=new Dipendenti();
        //Impiegato giovanni=new Impiegato(1989,11,23,"giovanni",'M',1500,3,"ufficiosegreto");// 3 è il livello
        //ImpiegatoStraordinario luca=new ImpiegatoStraordinario(1980,1,3,"albe",'M',1500,3,"ufficioauguri",34); //34 sono le ore straordinarie
        //Docente sandra=new Docente(1956,3,12,"sandradocente",'F',2900,45,"ITP","tepsit"); //45 sono le ore e 2900 il mensile
        //d.rimuoviDipendente("giliberta");
        int input=0;
        do{
            System.out.println("cosa vuoi fare?:");
            System.out.println("1)stampa Docenti");
            System.out.println("2)stampa Impiegati");
            System.out.println("3)stampa ImpiegatiStraordinari");
            System.out.println("4)rimuovi Dipendente");
            System.out.println("5)stampa Dipendenti");
            System.out.println("6)aggiungi Dipendente");
            input=sc.nextInt();
            switch(input){
                case 1:d.stampaDocenti();break;
                case 2:d.stampaImpiegati();break;
                case 3:d.stampaImpiegatiplus();break;
                case 4:
                    System.out.println("inserisci nome Dipendente:");
                    d.rimuoviDipendente(sc2.nextLine());break;
                case 5:d.stampaDipendenti();break;
                case 6:
                    int input2=0;
                    System.out.println("che tipo di dipendente vuoi?");
                    System.out.println("1)Impiegato");//id,anno,mese,giorno,nominativo,sesso,stipendio,livello,ufficio
                    System.out.println("2)ImpiegatoStraordinario");//id,anno,mese,giorno,nominativo,sesso,stipendio,livello,ufficio,orestraordinarie
                    System.out.println("3)Docente");//id,anno,mese,giorno,nominativo,sesso,stipendio,numeroOre,ruolo,disciplina
                    input2=sc.nextInt();
                    switch(input2){
                        case 1:
                            Impiegato i=creaImpiegato();
                            d.addDipendente(i);
                            break;
                        case 2:
                            ImpiegatoStraordinario i1=creaImpiegatoStraordinario();
                            d.addDipendente(i1);
                            break;
                        case 3:
                            Docente d1=creaDocente();
                            d.addDipendente(d1);
                            break;
                    }
            }
        }while(input!=0);


        //d.stampaDocenti();
        //d.stampaImpiegati();
        //d.stampaImpiegatiplus();
        //d.stampaDipendenti();


    }
    public static Impiegato creaImpiegato(){//id,anno,mese,giorno,nominativo,sesso,stipendio,livello,ufficio
        System.out.println("inserisci anno nascita");
        int anno=sc.nextInt();
        System.out.println("inserisci mese nascita");
        int mese=sc.nextInt();
        System.out.println("inserisci giorno nascita");
        int giorno=sc.nextInt();
        System.out.println("inserisci nominativo");
        String nominativo=sc2.nextLine();
        System.out.println("inserisci sesso M/F");
        char sesso=sc2.nextLine().charAt(0);
        System.out.println("inserisci stipendio");
        float stipendio=sc.nextFloat();
        System.out.println("inserisci livello");
        int livello=sc.nextInt();
        System.out.println("inserisci ufficio");
        String ufficio=sc2.nextLine();
        return new Impiegato(anno,mese,giorno,nominativo,sesso,stipendio,livello,ufficio);

    }
    public static Docente creaDocente(){//id,anno,mese,giorno,nominativo,sesso,stipendio,numeroOre,ruolo,disciplina
        System.out.println("inserisci anno nascita");
        int anno=sc.nextInt();
        System.out.println("inserisci mese nascita");
        int mese=sc.nextInt();
        System.out.println("inserisci giorno nascita");
        int giorno=sc.nextInt();
        System.out.println("inserisci nominativo");
        String nominativo=sc2.nextLine();
        System.out.println("inserisci sesso M/F");
        char sesso=sc2.nextLine().charAt(0);
        System.out.println("inserisci stipendio");
        float stipendio=sc.nextFloat();
        System.out.println("inserisci numero di ore");
        int numeroOre=sc.nextInt();
        System.out.println("inserisci ruolo");
        String ruolo=sc2.nextLine();
        System.out.println("inserisci disciplina");
        String disciplina=sc2.nextLine();
        return new Docente(anno,mese,giorno,nominativo,sesso,stipendio,numeroOre,ruolo,disciplina);
    }
    public static ImpiegatoStraordinario creaImpiegatoStraordinario(){//id,anno,mese,giorno,nominativo,sesso,stipendio,livello,ufficio,orestraordinarie
        System.out.println("inserisci anno nascita");
        int anno=sc.nextInt();
        System.out.println("inserisci mese nascita");
        int mese=sc.nextInt();
        System.out.println("inserisci giorno nascita");
        int giorno=sc.nextInt();
        System.out.println("inserisci nominativo");
        String nominativo=sc2.nextLine();
        System.out.println("inserisci sesso M/F");
        char sesso=sc2.nextLine().charAt(0);
        System.out.println("inserisci stipendio");
        float stipendio=sc.nextFloat();
        System.out.println("inserisci livello");
        int livello=sc.nextInt();
        System.out.println("inserisci ufficio");
        String ufficio=sc2.nextLine();
        System.out.println("inserisci ore extra");
        int orextra=sc.nextInt();
        return new ImpiegatoStraordinario(anno,mese,giorno,nominativo,sesso,stipendio,livello,ufficio,orextra);

    }
}