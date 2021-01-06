/**
 * 父类
 * @author marco
 */
public class Person {
    private String account;
    private String password;
    private int isContestant;
    private String name;
    private String sex;
    private int age;

    public Person(String account,String password,int isContestant,String name, String sex, int age) {
        this.account = account;
        this.password = password;
        this.isContestant = isContestant;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    String getAccount(){
        return account;
    }

    int getIsContestant(){
        return isContestant;
    }

    void setPassword(String password){
        this.password = password;
    }

    String getPassword(){
        return this.password;
    }

    public int showOperationsAndSelect(){ return 0;}

}
