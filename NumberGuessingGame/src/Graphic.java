import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Graphic {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private int randomNumber;
    private boolean guessedCorrectly;
    private int attempts;
    private final int maxAttempts = 10;
    private boolean cancelClicked = false;

    public Graphic() {
        frame = new JFrame("Number Guessing Game");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createNumberChoosingPanel(), "ChooseNumber");
        mainPanel.add(createMessagePanel(), "Message");
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
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
                cancelClicked = false; // Reset the cancel flag
                playGame();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                cancelClicked = true;
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(playButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(cancelButton, gbc);

        return panel;
    }

    private void playGame() {
        boolean validInput = false;
        int userInput = 0;
        while (!validInput && !cancelClicked) {
            String input = JOptionPane.showInputDialog(frame, "Enter your guess:");
            if (input == null) {
                cancelClicked = true;
                break;
            }
            try {
                userInput = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please try again.");
            }
        }
        if (cancelClicked) {
            return;
        }
        attempts++;
        if (userInput < randomNumber) {
            showMessage("Too low! Try again.", false);
        } else if (userInput > randomNumber) {
            showMessage("Too high! Try again.", false);
        } else {
            showMessage("Congratulations! You guessed the number in " + attempts + " attempts.", true);
            guessedCorrectly = true;
        }
        if (!guessedCorrectly && attempts >= maxAttempts) {
            showMessage("Sorry! You've used all the attempts. The number was " + randomNumber, true);
        }
    }

    private JPanel createMessagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(messageLabel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (guessedCorrectly || attempts >= maxAttempts) {
                    startNewGame();
                    cardLayout.show(mainPanel, "ChooseNumber");
                } else {
                    playGame(); // Directly start the game
                }
            }
        });
        panel.add(okButton, BorderLayout.SOUTH);

        return panel;
    }

    private void showMessage(String message, boolean gameEnded) {
        JLabel messageLabel1 = (JLabel) ((JPanel) mainPanel.getComponent(1)).getComponent(0);
        messageLabel1.setText(message);
        cardLayout.show(mainPanel, "Message");
    }

    private void startNewGame() {
        Random randomData = new Random();
        randomNumber = randomData.nextInt(100) + 1;
        attempts = 0;
        guessedCorrectly = false;
        cancelClicked = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graphic());
    }
}
