package Aula01;
import java.util.Scanner;

public class Surfista {
public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do surfista: ");
        String name = sc.nextLine();

        System.out.print("Digite a idade: ");
        int age = sc.nextInt();

        System.out.print("Digite a altura: ");
        double height = sc.nextDouble();

        System.out.println("NOME: " + name);
        System.out.println("IDADE: " + age);
        System.out.println("ALTURA: " + height);

        sc.close();
    }

}