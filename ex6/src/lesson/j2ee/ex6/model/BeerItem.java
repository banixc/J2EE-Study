package lesson.j2ee.ex6.model;

/**
 * Created by Banixc on 2016/11/5.
 * JavaBean: BeerItem
 * 用于存储从数据库中找到的Beer实体对象
 */
public class BeerItem {
    int id;

    String name;
    String color;
    String manufacturer;

    public BeerItem(int id, String name, String manufacturer, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
        System.out.println(id + ": " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //返回一个总的名称包含名字、类型、以及产地
    public String getAllName() {
        return "The " + name + " " + color + " beer of " + manufacturer;
    }
}
