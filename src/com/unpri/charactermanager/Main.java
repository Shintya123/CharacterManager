
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // 1. Membuat objek CharacterManager
        CharacterManager manager = new CharacterManager();

        // 2. Menambahkan data karakter
        manager.addCharacter(
            new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Athena", CharacterType.ARCHER, 4)
        );

        // 3. Menghitung rata-rata level karakter
        double averageLevel = manager.getAverageLevel();

        // 4. Menjalankan GUI
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(
                manager.getAllCharacters(),
                averageLevel
            );

            window.setVisible(true);
        });
    }
}
