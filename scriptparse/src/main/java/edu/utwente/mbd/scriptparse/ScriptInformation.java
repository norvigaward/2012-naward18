package edu.utwente.mbd.scriptparse;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

/**
 * "tuple" of (fileName, isInline, isBodyLess)
 */
public final class ScriptInformation{
	public final boolean inline;
	public final String fileName;
	
	public ScriptInformation(String fileName, boolean inline){
		this.fileName = checkNotNull(fileName);
		this.inline = inline;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ScriptInformation){
			ScriptInformation that = (ScriptInformation)obj;
			
			return Objects.equal(this.inline, that.inline) && Objects.equal(this.fileName, that.fileName);			
		}
		return false;
	}
}