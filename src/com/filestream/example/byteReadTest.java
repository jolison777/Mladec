package com.filestream.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class byteReadTest {
	public static void main(String[] args) {
		try(FileInputStream fiss = new FileInputStream("C:\\Users\\jolison.e1\\Documents\\bytetest.txt");
				BufferedInputStream biss = new BufferedInputStream(fiss))
		{
			byte[] br = new byte[1024];
			int x = 0;
			while((x=biss.read(br)) != -1)
			{
				System.out.println(new String(br,0,x));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}

}
