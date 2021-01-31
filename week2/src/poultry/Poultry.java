package poultry;

public abstract class Poultry {
    private String kind_name;
    private String symptom;
    private int age;
    private String illness;

    public Poultry() {
    }

    public Poultry(String kind_name, String symptom, int age, String illness) {
        this.kind_name = kind_name;
        this.symptom = symptom;
        this.age = age;
        this.illness = illness;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getAge() {
        return age;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getKind_name() {
        return kind_name;
    }

    public String getIllness() {
        return illness;
    }

    public abstract void showSymptom();

    public void getMsg() {
        System.out.printf("动物种类:%s,年龄:%d\n", kind_name, age);
        System.out.printf("入院原因:%s\n", symptom);
    }
}
