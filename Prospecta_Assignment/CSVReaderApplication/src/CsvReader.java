import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CsvReader {

    private Map<String,Double> values=new HashMap<String,Double>();

    public void csvProcessor(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            int rowNum = 1;

            // Read header
            String header = reader.readLine();
            writer.write(header); // Write header to output
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                for (int i = 0; i < cells.length; i++) {
                    String cellReference = getCellReference(i + 1, rowNum);
                    String cellValue = cells[i].trim();

                    if (isFormula(cellValue)) {
                        double evaluatedValue = evaluateFormula(cellValue);
                        values.put(cellReference, evaluatedValue);
                        writer.write(String.valueOf(evaluatedValue));
                    } else {
                        double numericValue = Double.parseDouble(cellValue);
                        values.put(cellReference, numericValue);
                        writer.write(cellValue);
                    }

                    writer.write(","); // Write delimiter
                }
                writer.newLine(); // Move to next row
                rowNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCellReference(int column, int row) {
        char columnLetter = (char) ('A' + column - 1);
        return columnLetter + String.valueOf(row);
    }

    private boolean isFormula(String cellValue) {
        return cellValue.startsWith("=");
    }

    private double evaluateFormula(String formula) {
        String expression = formula.substring(1); // Remove the '=' sign
        String[] tokens = expression.split("\\+");

        double result = 0;
        for (String token : tokens) {
            token = token.trim();
            if (token.matches("[A-Z]\\d+")) {
                result += values.getOrDefault(token, 0.0);
            } else {
                result += Double.parseDouble(token);
            }
        }
        return result;
    }
}
