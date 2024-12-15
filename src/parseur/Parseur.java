package parseur;

public class Parseur {
private TokenManager tm;
private char tc;
private void avancer() {
	tc=tm.suivant();
	}


private void consomer(char attendu) {
	if(tc==attendu)
		avancer();


   else {
	throw new RuntimeException("Erreur: attendu,"+attendu+ "a été trouvé");
   }
   
}

public Parseur(TokenManager tm) {
	this.tm=tm;
	avancer();
}

//S --> bSb
private void S() {
	if(tc=='b') {
	consomer('b');
	S();
	consomer('b');
	}
	else if(tc=='c') {
		consomer('c');
		A();
		consomer('c');
	}
	else {
		throw new RuntimeException("Erreur:" + tc);
}
}

private void A() {
	if(tc=='b') {
	consomer('b');
	A();
	A();
	}
	else if(tc=='c') {
		consomer('c');
		A();
		S();
		A();
		consomer('b');
	}
	else if(tc=='d'){
		consomer('d');
		consomer('c');
		consomer('b');
	}
	else {
		throw new RuntimeException("Erreur:" + tc);
}
}
public void parse() {
	S();
	if(tc!='#')
		throw new RuntimeException("Erreur:"+tc);
}

}