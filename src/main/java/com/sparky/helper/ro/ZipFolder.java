package com.sparky.helper.ro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {


	private static String SOURCE_FOLDER ;
    /**
	 * @return the sOURCE_FOLDER
	 */
	public String getSOURCE_FOLDER() {
		return SOURCE_FOLDER;
	}

	/**
	 * @param sOURCE_FOLDER the sOURCE_FOLDER to set
	 */
	public void setSOURCE_FOLDER(String sOURCE_FOLDER) {
		SOURCE_FOLDER = sOURCE_FOLDER;
	}

	/**
	 * @return the dESTINATION_FOLDER
	 */
	public String getDESTINATION_FOLDER() {
		return DESTINATION_FOLDER;
	}

	/**
	 * @param dESTINATION_FOLDER the dESTINATION_FOLDER to set
	 */
	public void setDESTINATION_FOLDER(String dESTINATION_FOLDER) {
		DESTINATION_FOLDER = dESTINATION_FOLDER;
	}

	private static String DESTINATION_FOLDER;

	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList) {

		try {
			FileOutputStream fos = new FileOutputStream(ZipFolder.DESTINATION_FOLDER+"\\"+directoryToZip.getName()+".zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(file);

		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}
}