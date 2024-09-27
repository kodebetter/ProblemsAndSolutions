package com.sandeep.string;

public class Anagram {


    public static void main(String[] args) {
        System.out.println("String Sandeep and String andeepS are anagram :  " +checkAnagram("Sandeep", "epednas"));
    }

    public static boolean checkAnagram(String first, String second) {
        char[] characters = first.toLowerCase().toCharArray();
        StringBuilder sbSecond = new StringBuilder(second.toLowerCase());
        for (char ch : characters) {
            int index = sbSecond.indexOf("" + ch);
            if (index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return sbSecond.length() == 0 ? true : false;
    }


}
