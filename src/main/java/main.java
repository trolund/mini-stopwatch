import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class main {
    private static JFrame frame;
    private JButton stopButton;
    private JButton startButton;
    private JButton resetButton;
    private JPanel jpanel;
    private JLabel timeLabel;
    private JCheckBox alwaysOnTopCheckBox;
    private StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) {
        frame = new JFrame("The mini stopWatch! 2018 V0.2");
        frame.setContentPane(new main().jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public main() {

        final javax.swing.Timer timer = new Timer(90, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timeLabel.setText(stopWatch.elapsedTime()+ "");
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText("00:00:00");
                timer.stop();
            }
        });
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopWatch.start();
                timer.start();
            }
        });

        alwaysOnTopCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) { //checkbox has been selected
                    frame.setAlwaysOnTop(true);
                } else {//checkbox has been deselected
                    frame.setAlwaysOnTop(false);
                };
            }
        });
    }

}
