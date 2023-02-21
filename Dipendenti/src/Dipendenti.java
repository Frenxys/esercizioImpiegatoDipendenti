import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Dipendenti {
    private Dipendente[] array;
    private int numerodipendenti=0;
    public Dipendenti() throws IOException {
        array=new Dipendente[100];
        leggiDocenti();
        leggiImpiegati();
        leggiImpiegati2();
    }
    public void addDipendente(Dipendente a){
        array[numerodipendenti]=a;
        numerodipendenti++;
    }
    public void stampaDipendenti(){
        System.out.println("DIPENDENTI:");
        for(int i=0; i<numerodipendenti; i++){
            System.out.println(array[i].getNominativo());
        }
    }
    public void rimuoviDipendente(String nome){
        for(int i=0; i<numerodipendenti; i++){
            if(array[i].getNominativo().equals(nome)){
                array[i]=null;
                numerodipendenti--;
                pushArray(i); //shift
                break;
            }
        }
    }
    public void pushArray(int pos){ //sposta l'array a sinistra di 1
        for(int i=pos; i<numerodipendenti; i++){
            if(Dipendente.isDocente(array[i+1])){
                array[i]=new Docente((Docente) array[i+1]);
            }
            else if(Dipendente.isImpiegato(array[i+1])){
                array[i]=new Impiegato((Impiegato) array[i+1]);
            }
            else if(Dipendente.isImpiegatoplus(array[i+1])){
                array[i]=new ImpiegatoStraordinario((ImpiegatoStraordinario) array[i+1]);
            }
        }
    }

    public void stampaImpiegati(){
        System.out.println("IMPIEGATI:");
        for(int i=0; i<numerodipendenti; i++){
            if(Dipendente.isImpiegato(array[i])){
                System.out.println(array[i].getNominativo()+" "+array[i].getStipendio());
            }
        }
    }
    public void stampaImpiegatiplus(){
        System.out.println("IMPIEGATISTRAORDINARI:");
        for(int i=0; i<numerodipendenti; i++){
            if(Dipendente.isImpiegatoplus(array[i])){
                System.out.println(array[i].getNominativo()+" "+array[i].getStipendio());
            }
        }
    }
    public void stampaDocenti(){
        System.out.println("DOCENTI:");
        for(int i=0; i<numerodipendenti; i++){
            if(Dipendente.isDocente(array[i])){
                System.out.println(array[i].getNominativo()+" "+array[i].getStipendio());
            }
        }
    }
    public void leggiImpiegati()throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader("Impiegati.csv"));
        String linea;
        while((linea=reader.readLine())!=null){
            String[] linee=linea.split(";");
            String[] linee2=linee[1].split("/");
            Impiegato i=new Impiegato(
                            parseInt(linee[0]),
                            parseInt(linee2[0]),
                            parseInt(linee2[1]),
                            parseInt(linee2[2]),
                            linee[2],
                            linee[3].charAt(0),
                            parseFloat(linee[4]),
                            parseInt(linee[5]),
                            linee[6]);
            addDipendente(i);
        }
    }
    public void leggiImpiegati2()throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader("ImpiegatiStraordinari.csv"));
        String linea;
        while((linea=reader.readLine())!=null){
            String[] linee=linea.split(";");
            String[] linee2=linee[1].split("/");
            ImpiegatoStraordinario i=new ImpiegatoStraordinario(
                    parseInt(linee[0]),
                    parseInt(linee2[0]),
                    parseInt(linee2[1]),
                    parseInt(linee2[2]),
                    linee[2],
                    linee[3].charAt(0),
                    parseFloat(linee[4]),
                    parseInt(linee[5]),
                    linee[6],
                    parseInt(linee[7]));
            addDipendente(i);
        }
    }
    public void leggiDocenti()throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader("Docenti.csv"));
        String linea;
        while((linea=reader.readLine())!=null){
            String[] linee=linea.split(";");
            String[] linee2=linee[1].split("/");
            Docente d=new Docente(
                    parseInt(linee[0]),
                    parseInt(linee2[0]),
                    parseInt(linee2[1]),
                    parseInt(linee2[2]),
                    linee[2],
                    linee[3].charAt(0),
                    parseFloat(linee[4]),
                    parseInt(linee[5]),
                    linee[6],
                    linee[7]);
            addDipendente(d);
        }
    }
}
