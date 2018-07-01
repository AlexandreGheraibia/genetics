package bioSyntheseInheritanceUse;

import java.util.ArrayList;
import java.util.HashMap;

//est un Strand
public class Rna extends Strand {
    //a un milieu
    public static HashMap<String,String> aminoAcidMap=new HashMap<>();
    private static boolean aminoMapExist=false;
    private static boolean getARminoMapExist(){
        return aminoMapExist;
    }
    private static void initAminoMap(){
        aminoMapExist=true;
        aminoAcidMap.put("UUU","phénylanine");  aminoAcidMap.put("UCU","sérine");   aminoAcidMap.put("UAU","tyrosine");
        aminoAcidMap.put("UUC","phénylanine");  aminoAcidMap.put("UCC","sérine");   aminoAcidMap.put("UAC","tyrosine");
        aminoAcidMap.put("UUA","leucine");      aminoAcidMap.put("UCA","sérine");   aminoAcidMap.put("UAA","stop");
        aminoAcidMap.put("UUG","leucine");      aminoAcidMap.put("UCG","sérine");   aminoAcidMap.put("UAG","stop");

        aminoAcidMap.put("CUU","leucine");      aminoAcidMap.put("CCU","proline");  aminoAcidMap.put("CAU","histidine");
        aminoAcidMap.put("CUC","leucine");      aminoAcidMap.put("CCC","proline");  aminoAcidMap.put("CAC","histidine");
        aminoAcidMap.put("CUA","leucine");      aminoAcidMap.put("CCA","proline");  aminoAcidMap.put("CAA","glutamine");
        aminoAcidMap.put("CUG","leucine");      aminoAcidMap.put("CCG","proline");  aminoAcidMap.put("CAG","glutamine");


        aminoAcidMap.put("AUU","isoleucine");    aminoAcidMap.put("ACU","théonine"); aminoAcidMap.put("AAU","asparagine");
        aminoAcidMap.put("AUC","isoleucine");    aminoAcidMap.put("ACC","théonine"); aminoAcidMap.put("AAC","asparagine");
        aminoAcidMap.put("AUA","isoleucine");    aminoAcidMap.put("ACA","théonine"); aminoAcidMap.put("AAA","asparagine");
        aminoAcidMap.put("AUG","méthionine");    aminoAcidMap.put("ACG","théonine"); aminoAcidMap.put("AAG","asparagine");

        aminoAcidMap.put("GUU","valine");        aminoAcidMap.put("GCU","valine"); aminoAcidMap.put("GAU","acide");
        aminoAcidMap.put("GUC","valine");        aminoAcidMap.put("GCC","valine"); aminoAcidMap.put("GAC","asparagine");
        aminoAcidMap.put("GUA","valine");        aminoAcidMap.put("GCC","valine"); aminoAcidMap.put("GAC","acide");
        aminoAcidMap.put("GUG","valine");        aminoAcidMap.put("GCG","valine"); aminoAcidMap.put("GAG","glutamine");


        aminoAcidMap.put("UGU","cystéine");      aminoAcidMap.put("CGU","argine");  aminoAcidMap.put("AGU","sérine");
        aminoAcidMap.put("UGC","cystéine");      aminoAcidMap.put("CGC","argine");  aminoAcidMap.put("AGC","sérine");
        aminoAcidMap.put("UGA","stop");          aminoAcidMap.put("CGA","argine");  aminoAcidMap.put("AGA","argine");
        aminoAcidMap.put("UGG","tryptophane");   aminoAcidMap.put("CGG","argine");  aminoAcidMap.put("AGG","argine");

        aminoAcidMap.put("GGU","glycine");
        aminoAcidMap.put("GGC","glycine");
        aminoAcidMap.put("GGA","glycine");
        aminoAcidMap.put("GGG","glycine");
    }
    public  AminoAcid codonToAminoAcid(String codon){
       if(!aminoMapExist){
           initAminoMap();
       }
       if(aminoAcidMap.containsKey(codon)){
            return new AminoAcid(aminoAcidMap.get(codon).toString());
       }
        System.err.println("Can't translate the codon do an amino acid");
        return null;
    }
    public Rna(){
        this.setType("Rna");

    }
    public Rna(String seqSymbol){
        super(seqSymbol,"Rna");

    }
    public Rna(ArrayList<Base> seqBaseList){
        super(seqBaseList,"Rna");
    }

    public ArrayList<AminoAcid> traduction(){
        int tripletNB=this.getNucleoAcideList().size()/3;
        String codon;
        ArrayList<AminoAcid> protein=new ArrayList<>();
        int i=0;
        boolean fin=false;
        while(i<tripletNB&&!fin){
            codon="";
            for(int j=0;j<3;j++){
                codon+=this.getNucleoAcideList().get(i*3+j).getSymbol();
            }
            AminoAcid a=codonToAminoAcid(codon);
            if(!a.getName().equals("stop"))
                 protein.add(a);
            else{
                fin=true;
            }
            i++;
        }
        return protein;
    }


}
