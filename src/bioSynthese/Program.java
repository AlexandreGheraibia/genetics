package bioSynthese;

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
        String seqSymbol="ACGTCCGGTATT";
        Strand strand=new Strand("U"+seqSymbol+"U");
        testsDisplay("test strand generation ",strand);
        strand=new Dna(seqSymbol);
        //Dna d=new Dna(seqSymbol);
        testsDisplay("test Dna generation ",strand);
        testsDisplay("test Dna compl generation ",((Dna)strand).getComplStrand());
        //System.out.println(d.transcriptioh());
        strand=(((Dna)strand).transcriptioh());
        testsDisplay("test Rna generation",strand);

    }
}
