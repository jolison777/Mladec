package com.filestream.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class CharReadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileReader fr=new FileReader("C:\\Users\\jolison.e1\\Documents\\chartest.txt");
				BufferedReader bw=new BufferedReader(fr)){
			System.out.println(bw.readLine());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
