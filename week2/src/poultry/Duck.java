package poultry;

public class Duck extends Poultry {
    public Duck(String kind_name, String symptom, int age, String illness) {
        super(kind_name, symptom, age, illness);
    }

    public Duck() {
    }

    @Override
    public void getMsg() {
        super.getMsg();
        showSymptom();
    }

    @Override
    public void showSymptom() {
        System.out.printf("症状:%s\n", getSymptom());
    }
}
