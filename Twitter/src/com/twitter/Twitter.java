package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;
/**
 * @author Marina Guzvic
 * Ova klasa sadrzi listu Twitter poruka
 * 
 *
 */
public class Twitter {
	/**
	 * Ovaj atribut predstavlja listu twitter poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Ova metoda vraca sve poruke iz liste
	 * @return poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
 	 * Ovaj atribut predstavlja listu poruka
 	 * Ova metoda sluzi za unos nove Twitter poruke
 	 * @param 
 	 * <ul>
	 * <li>String korisnik - ime korisnika</li>
	 * <li>String poruka - tekst poruke</li>
 	 * </ul>
	 * @throws RuntimeException
	 * @returns LinkedList<> poruke
 	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja pretrazuje poruke po zadatom tekstu,
	 * prodslednjujemo joj maksimalan broj poruka koje treba da vrati i kriterijuma, a ona
	 * nam vraca niz poruka
	 * @param int maxBroj - maksimalan broj poruka, String tag - tekst po kome pretrazuje
	 * @throws RuntimeException
	 * @return TwitterPoruka [] - niz poruka 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0) maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				} else break;
		return rezultat;
	}

}
