public class MonthResult {
    int month;
    double expence;
    double income;
    //int year;

    public MonthResult(int month, Double expence, Double income) {
        this.month = month;
        this.expence = expence;
        this.income = income;
        //this.year=yaer;
    }



    public MonthResult(int iterator, double monthExpense, double monthIncome) {
    }

    public double getExpence() {
        return expence;
    }

    public void setExpence(String expence) {
        this.expence = Double.parseDouble(expence);
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = Double.parseDouble(income);
    }

    public int getMonth() { return month;
    }

    public void setMonth(int month) { this.month = month;
    }


}