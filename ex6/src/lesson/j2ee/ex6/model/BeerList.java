package lesson.j2ee.ex6.model;

import java.util.ArrayList;

/**
 * Created by Banixc on 2016/11/5.
 * 存储Beer的列表 继承ArrayList方便迭代
 */
public class BeerList extends ArrayList<Beer> {

    public void addBeer(String beer) {
        for (Beer b: this) {
            if(b.getName().equals(beer)) {
                b.num++;
                return;
            }
        }
        this.add(new Beer(beer));
    }

}
