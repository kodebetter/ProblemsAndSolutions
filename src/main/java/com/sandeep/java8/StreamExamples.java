package com.sandeep.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        List<Report> reportList = getReports();
        exampleOfFilter(reportList);
    }

    public static void exampleOfFilter(List<Report> reportList) {
        System.out.println("**********************FILTER*************************");
        List<Report> reports = reportList.stream().filter(report -> report.getStudentNumber().
                equalsIgnoreCase("111")).collect(Collectors.toList());
        reports.forEach(report -> System.out.println(report.getStudentNumber()));
    }

    public static void exampleOfMap(List<Report> reportList) {
        System.out.println("**********************Map*************************");
        List<Report> reports = reportList.stream().filter(report -> report.getStudentNumber().
                equalsIgnoreCase("111")).collect(Collectors.toList());
        //List<String> reps = reports.stream().map(report -> report.setStudentNumber("8888")).collect(Collectors.toList());
        reports.forEach(report -> System.out.println(report.getStudentNumber()));
    }

    private static Report getUpdatedReport(Report report){
        report.setStudentNumber("8888");
        return report;
    }

    private static List<Report> getReports() {
        Report report = new Report("1", "111", "SKPSHSA");
        Report report1 = new Report("2", "222", "SKPSHSB");
        Report report2 = new Report("3", "333", "SKPSHSC");
        Report report3 = new Report("4", "111", "SKPSHSA");
        Report report4 = new Report("5", "444", "SKPSHSD");
        Report report5 = new Report("6", "555", "SKPSHSE");
        Report report6 = new Report("7", "666", "SKPSHSF");
        Report report7 = new Report("8", "777", "SKPSHSG");
        return Arrays.asList(report, report1, report2, report3, report4, report5, report6, report7);
    }
}
