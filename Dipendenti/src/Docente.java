public class Docente extends Dipendente{
    private int numeroOre;
    private String ruolo;
    private String disciplina;
    public Docente(int id,int anno,int mese,int giorno,String nominativo, char sesso, float stipendio,int numeroOre,String ruolo,String disciplina) {
        super(nominativo, sesso, stipendio,anno,mese,giorno);
        setNumeroOre(numeroOre);
        setRuolo(ruolo);
        setDisciplina(disciplina);
    }
    public Docente(Docente d){ //costruttore copia
        super(d.getNominativo(),d.getSesso(),d.getStipendio(),d.getDatanascita());
    }
    public Docente(){
        super();
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setNumeroOre(int numeroOre) {
        this.numeroOre = numeroOre;
    }

    public int getNumeroOre() {
        return numeroOre;
    }
    public String toString(){
        return super.toString()+"Ruolo:"+ruolo+" Disciplina:"+disciplina+" numero ore:"+numeroOre;
    }
}
