package com.company;

import com.company.utils.BufferedIOUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BufferedIOUtils rw = new BufferedIOUtils();
        List<String> test = rw.readFile();
        rw.fileWriter("Teste", String.join("\n", test));

    }

}
