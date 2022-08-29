import java.io.FileReader;
import java.io.BufferedReader;

public class Interpretador {

    static String str="";

    public static boolean isFim(String string){
        return(!(string.length() == 4 && string.charAt(0) == 'f' && string.charAt(1) == 'i' && string.charAt(2) == 'm' && string.charAt(3) == '.'));
    }

    public static void main(String []args){
        FileReader arq, arqW;
        BufferedReader br, brW;
        String string;

        try{
            arq = new FileReader("");
            br = new BufferedReader(arq);

            arqW = new FileReader("");
            brW = new BufferedReader(arqW);

            while(isFim(string = br.readLine())){
                try{
                    str = interpretar(string);



                }catch(Exception e){
                    System.out.println(e.getMessage());
                }       
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static String interpretar(String string){
        String tmp="";

        if(string.charAt(0) == 'X'){
            for(int i=0; i<3; i++){
                tmp += str.charAt(i+1); 
            }
        }
        else if(string.charAt(0) == 'Y'){
            for(int i=0; i<3; i++){
                if(i != 1){
                    tmp += str.charAt(i); 
                }
                else{

                }
            }
        }
        else{

        }

        return str;
    }



}
