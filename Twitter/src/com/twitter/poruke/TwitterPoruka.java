package com.twitter.poruke;
/**
 * @author Marina Guzvic
 * Ova klasa predstavlja jednu Twitter poruku i sadrzi metode
 * za setovanje i getovanje poruke i korisnika koji salje poruku
 *
 */
public class TwitterPoruka {
	/**
	 * Ovo je atribut koji oznacava korisnika koji salje Twitter poruku
	 *
	 */
	private String korisnik; 
	/**
	 * Ovo je atribut koji sadrzi tekst poruke koju je korisnik poslao
	 *
	 */
	private String poruka; 
	/**
	 * @return korisnik
	 * Ova metoda vraca korisnika koji je napisao ovu poruku
	 *
	 */
	public String getKorisnik() { 
		return korisnik; 
	} 
	/**
 	 * Upisuje ime korisniku
-	 * @param String korisnik
+	 * @throws RuntimeException, u slucaju da je uneti parametar null ili prazan String
 	 */
	public void setKorisnik(String korisnik) { 
		if (korisnik==null || korisnik == "") 
			throw new RuntimeException("Ime korisnika mora biti uneto"); 
		this.korisnik = korisnik; 
	} 
	/**
	 *
	 * @return String poruka
	 *	Ova metoda vraca poruku koju je korisnik poslao
	 */	
	public String getPoruka() { 
		return "poruka"; 
	} 
	/**
	 * Postavlja vrednost poruke na unesenu vrednost
	 * @param String poruka
	 * @throws RuntimeException u slucaju da je uneti parametar null, duzi od 140 znakova ili prazan String
	 */	
	public void setPoruka(String poruka) { 
		if (poruka==null || this.poruka.length()>140) 
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka; 
	}
	/**
 	 * Redefinicija toString metode
	 * @return ime korisnika i poruku koju je poslao
 	 *
 	 */	
	public String toString(){ 
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka; 
	} 
}
