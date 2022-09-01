import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Interpretador {

    static String str="XXX";

    public static boolean isFim(String string){
        return(!(string.length() == 4 && string.charAt(0) == 'f' && string.charAt(1) == 'i' && string.charAt(2) == 'm' && string.charAt(3) == '.'));
    }

    public static void main(String []args){
        FileReader arq;
        FileWriter arq2 = null;
        File arqW;
        BufferedReader br;
        BufferedWriter br2 = null;
        String string;
        

        try{
            arq = new FileReader("testeula.ula");
            br = new BufferedReader(arq);

            arqW = new File("testeula.hex");
            if(!arqW.exists()){
                arqW.createNewFile();
            }

            arq2 = new FileWriter(arqW);
            br2 = new BufferedWriter(arq2);

            br.readLine();

            while(isFim(string = br.readLine())){
                try{
                    str = interpretar(string);
                    if(string.charAt(0) == 'W'){
                        arq2.write(str);
                        arq2.write(System.getProperty( "line.separator" ));
                    }

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }       
            }

            arq.close();
            br.close();

            arq2.close();
            br2.close();

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
                    tmp += mnemonicoHexa(string).charAt(0);
                }
            }
        }
        
        return tmp;
    }

    public static String mnemonicoHexa(String string){
        String hexa="";

        switch(string){

            case "W=An;":
                hexa += '0';
                break;

            case "W=nAoB;":
                hexa += '1';
                break;

            case "W=AnB;":
                hexa += '2';
                break;

            case "W=zeroL;":
                hexa += '3';
                break;

            case "W=nAeB;":
                hexa += '4';
                break;

            case  "W=Bn;":
                hexa += '5';
                break;

            case  "W=AxB;":
                hexa += '6';
                break;

            case  "W=ABn;":
                hexa += '7';
                break;

            case  "W=AnoB;":
                hexa += '8';
                break;

            case  "W=nAxB;":
                hexa += '9';
                break;

            case  "W=copiaB;":
                hexa += 'A';
                break;

            case  "W=AB;":
                hexa += 'B';
                break;

            case  "W=umL;":
                hexa += 'C';
                break;

            case  "W=AoBn;":
                hexa += 'D';
                break;

            case  "W=AoB;":
                hexa += 'E';
                break;

            case  "W=copiaA;":
                hexa += 'F';
                break;
        }

        //System.out.println("hexa: " + hexa);

        return hexa;
    }



}
