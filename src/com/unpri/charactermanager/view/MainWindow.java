
package com.unpri.charactermanager.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    // Constructor menerima daftar karakter dan rata-rata level
    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        super("Character Manager v0.4");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        pack();
        setMinimumSize(new Dimension(420, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));

        mainPanel.setBackground(AppTheme.BG_MAIN);

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(16, 16, 16, 16)
        );

        // Judul daftar karakter
        mainPanel.add(createTitleLabel());

        // Menampilkan setiap karakter
        for (Character c : characterList) {
            mainPanel.add(createCharacterLabel(c));
        }

        // Menampilkan statistik rata-rata level
        JLabel averageLabel = new JLabel(
            String.format(
                java.util.Locale.US,
                "Rata-rata Level: %.1f",
                averageLevel
            ),
            SwingConstants.CENTER
        );

        averageLabel.setFont(AppTheme.FONT_TITLE);
        averageLabel.setForeground(AppTheme.TEXT_MAIN);

        mainPanel.add(averageLabel);

        add(mainPanel);
    }

    // Membuat judul
    private JLabel createTitleLabel() {

        JLabel lbl = new JLabel(
            "Daftar Karakter (" + characterList.size() + ")",
            SwingConstants.CENTER
        );

        lbl.setFont(AppTheme.FONT_TITLE);
        lbl.setForeground(AppTheme.TEXT_MAIN);

        return lbl;
    }

    // Membuat kartu karakter
    private JLabel createCharacterLabel(Character c) {

        String info = c.getName() + " | " + c.getType()
                + " | Lv." + c.getLevel()
                + " | HP:" + c.getHitPoints()
                + " | ATK:" + c.getAttackPower();

        JLabel lbl = new JLabel(info);

        lbl.setFont(AppTheme.FONT_BODY);
        lbl.setForeground(AppTheme.TEXT_LIGHT);
        lbl.setBackground(AppTheme.colorFor(c.getType()));
        lbl.setOpaque(true);
        lbl.setBorder(AppTheme.CARD_BORDER);

        lbl.setToolTipText(
            AppTheme.describe(c.getType())
        );

        lbl.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        return lbl;
    }
}
