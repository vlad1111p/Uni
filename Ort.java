import java.util.Comparator;
import java.util.Map;


/*
 * new Ort(569, "cqeolmxfbmtreemi") is not equal to new Ort(569, new String("cqeolmxfbmtreemi")) expected: Ort<Ort@186b> but was: Ort<Ort@186b>
stacktrace:
 ... in AdresseTests.hashcodeTest line 47
 
 expected: Adresse<Adresse@74e88> but was: Adresse<Adresse@74e88>
stacktrace:
 ... in AdresseTests.adresseEqualsTest line 32
 
 expected:<weiss> but was:<null>
stacktrace:
 ... in AdresseTests.hashtableTest2 line 99
 
  
  Die Fehler waren nicht nachvollziehbar, da dort bei expected und but was genau das selbe steht. 
 * 
 * 
 * 
 */
public class Ort {
	private int postleitzahl;
	private String name;
	
	Ort(int postleitzahl, String name) {
		this.postleitzahl=postleitzahl;
		this.name=name;
	}
	
	public int getPostleitzahl() {
		return this.postleitzahl;
	}
	public String getName() {
		return this.name;
	}
	public boolean equals (Ort ort) {

		if (this==ort) {
			return true;
		}
		if (ort==null) {
			return false;
		}
		if (!(ort instanceof Ort)) {
			return false;
		}
		return this.postleitzahl==ort.getPostleitzahl() && this.name.equals(ort.getName());
	}
	
	public int hashCode() {

		int hash=0;
		for (int i=0; i<name.length(); i++) {
			hash=hash+Character.getNumericValue(name.charAt(i));
		}
		hash=hash*7+postleitzahl*7;
		System.out.println("Hash:" +hash);
		return hash;

	}

}

class Adresse {
	private Ort ort;
	private String strasse;
	private String hausNummer;
	
	Adresse(Ort ort, String strasse, String hausNummer) {
		this.ort=ort;
		this.strasse=strasse;
		this.hausNummer=hausNummer;
	}
	
	public Ort getOrt() {
		return this.ort;
	}
	public String getStrasse() {
		return this.strasse;
	}
	public String getHausNummer() {
		return this.hausNummer;
	}
	public boolean equals (Adresse adr) {
		System.out.println("Objekt 1: " + this.ort.getPostleitzahl() + " " + this.ort.getName() + " " + this.strasse + " " + this.hausNummer);
		System.out.println("Objekt 2: " + adr.getOrt().getPostleitzahl() + " " + adr.getOrt().getName() + " " + adr.getStrasse() + " " + adr.getHausNummer());
		if (this==adr) {
			return true;
		}
		if (adr==null) {
			return false;
		}
		if (!(adr instanceof Adresse)) {
			return false;
		}
		return this.ort.equals(adr.getOrt()) && this.strasse.equals(adr.getStrasse()) && this.hausNummer.equals(adr.getHausNummer());
	}
	
	public int hashCode() {
		int hash=ort.hashCode();
		for (int i=0; i<strasse.length(); i++) {
			hash=hash+(Character.getNumericValue(strasse.charAt(i))*7);
		}
		for (int i=0; i<hausNummer.length(); i++) {
			hash=hash+(Character.getNumericValue(hausNummer.charAt(i))*7);
		}
		
		return hash;
	}
}

class AdressVergleicher implements Comparator<Adresse> {
	
	AdressVergleicher() {
	}
	@Override
	public int compare(Adresse ad1, Adresse ad2) {
        if (ad1.equals(ad2)) {
            return 0;
        }
        if (ad1.getOrt().getPostleitzahl() > ad2.getOrt().getPostleitzahl()) {
            return 1;
        }
        if (ad1.getOrt().getPostleitzahl() < ad2.getOrt().getPostleitzahl()) {
            return -1;
        }
        if (ad1.getOrt().getPostleitzahl() == ad2.getOrt().getPostleitzahl()) {
            if (ad1.getStrasse().compareTo(ad2.getStrasse())==1) {
                return 1;
            }
            if (ad1.getStrasse().compareTo(ad2.getStrasse())==-1) {
                return -1;
            }
            if (ad1.getStrasse().compareTo(ad2.getStrasse())==0) {
                if (ad1.getHausNummer().compareTo(ad2.getHausNummer())==1) {
                    return 1;
                }
                if (ad1.getHausNummer().compareTo(ad2.getHausNummer())==-1) {
                    return -1;
                }
                if (ad1.getHausNummer().compareTo(ad2.getHausNummer())==0) {
                    return 0;
                }
            }
        }
        return 0;

    }
	
}