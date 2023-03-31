package Ex01;

public class CamelCase {
	static String convertirCamel(String[] tab, int n)
	{
		String reponse = "";
		for(int i = 0 ; i < n; i++)
		{
			if(reponse.length() > 0)
			{
				reponse += "";
			}
			
			reponse += Character.toUpperCase(tab[i].charAt(0));
			for(int j = 1; j < tab[i].length(); j++)
			{
				if(tab[i].charAt(j) == ' ')
				{
					reponse += "";
					char c = Character.toUpperCase(tab[i].charAt(j + 1));
					reponse += c;
					j++;
				}
				else
				{
					reponse += Character.toLowerCase(tab[i].charAt(j));
				}
			}
		}
		return reponse;
	}
}
