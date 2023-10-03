import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionF {
    public static void main(String[] args) throws ParseException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите данные (Фамилия Имя Отчество дата рождения номер телефона пол): ");
            String input = scanner.nextLine();
            
            String[] data = input.split(" ");
            
            if (data.length != 6) {
                System.out.println("Ошибка! Введено неверное количество данных.");
                return;
            } 
            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            Date birthdate;
            try {
            birthdate = format.parse(data[3]);
            }catch (ParseException e){
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
            }
            int phoneNumber;
            try {
                phoneNumber = Integer.parseInt(data[4]);
            }catch (NumberFormatException e){
                throw new NumberFormatException("Неверный формат телефона");
            }
            String gender = data[5];
            if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")){
                throw new RuntimeException("Неверно введен пол");
            }
            try {
                String surname = data[0];
                String firstName = data[1];
                String middleName = data[2];
                String output = surname + firstName + middleName + birthdate + " " + phoneNumber + gender;
                
                FileWriter fileWriter = new FileWriter(surname + ".txt");
                fileWriter.write(output);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Ошибка! Неудалось создать файл.");
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка! Введены неполные данные.");
                return;
            }
            System.out.println("Данные успешно сохранены в файле " + data[0] + ".txt");
        }
    }
}

