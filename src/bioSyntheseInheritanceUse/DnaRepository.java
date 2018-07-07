package bioSyntheseInheritanceUse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DnaRepository {
    private Dna dna;
    public void load(String uri) throws IOException {
            dna=new Dna();
            BufferedReader reader = new BufferedReader(new FileReader(uri));
            String line = reader.readLine();
            dna.generateAcid(line);
            line = reader.readLine();
            reader.close();
    }

    public Dna getDna(){
        return dna;
    }

}
