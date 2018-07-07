package bioSyntheseInheritanceUse;

import java.util.ArrayList;

public class Program {

    static final String RED_COLOR_CODE = "\u001B[31m";
    static final String RESET_CODE = "\u001B[0m";

    static void affiche(String text){
        System.out.println(RED_COLOR_CODE + text + RESET_CODE);
    }

    static void testsDisplay(String text, Strand b){
        affiche(text);
        System.out.println("nucleo acid:\t"+b);
        System.out.println("type:\t"+b.getType());
    }

    public static void main(String[] Arg){
        try{
            DnaRepository repDna=new DnaRepository();
            repDna.load("dna.txt");
            Dna dnaStrand=repDna.getDna();
            Enzyme arnPolymerase=new Enzyme();
            testsDisplay("test repositoryDna",dnaStrand);
            testsDisplay("test dna apariz", arnPolymerase.transcriptioh(dnaStrand));
            Ribosome ribosome=new Ribosome();
            ArrayList<Protein>proteinList;

            Protein protein=new Protein(ribosome.traduction(arnPolymerase.transcriptioh(dnaStrand)));
            //System.out.print(protein);
            proteinList=protein.factory(protein);
            for(Protein proCur:proteinList){
                System.out.println(proCur);
            }


        }
        catch (Exception e){
                return;
        }

    }

}
