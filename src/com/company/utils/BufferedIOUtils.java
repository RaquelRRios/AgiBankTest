package com.company.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class BufferedIOUtils {
    public List<String> readFile(){
        List<String> list = new ArrayList<>();
        try{
            FileReader fr = new FileReader("dadosExemplo.dat");
            BufferedReader bf = new BufferedReader(fr);
            String linha;
            do {
                linha = bf.readLine();
                list.add(linha);
            } while (linha!=null);

            list.remove(list.size()-1);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao ler o arquivo" );
        }
        return list;
    }

    public void fileWriter(String fileName, String text){
        try{
            FileWriter fw = new FileWriter(fileName);
//            fw.write(text);
            fw.append(text);
            fw.close();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao escrever o arquivo");
        }
    }
}
