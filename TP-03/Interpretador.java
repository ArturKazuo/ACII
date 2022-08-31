import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Interpretador {

    static String str="";

    public static boolean isFim(String string){
        return(!(string.length() == 4 && string.charAt(0) == 'f' && string.charAt(1) == 'i' && string.charAt(2) == 'm' && string.charAt(3) == '.'));
    }

    public static void main(String []args){
        FileReader arq;
        FileWriter arq2;
        File arqW;
        BufferedReader br;
        BufferedWriter br2;
        String string;
        

        try{
            arq = new FileReader("testeula.ula");
            br = new BufferedReader(arq);

            arqW = new File("testeula.hex");
            arqW.createNewFile();

            arq2 = new FileWriter(arqW);
            br2 = new BufferedWriter(arq2);

            while(isFim(string = br.readLine())){
                try{
                    str = interpretar(string);
                    if(string.charAt(0) == 'W'){
                        
                    }

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
                if(i != 0){
                    tmp += str.charAt(i); 
                }
                else{
                    tmp += string.charAt(2);
                }
            }
        }
        else if(string.charAt(0) == 'Y'){
            for(int i=0; i<3; i++){
                if(i != 1){
                    tmp += str.charAt(i); 
                }
                else{
                    tmp += string.charAt(2);
                }
            }
        }
        else{
            for(int i=0; i<3; i++){
                if(i != 2){
                    tmp += str.charAt(i); 
                }
                else{
                    tmp += mnemonicoHexa(string);
                }
            }
        }

        str = tmp;

        return str;
    }

    public static String mnemonicoHexa(String string){
        String hexa="";

        switch(string){

            case "An":
                hexa += "0";
                break;

            case "nAoB":
                hexa += "1";
                break;

            case "AnB":
                hexa += "2";
                break;

            case "zeroL":
                hexa += "3";
                break;

            case "nAeB":
                hexa += "4";
                break;

            case  "Bn":
                hexa += "5";
                break;

            case  "AxB":
                hexa += "6";
                break;

            case  "ABn":
                hexa += "7";
                break;

            case  "AnoB":
                hexa += "8";
                break;

            case  "nAxB":
                hexa += "9";
                break;

            case  "copiaB":
                hexa += "A";
                break;

            case  "AB":
                hexa += "B";
                break;

            case  "umL":
                hexa += "C";
                break;

            case  "AoBn":
                hexa += "D";
                break;

            case  "AoB":
                hexa += "E";
                break;

            case  "copiaA":
                hexa += "F";
                break;
        }

        return hexa;
    }



}
