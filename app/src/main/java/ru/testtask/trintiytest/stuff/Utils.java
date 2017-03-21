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
        return BaseApplication.getInstance().getApplicationContext().getResources().getQuantityString(R.plurals.years, age);
    }

    public static boolean dayIsYesterday(DateTime day) {
        DateTime yesterday = new DateTime().withTimeAtStartOfDay().minusDays(1);
        DateTime inputDay = day.withTimeAtStartOfDay();

        return inputDay.isEqual(yesterday);
    }
}
