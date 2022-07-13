import java.io.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.parseDouble;
import static java.nio.file.Files.readAllLines;

import java.lang.Iterable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;




public class monthReport {


    Map<Integer, List<Item>> monthReports = new HashMap<>();   // Все месячные отчеты
    NameOfMonthes nameOfMonthes = new NameOfMonthes();



    public void readFileContentsOrNull() {

        for (int i = 1; i <= 3; i++) {
            String address = "resources/m."+"2021"+"0" + i + ".csv";
            File file = new File(address);
            ArrayList<Item> monthReport = new ArrayList<>();

            try {
                Scanner filescanner = new Scanner(file);
                int iterator = 0;
                while (filescanner.hasNextLine()) {
                    String line = filescanner.nextLine();
                    String razdel = ",";
                    if (iterator == 0) {
                        iterator++;
                        continue;
                    }
                    monthReport.add(new Item(line.split(razdel)[0], line.split(razdel)[1], parseDouble(line.split(razdel)[2]), parseDouble(line.split(razdel)[3])));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файлы для считывания не обнаружены");
                e.printStackTrace();
            }
            monthReports.put(i, monthReport);
        }
        System.out.println("Считываине файлов c месячными отчетами произведено успешно" + "\n");

        rewriteMonth(); // ЗАПУСК МЕТОДА ПРЕОБРАЗОВАНИЯ В MONTHSRESULTS!!!!
        System.out.println("Месячный отчет "+monthReports.size());
        //return monthReports;
    }



    public void findMaxIncomeAndExpense() {
        double maxExpense = 0;
        String nameOfMaxExpense = "";
        double maxIncome = 0;
        String nameOfMaxIncome = "";

        for (Map.Entry<Integer, List<Item>> monthReport : monthReports.entrySet()) {
            System.out.println("\n" + "Месяц " + nameOfMonthes.getMonth()[monthReport.getKey()] + "\n");
            for (Item item : monthReport.getValue()) {
                if (item.getIsExpense() == true) {
                    maxExpense = item.getSumm();
                    nameOfMaxExpense = item.getName();
                } else if (item.getIsExpense() == false) {
                    maxIncome = item.getSumm();
                    nameOfMaxIncome = item.getName();
                }

            }
            System.out.println("Наибольшая трата " + nameOfMaxExpense + " - " + maxExpense);
            System.out.println("Наибольший доход " + nameOfMaxIncome + " - " + maxIncome);
        }
    }

    public void showExpenseAndInput() {

        for (Map.Entry<Integer, List<Item>> monthReport : monthReports.entrySet()) {

            System.out.println("\n" + "Месяц " + nameOfMonthes.getMonth()[monthReport.getKey()] + "\n");
            double expense = 0;
            double income = 0;

            for (Item item : monthReport.getValue()) {
                System.out.println(item.getName() + " " + item.getIsExpense() + " " + item.getPrise() + " " + item.getQuantity());

                boolean isExpense = item.getIsExpense();
                if (isExpense == true) {
                    expense = expense + item.getSumm();
                } else if (isExpense == false) {
                    income = income + item.getSumm();
                }
            }
            System.out.println("\n Затраты: " + expense + ";\n Доходы: " + income + "\n");
        }
    }

    public Map<Integer, MonthResult> rewriteMonth() {
        Map<Integer, MonthResult> rewritedMonthes = new HashMap<>();
        double monthExpense = 0;
        double monthIncome = 0;
        int iterator = 1;

        for (Map.Entry<Integer, List<Item>> monthReport : monthReports.entrySet()) {
            System.out.println("Пергоняем \n" + "Месяц " + nameOfMonthes.getMonth()[monthReport.getKey()] + "\n");

            for (Item item : monthReport.getValue()) {

                if (item.getIsExpense() == true) {
                    monthExpense = monthExpense + item.getSumm();
                } else if (item.getIsExpense() == false) {
                    monthIncome = monthIncome + item.getSumm();
                }
            }
            iterator++;

            rewritedMonthes.put(iterator, new MonthResult(iterator, monthExpense, monthIncome));
        }
        System.out.println("Перерзаписанный месячный отет "+rewritedMonthes.size());
        return rewritedMonthes;
    }

}