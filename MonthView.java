import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MonthView extends JPanel{

    Calendar cal = Calendar.getInstance();
    
    GridLayout layout = new GridLayout(1, 0);

    public MonthView(){

        cal.set(Calendar.DAY_OF_WEEK, 1);

        DayMonthView dmv = new DayMonthView();
        add(dmv);
    }
}