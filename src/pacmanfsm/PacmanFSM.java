package pacmanfsm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre
 */


public class PacmanFSM {

    /**
     * @param args the command line arguments
     */
//    public boolean see;
//    public boolean blue;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> line = new ArrayList<>();
        Roam startPoint = new Roam();
        boolean see;
        boolean blue;
        int index = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/alexandre/Dropbox"
                    + "/netbeansproject/PacmanFSM/src/pacmanfsm/seeblue"));
            
            while (br.ready()){
                line.add(br.readLine());
            }
            
            String[] valueSeeBlue = arrayCheck(line, index);
            see  = Boolean.parseBoolean(valueSeeBlue[0]);
            blue = Boolean.parseBoolean(valueSeeBlue[1]);
            Roam ro = new Roam();            
            ro.roamTrans(line, index);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PacmanFSM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PacmanFSM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    } 
    
    public static String[] arrayCheck(ArrayList<String> str, int index){
        
        String[] aux = str.get(index).split(";");
        
        return aux;
    }
    
    
}

class Roam extends PacmanFSM{
    
    public void roamTrans(ArrayList<String> str, int index){
        
        boolean see;
        boolean blue;
                
        if(index >= str.size()){
            System.out.println("Estado Roam - Final");
            System.exit(0);
        }         
        
        String[] valueSeeBlue = arrayCheck(str, index); 
        see  = Boolean.parseBoolean(valueSeeBlue[0]);
        blue = Boolean.parseBoolean(valueSeeBlue[1]);
        index++;
        
        System.out.println("Estado Roam - see = " + valueSeeBlue[0] + " blue = " + valueSeeBlue[1]);
        
        if (see == false && blue == false){
            
            Roam ro = new Roam();           
            ro.roamTrans(str, index);            
            
        } else {
           
            if (see == false && blue == true){
            
                Evade ev = new Evade();                                               
                ev.evadeTrans(str, index);                
            
            } else {
                
                if (see == true && blue == false){
            
                    Chase ch = new Chase();                    
                    ch.chaseTrans(str, index);
                
            
                } else {
                    
                    if (see == true && blue == true){
            
                         Evade ev = new Evade();                                         
                         ev.evadeTrans(str, index);             
            
                    }                
                    
                }               
                
            }
        }
        
    }

}

class Evade  extends PacmanFSM{
    
    public void evadeTrans(ArrayList<String> str, int index){
        
        boolean see;
        boolean blue;
        
        
        if(index >= str.size()){
            System.out.println("Estado Evade - Final");
            System.exit(0);
        }
        
        String[] valueSeeBlue = arrayCheck(str, index); 
        see  = Boolean.parseBoolean(valueSeeBlue[0]);
        blue = Boolean.parseBoolean(valueSeeBlue[1]);
        index++;
        System.out.println("Estado Evade - see = " + valueSeeBlue[0] + " blue = " + valueSeeBlue[1]);
        
        if (see == false && blue == false){
            
            Roam ro = new Roam();
            
            see  = Boolean.parseBoolean(valueSeeBlue[0]);
            blue = Boolean.parseBoolean(valueSeeBlue[1]);
            ro.roamTrans(str, index);            
            
        } else {
           
            if (see == false && blue == true){
            
                Evade ev = new Evade();
                ev.evadeTrans(str, index);               
            
            } else {
                
                if (see == true && blue == false){
            
                    Chase ch = new Chase();
                    ch.chaseTrans(str, index);
                
            
                } else {
                    
                     Evade ev = new Evade();
                
                     ev.evadeTrans(str, index);              
                    
                }               
                
            }
        }
        
        
        
    }
    
}

class Chase  extends PacmanFSM {
    
    public void chaseTrans(ArrayList<String> str, int index){
        
        boolean see;
        boolean blue;
                
        if(index >= str.size()){
            System.out.println("Estado Chase - Final");
            System.exit(0);
        }
                
        String[] valueSeeBlue = arrayCheck(str, index);
        see  = Boolean.parseBoolean(valueSeeBlue[0]);
        blue = Boolean.parseBoolean(valueSeeBlue[1]);
        index++;
        System.out.println("Estado Chase - see = " + valueSeeBlue[0] + " blue = " + valueSeeBlue[1]);
        
        if (see == false && blue == false){
            
            Roam ro = new Roam();
            
            ro.roamTrans(str, index);            
            
        } else {
           
            if (see == false && blue == true){
            
                Evade ev = new Evade();
               
                              
                ev.evadeTrans(str, index);
                
            
            } else {
                
                if (see == true && blue == false){
            
                    Chase ch = new Chase();

                    
                    ch.chaseTrans(str, index);
                
            
                } else {
                    
                    if (see == true && blue == true){
            
                         Evade ev = new Evade();
                
                        
                                      
                         ev.evadeTrans(str, index);             
            
                    }                
                    
                }               
                
            }
        }   
        
   }
    
}
