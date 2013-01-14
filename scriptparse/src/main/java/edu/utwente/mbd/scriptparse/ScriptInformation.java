package edu.utwente.mbd.scriptparse;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

/**
 * "tuple" of (fileName, isInline, isBodyLess)
 */
public final class ScriptInformation{
	public static enum Type { INLINE, LOCAL, REMOTE };
	
	public final Type type;
	public final String fileName;
	public final String pageAddr;
	
	public ScriptInformation(String fileName, String pageAddr, Type type){
		this.fileName = checkNotNull(fileName);
		this.pageAddr = checkNotNull(pageAddr);
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ScriptInformation){
			ScriptInformation that = (ScriptInformation)obj;
			
			return Objects.equal(this.type, that.type) && Objects.equal(this.pageAddr, that.pageAddr) && Objects.equal(this.fileName, that.fileName);			
		}
		return false;
	}
}