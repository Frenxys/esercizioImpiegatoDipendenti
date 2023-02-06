public class Impiegato extends Dipendente{
    private String ufficio;
    public Impiegato(String nominativo, char sesso, String indirizzo,String ufficio) {
        super(nominativo, sesso, indirizzo);
        setUfficio(ufficio);
    }
    public Impiegato(Impiegato i){
        super(i.getNominativo(),i.getSesso(),i.getIndirizzo());
        setUfficio(i.getUfficio());
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
}
