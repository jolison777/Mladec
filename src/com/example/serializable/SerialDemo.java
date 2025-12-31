package com.example.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class SerialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<serializableexample> data =Arrays.asList(new serializableexample(1, "Kohli", "All rounder","Chennai"),
				new serializableexample(1, "Kohli", "All rounder","Mumbai"),
				new serializableexample(3, "SKY", "All rounder 360","Kolkata"));
				
		String path="team.txt";
		try(ObjectOutputStream ow=new ObjectOutputStream(new FileOutputStream(path))) {
			ow.writeObject(data);
			ow.flush();
			System.out.println("Done");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
