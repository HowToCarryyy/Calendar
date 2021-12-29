import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class DayYearView extends JButton {

    Calendar cal = Calendar.getInstance();
    Calendar currentCal = Calendar.getInstance();

    public DayYearView(int yearIndex, int monthIndex, int dayOfMonthIndex) {

        setPreferredSize(new Dimension(1920 / 15, 20));

        int currentYear = currentCal.get(Calendar.YEAR);
        int currentMonth = currentCal.get(Calendar.MONTH);
        int currentDayOfMonth = currentCal.get(Calendar.DAY_OF_MONTH);

        if (currentMonth == monthIndex && currentDayOfMonth == dayOfMonthIndex) {
            if (currentYear == yearIndex) {
                this.setBackground(Color.RED);
            } else {
                this.setBackground(Color.GRAY);
            }
        }
             

        cal.set(Calendar.YEAR, yearIndex);
        cal.set(Calendar.MONTH, monthIndex);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonthIndex);

        DateFormat df = new SimpleDateFormat("EEE, d. yyyy");
        Date date = cal.getTime();
        String buttonLabelCurrentDate = df.format(date);

        this.setText(buttonLabelCurrentDate);
    }
}
