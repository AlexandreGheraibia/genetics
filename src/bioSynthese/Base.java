package bioSynthese;

public class Base {

    private String name;
    private String symbol;
    private String family;
    //Constructeur
    Base(String symbol){
        initBaseElement(symbol);
    }
    private void initBaseElement(String symbol){
        this.symbol=symbol;
        switch(symbol){

            case "A":
                this.name="adénine";
                this.family="purine";

                break;
            case "T":
                this.name="thymine";
                this.family="pyrimidines";
                break;
            case "U":
                this.name="uracile";
                this.family="pyrimidines";
                break;
            case "G":
                this.name="adénine";
                this.family="purine";
                break;
            case "C":
                name="cytosine";
                family="pyrimidines";
                break;
            default:
            break;
        }

    }
    public Base compl(){//manque le isArn
        Base select=new Base("C");
        switch(this.symbol){
            case "A":
                select= new Base("T");;
                break;
            case "T":
                select= new Base("A");;
            break;
            case "C":
                select= new Base("G");;
            break;

        }
        return select;
    }

    public boolean isAdenine(){
        return this.symbol.equals("A");
    }
    public boolean isCytosine(){
        return this.symbol.equals("C");
    }
    public boolean isGuamine(){
        return this.symbol.equals("G");
    }
    public boolean isThymine(){
        return this.symbol.equals("T");
    }
    public boolean isUracile(){
        return this.symbol.equals("U");
    }

    public String toString(){
        String color="\u001B[32m";
        String colorReset="\u001B[0m";
        return this.symbol;
    }

}
