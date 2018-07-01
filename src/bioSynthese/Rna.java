package bioSynthese;

import java.util.ArrayList;

//est un Strand
public class Rna extends Strand {
    //a un milieu

    public Rna(){
        this.setType("Rna");

    }
    public Rna(String seqSymbol){
        super(seqSymbol,"Rna");

    }
    public Rna(ArrayList<Base> seqBaseList){
        super(seqBaseList,"Rna");
    }

    public void traduction(){
        int tripletNB=this.getNucleoAcideList().size()/3;
        Base[] codon=new Base[3];

        for(int i=0;i<tripletNB;i++){
            codon[0]=this.getNucleoAcideList().get(i*3);
            codon[1]=this.getNucleoAcideList().get(i*3+1);
            codon[2]=this.getNucleoAcideList().get(i*3+2);
            this.aminoAcidGeneration(codon);
        }

    }
     private AminoAcid aminoAcidGeneration(Base[] codon){
        return new AminoAcid();
     }

}
