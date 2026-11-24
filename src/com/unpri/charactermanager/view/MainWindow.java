
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    // Constructor menerima data karakter dan rata-rata level
    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        super("Character Manager v0.3");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Membuat komponen GUI
    private void initComponents() {

        mainPanel = new JPanel(new BorderLayout(10, 10));

        // BAGIAN ATAS: Judul
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ==="
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(
            BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // BAGIAN TENGAH: Daftar karakter
        JPanel listPanel = new JPanel(
            new GridLayout(0, 1, 5, 5)
        );

        for (Character c : characterList) {

            String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP: " + c.getHitPoints()
                    + " | ATK: " + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);

            characterLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
            );

            listPanel.add(characterLabel);
        }

        mainPanel.add(listPanel, BorderLayout.CENTER);

        // BAGIAN BAWAH: Statistik rata-rata level
        JLabel averageLabel = new JLabel(
            String.format(
                java.util.Locale.US,
                "Rata-rata Level: %.1f",
                averageLevel
            )
        );

        averageLabel.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        averageLabel.setForeground(new Color(0, 102, 153));

        averageLabel.setBorder(
            BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        mainPanel.add(averageLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
