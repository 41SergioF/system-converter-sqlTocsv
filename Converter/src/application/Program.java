package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Esté programa irá ler um arquivo .SQL e converter para .CSV
 * Caminhos dos arquivos SQL 
 * /home/csergio/Documentos/Banco_de_Dados/smallRelationsInsertFile.sql
 * /home/csergio/Documentos/Banco_de_Dados/largeRelationsInsertFile.sql
 */
public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//String filePath = scan.nextLine();		//entrada com o caminho do arquivo
		String filePath = "/home/csergio/Documentos/Banco_de_Dados/smallRelationsInsertFile.sql"; 
		String auxString = "/home/csergio/Documentos/Banco_de_Dados"; 
		
		boolean success = new File(auxString + "/exit").mkdir();
		String targetFile = auxString + "/exit/araquivo.csv";
		
		if (!success) {
			System.out.println("Erro!");
		}
		
		try (BufferedReader sqlFile = new BufferedReader(new FileReader(filePath))){
			
			String lineRaed = sqlFile.readLine();	
			
			while (lineRaed != null ){
				
				int begin = lineRaed.indexOf("("); //retornando a posição desse caracter
				int end = lineRaed.indexOf(")");   //retornando a posição - 1 desse caracter
				
				String subLineRead = lineRaed.substring(begin + 1, end); //recorda 
				lineRaed  = sqlFile.readLine();//lê uma linha do arquivo SQL
				
				try (BufferedWriter csvFile = new BufferedWriter(new FileWriter(targetFile, true))){
						csvFile.write(subLineRead);
						csvFile.newLine();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println(subLineRead);
										
			}
			
		} catch (IOException e) {
			e.printStackTrace();		//mostar o stack do erro 	
		}
		
		scan.close();
	}

}
