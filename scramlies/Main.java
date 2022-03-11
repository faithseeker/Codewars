package com.company.scramlies;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scramblies.scramble("","");
    }
}

class Scramblies {

    public static boolean scramble(String str1, String str2) {

        String[] str1Array = str1.split("");
        String[] str2Array  = str2.split("");
        HashMap<String,Integer> str1Hash = new HashMap<String,Integer>();
        HashMap<String,Integer> str2Hash = new HashMap<String,Integer>();

        for (String oneLetter:str1Array
        ) {
            if (str1Hash.get(oneLetter)==null)
                str1Hash.put(oneLetter,1);
            else
            {
                int tmpCount = str1Hash.get(oneLetter);
                tmpCount++;
                str1Hash.remove(oneLetter);
                str1Hash.put(oneLetter,tmpCount);
            }

        }

        for (String oneLetter:str2Array
        ) {
            if (str2Hash.get(oneLetter)==null)
                str2Hash.put(oneLetter,1);
            else
            {
                int tmpCount = str2Hash.get(oneLetter);
                tmpCount++;
                str2Hash.remove(oneLetter);
                str2Hash.put(oneLetter,tmpCount);
            }

        }

        for(Map.Entry<String, Integer> entry : str2Hash.entrySet()) {
            String str2key = entry.getKey();
            Integer str2value = entry.getValue();

            if(str1Hash.get(str2key) == null || str1Hash.get(str2key)<str2value)
            {
                return false;
            }



            // do what you have to do here
            // In your case, another loop.
        }
        return true;
    }
}

class Scramblies2{
    public static boolean scramble(String str1, String str2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        str2.chars().forEach(i -> cnt.put(i, cnt.getOrDefault(i, 0) + 1));
        str1.chars().filter(i -> cnt.containsKey(i)).forEach(i -> cnt.put(i, cnt.get(i) - 1));
        return cnt.values().stream().filter(i -> i>0).count() == 0;
    }
}