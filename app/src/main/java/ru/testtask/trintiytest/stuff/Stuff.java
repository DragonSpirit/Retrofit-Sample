package ru.testtask.trintiytest.stuff;

import ru.testtask.trintiytest.BaseApplication;
import ru.testtask.trintiytest.R;
/**
 * Created by nfedorov online 16.03.17.
 */

public class Stuff {
    public static String age2string(int age) {
        String[] ages = BaseApplication.getInstance().getResources().getStringArray(R.array.ages);
        age = age % 100;
        if (age > 19)
            age = age % 10;
        switch (age) {
            case 1:
                return (ages[0]);
            case 2: case 3: case 4:
                return (ages[1]);
            default:
                return (ages[2]);
        }
    }
}
