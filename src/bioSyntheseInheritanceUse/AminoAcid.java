package bioSyntheseInheritanceUse;

public class AminoAcid {

    private String name;
    private String symbol;
    private String formule;
    private String trigram;

    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public AminoAcid(){

    }

    public AminoAcid(String symbol,String trigram){
        this.symbol=symbol;
        this.name=Ribosome.getAminoName(symbol);
        this.trigram = trigram;
    }

    @Override
    public String toString() {
        return getSymbol()+"("+getTrigram()+")";
    }


    public String getTrigram() {
        return trigram;
    }
}
