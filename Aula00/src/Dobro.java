import java.util.Scanner;

public class Dobro {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int number = sc.nextInt();
        int dobro = number*2;
        System.out.println(dobro);

        sc.close();
    }
}
