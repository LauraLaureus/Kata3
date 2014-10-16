package kata3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailReader {

    private final String path;
    
    public String[] readDomains(){
        
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(path));
            ArrayList<String> domainList = new ArrayList<>();
            
            while(true){
                
                String line = reader.readLine();
                if(line == null) break;
                if(line.contains("@"))
                    domainList.add(line.split("@")[1]);
            }
            
            return domainList.toArray(new String[domainList.size()]);
        
        
        
        } catch (IOException ex) {
            return new String[0];
        
        
        
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public MailReader(String path) {
        this.path = path;
    }
} 



