import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Comparison {
    Map<Integer, MonthResult> rewritedMonthes;// = new HashMap<>();
    Map<Integer, MonthResult> yearData;// = new HashMap<>();
    NameOfMonthes nameOfMonthes = new NameOfMonthes();


    public Comparison(Map<Integer, MonthResult> rewritedMonthes, Map<Integer, MonthResult> yearData) {

        this.rewritedMonthes = rewritedMonthes;
        this.yearData = yearData;
    }

    public void comparisonData() {
        if(rewritedMonthes.size()==yearData.size()) {
            for (int i = 1; i <= rewritedMonthes.size(); i++) {
                if (rewritedMonthes.get(i).getExpence() == yearData.get(i).getExpence() && rewritedMonthes.get(i).getIncome() == yearData.get(i).getIncome()) {
                    System.out.println(nameOfMonthes.getMonth()[i] + " - Данные совпадают");
                } else {
                    System.out.println(nameOfMonthes.getMonth()[i] + " - Данные не совпадают");
                }
            }
        }else if(rewritedMonthes.size()<yearData.size()){
            System.out.println("Не все даные из месячных отчетов загружены"+" Годовой отчет - длина "+yearData.size()+" Месячные отчеты - длина "+ rewritedMonthes.size());
        }else{
            System.out.println("Не все даные из годового отчетов загружены"+" Годовой отчет - длина "+yearData.size()+" Месячные отчеты - длина"+ rewritedMonthes.size());
        }
    }
}

