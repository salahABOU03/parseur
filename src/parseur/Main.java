package parseur;


public class Main {

	public static void main(String[] args) {
		String ch="cdcb";
		TokenManager tm =new TokenManager(ch);
		Parseur parseur=new Parseur(tm);
		
		try {
			parseur.parse();
			System.out.println(ch+" est valide");
		}
		
		catch(RuntimeException exp){
			System.out.println(ch+" n'est pas valide");
		}

	}

}