import java.io.*;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Dipendenti {
    private Dipendente[] array;
    private int numerodipendenti=0;
    private int numeroImpiegati=0;
    private int numeroDocenti=0;
    private int numeroImpiegatiStraordinari=0;
    public Dipendenti() throws IOException {
        array=new Dipendente[100];
        leggiDocenti();
        leggiImpiegati();
        leggiImpiegati2();
    }
    public void addDipendente(Dipendente a) throws IOException {
        if(a instanceof Impiegato && !(a instanceof ImpiegatoStraordinario)){
            numeroImpiegati++;
            a.setId(numeroImpiegati);
        }else if(a instanceof Docente){
            numeroDocenti++;
            a.setId(numeroDocenti);
        }else if(a instanceof ImpiegatoStraordinario){
            numeroImpiegatiStraordinari++;
            a.setId(numeroImpiegatiStraordinari);
        }
        array[numerodipendenti]=a;
        numerodipendenti++;
        scriviImpiegati();
        scriviDocenti();
        scriviImpiegatiStraordinari();

    }
    public void stampaDipendenti(){
        System.out.println("DIPENDENTI:");
        for(int i=0; i<numerodipendenti; i++){
            System.out.println(array[i].getNominativo()+" stipendio:"+array[i].calcolaStipendio());
        }
    }
    public void scriviImpiegatiStraordinari()throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter("ImpiegatiStraordinari.csv"));
        int numeroImpiegatiStraordinari=0;
        for(int i=0; i<numerodipendenti; i++){
            if(array[i] instanceof ImpiegatoStraordinario){
                writer.write(numeroImpiegatiStraordinari +";"+
                        array[i].getDatanascita().getYear()+"/"+
                        array[i].getDatanascita().getMonthValue()+"/"+
                        array[i].getDatanascita().getDayOfMonth()+";"+
                        array[i].getNominativo()+";"+
                        array[i].getSesso()+";"+
                        array[i].getStipendio()+";"+
                        ((ImpiegatoStraordinario) array[i]).getLivello()+";"+
                        ((ImpiegatoStraordinario) array[i]).getUfficio()+";"+
                        ((ImpiegatoStraordinario) array[i]).getOre());
                numeroImpiegatiStraordinari++;
                writer.newLine();
            }
        }
        writer.close();
    }
    public void scriviDocenti()throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter("Docenti.csv"));
        int numeroDocenti=0;
        for(int i=0; i<numerodipendenti; i++){
            if(array[i] instanceof Docente){
                writer.write(numeroDocenti +";"+
                        array[i].getDatanascita().getYear()+"/"+
                        array[i].getDatanascita().getMonthValue()+"/"+
                        array[i].getDatanascita().getDayOfMonth()+";"+
                        array[i].getNominativo()+";"+
                        array[i].getSesso()+";"+
                        array[i].getStipendio()+";"+
                        ((Docente) array[i]).getNumeroOre()+";"+
                        ((Docente) array[i]).getRuolo()+";"+
                        ((Docente) array[i]).getDisciplina());
                numeroDocenti++;
                writer.newLine();
            }
        }
        writer.close();
    }
    public void scriviImpiegati()throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter("Impiegati.csv"));
        int numeroImpiegati=0;
        for(int i=0; i<numerodipendenti; i++){
            if(array[i] instanceof Impiegato && !(array[i] instanceof ImpiegatoStraordinario)){
                writer.write(numeroImpiegati +";"+
                        array[i].getDatanascita().getYear()+"/"+
                        array[i].getDatanascita().getMonthValue()+"/"+
                        array[i].getDatanascita().getDayOfMonth()+";"+
                        array[i].getNominativo()+";"+
                        array[i].getSesso()+";"+
                        array[i].getStipendio()+";"+
                        ((Impiegato) array[i]).getLivello()+";"+
                        ((Impiegato) array[i]).getUfficio());
                numeroImpiegati++;
                writer.newLine();
            }

        }
        writer.close();
    }
    public void rimuoviDipendente(String nome){
        for(int i=0; i<numerodipendenti; i++){
            if(array[i].getNominativo().equals(nome)){
                if(array[i] instanceof Impiegato && !(array[i] instanceof ImpiegatoStraordinario)){
                    numeroImpiegati--;
                }else if(array[i] instanceof Docente){
                    numeroDocenti--;
                }else if(array[i] instanceof ImpiegatoStraordinario){
                    numeroImpiegatiStraordinari--;
                }
                array[i]=null;
                numerodipendenti--;
                pushArray(i); //shift
                break;
            }
        }
    }
    public void pushArray(int pos){ //sposta l'array a sinistra di 1
        for(int i=pos; i<numerodipendenti; i++){
            if(array[i] instanceof Docente){
                array[i]=new Docente((Docente) array[i+1]);
            }
            else if(array[i] instanceof Impiegato && !(array[i] instanceof ImpiegatoStraordinario)){
                array[i]=new Impiegato((Impiegato) array[i+1]);
            }
            else if(array[i] instanceof ImpiegatoStraordinario){
                array[i]=new ImpiegatoStraordinario((ImpiegatoStraordinario) array[i+1]);
            }
        }
    }

    public void stampaImpiegati(){
        System.out.println("IMPIEGATI:");
        for(int i=0; i<numerodipendenti; i++){
            if(array[i] instanceof Impiegato && !(array[i] instanceof ImpiegatoStraordinario)){
                System.out.println(array[i].getNominativo()+" "+array[i].getStipendio());
            }
        }
    }
    public void stampaImpiegatiplus(){
        System.out.println("IMPIEGATISTRAORDINARI:");
        for(int i=0; i<numerodipendenti; i++){
            if(array[i] instanceof Impiegato && array[i] instanceof ImpiegatoStraordinario){
                System.out.println(array[i].getNominativo()+" "+array[i].getStipendio());
            }
        }
    }
    public void stampaDocenti(){
        System.out.println("DOCENTI:");
        for(int i=0; i<numerodipendenti; i++){
            if(array[i] instanceof Docente){
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
                            //parseInt(linee[0]),
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
        reader.close();
    }
    public void leggiImpiegati2()throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader("ImpiegatiStraordinari.csv"));
        String linea;
        while((linea=reader.readLine())!=null){
            String[] linee=linea.split(";");
            String[] linee2=linee[1].split("/");
            ImpiegatoStraordinario i=new ImpiegatoStraordinario(
                    //parseInt(linee[0]),
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
        }reader.close();
    }
    public void leggiDocenti()throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader("Docenti.csv"));
        String linea;
        while((linea=reader.readLine())!=null){
            String[] linee=linea.split(";");
            String[] linee2=linee[1].split("/");
            Docente d=new Docente(
                    //parseInt(linee[0]),
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
        reader.close();
    }
}
