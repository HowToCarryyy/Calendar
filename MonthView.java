import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MonthView extends JPanel{

        Calendar cal = Calendar.getInstance();

        GridLayout layout = new GridLayout(6, 1);

        int originalMonth;
        int currentDayOfMonth;
        int currentWeekOfYear;
        int currentMonth;
        int currentYear;

        int changingWeekOfYear;

        JButton[] switches = new JButton[2];
        JLabel currentMonthLabel;

        JPanel panelMonthSwitch = new JPanel();
        JPanel panelWeeks = new JPanel();

        WeekMonthView[] wmv = new WeekMonthView[6];

    public MonthView(){

        panelWeeks.setLayout(layout);

        switches[0] = new JButton("<");
        currentMonthLabel = new JLabel(""+(cal.get(Calendar.MONTH)+1));
        switches[1] = new JButton(">");

        panelMonthSwitch.add(switches[0]);
        panelMonthSwitch.add(currentMonthLabel);
        panelMonthSwitch.add(switches[1]);
        add(panelMonthSwitch);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        currentWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        currentYear = cal.get(Calendar.YEAR);



        initWeeks();

        actionListenerSwitches();
    }

    public void changingMonths(int changingValue){
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+changingValue);
        cal.set(Calendar.DAY_OF_MONTH, 1);
    }

    public void checkingForBreakingPoint(){
        if (cal.get(Calendar.DAY_OF_WEEK) == 2) currentWeekOfYear--;
        if (currentWeekOfYear == 52 && cal.get(Calendar.MONTH) == 0) currentYear--;
    }

    public void initWeeks(){
        checkingForBreakingPoint();
        originalMonth = cal.get(Calendar.MONTH);
        currentWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        currentYear = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.WEEK_OF_YEAR, currentWeekOfYear);



        currentMonth = cal.get(Calendar.MONTH);
        currentDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        changingWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);

        for (int i = 0; i < 6; i++){
            System.out.println(cal.get(Calendar.MONTH));
            wmv[i] = new WeekMonthView(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), changingWeekOfYear);
            panelWeeks.add(wmv[i]);
            changingWeekOfYear++;
        }
        add(panelWeeks);
        cal.set(Calendar.MONTH, originalMonth);
    }

    public void actionListenerSwitches() {
        switches[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                currentMonthLabel.setText(""+(cal.get(Calendar.MONTH)+1));
                changeMonths();
            }
            
        });

        switches[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                currentMonthLabel.setText(""+(cal.get(Calendar.MONTH)+1));
                changeMonths();
            }
            
        });
    }

    public void changeMonths(){
        for (int i = 0; i < 6; i++){
            panelWeeks.remove(wmv[i]);
        }
        initWeeks();
    }
}