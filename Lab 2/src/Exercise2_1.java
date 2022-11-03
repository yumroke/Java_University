import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2_1 {
    public static void main(String[] arghs) {

        int amount = 0;     //кількість стовпців
        String massive[];   //масив стовпців

        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.print("Введіть кількість стовпців:");
        try {
            amount = sc.nextInt();
            massive = new String[amount];

            for(int i = 0; i < massive.length; i++) {
                System.out.print("Введіть " + (i + 1) + " стовпець:");
                massive[i] = sc.next();
            }

            System.out.print("Введіть шуканий стовпець:");
            int fnumber = sc.nextInt();     //шуканий стовпець

            try {
                System.out.println("Стовпець " + fnumber + massive[fnumber - 1]);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Немає стовпця з таким номером.");
            }
            catch (InputMismatchException e){
                System.out.println("Ви ввели рядок замість числа.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Ви ввели рядок замість числа.");
        }
    }
}