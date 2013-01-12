package edu.utwente.mbd.scriptparse;

import java.net.MalformedURLException;
import java.net.URL;

import static com.google.common.base.Preconditions.*;

public class URLTools {
	public final static String HTTP = "http";
	public final static String HTTPS = "https";
	
	/**
	 * Is the given URL a HTTPS url?
	 * @param address URL over http protocol
	 * @return true when https, false when http
	 * @throws MalformedURLException when URL is invalid or when protocol is http nor https
	 */
	public static boolean isSecureHTTP(String address) throws MalformedURLException{
		URL url = new URL(checkNotNull(address));
		
		if (!(url.getProtocol().equalsIgnoreCase(HTTP) || url.getProtocol().equalsIgnoreCase(HTTPS)))
			throw new MalformedURLException(String.format("Expected HTTP or HTTPS protocol, not %s",url.getProtocol()));
		
		return url.getProtocol().equalsIgnoreCase(HTTPS);
	}
	
	/**
	 * Get the last URL segment from the given address
	 * @return last url segment, or the directory name if the path refers to a directory
	 * @throws MalformedURLException when URL is invalid
	 * @throws IllegalArgumentException when null
	 */
	public static String getFilename(String address) throws MalformedURLException{
		URL url = new URL(checkNotNull(address));
		
		String path = url.getPath();
		if (path.endsWith("/")){
			return path; // was index of site
		}
		// this is an relative URL from the root, get the last piece
		return path.substring(path.lastIndexOf('/') + 1);
	}

}
