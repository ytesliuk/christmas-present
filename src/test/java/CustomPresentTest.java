import com.present.model.entities.presents.CustomPresent;
import com.present.model.entities.present_items.IPresentItem;
import com.present.model.entities.presents.Present;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
class CustomPresentTest {
    static List<IPresentItem> items;
    Present present;

    @BeforeAll
    static void resourceInitialization(){
        items = new ArrayList<>();
//        items.add(new Sweety("ромашка",50,10));
//        items.add(new Sweety("гвоздичка",45,0));
//        items.add(new Sweety("незабудка",30,14));
//        items.add(new Sweety("одуванчик",38,5));
    }


    @BeforeEach
    void setUp(){
        present = new CustomPresent();
    }

    @Test
    void addToPresent() {
//        assertTrue(present.addToPresent(items.get(0),5));
//        assertTrue(present.addToPresent(items.get(1),2));
//        assertTrue(present.addToPresent(items.get(2),2));
//        assertFalse(present.addToPresent(items.get(3),3));

    }
}