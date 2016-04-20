package com.twitter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	 private Twitter twitter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	@Test
	public void testVratiSvePorukeSveOk() {
		String korisnik = "Marina";
		String poruka = "Cao";
		twitter.unesi(korisnik, poruka);
		assertEquals(korisnik, twitter.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(poruka, twitter.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testUnesiSveOk() {
		String korisnik = "Marina";
		String poruka = "Cao";
		twitter.unesi(korisnik, poruka);
		assertEquals(korisnik, twitter.vratiSvePoruke().getLast().getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikNull() {
		String korisnik = null;
		String poruka = "Cao";
		twitter.unesi(korisnik, poruka);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikPrazanString() {
		String korisnik = "";
		String poruka = "Cao";
		twitter.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaNull() {
		String korisnik = "Marina";
		String poruka = null;
		twitter.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaPrazanString() {
		String korisnik = "Marina";
		String poruka = "";
		twitter.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaDuzaOd140() {
		String korisnik = "Marina";
		String poruka = "Pisem nesto i tako dalje Pisem nesto i tako dalje "
				+ "Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje "
				+ "Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje "
				+ "Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje "
				+ "Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje "
				+ "Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje Pisem nesto i tako dalje ";
		twitter.unesi(korisnik, poruka);
	}
	
	@Test
	public void testVratiPorukeSveOk() {
		String korisnik = "Marina";
		String poruka = "Cao ja sam Marina";
		String tag = "sam";
		twitter.unesi(korisnik, poruka);
		TwitterPoruka [] poruke = twitter.vratiPoruke(1, tag);
		assertEquals(1, poruke.length);
		assertEquals(korisnik, poruke[0].getKorisnik());
		assertEquals(poruka, poruke[0].getPoruka());
	}


	@Test
	public void testVratiPorukeMaxBrojNegativan() {
		String korisnik = "Marina";
		String poruka = "Cao ja sam Marina";
		String tag = "Cao";
		twitter.unesi(korisnik, poruka);
		TwitterPoruka [] poruke = twitter.vratiPoruke(-1, tag);
		assertEquals(100, poruke.length);
		assertEquals(korisnik, poruke[0].getKorisnik());
		assertEquals(poruka, poruke[0].getPoruka());
	}
	

	

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		String korisnik = "Marina";
		String poruka = "Cao ja sam Marina";
		String tag = "";
		twitter.unesi(korisnik, poruka);
		twitter.vratiPoruke(1, tag);
	}
	
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		String korisnik = "Marina";
		String poruka = "Cao ja sam Marina";
		String tag = null;
		twitter.unesi(korisnik, poruka);
		twitter.vratiPoruke(1, tag);
	}

	
	
	
}