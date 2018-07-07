package bioSyntheseInheritanceUse;

import java.util.ArrayList;
import java.util.HashMap;

//est un Strand
public class Rna extends Strand {

    public Rna(){
        this.setType("Rna");

    }
   public Rna(String seqSymbol){
        super(seqSymbol,"Rna");
    }
    public Rna(ArrayList<Base> seqBaseList){
        super(seqBaseList,"Rna");
    }

}
