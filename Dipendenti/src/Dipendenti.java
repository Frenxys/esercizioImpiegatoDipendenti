public class Dipendenti {
    private Dipendente[] array;
    private int numerodipendenti=0;
    public Dipendenti(){
        array=new Dipendente[100];
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
    public void cambiaIndirizzoNome(String nome, String indirizzo){
        for(int i=0; i<numerodipendenti; i++){
            if(nome.equals(array[i].getNominativo())){
                array[i].setIndirizzo(indirizzo);
            }
        }
    }
    public void rimuoviDipendente(String nome){
        for(int i=0; i<numerodipendenti; i++){
            if(array[i].getNominativo().equals(nome)){
                array[i]=null;
                numerodipendenti--;
                pushArray(i);
                break;
            }
        }
    }
    public void pushArray(int pos){ //sposta l'array a sinistra di 1
            for(int i=pos; i<numerodipendenti; i++){
                if(array[i+1].isDocente(array[i+1])){
                    array[i]=new Docente((Docente) array[i+1]);
                }
                else if(array[i+1].isImpiegato(array[i+1])){
                    array[i]=new Impiegato((Impiegato) array[i+1]);
                }

            }
    }

    public void stampaImpiegati(){
        System.out.println("IMPIEGATI:");
        for(int i=0; i<numerodipendenti; i++){
            Impiegato impiegato=new Impiegato();
            if(impiegato.isImpiegato(array[i])){
                System.out.println(array[i].getNominativo());

            }
        }
    }
    public void stampaDocenti(){
        System.out.println("DOCENTI:");
        for(int i=0; i<numerodipendenti; i++){
            Docente d=new Docente();
            if(d.isDocente(array[i])){
                System.out.println(array[i].getNominativo());
            }
        }
    }
}
