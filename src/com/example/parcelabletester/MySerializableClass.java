package com.example.parcelabletester;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


public class MySerializableClass implements Serializable {
	
	public static final long serialVersionUID = 1865151003590118998L;
	public String mStringData = "";
	public int mIdenty = 0;
	public boolean mIsActive = false;
	public float mDest = 0.0f;
	public ArrayList<String> mStringList;
	
	public MySerializableClass() 
	{
		mStringData = UUID.randomUUID().toString();
		
		mStringList = new ArrayList<String>();
		Random rand = new Random();
		int maxI = rand.nextInt();
		
		for (int i = 0; i < maxI % 15; i++) 
		{
			mStringList.add(UUID.randomUUID().toString());
		}
		
		mIdenty = rand.nextInt();
		mIsActive = rand.nextBoolean();
		mDest = rand.nextFloat();
	}
}
