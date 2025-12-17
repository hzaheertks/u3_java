import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.LocalTime;

public class Project3 {


    ///  ADD METHODS HEREIUQWJKAFDNSIAWBJRKSGFND,IPERABSFJKDN
    public static void main(String[] args) {
        JFrame frame =  new JFrame("Murder Mysery!");
        frame.setSize(700,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea output = new JTextArea();

        //  intro:
        LocalTime now = LocalTime.now();
        output.append("CASE FILE #2211\n");
        output.append("From detective Sergeant Tellez\n");
        output.append("To detective... YOU!\n");
        output.append("A body was found at 11.42 pm\n");
        output.append("Current time: " + now + "\n");
        output.append("Everyone had a reason\n");
        output.append("You have ONE chance only to find the killer...");

        JButton interrogate = new JButton("1. Interrogate suspects");
        JButton clue = new JButton("2. View clues");
        JButton accusation = new JButton("3. Make accusation");

        JPanel buttons = new JPanel();
        buttons.add(interrogate);
        buttons.add(clue);
        buttons.add(accusation);


        frame.add(output);
        frame.add(buttons, "South");
        frame.setVisible(true);

        interrogate.addActionListener(click -> interrogates());
        clue.addActionListener(click -> clues());
        accusation.addActionListener(click -> accusations());

        
    }
}
