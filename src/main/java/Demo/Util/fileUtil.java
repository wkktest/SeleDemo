package Demo.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Demo.Base.base;
import org.openqa.selenium.By;


public class fileUtil extends base {
	/**
	 * id下载文件
	 * 
	 * @param id
	 * @param filepath
	 */
	public static void download(String id, String filepath) {
		driver.findElement(By.id(id)).sendKeys(filepath);
	}

	/**
	 * id上传文件
	 * 
	 * @param id
	 * @param filepath
	 */
	public static void upload(String id, String filepath) {
		driver.findElement(By.id(id)).sendKeys(filepath);
	}

	/**
	 * 删除文件
	 * 
	 * @throws Exception
	 */
	/**
	 * 删除文件：包括文件，空的文件夾
	 * 
	 * @param folderPath
	 *            文件夹完整绝对路径
	 */

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容，不包括空的文件夾
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定文件夹下:所有文件，不包括空的文件夾
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 */

	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 刪除文件不包括本身文件夾
	 * 
	 * @param delpath
	 * @return
	 * @throws Exception
	 */
	public static boolean deletefile(String delpath) throws Exception {
		try {

			File file = new File(delpath);
			// 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
			if (!file.isDirectory()) {
				file.delete();
			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delpath + "\\" + filelist[i]);
					if (!delfile.isDirectory()) {
						delfile.delete();
						System.out.println(delfile.getAbsolutePath() + "删除文件成功");
					} else if (delfile.isDirectory()) {
						deletefile(delpath + "\\" + filelist[i]);
						System.out.println(file + "ssss");
					}
				}
				if (!file.toString().equals("D:\\file")) { // 选择不删除自身文件夹
					System.out.println(file.toString() + "lllllll");
					file.delete();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("deletefile() Exception:" + e.getMessage());
		}
		return true;
	}

	/**
	 * 复制文件夹
	 */

	
	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public static void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 复制文件
	 */
	public static void copyFile(String oldPath, String newPath) throws IOException {
		File oldFile = new File(oldPath);
		File file = new File(newPath);
		FileInputStream in = new FileInputStream(oldFile);
		FileOutputStream out = new FileOutputStream(file);
		;
		byte[] buffer = new byte[2097152];
		while ((in.read(buffer)) != -1) {
			out.write(buffer);
		}

	}

}
