import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Whack-a-mole Game.
 * @author Meng Li
 */
public class Game  extends JFrame implements ActionListener {
        /**
         * Serial version.
         */
        private static final long serialVersionUID = 1L;
        /**
         * Up string constant.
         */
        private static final String UP_STRING = " :-) ";
        /**
         * Down string constant.
         */
        private static final String DOWN_STRING = "     ";
        /**
         * Hit string constant.
         */
        private static final String HIT_STRING = " :-( ";
        /**
         * Down color constant.
         */
        private static final Color DOWN_COLOR = Color.LIGHT_GRAY;
        /**
         * Up color constant.
         */
        private static final Color UP_COLOR = Color.GREEN;
        /**
         * Hit color constant.
         */
        private static final Color HIT_COLOR = Color.RED;

        /**
         * Array of buttons to show on and off.
         */
        private JButton[] buttons;
        /**
         * Reference to the start button.
         */
        private JButton startButton;
        /**
         * Reference to the time left text field.
         */
        private JTextField time;
        /**
         * Reference to the score text field.
         */
        private JTextField score;

        /**
         * Constructor.
         * The class itself is a sub class of JFrame here.
         */
        public Game() {
            super("Whack-a-mole Game");
            setSize(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            FlowLayout flow = new FlowLayout(FlowLayout.CENTER);

            JPanel pane = new JPanel();
            pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

            JPanel line1 = new JPanel();
            line1.setLayout(flow);
            Font font = new Font(Font.MONOSPACED, Font.BOLD, 13);
            Font bigFont = new Font(Font.DIALOG, Font.PLAIN, 14);

            startButton = new JButton("Start");
            startButton.setFont(bigFont);
            startButton.setFocusPainted(false);
            line1.add(startButton);
            startButton.addActionListener(this);

            time = new JTextField(5);
            JLabel label1 = new JLabel("Time Left:");
            label1.setFont(bigFont);
            line1.add(label1);
            line1.add(time);
            time.setEditable(false);
            time.setBackground(Color.WHITE);
            time.addActionListener(this);

            score = new JTextField(5);
            score.setEditable(false);
            score.setBackground(Color.WHITE);
            JLabel label2 = new JLabel("Score:");
            label2.setFont(bigFont);
            line1.add(label2);
            line1.add(score);
            score.addActionListener(this);

            buttons = new JButton[12];
            for (int i = 0; i < 12; i++) {
                // initially, set every button to down
                buttons[i] = new JButton(DOWN_STRING);
                buttons[i].setBackground(DOWN_COLOR);
                buttons[i].setOpaque(true);
                buttons[i].setFont(font);
                buttons[i].setFocusPainted(false);
                buttons[i].addActionListener(this);
            }

            JPanel line2 = new JPanel();
            line2.setLayout(flow);
            for (int i = 0; i < 4; i++) {
                // initially, set every button to down
                line2.add(buttons[i]);
            }

            JPanel line3 = new JPanel();
            line3.setLayout(flow);
            for (int i = 4; i < 8; i++) {
                // initially, set every button to down
                line3.add(buttons[i]);
            }

            JPanel line4 = new JPanel();
            line4.setLayout(flow);
            for (int i = 8; i < 12; i++) {
                // initially, set every button to down
                line4.add(buttons[i]);
            }

            pane.add(line1);
            pane.add(line2);
            pane.add(line3);
            pane.add(line4);

            setContentPane(pane);
            setVisible(true);
        }

        /*
         * Method to be invoked when buttons are clicked.
         * @param event event object
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == startButton) {
                startButton.setEnabled(false);
                Thread  tm = new TimeThread(time, startButton);
                tm.start();
                score.setText("0");
                for (int i = 0; i < 12; i++) {
                    buttons[i].setEnabled(true);
                    MyRunnable r = new MyRunnable(buttons[i], time);
                    Thread t = new Thread(r);
                    t.start();
                 }
                return;
            }

            for (int i = 0; i < 12; i++) {
                if (event.getSource() == buttons[i]) {
                buttonHit(buttons[i]);
            }
            }
        }

        /**
         * Hit buttons.
         * @param b button[i]
         */
        private void buttonHit(JButton b) {
            if (time.getText().equals("0")) {
               return;
            }

            if (time.getText().equals("")) {
                return;
             }

            if (b.getText().equals(UP_STRING)) {
                synchronized (this) {
                int a = Integer.parseInt(score.getText());
                a = a + 1;
                score.setText(Integer.toString(a));
                b.setText(HIT_STRING);
                b.setBackground(HIT_COLOR);
                }
            }
        }

        /**
         * static nested class that implement Runnable.
         * @author Meng Li
         */
        private static class MyRunnable implements Runnable {
            /**
             * my button.
             */
            private JButton mybutton;
            /**
             * my time.
             */
            private JTextField myTime;
            /**
             * Random object to pick a button from the array.
             */
            private Random random = new Random();
            /**
             * my finished.
             */
            private boolean finished = false;

            /**
             * Constructor with sleep time and text are to display values.
             * @param button button
             * @param time time
             */
            MyRunnable(JButton button, JTextField time) {
                this.mybutton = button;
                this.myTime = time;
            }

            /**
             * Implementation of run method of Runnable Interface.
             */
            @Override
            public void run() {
                try {
                    while (!finished) {
                        int sleepTime = random.nextInt(3500) + 500;
                            mybutton.setText(UP_STRING);
                            mybutton.setBackground(UP_COLOR);
                            Thread.sleep(sleepTime);
                            mybutton.setText(DOWN_STRING);
                            mybutton.setBackground(DOWN_COLOR);
                            Thread.sleep(2500);
                            synchronized (myTime) {
                            if (myTime.getText().equals("0")) {
                                finished = true;
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /**
         * static nested class that extends Thread.
         * @author Meng Li
         */
        private static class TimeThread extends Thread {
            /**
             * my time.
             */
            private JTextField myTime;
            /**
             * my start.
             */
            private JButton myStart;

            /**
             * Constructor.
             * @param start start
             * @param time time
             */
            TimeThread(JTextField time, JButton start) {
                this.myTime = time;
                this.myStart = start;
            }

            /**
             * Implement run method of Thread class.
             */
            @Override
            public void run() {
                try {
                    int count = 20;
                    while (count != -1) {
                        synchronized (myTime) {
                            myTime.setText(Integer.toString(count));
                        }
                        count = count - 1;
                        Thread.sleep(1000);
                    }
                    Thread.sleep(4000);
                    myStart.setEnabled(true);
                } catch (InterruptedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /**
         * Program to start the game.
         * @param args arguments
         */
        public static void main(String[] args) {
            new Game();
        }
}
