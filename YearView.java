import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class YearView extends JPanel {

        MonthYearView[] myvList = new MonthYearView[12];

        Calendar cal = Calendar.getInstance();
        
        
        JButton[] switches = new JButton[2];
        JLabel currentYear;

        JPanel panelYearSwitch = new JPanel();
        JPanel panelMonths = new JPanel();
        int chosenYear;

    public YearView() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        panelMonths.setLayout(new BoxLayout(panelMonths, BoxLayout.X_AXIS));

        int currentYearCalendar = cal.get(Calendar.YEAR);
        chosenYear = currentYearCalendar;


        switches[0] = new JButton("<");
        currentYear = new JLabel(""+currentYearCalendar);
        switches[1] = new JButton(">");

        panelYearSwitch.add(switches[0]);
        panelYearSwitch.add(currentYear);
        panelYearSwitch.add(switches[1]);
        add(panelYearSwitch);

        initMonths();

        switches[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenYear--;
                currentYear.setText(""+chosenYear);
                changeMonths();
            }
            
        });

        switches[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenYear++;
                currentYear.setText(""+chosenYear);
                changeMonths();
            }
            
        });

    }

    public void initMonths(){
        for (int i = 0; i < myvList.length; i++){
            myvList[i] = new MonthYearView(chosenYear, i);
            panelMonths.add(myvList[i]);
        }
        add(panelMonths);
    }

    public void changeMonths(){
        for (int i = 0; i < myvList.length; i++){
            panelMonths.remove(myvList[i]);
        }
        initMonths();
    }

}
