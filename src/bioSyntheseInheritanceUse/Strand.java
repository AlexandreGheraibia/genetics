package bioSyntheseInheritanceUse;


import java.util.ArrayList;

//Class A
public abstract class Strand {
    private String type;
    //Classe C
    private ArrayList<Base> nucleoAcideList=new ArrayList<>();

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type=type;
    }

    public ArrayList<Base> getNucleoAcideList() {
        return nucleoAcideList;
    }

    public void setNucleoAcideList(ArrayList<Base> nucleoAcideList) {
        this.nucleoAcideList = nucleoAcideList;
    }

    Strand(){
        this.type="Brin";
    }

    public Strand(String seqSymbol,String type){
        this.generateAcid(seqSymbol);
        this.type=type;
    }
  /*  public Strand(ArrayList<Base> baseList){
        this.setNucleoAcideList(baseList);
    }

    public Strand(ArrayList<Base> baseList,String type){
        this(baseList);
        this.type=type;
    }
    */
    public void generateAcid(String seqSymbol){

        for(Character c : seqSymbol.toCharArray()){
                if(c=='U'||c=='A'||c=='C'||c=='T'||c=='G'){
                    if((this.getType()=="Rna"&&c!='T')||(this.getType()=="Dna"&&c!='U')||(this.getType()=="Brin")){
                        nucleoAcideList.add(new Base(String.valueOf(c)));
                    }
                    else{
                        System.err.println("the symbol "+c+" can't contained by a "+this.getType());
                    }
                }
                else{
                    System.err.println("the symbol isn't a base element");

                }
        }
    }

    public String toString(){
        String color="\u001B[31m";
        String colorReset="\u001B[0m";
        String accuString="";
        for(Base b: nucleoAcideList){
            accuString+=b.isUracile()||b.isThymine()? color+b+colorReset:b;
        }
        return accuString;
    }

}
