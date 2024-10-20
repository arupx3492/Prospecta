public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CsvReader csvReader=new CsvReader();
        csvReader.csvProcessor("C:\\Users\\ARUP MAHATO\\Desktop\\data.csv",
                "C:\\Users\\ARUP MAHATO\\Desktop\\output.csv");
    }
}