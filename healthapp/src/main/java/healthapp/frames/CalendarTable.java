package healthapp.frames;

import javax.swing.JLabel;
import javax.swing.JPanel;

import healthapp.models.UserData;
import healthapp.utilities.Requests;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarTable extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;

    private int s = 7;
    private LinkedList<JButton> days;
    private Calendar cal;
    private JButton addDate;
    private UserData curUser;

    /**
     * /** constructor
     * @param user userdata
     * @return nothing
     */
    public CalendarTable(UserData user) {
        this.curUser = user;
        setLayout(new GridLayout(0, 7, 15, 40));
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

        Map<String, Object> authStuff = new HashMap<String, Object>();
        authStuff.put("Uname", this.curUser.getUname());
        authStuff.put("Hash", this.curUser.getHash());
        Map<String, String> dates = Requests.send(authStuff, "PUT", "/ref");

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
                    day.setActionCommand(Integer.toString(dayCounter));
                    days.addLast(day);
                    this.add(days.getLast());
                    dayCounter++;
                }
            }
        }
        addDate = new JButton();
        addDate.add(new JLabel("Add a new event"));
        addDate.addActionListener(this);
        this.add(addDate);
        Date newDay = new Date(Long.parseLong(dates.get("RTime")));
        add(new JLabel("Last Temp\n: " + dates.get("Temp")));
        add(new JLabel("Last Pulse\n: " + dates.get("Pulse")));
        add(new JLabel("Last Weight\n: " + dates.get("Wght")));
        add(new JLabel("Last Systolic\n: " + dates.get("Sys")));
        add(new JLabel("Last Diastolic\n: " + dates.get("Dia")));
        add(new JLabel("Last time\n: " + newDay));
        setVisible(true);
    }

    /**
     * /** Method handles actions
     * @param e action
     * @return nothing
     */
    public void actionPerformed(ActionEvent e) {
        new DailyLogFrame(this.curUser.getHash(), e.getActionCommand());
    }

}
