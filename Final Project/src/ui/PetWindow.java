package ui;

import PetManager.Pet;
import ReportBuilder.ReportBuilder;
import sql.DatabaseManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class PetWindow {
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel petNameGoesHere;
    private JLabel petAgeGoesHere;
    private JLabel breedLabel;
    private JLabel petBreedGoesHere;
    private JLabel idLabel;
    private JLabel petIdGoesHere;
    private JLabel genderLAbel;
    private JLabel petGenderGoesHere;
    private JLabel petCityGoesHere;
    //private JButton addPet;
    private JButton dietBttn;
    private JButton exerciseBttn;
    private JButton medicationBttn;
    private JButton addPhoto;
    private JPanel panel1;
    private JButton uploadImageButton;
    private JPanel imagepanel;
    private JPanel dietPanel;
    private DatabaseManager sql;
    private Pet pet;

    public PetWindow(DatabaseManager sql, Pet p) {
        this.pet = p;
        this.sql = sql;
        petNameGoesHere.setText(pet.name);
        int age = Year.now().getValue() - pet.petBirthday.getYear();
        petAgeGoesHere.setText("" + age);
        petBreedGoesHere.setText(pet.breed);
        petIdGoesHere.setText("" + pet.tracking_id);
        petGenderGoesHere.setText(pet.gender);

        if (pet.icon != null) {
            this.addIcon(new File(pet.icon));
        }

        dietBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.openDietPopUpWindow(sql, PetWindow.this.pet);
            }
        });

        exerciseBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.openExercisePopUpWindow(sql, PetWindow.this.pet);
            }
        });

        medicationBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.openMedicationPopUpWindow(sql, PetWindow.this.pet);
            }
        });
        addPhoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");

                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Document", "pdf");
                fileChooser.setFileFilter(filter);
                fileChooser.setDialogTitle("Save report");

                int userSelection = fileChooser.showSaveDialog(PetWindow.this.panel1);
                fileChooser.setFileFilter(filter);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    String path = fileToSave.getAbsolutePath();
                    if (!path.endsWith(".pdf"))
                        path = path + ".pdf";
                    ReportBuilder rb = new ReportBuilder(path);

                    try {
                        rb.generate(PetWindow.this.pet);
                        rb.save();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Unable to save file!", "Error!", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });
        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter f = new FileNameExtensionFilter("Supported images", "png", "jpg");
                chooser.setFileFilter(f);
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    if (pet.icon != null) {
                        File old = new File(pet.icon);
                        old.delete();
                    }

                    File icon = chooser.getSelectedFile();
                    try {
                        pet.icon = icon.getName();
                        InputStream is = new FileInputStream(icon);
                        OutputStream os = new FileOutputStream(icon.getName());
                        byte[] buf = new byte[1024];
                        int len;
                        while ((len = is.read(buf)) > 0) {
                            os.write(buf, 0, len);
                        }
                        is.close();
                        os.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    PetWindow.this.addIcon(new File(icon.getName()));
                    try {
                        sql.updatePet(PetWindow.this.pet);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void addIcon(File f) {
        try {
            if (imagepanel.getComponentCount() > 0) {
                imagepanel.removeAll();
            }

            BufferedImage myPicture = ImageIO.read(f);
            Dimension d = new Dimension(150, 150);
            Image img = myPicture.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);

            BufferedImage b = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics g = b.getGraphics();
            g.drawImage(img, 0, 0, null);
            g.dispose();

            JLabel l = new JLabel(new ImageIcon(b));
            l.setSize(d);
            imagepanel.add(l);
            imagepanel.repaint();
            imagepanel.revalidate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static JFrame spawn(DatabaseManager sql, Pet p) {
        JFrame frame = new JFrame("PetMe+ Add Pet Window");
        frame.setContentPane(new PetWindow(sql, p).panel1);
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setEnabled(true);
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 5, new Insets(25, 25, 25, 25), -1, -1));
        panel1.setEnabled(true);
        panel2.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        imagepanel = new JPanel();
        imagepanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(imagepanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 150), null, 1, false));
        uploadImageButton = new JButton();
        uploadImageButton.setText("Upload image");
        panel1.add(uploadImageButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Segoe UI", -1, 22, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Diet");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 2, false));
        dietBttn = new JButton();
        Font dietBttnFont = this.$$$getFont$$$(null, -1, 22, dietBttn.getFont());
        if (dietBttnFont != null) dietBttn.setFont(dietBttnFont);
        dietBttn.setIcon(new ImageIcon(getClass().getResource("/dog-food.png")));
        dietBttn.setText("");
        panel1.add(dietBttn, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Segoe UI", -1, 22, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Exercise");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 2, false));
        exerciseBttn = new JButton();
        Font exerciseBttnFont = this.$$$getFont$$$(null, -1, 22, exerciseBttn.getFont());
        if (exerciseBttnFont != null) exerciseBttn.setFont(exerciseBttnFont);
        exerciseBttn.setIcon(new ImageIcon(getClass().getResource("/dog-walk.png")));
        exerciseBttn.setText("");
        panel1.add(exerciseBttn, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Segoe UI", -1, 22, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Medication");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 2, false));
        medicationBttn = new JButton();
        Font medicationBttnFont = this.$$$getFont$$$(null, -1, 22, medicationBttn.getFont());
        if (medicationBttnFont != null) medicationBttn.setFont(medicationBttnFont);
        medicationBttn.setIcon(new ImageIcon(getClass().getResource("/medicine.png")));
        medicationBttn.setText("");
        panel1.add(medicationBttn, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Segoe UI", -1, 22, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Report");
        panel1.add(label4, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 2, false));
        addPhoto = new JButton();
        Font addPhotoFont = this.$$$getFont$$$(null, -1, 22, addPhoto.getFont());
        if (addPhotoFont != null) addPhoto.setFont(addPhotoFont);
        addPhoto.setIcon(new ImageIcon(getClass().getResource("/print-24px.png")));
        addPhoto.setText("");
        panel1.add(addPhoto, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        petNameGoesHere = new JLabel();
        Font petNameGoesHereFont = this.$$$getFont$$$("Segoe UI", -1, 14, petNameGoesHere.getFont());
        if (petNameGoesHereFont != null) petNameGoesHere.setFont(petNameGoesHereFont);
        petNameGoesHere.setText("\"pet name\"");
        panel1.add(petNameGoesHere, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setBackground(new Color(-15788009));
        Font label5Font = this.$$$getFont$$$("Nirmala UI", Font.BOLD, 20, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("Pet Log");
        panel1.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 4, false));
        petAgeGoesHere = new JLabel();
        Font petAgeGoesHereFont = this.$$$getFont$$$("Segoe UI", -1, 14, petAgeGoesHere.getFont());
        if (petAgeGoesHereFont != null) petAgeGoesHere.setFont(petAgeGoesHereFont);
        petAgeGoesHere.setText("\"pet age\"");
        panel1.add(petAgeGoesHere, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        petBreedGoesHere = new JLabel();
        Font petBreedGoesHereFont = this.$$$getFont$$$("Segoe UI", -1, 14, petBreedGoesHere.getFont());
        if (petBreedGoesHereFont != null) petBreedGoesHere.setFont(petBreedGoesHereFont);
        petBreedGoesHere.setText("\"pet breed\"");
        panel1.add(petBreedGoesHere, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        petIdGoesHere = new JLabel();
        Font petIdGoesHereFont = this.$$$getFont$$$("Segoe UI", -1, 14, petIdGoesHere.getFont());
        if (petIdGoesHereFont != null) petIdGoesHere.setFont(petIdGoesHereFont);
        petIdGoesHere.setText("\"pet ID\"");
        panel1.add(petIdGoesHere, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        petGenderGoesHere = new JLabel();
        Font petGenderGoesHereFont = this.$$$getFont$$$("Segoe UI", -1, 14, petGenderGoesHere.getFont());
        if (petGenderGoesHereFont != null) petGenderGoesHere.setFont(petGenderGoesHereFont);
        petGenderGoesHere.setText("\"petgender\"");
        panel1.add(petGenderGoesHere, new com.intellij.uiDesigner.core.GridConstraints(5, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        Font nameLabelFont = this.$$$getFont$$$("Segoe UI", -1, 22, nameLabel.getFont());
        if (nameLabelFont != null) nameLabel.setFont(nameLabelFont);
        nameLabel.setText("Name");
        panel1.add(nameLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ageLabel = new JLabel();
        Font ageLabelFont = this.$$$getFont$$$("Segoe UI", -1, 22, ageLabel.getFont());
        if (ageLabelFont != null) ageLabel.setFont(ageLabelFont);
        ageLabel.setText("Age");
        panel1.add(ageLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        breedLabel = new JLabel();
        Font breedLabelFont = this.$$$getFont$$$("Segoe UI", -1, 22, breedLabel.getFont());
        if (breedLabelFont != null) breedLabel.setFont(breedLabelFont);
        breedLabel.setText("Breed");
        panel1.add(breedLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idLabel = new JLabel();
        Font idLabelFont = this.$$$getFont$$$("Segoe UI", -1, 22, idLabel.getFont());
        if (idLabelFont != null) idLabel.setFont(idLabelFont);
        idLabel.setText("Pet ID");
        panel1.add(idLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderLAbel = new JLabel();
        Font genderLAbelFont = this.$$$getFont$$$("Segoe UI", -1, 22, genderLAbel.getFont());
        if (genderLAbelFont != null) genderLAbel.setFont(genderLAbelFont);
        genderLAbel.setText("Sex");
        panel1.add(genderLAbel, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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

}
