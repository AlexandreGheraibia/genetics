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
        String seqSymbol="ACGTCCGGTATTTAAUUTCGT";
        Strand strand=new Strand("U"+seqSymbol+"U");
        testsDisplay("test strand generation ",strand);
        strand=new Dna(seqSymbol);
        //Dna d=new Dna(seqSymbol);
        testsDisplay("test Dna generation ",strand);
        testsDisplay("test Dna compl generation ",((Dna)strand).getComplStrand());
        //System.out.println(d.transcriptioh());
        strand=(((Dna)strand).transcriptioh());
        testsDisplay("test Rna generation",strand);
        ArrayList<AminoAcid>aminoAcidList;
        aminoAcidList=((Rna)strand).traduction();
        affiche("display pseudo protein ");
        System.out.println(aminoAcidList);


        /*
        test strand generation
        nucleo acid:	UACGTCCGGTATTTAAUUTCGTU
        type:	Brin
        test Dna generation
        nucleo acid:	ACGTCCGGTATTTAAUUTCGT
        type:	Dna
        test Dna compl generation
        nucleo acid:	TGCAGGCCATAAATTCCAGCA
        type:	Brin
        test Rna generation
        nucleo acid:	ACGUCCGGUAUUUAAUUUCGU
        type:	Rna
        display pseudo protein
        [théonine, sérine, glycine, isoleucine]

        Process finished with exit code 0

        * */

    }
}
