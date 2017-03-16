package ru.testtask.trintiytest.stuff;

import ru.testtask.trintiytest.BaseApplication;
import org.joda.time.DateTime;
import ru.testtask.trintiytest.R;

public class Utils {

    /**
     * Возвращает окончание (год/года/лет) для указанного числа
     * @param age количество лет
     * @return
     */

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

    public static boolean dayIsYesterday(DateTime day) {
        DateTime yesterday = new DateTime().withTimeAtStartOfDay().minusDays(1);
        DateTime inputDay = day.withTimeAtStartOfDay();

        return inputDay.isEqual(yesterday);
    }
}
