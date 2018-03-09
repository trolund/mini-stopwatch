import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private JButton stopButton;
    private JButton startButton;
    private JButton resetButton;
    private JPanel jpanel;
    private JLabel timeLabel;
    private StopWatch stopWatch = new StopWatch();


    public static void main(String[] args) {
        JFrame frame = new JFrame("The mini stopWatch! 2018");
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
               // timeLabel.setText(stopWatch.toString());
            }
        });
    }

}
