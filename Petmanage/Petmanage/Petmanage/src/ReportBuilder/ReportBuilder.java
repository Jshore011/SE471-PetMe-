package ReportBuilder;

import PetManager.Pet;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Report builder that constructs our PDF
 */
public class ReportBuilder {
    private PDDocument document;
    private String file;

    /**
     * Constructs a new report builder object
     * @param file path to store the report
     */
    public ReportBuilder(String file) {
            document = new PDDocument();
        
        this.file = file;
    }

    /**
     * Generates a report for the given pet
     * @param pet pet to build report for
     * @throws IOException
     */
    public void generate(Pet pet) throws IOException {
        addFirstPage(pet);
        addLog(pet.diet, "Diet Log");
        addLog(pet.medicine, "Medicine Log");
        addLog(pet.exercise, "Exercise Log");
    }

    /**
     * Saves the report to the pre-specified path
     * @throws IOException
     */
    public void save() throws IOException {
        document.save(file);
        document.close();
    }

    // adds title page & dog image
    private void addFirstPage(Pet pet) throws IOException {
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream stream = new PDPageContentStream(document, page)) {

            stream.beginText();
            stream.newLineAtOffset(45f, page.getMediaBox().getUpperRightY()-15f);
            stream.setFont(PDType1Font.TIMES_ITALIC, 15);
            stream.showText("PetMe+ Recent Activity Report");
            stream.endText();

            if (pet.icon != null) {
                PDImageXObject pdImage = PDImageXObject.createFromFile(pet.icon, document);

                stream.drawImage(pdImage, page.getMediaBox().getUpperRightX()-400, page.getMediaBox().getUpperRightY()-350, 200, 200);
            }
            
            stream.beginText();
            stream.newLineAtOffset(45f, page.getMediaBox().getUpperRightY()-450f);
            stream.setFont(PDType1Font.TIMES_BOLD, 32);
            stream.showText("Name: " + pet.name);
            stream.endText();
            
                        stream.beginText();
            stream.newLineAtOffset(45f, page.getMediaBox().getUpperRightY()-480f);
            stream.setFont(PDType1Font.TIMES_BOLD, 28);
            stream.showText("Gender: " + pet.gender);
            stream.endText();

            int age = Year.now().getValue() - pet.petBirthday.getYear();
            stream.beginText();
            stream.newLineAtOffset(45f, page.getMediaBox().getUpperRightY()-510f);
            stream.setFont(PDType1Font.TIMES_BOLD, 28);
            if(age > 1)
                stream.showText("Age: " + age + " years old");
            else
                stream.showText("Age: " + age + " year old");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(45f, page.getMediaBox().getUpperRightY()-540f);
            stream.setFont(PDType1Font.TIMES_BOLD, 28);
            stream.showText("Pet type: " + pet.type);
            stream.endText();
        }
    }

    // Universal log entry addition
    private void addLog(PetLog log, String title) throws IOException {
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream stream = new PDPageContentStream(document, page)) {

            stream.beginText();
            stream.newLineAtOffset(15f, page.getMediaBox().getUpperRightY()-15f);
            stream.setFont(PDType1Font.TIMES_ITALIC, 15);
            stream.showText("PetMe+ Recent Activity Report");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(45f, page.getMediaBox().getUpperRightY()-65f);
            stream.setFont(PDType1Font.TIMES_BOLD, 32);
            stream.showText(title);
            stream.endText();

            Table.TableBuilder tableBuilder = Table.builder()
                    .addColumnsOfWidth(200, 300)
                    .padding(2)
                    .borderColor(Color.black)
                    .numberOfColumns(2)
                    .borderWidth(1.35f);

            tableBuilder.addRow(
                    Row.builder()
                            .add(TextCell.builder().text("Date").build())
                            .add(TextCell.builder().text("Description").build())
                            .build()
            );

            int i = log.getSize();
            while (i-- > 0) {
                LogEntry entry = log.getEntry(i);

                // convert date instant to our timezone
                tableBuilder.addRow(
                        Row.builder()
                                .add(TextCell.builder().text(entry.date.toString()).build())
                                .add(TextCell.builder().text(entry.text).build())
                                .build()
                );
            }

            Table table = tableBuilder.build();
            // time to actually draw
            TableDrawer td = TableDrawer.builder()
                    .contentStream(stream)
                    .startX(45f)
                    .startY(page.getMediaBox().getUpperRightY()-100f)
                    .table(table)
                    .build();

            td.draw();
        }
    }
}
