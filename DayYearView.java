import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class DayYearView extends JButton {

    Calendar cal = Calendar.getInstance();
    Calendar currentCal = Calendar.getInstance();

    int currentYear;
    int currentMonth;
    int currentDayOfMonth;

    int yearIndex;
    int monthIndex;
    int dayOfMonthIndex;

    String buttonLabelCurrentDate;

    public DayYearView(int _yearIndex, int _monthIndex, int _dayOfMonthIndex) {

        yearIndex = _yearIndex;
        monthIndex = _monthIndex;
        dayOfMonthIndex = _dayOfMonthIndex;

        setPreferredSize(new Dimension(1920 / 15, 20));

        currentYear = currentCal.get(Calendar.YEAR);
        currentMonth = currentCal.get(Calendar.MONTH);
        currentDayOfMonth = currentCal.get(Calendar.DAY_OF_MONTH);

        markCurrentDay();

        cal.set(Calendar.YEAR, yearIndex);
        cal.set(Calendar.MONTH, monthIndex);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonthIndex);

        setTextButtonLabelCurrentDate();
        this.setText(buttonLabelCurrentDate);
    }

    public void markCurrentDay(){
        if (currentMonth == monthIndex && currentDayOfMonth == dayOfMonthIndex) {
            if (currentYear == yearIndex) {
                this.setBackground(Color.RED);
            } else {
                this.setBackground(Color.GRAY);
            }
        }
    }
    public void setTextButtonLabelCurrentDate(){
        DateFormat df = new SimpleDateFormat("EEE, d. yyyy");
        Date date = cal.getTime();
        buttonLabelCurrentDate = df.format(date);
    }
}
