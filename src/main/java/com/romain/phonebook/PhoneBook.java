package com.romain.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {
	
	public static Scanner sc = null;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		String userLastName 	= getUserInput("Entrer un nom de famille: ");
		String userFirstName 	= getUserInput("Entrer un prénom: ");
		String userPhoneNumber 	= getUserInput("Entrer un numéro de téléphone: ");		
		
		Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);
		
		System.out.println(newContact.toString());
		
		File phoneBookFile = new File("D:\\Eclipse\\eclipseProjet\\contact\\phonebook.txt");
		
		if(phoneBookFile.exists()) {
			System.out.println("Le fichier existe.");
		}else {
			System.out.println("Le fichier n'existe pas");
		}
		
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true));
			fileWriter.append(newContact.toString());
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
	public static String getUserInput(String userRequest) {
		System.out.println(userRequest);
		return sc.nextLine();
	}

}
