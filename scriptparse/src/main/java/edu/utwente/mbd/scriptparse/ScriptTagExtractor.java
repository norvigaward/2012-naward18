package edu.utwente.mbd.scriptparse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static com.google.common.base.Preconditions.*;

/**
 * Extract script tags form a document
 * @author kockt
 *
 */
public class ScriptTagExtractor {
	public final static String SCRIPT_TAG_SELECTOR = "script";
	public final static String SRC_ATTRIBUTE = "src";
	
	/**
	 * Instantiate tag extractor based on parsed DOM content
	 * @param content (jsoup) document to analyze
	 * @param addr address of the page
	 * @throws IllegalArgumentException when arugments are null
	 */
	public static Iterable<ScriptInformation> getScripts(String addr, Document content) throws IllegalArgumentException, MalformedURLException{
		final Document document = checkNotNull(content); // explicit null check
		final URL url = new URL(checkNotNull(addr));
		
		// get script tags from document
		for (Element elem : document.select(SCRIPT_TAG_SELECTOR)){
			if (elem.hasAttr(SRC_ATTRIBUTE)){ // external JS
				// is it local or remote?
				
				
			} else {
				// match against inline JS
				// return when it is a match
			}	
		}
		
		return null;
	}
	
	/**
	 * "tuple" of (fileName, isInline, isBodyLess)
	 */
	public class ScriptInformation{
		public final boolean inline;
		public final boolean empty;
		public final boolean selfClosing;
		public final String fileName;
		
		public ScriptInformation(String fileName, boolean inline, boolean empty, boolean selfClosing){
			this.fileName = checkNotNull(fileName);
			this.selfClosing = selfClosing;
			this.inline = inline;
			this.empty = empty;
		}
	}
}
