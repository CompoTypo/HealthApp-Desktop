package healthapp.frames;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * CalendarPane
 */
public class CalendarPane extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel sun, m, t, w, th, f, sat;
    private int s = 7;
    private Calendar cal;

    CalendarPane() {
        setLayout(new GridLayout(7, 7, 20, 20));
        setSize(1500, 900);
        this.cal = new GregorianCalendar();
        int today = this.cal.get(Calendar.DATE);
        int daysInMonth = this.cal.getActualMaximum(Calendar.DATE);
        this.cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));
        int firstDay = this.cal.get(Calendar.DAY_OF_WEEK);

        System.out.println(today + " " + daysInMonth + " " + firstDay);
        this.sun = new JLabel("Sunday");
        this.m = new JLabel("Monday");
        this.t = new JLabel("Tuesday");
        this.w = new JLabel("Wednesday");
        this.th = new JLabel("Thursday");
        this.f = new JLabel("Friday");
        this.sat = new JLabel("Saturday");
        this.add(this.sun);
        this.add(this.m);
        this.add(this.t);
        this.add(this.w);
        this.add(this.th);
        this.add(this.f);
        this.add(this.sat);


        int dayCounter = 1;
        boolean monthStarted = false;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s && dayCounter <= daysInMonth; j++) {
                if (i == 0 && j == firstDay - 1) {
                    this.add(new JLabel(Integer.toString(dayCounter++)));
                    monthStarted = true;
                } else if (monthStarted) {
                    this.add(new JLabel(Integer.toString(dayCounter++)));
                } else {
                    this.add(new JLabel(" "));
                }
            }
        }
        setVisible(true);

    }

}