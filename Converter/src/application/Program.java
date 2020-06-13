package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Esté programa irá ler um arquivo .SQL e converter para .CSV
 * caminho do arquivo SQL /home/csergio/Documentos/Banco_de_Dados/smallRelationsInsertFile.sql
 */
public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String filePath = scan.nextLine();		//entrada com o caminho do arquivo
		
		try (BufferedReader sqlFile = new BufferedReader(new FileReader(filePath))){
			
			String lineRaed = sqlFile.readLine();//lê uma linha
			
			while (lineRaed != null ) {
				System.out.println(lineRaed);
				lineRaed = sqlFile.readLine();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();		//mostar o stack do erro 	
		}
		
		scan.close();
	}

}
