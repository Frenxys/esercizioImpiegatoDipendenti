import java.time.LocalDate;

abstract public class Dipendente {
    private String nominativo;
    private char sesso;
    private float stipendio;
    private LocalDate datanascita;
    public Dipendente(String nominativo, char sesso, float stipendio,int anno,int mese,int giorno){
        setStipendio(stipendio);
        setNominativo(nominativo);
        setSesso(sesso);
        setDatanascita(LocalDate.of(anno,mese,giorno));
    }
    public Dipendente(String nominativo,char sesso,float stipendio,LocalDate datanascita){
        setStipendio(stipendio);
        setNominativo(nominativo);
        setSesso(sesso);
        setDatanascita(datanascita);
    }
    public Dipendente(){

    }

    public void setDatanascita(LocalDate datanascita) {
        this.datanascita = datanascita;
    }

    public LocalDate getDatanascita() {
        return datanascita;
    }

    public float getStipendio() {
        return stipendio;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }

    public static boolean isDocente(Dipendente d){
        Docente a=new Docente();
        if(a.getClass()==d.getClass()){
            return true;
        }
        return false;
    }
    public static boolean isImpiegato(Dipendente a){
        Impiegato b=new Impiegato();
        if(b.getClass()==a.getClass()){
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

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }


    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public static boolean isImpiegatoplus(Dipendente a) {
        ImpiegatoStraordinario i=new ImpiegatoStraordinario();
        if(a.getClass()==i.getClass()){
            return true;
        }
        return false;
    }
}
