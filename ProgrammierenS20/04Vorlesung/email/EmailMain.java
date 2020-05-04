package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMain {

	public static void main(String[] args) {
		
		Email [] emails = new Email[28];
		emails[0] = new Email("Programmieren 2 Vorlesung", "Hallo allerseits,\ndie Vorlesung morgen f�llt leider aus.\nViele Gr��e\nStephi");
		emails[1] = new Email("Witze", "Huhu,\nich bin gerade auf der Suche nach coolen Chuck Norris Witzen. Du kennst doch so viele. Kannst du mir mal welche schreiben?\nDas w�re mega cool :)\nLG, Rudolf");
		emails[2] = new Email("SRA Treffen", "Guten Tag liebe Kollegen und Kollginnen,\nheute findet der n�chste Studienreformausschuss in E45 statt.\nMit freundlichen Gr��en\nMarkus Schubert");
		emails[3] = new Email("Geburtstag", "Hallo Maria, ich wollte dir alles Gute zum geburtstag w�nschen. Ich hoffe du machst dir einen sch�nen Tag und l�sst dich ordentlich feiern.\nLiebe Gr��e\nKira");
		emails[4] = new Email("Hiiillllllffffeeeeee :(", "Hallo Sina,\nich glaube ich habe einen Virus auf dem Rechner. Was soll ich tun? Kannst du dir das nachher mal anschauen? Danke und liebe Gr��e\nPapa");
		emails[5] = new Email("Buch ausleihen", "Hey Hannes,\nTim sagte mir du hast die ganze Harry Potter Reihe an B�chern. Ich habe gerade voll Langeweile und w�rde mir gerne mal etwas Leselekt�re ausleihen. Ich bring dir als Danke mal ein 6er Bier vorbei :) Gr��e\nAnna");
		emails[6] = new Email("Spieleabend", "Hey Leudde,\nheute Abend bei uns Spieleabend mit leckeren Cocktails. Biste dabei?\nGr��e Laura und Dennis");
		emails[7] = new Email("Festival", "Hey,\ndas letzte Mal Flanky Ball ist schon ein Weilchen her. Ich w�rde sagen Zeit f�rs n�chste Festival ;) Biste diesen Sommer wieder am Start? Wollen entweder aufs Highfield, Hurricane oder Wacken. Over and out Digga\nKolle");
		emails[8] = new Email("Game Jam", "Moinsen,\nhab geh�rt der FSR organisiert einen Game Jam. Wei�t du wann der ist? H�tte da ja mal echt Bock drauf, wie schauts bei dir aus?\n\nViele Gr��e\nBasti");
		emails[9] = new Email("Fu�ball", "Hey Dave,\nkommste in zwei Wochen mit zum Pauli-Spiel? Die Bielefelder hauen wir wech. Keine Ahnung, wo die Spieler her kommen, Bielefeld gibts doch eh nicht :D\nGr��e\nMaik");
		emails[10] = new Email("Kleidertausch", "Hey Bine,\nhabe heute geh�rt, dass demn�chst ein Kleidertausch ist. Kommste mit?\nBussi\nFrauke");
		emails[11] = new Email("AW Fu�ball", "Ey Tim,\nsischer bin ich dabei! Ich frag die restlichen Jungs auch mal. Bis Donnerstag, Dave");
		emails[12] = new Email("Hausaufgaben", "Hallo,\nhat jemand von euch die Hausaufgaben programmiert und verstanden? Ich br�uchte da mal Hilfe. Ciao Dome");
		emails[13] = new Email("Kino", "Hey M�dels,\nam Samsta kommt der Goldene Handschuh in die Kinos. Da gabs ja auch ein Buch zu, das war schon echt krass. Lass uns da mal hingehen.\nGr��e\nLaura");
		emails[14] = new Email("Zocken", "Hey ho, Lust auf ne Runde Spielen am Wochenende und Grillen im Stadtpark? Sag mal Bescheid, ob du dabei bist! LG");
		emails[15] = new Email("Badminton", "Hey Tom,\nwir H�user waren am Sonntag Badminton spielen, das war ja so mega. N�chstes Mal musst du mitkommen. Wie geht es eigentlich deiner Kleinen?\nViele Gr��e\nRudi");
		emails[16] = new Email("Treffen", "Aloha,\nkommste nachher mit zum Slam? Wollen uns um 19 uhr treffen und dann was Essen gehen. Es geht dann um 20:30 Uhr los.\nCu Peter");
		emails[17] = new Email("Bier brauen", "Hey Jan,\nSarah will mal Bier brauen, du musst dann wohl unter �bel vorbei kommen zum kosten.\nBis denne\nSteve");
		emails[18] = new Email("Nachbarschaftshilfe", "Hey Laura,\nwollen 00:34:45 wir mal Werbung f�r unsere Nachbarschaftshilfe machen? K�nnen ja mal nachher dr�ber quatschen. Wann treffen wir uns eigentlich?");
		emails[19] = new Email("Bla", "Test, bla, test, huhu, was geht, was geht Digga?");
		emails[20] = new Email("Bla2", "sagte");
		emails[21] = new Email("MyName", "Cemsn hiho test blub");
		emails[22] = new Email("Uhrzeit", "23:59:00");
		emails[23] = new Email("Uhrzeit2", "00:23:00");
		emails[24] = new Email("Uhrzeit3", "00:23:23");
		emails[25] = new Email("Uhrzeit4", "00:23:81");
		emails[26] = new Email("Uhrzeit5", "13:37:37");
		emails[27] = new Email("Uhrzeit6", "11:23:06");
		
		
		//A ... d
		// String regex = "(Haus)|(H�user)";
		// String regex = "\\s[Aa][a-z]*[d]\\s";
		// String regex = "(\\s|^)[Aa]\\w*[d](\\s|[.,=!:;])";
		// String regex = "(^|\\s)[Ss][a-zA-Z]*[e](\\s|[.,?!:;]|$)";
		String regex = "(([0-1][0-9])|([2][0-3])):[0-5][0-9]:[0-5][0-9].*";
		
		// Aufgabe Name filtern
		// String regex = "Cemsn";
		// String regex = "(^|\\s)[Cc][a-zA-Z]*[n](\\s|[.,?!:;]|$)";
		
		Pattern pattern = Pattern.compile(regex);
		for(Email email : emails) {
			Matcher matcher = pattern.matcher(email.getMessage());
			if(matcher.find()) {
				System.out.println(email.getMessage().substring(matcher.start(), matcher.end()) +
						"\n" + email.getMessage());
			}
		}
		
		
		
		/*
		String regex = "(Haus)|(H�user)";
		Pattern pattern = Pattern.compile(regex);
		for(Email email : emails) {
			Matcher matcher = pattern.matcher(email.getMessage());
			if(matcher.find()) {
				System.out.println(email.getMessage());
			}
		}
		*/
		
	}
	
	
}
