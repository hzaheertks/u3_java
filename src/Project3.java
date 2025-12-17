import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.LocalTime;

public class Project3 {

    static String murderer = "Mr. Green";
    static JTextArea output;
    static ArrayList<String> collectedClues = new ArrayList<>();

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

    public static String RandomHint() {
        String[] hints = {"Green glove", "red ring", "purple pen"};
        return "Clue obtained: " + hints[(int)(Math.random() * hints.length)];
    }

    public static String clues(String suspect) {
        switch (suspect) {
            case "Mr. Green": return "Green glove";
            case "Ms. Scarlett": return "Red ring";
            case "Prof. Plum": return "purple pen";

        }
    }

    public static String interrogates() {
        String[] suspects = {"Mr. Green", "Ms. Scarlett", "Prof. Plum"};

        //Modifiied from: ChatGPT
        //Prompt: "How do I code the parameters for JOptionPane.showInputDialog?
        //Date accessed: 17 Dec
        String suspect = (String) JOptionPane.showInputDialog(
                null,
                "Who do you want to interrogate?",
                "Interrogate Suspect",
                JOptionPane.PLAIN_MESSAGE,
                null,
                suspects,
                suspects[0]

                //End of citaiton
        );

        if (suspect != null) {
            switch (suspect) {
                case "Mr. Green":
                    output.append("Mr. Green says he was in the kitchen at 11 pm\n");
                    break;
                case "Ms. Scarlett":
                    output.append("Ms. Scalett says Mr. Green was NOT in the kitchen\n");
                    break;
                case "Prof. Plum":
                    output.append("Prof. Plum says he say Ms. Scarlett in the library\n");
                    break;

        }

        String clue = clues(suspect);
            if (!collectedClues.contains(clue)) {
                collectedClues.add(clue);
                output.append("Clue obtained: " + clue + "\n");

            }

        }
    }
}
