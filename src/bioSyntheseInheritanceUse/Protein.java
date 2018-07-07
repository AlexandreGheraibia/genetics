package bioSyntheseInheritanceUse;

import java.util.ArrayList;

public class Protein {

    private ArrayList<AminoAcid> chain=new ArrayList<>();

    Protein(){

    }

    Protein(ArrayList<AminoAcid>chain){
        this.chain=chain;
    }
    ArrayList<Protein>factory(Protein protein){
        ArrayList<Protein>proteinList=new ArrayList<>();
        Protein accu=new Protein();
        for(AminoAcid proCur:protein.getChain()){
            if(Ribosome.isTheEnd(proCur)){
                if(accu.getChain().size()>0){
                    proteinList.add(accu);
                    accu=new Protein();

                }

            }
            else{
               accu.getChain().add(proCur);
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
