package bioSyntheseInheritanceUse;

import java.util.ArrayList;

public class Protein {

    private ArrayList<AminoAcid> chain=new ArrayList<>();

    Protein(){

    }
    Protein(ArrayList<AminoAcid>chain){
        this.chain=chain;
    }
    ArrayList<Protein>factory(ArrayList<AminoAcid>aminoAcidList){
        ArrayList<Protein>proteinList=new ArrayList<>();
        Protein protein=new Protein();
        for(AminoAcid proCur:aminoAcidList){
            if(Ribosome.isTheEnd(proCur)){
                if(protein.getChain().size()>0){
                    proteinList.add(protein);
                    protein=new Protein();

                }

            }
            else{
                protein.getChain().add(proCur);
            }
        }
       return proteinList;
    }

    public String toString(){
        String str="";
        for(AminoAcid elem:getChain()){
            str+=elem;
        }
        return str;
    }
    public ArrayList<AminoAcid> getChain() {
        return chain;
    }
}
