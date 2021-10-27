import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName;


		ConfigParser config = new ConfigParser("development");
		System.out.println("Environment");
		Scanner input = new Scanner(System.in);
		System.out.println("Type in Key ");
		String key = input.nextLine();
		System.out.println(config.getValue(key));

	}

}
