import java.time.*;
import java.util.*;
import java.awt.*;
import java.text.*;

import javax.swing.*;

public class MonthYearView extends JPanel{

        Calendar cal = Calendar.getInstance();
        GridLayout layout = new GridLayout(0, 1);
        JLabel monthLabel;
        
    public MonthYearView(int yearIndex, int monthIndex){
        
        setLayout(layout);
        
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, yearIndex);
        cal.set(Calendar.MONTH, monthIndex);

        DateFormat df = new SimpleDateFormat("MMMM");
        Date date = cal.getTime();
        String labelCurrentMonth = df.format(date);
        monthLabel = new JLabel(labelCurrentMonth);
        add(monthLabel);

        
        YearMonth yearMonthObject = YearMonth.of(yearIndex, monthIndex + 1);
        int daysInMonth = yearMonthObject.lengthOfMonth() + 1;

        DayYearView[] CallsForDayYearView = new DayYearView[daysInMonth];

        for (int i = 1; i <  daysInMonth; i++){
            CallsForDayYearView[i] = new DayYearView(yearIndex, monthIndex, i);
            add(CallsForDayYearView[i]);
        }
    }
}
