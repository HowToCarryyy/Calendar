import java.awt.Color;
import java.text.*;
import java.util.*;

import javax.swing.*;

public class DayMonthView extends JButton {

        String buttonLabelCurrentDate;
        Calendar cal = Calendar.getInstance();

        int yearIndex;
        int monthIndex;
        int dayOfMonthIndex;
        boolean thisMonth;

    public DayMonthView(int _yearIndex, int _monthIndex, int _dayOfMonthIndex, boolean _thisMonth){
        yearIndex = _yearIndex;
        monthIndex = _monthIndex;
        dayOfMonthIndex = _dayOfMonthIndex;
        thisMonth = _thisMonth;

        cal.set(Calendar.YEAR, yearIndex);
        cal.set(Calendar.MONTH, monthIndex);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonthIndex);

        setTextButtonLabelCurrentDate();
        markInThisMonth();
    }

    public void setTextButtonLabelCurrentDate(){
        DateFormat df = new SimpleDateFormat("EEE, dd. MM yyyy");
        Date date = cal.getTime();
        buttonLabelCurrentDate = df.format(date);
        this.setText(buttonLabelCurrentDate);
    }

    public void markInThisMonth(){
        if (!thisMonth) this.setBackground(Color.GRAY);
    }
}
