package lesson.j2ee.ex6.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Banixc on 2016/11/5.
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
