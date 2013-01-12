package edu.utwente.mbd.scriptparse;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import static com.google.common.base.Preconditions.*;

public class ScriptTagExtractor {
	// HTTPS
	public final String HTTPS = "https";
	
	private final Document document;
	private final URL url;
	
	/**
	 * Instantiate tag extractor based on parsed DOM content
	 * @param content
	 * @throws IllegalArgumentException when arugmnets are null
	 */
	public ScriptTagExtractor(String url, Document content) throws MalformedURLException, IllegalArgumentException{
		this.url = new URL(checkNotNull(url));
		this.document = checkNotNull(content);
	}
}
