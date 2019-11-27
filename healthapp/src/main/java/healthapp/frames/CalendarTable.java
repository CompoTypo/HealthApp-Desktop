package healthapp.frames;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CalendarPane
 */
public class CalendarTable extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    private int s = 7;
    private LinkedList<JButton> days;
    private Calendar cal;

    public CalendarTable() {
        setLayout(new GridLayout(0, 7, 20, 20));
        setSize(1500, 900);
        this.cal = new GregorianCalendar();
        int today = this.cal.get(Calendar.DATE);
        int daysInMonth = this.cal.getActualMaximum(Calendar.DATE);
        this.cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));
        int firstDay = this.cal.get(Calendar.DAY_OF_WEEK);

        System.out.println(today + " " + daysInMonth + " " + firstDay);
        this.add(new JLabel("Sunday"));
        this.add(new JLabel("Monday"));
        this.add(new JLabel("Tuesday"));
        this.add(new JLabel("Wednesday"));
        this.add(new JLabel("Thursday"));
        this.add(new JLabel("Friday"));
        this.add(new JLabel("Saturday"));


        days = new LinkedList<JButton>();
        int dayCounter = 1;
        for (int i = 0; i < s - 1; i++) {

            for (int j = 0; j < s && dayCounter <= daysInMonth; j++) {
                if (i == 0 && j < firstDay - 1) {
                    this.add(new JLabel(" "));
                } else {
                    JButton day = new JButton();
                    day.add(new JLabel(Integer.toString(dayCounter)));
                    if (dayCounter == today) {
                        day.setBackground(Color.CYAN);
                    } else {
                        day.setBackground(Color.LIGHT_GRAY);
                    }
                    
                    day.addActionListener(this);
                    days.addLast(day);
                    this.add(days.getLast());
                    dayCounter++;
                }
            }
        }
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        
    }

}

