package bioSyntheseInheritanceUse;

//est un Strand
public class Dna extends Strand {
    //a un milieu
    public Dna(){
        this.setType("Dna");
    }

    public Dna(String seqSymbol){
        super(seqSymbol,"Dna");

    }

    public Strand getComplStrand(){
        Strand strand=new Dna();
        for(int i=0;i<this.getNucleoAcideList().size();i++) {
            strand.getNucleoAcideList().add(this.getNucleoAcideList().get(i).compl());
        }
        return strand;
    }

}
