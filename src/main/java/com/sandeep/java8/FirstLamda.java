package com.sandeep.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FirstLamda {


    public static void main(String[] args) {

        /**
         * Using Anamanous class
         */
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        /**
         * using Lamda
         */
        FileFilter lamdaFileFilter = (File pathName) -> pathName.getName().endsWith(".java");

        File dir = new File("D:/Java/");
        File[] javaFiles = dir.listFiles(lamdaFileFilter);
        for (File file : javaFiles) {
            System.out.println(file.getName());
        }

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("I   " + i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        /**
         * Comparator using Lamda
         */

        List<String> namesList = new ArrayList<>();
        namesList.add("abbb");
        namesList.add("kvsnk");
        namesList.add("canlacncn");
        namesList.add("nalcvv");
        namesList.add("iahioadvlkdv");
        namesList.add("klacn");
        Comparator<String> stringComparable = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(namesList, stringComparable);

        /**
         * Comparing on multiple fields
         */

        Comparator<Report> stringComparator = Comparator.comparing(Report::getReportKey)
                .thenComparing(Report::getStudentNumber).reversed()
                .thenComparing(Report::getSchool);
        List<Report> reportList = new ArrayList<>();
        Collections.sort(reportList, stringComparator);

        /**
         * using comparator chain
         *
         */
        


    }
}
