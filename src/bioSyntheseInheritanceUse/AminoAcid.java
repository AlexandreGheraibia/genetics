package bioSyntheseInheritanceUse;

public class AminoAcid {

    private String name;

    private String formule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }
    public AminoAcid(){

    }

    public AminoAcid(String name){
        this.setName(name);

    }

    @Override
    public String toString() {
        return getName();
    }
}
