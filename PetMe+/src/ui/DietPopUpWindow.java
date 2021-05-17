package ui;

import PetManager.LogEntry;
import PetManager.Pet;
import PetManager.*;
import sql.DatabaseManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;

public class DietPopUpWindow {
    private JButton saveButton;
    private JComboBox dayCombo;
    private JComboBox yearCombo;
    private JComboBox hourCombo;
    private JComboBox minutesCombo;
    private JTextArea commentBox;
    private JComboBox amPmCombo;
    private JTextField dietName;
    private JComboBox monthCombo;
    private JPanel dietPanel;
    private JPanel panel1;
    private DatabaseManager sql;
    private Pet pet;
    private PetLogVisitor_IF visitor;

    public DietPopUpWindow(DatabaseManager sql, Pet pet) {
        this.sql = sql;
        this.pet = pet;

        addToMonthCombo();
        addToDayCombo();
        addToYearCombo();
        addToHourCombo();
        addToMinCombo();
        addToAmPmCombo();


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt((String) yearCombo.getSelectedItem());
                int month = monthCombo.getSelectedIndex() + 1;
                int day = Integer.parseInt((String) dayCombo.getSelectedItem());
                int hour = hourCombo.getSelectedIndex() + 1;
                int minute = Integer.parseInt((String) minutesCombo.getSelectedItem());
                String ampm = (String) amPmCombo.getSelectedItem();
                if (ampm.equalsIgnoreCase("PM")) {
                    hour += 12;
                }
                 
                DietLog diet = new DietLog(visitor, new ArrayList<>());
                String comments = commentBox.getText();
                LocalDateTime dt = LocalDateTime.of(year, month, day, hour, minute);
                diet.newEntry(comments, dt);
                DietPopUpWindow.this.pet.diet.addDietEntry(diet);

                try {
                    
                    DietPopUpWindow.this.sql.insertPetLog(DietPopUpWindow.this.pet,diet.newEntry(comments, dt));
                } catch (Exception ex) {
                    System.out.println("Unable to save pet log: " + ex.getMessage());
                }
                Main.dietPopUpWindow.dispose();
            }
        });
    }

    private void addToYearCombo() {
        int currentYear = Year.now().getValue();

        for (int i = currentYear; i > currentYear - 20; i--) {
            yearCombo.addItem("" + i);
        }
    }

    private void addToMonthCombo() {
        String[] month = {
                "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        };
        for (int i = 0; i < month.length; i++) {
            monthCombo.addItem(month[i]);
        }
    }

    private void addToDayCombo() {
        for (int i = 1; i <= 31; i++) {
            dayCombo.addItem("" + i);
        }
    }

    private void addToHourCombo() {
        for (int i = 1; i < 13; i++) {
            hourCombo.addItem("" + i);
        }
    }

    private void addToMinCombo() {
        for (int i = 0; i < 60; i++) {
            minutesCombo.addItem(String.format("%02d", i));
        }
    }

    private void addToAmPmCombo() {
        String[] amPM = {
                "am", "pm"
        };
        for (int i = 0; i < amPM.length; i++) {
            amPmCombo.addItem(amPM[i]);
        }
    }

    public static JFrame spawn(DatabaseManager sql, Pet pet) {
        JFrame frame = new JFrame("PetMe+ add Diet");
        frame.setContentPane(new DietPopUpWindow(sql, pet).panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(250, 250);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(25, 25, 25, 25), -1, -1));
        dietPanel = new JPanel();
        dietPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 13, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(dietPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Segoe UI", -1, 14, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Date");
        dietPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Segoe UI", -1, 14, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Time");
        dietPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Segoe UI", -1, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Comments");
        dietPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        commentBox = new JTextArea();
        dietPanel.add(commentBox, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, 100), null, 0, false));
        hourCombo = new JComboBox();
        hourCombo.setEditable(true);
        dietPanel.add(hourCombo, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 25), new Dimension(100, 25), new Dimension(100, 25), 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("hr");
        dietPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        minutesCombo = new JComboBox();
        minutesCombo.setEditable(true);
        dietPanel.add(minutesCombo, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 25), new Dimension(100, 25), new Dimension(100, 25), 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("min");
        dietPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        monthCombo = new JComboBox();
        monthCombo.setEditable(true);
        dietPanel.add(monthCombo, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 25), new Dimension(100, 25), new Dimension(100, 25), 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("month");
        dietPanel.add(label6, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dayCombo = new JComboBox();
        dayCombo.setEditable(true);
        dietPanel.add(dayCombo, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 25), new Dimension(100, 25), new Dimension(100, 25), 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("day");
        dietPanel.add(label7, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        amPmCombo = new JComboBox();
        amPmCombo.setEditable(true);
        Font amPmComboFont = this.$$$getFont$$$("Nirmala UI", -1, -1, amPmCombo.getFont());
        if (amPmComboFont != null) amPmCombo.setFont(amPmComboFont);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        amPmCombo.setModel(defaultComboBoxModel1);
        dietPanel.add(amPmCombo, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 25), new Dimension(100, 25), new Dimension(100, 25), 0, false));
        yearCombo = new JComboBox();
        yearCombo.setEditable(true);
        dietPanel.add(yearCombo, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, 25), new Dimension(100, 25), new Dimension(100, 25), 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("year");
        dietPanel.add(label8, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("am/pm");
        dietPanel.add(label9, new com.intellij.uiDesigner.core.GridConstraints(3, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        Font label10Font = this.$$$getFont$$$("Segoe UI", Font.BOLD, 28, label10.getFont());
        if (label10Font != null) label10.setFont(label10Font);
        label10.setText("Add Diet Entry");
        panel1.add(label10, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        Font saveButtonFont = this.$$$getFont$$$("Segoe UI", -1, 14, saveButton.getFont());
        if (saveButtonFont != null) saveButton.setFont(saveButtonFont);
        saveButton.setText("Save");
        panel1.add(saveButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 20, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}

