import java.time.LocalDate;

public class Impiegato extends Dipendente{
    private int livello;
    private String ufficio;
    public Impiegato(int anno,int mese,int ore,String nominativo, char sesso, float stipendio,int livello,String ufficio) {
        super(nominativo, sesso, stipendio,anno,mese,ore);
        setLivello(livello);
        setUfficio(ufficio);
    }
    public Impiegato(Impiegato i){
        super(i.getNominativo(),i.getSesso(),i.getStipendio(),i.getDatanascita());
        setLivello(i.getLivello());
        setUfficio(i.getUfficio());
    }
    public Impiegato(String nominativo, char sesso, float stipendio, int livello, String ufficio, LocalDate datanascita){
        super(nominativo,sesso,stipendio,datanascita);
        setLivello(livello);
        setUfficio(ufficio);
    }
    public Impiegato(){
        super();

    }

    public String getUfficio() {
        return ufficio;
    }

    public void setUfficio(String ufficio) {
        this.ufficio = ufficio;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }
    public String toString(){
        return super.toString()+"livello:"+livello+" ufficio:"+ufficio;
    }
}
