import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class Graphic {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    Random randomData = new Random();
    private int randomNumber = randomData.nextInt(1, 100 + 1);
    Scanner scanner = new Scanner(System.in);
    private int userInput = scanner.nextInt();
    private boolean guessedCorrectly = false;
    private int attempts = 0;
    private int maxAttempts = 10;
    public Graphic(){
        frame = new JFrame("Number Guessing Game");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);


        mainPanel.add(createNumberChoosingPanel(), "ChooseNumber");
        mainPanel.add(createMessagePanel(), "Message");
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible((true));
        startNewGame();

    }
    private JPanel createNumberChoosingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });
        JButton cancelButtom = new JButton("Cancel");
        cancelButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(playButton, gbc);
        return null;
    }

    private void playGame() {
    }

    private Component createMessagePanel() {
        return null;
    }

    private void startNewGame() {
    }

}