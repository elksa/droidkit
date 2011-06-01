package org.droidkit.net.ezhttp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EzHttpFilePostUploadEntity extends AbstractEzHttpPostUploadEntity {

	private File mFile;

	public EzHttpFilePostUploadEntity(File f, String paramName, String postFileName, String contentType) {
		super(paramName, postFileName, contentType);
		mFile = f;
		if ((!mFile.exists()) || !(mFile.isFile())) {
			throw new RuntimeException("Tried to create an EzHttpFilePostUploadEntity from a file that does not exist");
		}
	}

	@Override
	public InputStream getInputStream() {
		try {
			return new FileInputStream(mFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public long getSize() {
		return mFile.length();
	}

}
