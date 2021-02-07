package uni.plovdiv.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * Gets current date time
     * @return Surrent date time as Date object
     */
    static public Date Time()
    {
        return Calendar.getInstance().getTime();
    }

}
