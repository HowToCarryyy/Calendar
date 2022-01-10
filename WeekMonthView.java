import java.util.*;
import javax.swing.*;

public class WeekMonthView extends JPanel {

    Calendar cal = Calendar.getInstance();

    int originalDayOfMonth;

    public WeekMonthView(int _yearIndex, int _originalMonthIndex, int _weekOfYearIndex){

        cal.clear();

        cal.set(Calendar.YEAR, _yearIndex);
        cal.set(Calendar.WEEK_OF_YEAR, _weekOfYearIndex);
        originalDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        for (int i = 1; i <= 7; i++) {
            boolean thisMonth = true;
            if (cal.get(Calendar.MONTH) == 0 /** hier muss noch der jetzige Monat eingefügt werden */){
                thisMonth = true;
            } else {
                thisMonth = false;
            }
            DayMonthView dmv = new DayMonthView(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), thisMonth);
            add(dmv);
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        }
    }
}
