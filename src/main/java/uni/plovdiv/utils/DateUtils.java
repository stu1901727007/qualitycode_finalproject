package uni.plovdiv.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility class about DateTime
 */
public class DateUtils {

    /**
     * Gets current date time
     *
     * @return Current date time as Date object
     */
    static public Date Time()
    {
        return Calendar.getInstance().getTime();
    }

}
