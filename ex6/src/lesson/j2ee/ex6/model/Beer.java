package lesson.j2ee.ex6.model;

/**
 * Created by Banixc on 2016/11/5.
 * JavaBean Beer
 * 转换SessionList中的String为一个对象，合并重复部分为一个数字
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
