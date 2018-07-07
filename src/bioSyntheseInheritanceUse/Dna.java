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


    public Rna transcriptioh(){
        Rna rna=new Rna();
        for(Base elem:this.getNucleoAcideList()){
            if(elem.isThymine()){
                rna.getNucleoAcideList().add(new Base("U"));
            }
            else{
                rna.getNucleoAcideList().add(elem);
            }
        }
        return rna;
    }

    public Strand getComplStrand(){
        Strand strand=new Strand();
        for(int i=0;i<this.getNucleoAcideList().size();i++) {
            strand.getNucleoAcideList().add(this.getNucleoAcideList().get(i).compl());
        }
        return strand;
    }

}
