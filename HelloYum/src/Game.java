import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Chio nun
 *
 */
public class Game implements ActionListener {
    /**
     * Reference to startButton.
     */
    private JButton startButton;
    /**
     * Reference to timeField TextArea.
     */
    private JTextArea timeField;
    /**
     * Reference to scoreField TextArea.
     */
    private JTextArea scoreField;
    /**
     * Refence to JButton Array.
     */
    private JButton[] buttons;
    /**
     * Hit color constant.
     */
    private static final Color HIT_COLOR = Color.RED;
    /**
     * up color constant.
     */
    private static final Color UP_COLOR = Color.GREEN;
    /**
     * down color constant.
     */
    private static final Color DOWN_COLOR = Color.GRAY;
    /**
     * global varaible.
     */
    private int score;
    /**
     * global variable.
     */
    private int count;


    /**
     * constructor.
     */
    public Game() {
        //initialize score.
        score = 0;
        //create a window.
        JFrame fr = new JFrame("Whack-a-mole");
        fr.setSize(400, 250);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creat and layout panels.
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        JPanel pane = new JPanel();
        BoxLayout box = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(box);

        //create start,time and scores.
        JPanel line1 = new JPanel();
        line1.setLayout(flow);
        startButton = new JButton("Start");
        startButton.addActionListener(this);


        JLabel timeLabel = new JLabel("Time Left:");

        timeField = new JTextArea(1, 5);

        JLabel scoreLabel = new JLabel("Score:");

        scoreField = new JTextArea(1, 5);
        scoreField.setText("0");

        line1.add(startButton);
        line1.add(timeLabel);
        line1.add(timeField);
        line1.add(scoreLabel);
        line1.add(scoreField);

        //create holes.
        JPanel line2 = new JPanel();
        line2.setLayout(flow);
        JPanel line3 = new JPanel();
        line3.setLayout(flow);
        JPanel line4 = new JPanel();
        line4.setLayout(flow);
        buttons = new JButton[12];
        for (int i = 0; i < buttons.length; i++) {
            // initially, set every button to OFF
            buttons[i] = new JButton("   ");
            buttons[i].setBackground(DOWN_COLOR);
            buttons[i].setOpaque(true);
            buttons[i].addActionListener(this);
        }
        for (int i = 0; i < 4; i++) {
            line2.add(buttons[i]);
        }
        for (int i = 4; i < 8; i++) {
            line3.add(buttons[i]);
        }
        for (int i = 8; i < 12; i++) {
            line4.add(buttons[i]);
        }

        pane.add(line1);
        pane.add(line2);
        pane.add(line3);
        pane.add(line4);

        fr.setContentPane(pane);
        fr.setVisible(true);

    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            count = 20;
            TimerThread t = new TimerThread();
            t.start();
            for (int i = 0; i < 12; i++) {
                ButtonThread[] tButtons = new ButtonThread[12];
                tButtons[i] = new ButtonThread(buttons[i]);
                tButtons[i].start();
            }
        }
        for (int i = 0; i < 12; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getBackground() == UP_COLOR) {
                    if (count > 0) {
                        buttons[i].setBackground(HIT_COLOR);
                        score = score + 1;
                        scoreField.setText(String.valueOf(score));
                    }
                    buttons[i].setText("   ");
                }
            }
        }
    }
    /**
     * @author Chio nun
     * class of TimerThread
     *
     */
    private class TimerThread extends Thread {
        /**
         * @Overide run method.
         */
          public void run() {
                  timeField.setText(String.valueOf(count));
                  try {
                      while (count > 0) {
                          Thread.currentThread();
                          Thread.sleep(1000);
                          count = count - 1;
                          timeField.setText(String.valueOf(count));
                      }
                  } catch (InterruptedException e1) {
                      // TODO Auto-generated catch block
                      e1.printStackTrace();
                  }
                  try {
                    Thread.currentThread();
                    Thread.sleep(5000);
                  } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                  }

                  startButton.setEnabled(true);
                  score = 0;
                  scoreField.setText(String.valueOf(score));
          }
    }

    /**
     * @author Chio nun
     *
     */
    private class ButtonThread extends Thread {
        /**
         * random pop time.
         */
        private Random randompop = new Random();
        /**
         * random down time.
         */
        private Random randomdown = new Random();
        /**
         * Reference to myButton.
         */
        private JButton myButton = new JButton();
        /**
         * sleeptime for pop delay.
         */
        private long sleeptime1;
        /**
         * sleeptime for down delay.
         */
        private long sleeptime2;
        /**
         * constructor.
         * @param button button.
         */
        private ButtonThread(JButton button) {
            this.myButton = button;
        }
        /**
         * @Overide run method.
         */
        public void run() {
            try {
                while (count > 0) {
                    sleeptime1 = 1000 + randompop.nextInt(3000);
                    sleeptime2 = 2000 + randomdown.nextInt(1800);
                    if (this.myButton.getBackground() == DOWN_COLOR) {
                        if (count != 0) {
                            this.myButton.setBackground(UP_COLOR);
                            Thread.currentThread();
                            Thread.sleep(sleeptime1);
                        }
                    } else {
                        this.myButton.setBackground(DOWN_COLOR);
                        Thread.currentThread();
                        Thread.sleep(sleeptime2);
                    }
                }
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            myButton.setBackground(DOWN_COLOR);
        }
    }
    /**
     * @param args input string.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Game();
    }

}

