/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportBuilder;

import PetManager.LogEntry;
import PetManager.Pet;
import PetManager.PetLog;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPEGReportGenerator implements ReportGenerator{

    private final int width = 800;
    private final int height = 1200;
    private final String file;
    
    
    public JPEGReportGenerator(String file) {
        this.file = file;
    }
        
    private void generate(Pet pet) throws IOException
    {
        BufferedImage petReport = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D petImage = petReport.createGraphics();
        
        Font petHeaderFont = new Font("default", Font.PLAIN, 16);
        Font petDataFont = new Font("default", Font.BOLD, 20);
        
        int age = Year.now().getValue() - pet.petBirthday.getYear();
        
        Stroke origStroke = petImage.getStroke();
        Stroke newStroke = new BasicStroke(2);
        
        petImage.setColor(Color.WHITE);
        petImage.setStroke(newStroke);
        petImage.fillRect(0, 0, width, height);
        petImage.setStroke(origStroke);
        
                
        petImage.setColor(Color.BLACK);
        petImage.setFont(petHeaderFont);
        petImage.drawString("PetMe+ Recent Activity Report", 15, 15);
        
        petImage.setFont(petDataFont);
        petImage.drawString("Name: " + pet.name, 45, 115);
        petImage.drawString("Gender: " + pet.gender, 45, 145);
        petImage.drawString("Age: " + age + " Year(s)", 45, 175);
        petImage.drawString("Pet type: " + pet.type, 45, 205);
        
        BufferedImage petIcon = ImageIO.read(new File(pet.icon));
        
        petImage.drawImage(petIcon, 400, 45, null);
               
        petImage.drawString("Diet Log", 45, 400);
        petImage.drawImage(addLog(pet.diet), 45, 430, null);
        
        petImage.drawString("Medicine Log", 45, 600);
        petImage.drawImage(addLog(pet.medicine), 45, 630, null);
        
        
        petImage.drawString("Exercise Log", 45, 800);
        petImage.drawImage(addLog(pet.exercise), 45, 830, null);
        
        petImage.dispose();
        
        File petFile = new File(file);
        ImageIO.write(petReport, "jpg", petFile);
        
    }
    
        private BufferedImage addLog(PetLog log) throws IOException {
            
            Vector rowData = new Vector();
            int size = log.getSize();
            while (size-- > 0) {
                LogEntry entry = log.getEntry(size);
                
                for (int i = 0; i < 1; i++) {
                Vector colData = new Vector(Arrays.asList(entry.date, entry.text));
                rowData.add(colData);
            }
            }
            
            String[] columnNames = {"Date", "Description"};
            Vector columnNamesV = new Vector(Arrays.asList(columnNames));
            
            int totalWidth = 600;
            int totalHeight = 100;
            
            Dimension tableDimension = new Dimension(totalWidth, totalHeight);

            JTable table = new JTable(rowData, columnNamesV);
            table.setSize(tableDimension);
            table.setPreferredSize(tableDimension);
            
            JScrollPane scroll = new JScrollPane(table);
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            JPanel p = new JPanel(new BorderLayout());
            p.add(scroll, BorderLayout.CENTER);
            p.addNotify();
            p.setSize(p.getPreferredSize());
            p.validate();
            
            BufferedImage tableImage = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2D = (Graphics2D) tableImage.getGraphics();

            p.paint(g2D);
            g2D.dispose();
            return tableImage;
                        
    }
        
    @Override
    public void export(Pet pet) throws IOException {
        generate(pet);
    }
    
}
