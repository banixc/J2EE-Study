package lesson.j2ee.ex6.model;

/**
 * Created by Banixc on 2016/11/5.
 */
public class Beer {
    String name;
    int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Beer(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Beer(String name) {
        this.name = name;
        this.num = 1;
    }

}
