package com.example.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class deserializableex {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String path="team.txt";
		try(ObjectInputStream or= new ObjectInputStream(new FileInputStream(path)))
		{
			List<serializableexample> data=(List<serializableexample>)or.readObject();
			for(serializableexample dt:data) {
				System.out.println(dt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
