package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        try{
            FileWriter fw;
            fw = new FileWriter("dadosProva.txt");
            fw.write("001ç1234567891234çPedroç50000\n" +
                        "001ç3245678865434çPauloç40000.99\n" +
                        "002ç2345675434544345çJose da SilvaçRural\n" +
                        "002ç2345675433444345çEduardo PereiraçRural\n" +
                        "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                        "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo" );
            fw.close();

        } catch (Exception e){
            System.out.println("Erro "+e.getMessage());
        }

        try{
            FileReader fr;
            fr = new FileReader("dadosProva.txt");
            BufferedReader bf = new BufferedReader(fr);
            String linha = bf.readLine();
            System.out.println(linha);
            while(linha!=null){
                System.out.println(linha);
                linha = bf.readLine();
            }

        } catch (Exception e){
            System.out.println("Erro "+e.getMessage());
        }
    }
}
