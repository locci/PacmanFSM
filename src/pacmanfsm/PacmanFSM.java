package pacmanfsm;

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
    } 
    
    public static String[] arrayCheck(String[] str, int index){
        
        String[] aux = str[index].split(";");     
        
        return aux;
    }
    
    
}

class Roam extends PacmanFSM{
    
    public void roamTrans(boolean see, boolean blue, String[] str, int index){
        
        String[] valueSeeBlue = arrayCheck(str, index);        
        
        if (see == false && blue == false){
            
            Roam ro = new Roam();
            
            see  = Boolean.getBoolean(valueSeeBlue[0]);
            blue = Boolean.getBoolean(valueSeeBlue[1]);
            index++;
            ro.roamTrans(see, blue, str, index);            
            
        } else {
           
            if (see == false && blue == true){
            
                Evade ev = new Evade();
                
                see  = Boolean.getBoolean(valueSeeBlue[0]);
                blue = Boolean.getBoolean(valueSeeBlue[1]);
                index++;
                
                ev.evadeTrans(see, blue, str, index);
                
            
            } else {
                
                if (see == true && blue == false){
            
                    Chase ch = new Chase();

                    see  = Boolean.getBoolean(valueSeeBlue[0]);
                    blue = Boolean.getBoolean(valueSeeBlue[1]);
                    index++;

                    ch.chaseTrans(see, blue, str, index);
                
            
                } 
                
            }
        }
        
    }

}

class Evade  extends PacmanFSM{
    
    public void evadeTrans(boolean see, boolean blue, String[] str, int index){
        
        
        
    }
    
}

class Chase  extends PacmanFSM {
    
    public void chaseTrans(boolean see, boolean blue, String[] str, int index){
        
    }
    
}
