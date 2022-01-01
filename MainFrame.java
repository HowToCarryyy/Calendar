import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame{

    JButton view;
    JPanel viewPanel = new JPanel();
    JPanel mainPanel = new JPanel();

    String currentView = "YearView";

    YearView yv;
    MonthView mv;

    public MainFrame(){

        view = new JButton("Month View");
        viewPanel.add(view);
        mainPanel.add(viewPanel);
        
        yv = new YearView();
        mainPanel.add(yv);

        add(mainPanel);
        setVisible(true);
        setTitle("Calendar V2.0");
        setSize(1920, 1080);

        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (currentView == "YearView"){
                    mv = new MonthView();
                    mainPanel.remove(yv);
                    repaint();
                    mainPanel.add(mv);
                    repaint();
                    view.setText(currentView);
                    currentView = "MonthView";
                } else if (currentView == "MonthView") {
                    yv = new YearView();
                    mainPanel.remove(mv);
                    repaint();
                    mainPanel.add(yv);
                    repaint();
                    view.setText(currentView);
                    currentView = "YearView";
                }
            }
            
        });
    }
    
    public static void main(String[]args){
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
