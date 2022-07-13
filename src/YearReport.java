import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class YearReport {

    Map<Integer, MonthResult> yearData = new HashMap<Integer, MonthResult>();

int year;
       NameOfMonthes nameOfMonthes = new NameOfMonthes();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public YearReport(int year) {
        this.year = year;
    }




    public Map<Integer, MonthResult> readYearReport() {
        List<Double> yearIncome = new ArrayList();
        List<Double> yearExpense = new ArrayList();

        Scanner scanner;
        System.out.println("Начинаю считывание годовых отчетов");
        String address = "resources/y."+year+".csv";
        File file = new File(address);
        int iter = 0;
        try {
          scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String razdel = ",";
                if (iter == 0) {
                    iter++;
                    continue;
                }
                if ((line.split(razdel)[2]).equals("false")) {
                    yearIncome.add(Double.parseDouble(line.split(razdel)[1]));
                }
                if ((line.split(razdel)[2]).equals("true")) {
                    yearExpense.add(Double.parseDouble(line.split(razdel)[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файлы для считывания не обнаружены");
            e.printStackTrace();
        }

        for (int i = 1; i <= yearIncome.size(); i++) {
            yearData.put(i, new MonthResult(i ,yearExpense.get(i - 1), yearIncome.get(i - 1)));
        }
        System.out.println("Считывание файла с годовым отчетом выполнено");
        System.out.println("Годовой отчет "+yearData.size());

        return yearData;

    }

    public void showYearReport() {

        double averageIncome = 0;
        double averageExpence = 0;
        int iterator = 1;

        for (Map.Entry<Integer, MonthResult> year : yearData.entrySet()) {
            System.out.println(ANSI_BLUE + nameOfMonthes.getMonth()[iterator] + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Доходы " + year.getValue().getIncome() + ANSI_RESET);
            System.out.println(ANSI_RED + "Затраты " + year.getValue().getExpence() + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Прибыль " + (year.getValue().getIncome() - year.getValue().getExpence())  + ANSI_RESET+"\n");

            averageIncome = (averageIncome + year.getValue().getIncome()) / yearData.size();
            averageExpence = (averageExpence + year.getValue().getExpence()) / yearData.size();
            iterator = iterator + 1;
        }
        System.out.println("Средний доход " + averageIncome);
        System.out.println("Средний расход " + averageExpence);
    }

}