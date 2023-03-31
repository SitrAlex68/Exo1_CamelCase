package Ex01;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.ArrayList;

public class main 
{

	public static void main(String[] args) throws IOException
	{
		String[] stringsArray;
		stringsArray = openFile("exo1.txt");
		convertStringArray(stringsArray);
		
		// Affichage du texte converti dans la console
		display(stringsArray);
		
		// Création d'un nouveau fichier qui contiendra le texte traduit
		PrintStream o = new PrintStream(new File("exo1Traduit.txt"));
		
		// Redirection à partir de cette ligne vers le nouveau fichier
		System.setOut(o);
		
		// Affichage du texte converti dans le nouveau fichier
		display(stringsArray);   
	}
	
	
	public static String[] openFile(String s) throws IOException
	{
		Path filePath = new File(s).toPath();
		Stream<String> lines = Files.lines(filePath);
		List<String> result = new ArrayList<String>();
		result = lines.collect(Collectors.toList());
		String[] strLinArray = result.toArray(new String[] {});
		return  strLinArray;
	}
	
	public static String convertString(String s)
	{
		int nbSpaces = 0;
		int nStr = s.length();
		char ch[] = s.toCharArray();
		int c = 0;

		for(int i = 0; i < nStr; i++)
		{
			if(i == 0)
				ch[i] = Character.toLowerCase(ch[i]);
			if(ch[i] == ' ')
			{
				nbSpaces++;
				ch[i + 1] = Character.toUpperCase(ch[i + 1]);
				//continue;
			}
			else
				ch[c++] = ch[i];
			
		}	
		
		return String.valueOf( ch, 0, nStr - nbSpaces ) ;
	}
	
	public static void convertStringArray(String[] sa)
	{
		for(int nbLignes = 0; nbLignes < sa.length; nbLignes++)
			convertString(sa[nbLignes]);
	}
	
	public static void display(String[] sa)
	{
		for(int nbLignes = 0; nbLignes < sa.length; nbLignes++)
			System.out.println(sa[nbLignes] + " -> " + convertString(sa[nbLignes]));
	}
}
