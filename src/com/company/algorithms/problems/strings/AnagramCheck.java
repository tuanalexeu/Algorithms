package com.company.algorithms.problems.strings;

public class AnagramCheck {
    public static boolean isAnagram(String word, String anagram) {
        char[] ch = word.toCharArray();
        StringBuilder sbSecond = new StringBuilder(anagram);

        for (Character c: ch) {
            int index = sbSecond.indexOf(String.valueOf(c));

            if(index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return sbSecond.length() == 0;
    }

    public static void main(String[] args) {
        boolean t = isAnagram("alal","lala");
        System.out.println(t);
    }
}
