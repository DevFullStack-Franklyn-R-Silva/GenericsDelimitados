package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;
import model.services.CalculationService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String caminho = "C:\\temp\\prod.txt";

		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			Product x = CalculationService.max(list);
			System.out.println("Most expensive: ");//Interface comparável
			System.out.println(x);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
