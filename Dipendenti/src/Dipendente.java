abstract public class Dipendente {
    private String nominativo;
    private char sesso;
    private String indirizzo;
    public Dipendente(String nominativo,char sesso,String indirizzo){
        setNominativo(nominativo);
        setSesso(sesso);
        setIndirizzo(indirizzo);
    }
    public Dipendente(){

    }
    public boolean isDocente(Dipendente d){
        if(this.getClass()==d.getClass()){
            return true;
        }
        return false;
    }
    public boolean isImpiegato(Dipendente a){
        if(this.getClass()==a.getClass()){
            return true;
        }
        return false;
    }

    public String getNominativo() {
        return nominativo;
    }

    public char getSesso() {
        return sesso;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }
}
