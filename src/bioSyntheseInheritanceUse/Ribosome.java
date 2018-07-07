package bioSyntheseInheritanceUse;

import java.util.ArrayList;
import java.util.HashMap;

public class Ribosome {
    //a un milieu
    public static HashMap<String,String> codonMap =new HashMap<>(),couple=new HashMap<>();

    public static boolean isTheEnd(AminoAcid aminoAcid){
        return aminoAcid.getSymbol()==" ";
    }

    private static boolean aminoMapExist=false;

    private static boolean coupleExist=false;

    private static boolean getAminoMapExist(){
        return aminoMapExist;
    }

    private static boolean getAminoNameExist(){
        return coupleExist;
    }

    private static void initAminoName(){
        if(!coupleExist){
            couple.put("F","phénylanine");  couple.put("Y","tyrosine");       couple.put("A","alanine");
            couple.put("L","leucine");      couple.put(" ","STOP");           couple.put("S","sérine");
            couple.put("P","proline");      couple.put("H","histidine");      couple.put("I","isoleucine");
            couple.put("N","asparagine");   couple.put("M","méthionine");     couple.put("V","valine");
            couple.put("D","acide asparique");couple.put("C","cystéine");     couple.put("R","argine");
            couple.put("W","tryptophane");  couple.put("G","glycine");        couple.put("T","thréonine");
            couple.put("S","sérine");       couple.put("Q","glutamine");      couple.put("E","glutamaque");
            couple.put("K","lysine");
            coupleExist=true;
        }

    }
    public static String getAminoName(String symbol){
        if(!coupleExist){
            initAminoName();
        }
       return couple.get(symbol);
    }
    private static void initAminoMap(){
        aminoMapExist=true;
        initAminoName();
        codonMap=new HashMap<>();
        codonMap.put("UUU","F");
        codonMap.put("UUC","F");
        codonMap.put("UUA","L");
        codonMap.put("UUG","L");
        codonMap.put("CUU","L");
        codonMap.put("CUC","L");
        codonMap.put("CUA","L");
        codonMap.put("CUG","L");
        codonMap.put("AUU","I");
        codonMap.put("AUC","I");
        codonMap.put("AUA","I");
        codonMap.put("AUG","M");
        codonMap.put("GUU","V");
        codonMap.put("GUC","V");
        codonMap.put("GUA","V");
        codonMap.put("GUG","V");
        codonMap.put("UCU","S");
        codonMap.put("UCC","S");
        codonMap.put("UCA","S");
        codonMap.put("UCG","S");
        codonMap.put("CCU","P");
        codonMap.put("CCC","P");
        codonMap.put("CCA","P");
        codonMap.put("CCG","P");
        codonMap.put("ACU","T");
        codonMap.put("ACC","T");
        codonMap.put("ACA","T");
        codonMap.put("ACG","T");
        codonMap.put("GCU","A");
        codonMap.put("GCC","A");
        codonMap.put("GCA","A");
        codonMap.put("GCG","A");
        codonMap.put("UAU","Y");
        codonMap.put("UAC","Y");
        codonMap.put("UAA"," "); // STOP
        codonMap.put("UAG"," "); // STOP
        codonMap.put("CAU","H");
        codonMap.put("CAC","H");
        codonMap.put("CAA","Q");
        codonMap.put("CAG","Q");
        codonMap.put("AAU","N");
        codonMap.put("AAC","N");
        codonMap.put("AAA","K");
        codonMap.put("AAG","K");
        codonMap.put("GAU","D");
        codonMap.put("GAC","D");
        codonMap.put("GAA","E");
        codonMap.put("GAG","E");
        codonMap.put("UGU","C");
        codonMap.put("UGC","C");
        codonMap.put("UGA"," "); // STOP
        codonMap.put("UGG","W");
        codonMap.put("CGU","R");
        codonMap.put("CGC","R");
        codonMap.put("CGA","R");
        codonMap.put("CGG","R");
        codonMap.put("AGU","S");
        codonMap.put("AGC","S");
        codonMap.put("AGA","R");
        codonMap.put("AGG","R");
        codonMap.put("GGU","G");
        codonMap.put("GGC","G");
        codonMap.put("GGA","G");
        codonMap.put("GGG","G");
    }


    public  AminoAcid codonToAminoAcid(String codon){
        if(!aminoMapExist){
            initAminoMap();
        }
        if(codonMap.containsKey(codon)){
            return new AminoAcid(codonMap.get(codon).toString(),codon);
        }

        System.err.println("Can't translate the codon isn't an amino acid valid"+codon);
        return null;
    }

    public ArrayList<AminoAcid> traduction(Rna rna){
        int tripletNB=rna.getNucleoAcideList().size()/3;
        String codon;
        ArrayList<AminoAcid> protein=new ArrayList<>();
        int i=0;
        while(i<tripletNB){
            codon="";
            for(int j=0;j<3;j++){
                codon+=rna.getNucleoAcideList().get(i*3+j).getSymbol();
            }
            //System.out.println("codon:"+codon+"*");
            AminoAcid a;
            a = codonToAminoAcid(codon);
            protein.add(a);
            i++;
        }
        return protein;
    }

}
