import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Dipendenti d=new Dipendenti();
        Impiegato giovanni=new Impiegato(1989,11,23,"giovanni",'M',1500,3,"ufficiosegreto");// 3 è il livello
        ImpiegatoStraordinario luca=new ImpiegatoStraordinario(1980,1,3,"albe",'M',1500,3,"ufficioauguri",34); //34 sono le ore straordinarie
        Docente sandra=new Docente(1956,3,12,"sandradocente",'F',2900,45,"ITP","tepsit"); //45 sono le ore e 2900 il mensile
        d.addDipendente(giovanni);
        d.addDipendente(luca);
        d.addDipendente(sandra);

        d.stampaDocenti();
        d.stampaImpiegati();
        d.stampaImpiegatiplus();

        //d.stampaDipendenti();


    }
}