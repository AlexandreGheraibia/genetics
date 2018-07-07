package bioSyntheseInheritanceUse;

public class Enzyme {

    public Enzyme(){

    }

    public Rna transcriptioh(Dna dna){
        Rna rna=new Rna();
        for(Base elem:dna.getNucleoAcideList()){
            if(elem.isThymine()){
                rna.getNucleoAcideList().add(new Base("U"));
            }
            else{
                rna.getNucleoAcideList().add(elem);
            }
        }
        return rna;
    }
}
