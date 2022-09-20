import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

/*
======  
  PUC MINAS
  
  Curso: Computação - 02/2022
  Disciplina: Arquitetura de Computadores II
  
  Professor: Romanelli Lodron Zuim
  Atividade: Exercício Prático 03 - Exerc 01
  
  Alunos: Arthur Kazuo, Bernard Paes, Daniel Gomes e Hernane Velozo.
  Belo Horizonte, 31/08/2022.
======
*/

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
            arq = new FileReader("testeula.ula"); // abre o arquivo .ula para leitura
            br = new BufferedReader(arq);

            arqW = new File("testeula.hex"); // cria o arquivo .hex para escrita
            if(!arqW.exists()){// caso o arquivo nao exista, cria um
                arqW.createNewFile();
            }

            arq2 = new FileWriter(arqW);
            br2 = new BufferedWriter(arq2);

            br.readLine();

            while(isFim(string = br.readLine())){ /* checa toda linha para saber se o arquivo chegou ao fim e atribui a linha para uma string (caso nao seja o fim) 
                                                        para que ela seja enviada para o metodo interpretar */ 
                try{                                
                    str = interpretar(string);
                    if(string.charAt(0) == 'W'){ //escreve o valor hexadecimal do mnemonico no arquivo .hex
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


    public static String interpretar(String string){ // interpreta as linhas do arquivo .ula e passa os valores para hexa, para o arquivo .hex
        String tmp="";

        /*
         * caso o valor de x ou y precise ser alterado antes de ser atribuida uma nova operação, a string com os valores de x e y será 
         * atualizada com o if e else if 
         * 
         * já o else atribuirá à string o valor hexa do menemonico 
         */

        if(string.charAt(0) == 'X'){ // faz o parsing, char por char, do valor de x
            for(int i=0; i<3; i++){
                if(i != 0){
                    tmp += str.charAt(i); 
                }
                else{
                    tmp += string.charAt(2);
                }
            }
        }
        else if(string.charAt(0) == 'Y'){  // faz o parsing, char por char, do valor de y
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
                    tmp += mnemonicoHexa(string).charAt(0); //transforma o mnemonico em hexa para o codigo .hex
                }
            }
        }
        
        return tmp;
    }

    public static String mnemonicoHexa(String string){ //transforma o mnemonico em hexa
        String hexa="";

        switch(string){ //recebe a string com o mnemonico e faz o switch case para definir qual hexa retornar

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

        return hexa;
    }



}
