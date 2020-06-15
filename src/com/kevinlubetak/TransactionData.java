package com.kevinlubetak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class TransactionData {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/kevinlubetak/data.txt"))) {
            String line;
            String key= "";
            String value = "";
            while ((line = br.readLine()) != null) {

                    boolean res1 = isNumeric(line);
                    if(res1 == true) {
                        //System.out.println("Price: " + line);
                        value = line;
                    } else {
                        //System.out.println("Item : " + line);
                        key = line;
                    }
                map.put(key, value);

            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key2 = entry.getKey();
                String values2 = entry.getValue();
                System.out.println( key2 + " => " + values2);

            }
        }

    }
}
