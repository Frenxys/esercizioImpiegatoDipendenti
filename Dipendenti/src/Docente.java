public class Docente extends Dipendente{
    private String ruolo;
    private String disciplina;
    public Docente(String nominativo, char sesso, String indirizzo,String ruolo,String disciplina) {
        super(nominativo, sesso, indirizzo);
        setRuolo(ruolo);
        setDisciplina(disciplina);
    }
    public Docente(Docente d){
        super(d.getNominativo(),d.getSesso(),d.getIndirizzo());
        setRuolo(d.getRuolo());
        setDisciplina(d.getDisciplina());
    }
    public Docente(){
        super();
    }


    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public String getDisciplina() {
        return disciplina;
    }
}
