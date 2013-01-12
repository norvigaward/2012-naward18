package edu.utwente.mbd;

import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.junit.Assert.*;

import edu.utwente.mbd.scriptparse.ScriptTagExtractor;
import edu.utwente.mbd.scriptparse.URLTools;

public class TestURLTools {
	@Test
	public void correctlyDetectsHTTP() throws MalformedURLException {
		// normal + caps + mixed case
		assertFalse(URLTools.isSecureHTTP("http://www.example.org"));
		assertFalse(URLTools.isSecureHTTP("HTTP://www.example.org"));
		assertFalse(URLTools.isSecureHTTP("HtTP://www.example.org"));
	}

	@Test
	public void correctlyDetectsHTTPS() throws MalformedURLException {
		// normal + caps + mixed case
		assertTrue(URLTools.isSecureHTTP("https://www.example.org"));
		assertTrue(URLTools.isSecureHTTP("HTTPS://www.example.org"));
		assertTrue(URLTools.isSecureHTTP("HtTPs://www.example.org"));
	}

	@Test(expected=MalformedURLException.class)
	public void rejectsNonHTTP() throws MalformedURLException {
		URLTools.isSecureHTTP("ftp://ftp.example.org");
	}
	
	@Test
	public void testFilenameChecks() throws MalformedURLException{
		assertEquals("/", URLTools.getFilename("http://www.example.org/"));
		assertEquals("foo", URLTools.getFilename("http://www.example.org/foo"));
		
		// what happens with sub directories?
		assertEquals("foo", URLTools.getFilename("http://www.example.org/subdir/second/foo"));
		assertEquals("/subdir/foo/", URLTools.getFilename("http://www.example.org/subdir/foo/"));
		
		// ignore get parameters
		assertEquals("foo", URLTools.getFilename("http://www.example.org/foo?bla"));
	}
}
