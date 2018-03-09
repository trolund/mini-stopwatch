import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    private static JFrame frame;
    private JButton stopButton;
    private JButton startButton;
    private JButton resetButton;
    private JPanel jpanel;
    private JLabel timeLabel;
    private JCheckBox alwaysOnTopCheckBox;
    private JTextField textField1;
    private JLabel status;
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

        textField1.setText(timer.getDelay()+"");

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

        textField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
                  if (textField1.getText() != "") {
                      timer.setDelay(Integer.parseInt(textField1.getText()));
                      status.setText("update frekvens is now: " + textField1.getText());
                  }
              }catch (NumberFormatException e1){
                  status.setText("That is not an integer!");
              }
            }
        });
    }

}
