import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        monthReport monthReport = new monthReport();
        System.out.println("Введите год \n");
        int year;
        year = scanner.nextInt();
        YearReport yearReport = new YearReport(year);


        while (true) {
            printMenu();
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("Вы выбрали - 1 - Считать все месячные отчёты\n");
                    monthReport.readFileContentsOrNull();
                    break;

                case "2":
                    System.out.println("Вы выбрали - 2 - Считать годовой отчёт\n");

                    yearReport.readYearReport();

                    break;

                case "3":
                    System.out.println("Вы выбрали - 3 - Сверить отчеты\n");
                    Comparison comparison  = new Comparison(monthReport.rewriteMonth(), yearReport.readYearReport()); //
                    comparison.comparisonData();
                    break;

                case "4":
                    System.out.println("Вы выбрали - 4 - Вывести информацию о всех месячных отчетах\n");
                    monthReport.showExpenseAndInput();
                    monthReport.findMaxIncomeAndExpense();

                    break;

                case "5":
                    System.out.println("Вы выбрали - 5 - Вывести информацию о годовом отчете\n");
                    yearReport.showYearReport();

                    break;

                case "exit":
                    System.out.println("Программа завершена");
                    scanner.close();
                    return;
                default: System.out.println("Команда отсутствует");
            }
        }
    }
        private static void printMenu() {

            System.out.println("1 - Считать все месячные отчёты");
            System.out.println("2 - Считать годовой отчёт");
            System.out.println("3 - Сверить отчеты");
            System.out.println("4 - Вывести информацию о всех месячных отчетах");
            System.out.println("5 - Вывести информацию о годовом отчете");
            System.out.println("exit - Выход");
        }
    }

