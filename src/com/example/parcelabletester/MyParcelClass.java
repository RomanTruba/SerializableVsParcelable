package com.example.parcelabletester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelClass implements Parcelable {
	
	private String mStringData = "";
	private int mIdenty = 0;
	private boolean mIsActive = false;
	private float mDest = 0.0f;
	private List<String> mStringList;
	
	public MyParcelClass() 
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
	public MyParcelClass(Parcel parcel) 
	{
		mStringData = parcel.readString();
		mIdenty		= parcel.readInt();
		
		boolean[] temp = new boolean[1];
		parcel.readBooleanArray(temp);
		mIsActive 	= temp[0];
		
		mDest 		= parcel.readFloat();
		mStringList = new ArrayList<String>();;
		parcel.readList(mStringList, null);
	}
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) 
	{
		parcel.writeString(mStringData);
		parcel.writeInt(mIdenty);
		parcel.writeBooleanArray(new boolean[] {mIsActive});
		parcel.writeFloat(mDest);
		parcel.writeList(mStringList);
	}

	public static final Parcelable.Creator<MyParcelClass> CREATOR = new Parcelable.Creator<MyParcelClass>() {
        public MyParcelClass createFromParcel(Parcel in) {
            return new MyParcelClass(in); 
        }

        public MyParcelClass[] newArray(int size) {
            return new MyParcelClass[size];
        }
    };
}
