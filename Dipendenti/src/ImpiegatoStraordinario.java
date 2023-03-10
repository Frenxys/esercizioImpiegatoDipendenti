public class ImpiegatoStraordinario extends Impiegato{
    private int ore;
    private static int pagamentoorario=10;
    public ImpiegatoStraordinario(int anno, int mese, int giorno, String nominativo, char sesso, float stipendio, int livello, String ufficio, int orestraordinarie){
        super(anno,mese,giorno,nominativo, sesso, stipendio,livello,ufficio);
        setOre(orestraordinarie);
    }
    public ImpiegatoStraordinario(){
        super();
    }
    public ImpiegatoStraordinario(ImpiegatoStraordinario i){
        super(i.getNominativo(),i.getSesso(),i.getStipendio(),i.getLivello(),i.getUfficio(),i.getDatanascita());
        setOre(i.getOre());
    }

    @Override
    public double calcolaStipendio() {
        return super.getStipendio()+(ore*pagamentoorario);
    }

    public float getStipendio(){
        return super.getStipendio()+(ore*pagamentoorario);
    }
    public int getPagamentoorario() {
        return pagamentoorario;
    }

    public int getOre() {
        return ore;
    }

    public void setPagamentoorario(int pagamentoorario) {
        this.pagamentoorario = pagamentoorario;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }
}
