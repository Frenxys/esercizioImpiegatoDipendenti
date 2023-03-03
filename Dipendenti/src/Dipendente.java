import java.time.LocalDate;
abstract public class Dipendente {
    private String nominativo;
    private int id;
    private char sesso;
    private float stipendio;
    private LocalDate datanascita;
    public Dipendente(int id,String nominativo, char sesso, float stipendio,int anno,int mese,int giorno){
        setStipendio(stipendio);
        setNominativo(nominativo);
        setSesso(sesso);
        setDatanascita(LocalDate.of(anno,mese,giorno));
        setId(id);
    }
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
    public Dipendente(){}
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    abstract public double calcolaStipendio();
}
