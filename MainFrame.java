import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame(){
        YearView yv = new YearView();
        add(yv);
        setVisible(true);
        setTitle("Calendar V2.0");
        setSize(1920, 1080);
    }   
    public static void main(String[]args){
        new MainFrame();
    }
    // FEBRUAR FUNKTIONIERT NICHT IN ALLEN JAHREN, NUR IN SCHALTJAHREN                                                                                                                                                                                                                                                                        
}
