package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {
	TwitterPoruka poruka;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}
	
	@After
	public void tearDown() throws Exception {
		poruka = null;
	}
	
	@Test
	public void testSetKorisnikSveOk() {
		String korisnik = "Marina";
		poruka.setKorisnik(korisnik);
		assertEquals(korisnik, poruka.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		String korisnik = null;
		poruka.setKorisnik(korisnik);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString(){
		String korisnik = "";
		poruka.setKorisnik(korisnik);
	}
	
	@Test
	public void testSetPorukaSveOk() {
		String poruka = "Bla bla bla";
		this.poruka.setPoruka(poruka);
		assertEquals(poruka, this.poruka.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		String poruka = null;
		this.poruka.setPoruka(poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString(){
		String poruka = "";
		this.poruka.setPoruka(poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaViseOd140Znakova(){
		String poruka = "Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova, "
				+ "Neka mnogo duga poruka sa vise od 140 znakova, Neka mnogo duga poruka sa vise od 140 znakova.";
		this.poruka.setPoruka(poruka);
	}
	
	@Test 
	public void testToStringSveOk(){
		String poruka = "Bla bla bla";
		String korisnik = "Marina";
		this.poruka.setPoruka(poruka);
		this.poruka.setKorisnik(korisnik);
		assertEquals("KORISNIK:"+korisnik+" PORUKA:"+poruka, this.poruka.toString());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testToStringNullParametri(){
		String poruka = null;
		String korisnik = null;
		this.poruka.setPoruka(poruka);
		this.poruka.setKorisnik(korisnik);
		assertEquals("KORISNIK:"+korisnik+" PORUKA:"+poruka, this.poruka.toString());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testToStringPrazniStringovi(){
		String poruka = "";
		String korisnik = "";
		this.poruka.setPoruka(poruka);
		this.poruka.setKorisnik(korisnik);
		assertEquals("KORISNIK:"+korisnik+" PORUKA:"+poruka, this.poruka.toString());
	}
}
