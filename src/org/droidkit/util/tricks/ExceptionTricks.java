package org.droidkit.util.tricks;

public class ExceptionTricks {
	public static String getThrowableTraceAsString(Throwable t) {
		if (t == null)
			return "";
		
		StringBuilder b = new StringBuilder(t.getMessage() + "\n");
		StackTraceElement[] elms = t.getStackTrace();
		for (int i = 0; i<elms.length; i++) {
			StackTraceElement elm = elms[i];
			b.append("\t at " + elm.getClassName() + "." + elm.getMethodName() + "(" + elm.getFileName() + ":" + elm.getLineNumber() + ")\n");
		}
		return b.toString();
	}
}
