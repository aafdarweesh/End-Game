package com.end2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.endgame.R;

public class SpaceChoose extends Activity implements OnClickListener {

	Button evile, angle, random;
	SharedPreferences pepo = getSharedPreferences("SpaceChoose_Data",
			Context.MODE_PRIVATE);
	Editor edit = pepo.edit();

	int image1, image2, image3, image4, image5, image6, image7, image8, image9,
			image10, image11, image12, image13, image14, image15;

	int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;

	int Eimage1, Eimage2, Eimage3, Eimage4, Eimage5, Eimage6, Eimage7, Eimage8,
			Eimage9, Eimage10, Eimage11, Eimage12, Eimage13, Eimage14,
			Eimage15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose);

		evile = (Button) findViewById(R.id.bChooseEvil);
		angle = (Button) findViewById(R.id.bChooseAngle);
		random = (Button) findViewById(R.id.bChooseRandom);

		evile.setOnClickListener(this);
		angle.setOnClickListener(this);
		random.setOnClickListener(this);

		i1 = i2 = i3 = i4 = i5 = i6 = i7 = i8 = i9 = i10 = i11 = i12 = i13 = i14 = i15 = 0;

		/*
		image1 = R.drawable.bacground;
		image2 = R.drawable.backavatar;
		image3 = R.drawable.ball;
		image4 = R.drawable.ballone;
		image5 = R.drawable.ballthree;
		image6 = R.drawable.balltwo;
		image7 = R.drawable.boxafter;
		image8 = R.drawable.boxbefore;
		image9 = R.drawable.firstm;
		image10 = R.drawable.forimage;
		image11 = R.drawable.hadood;
		image12 = R.drawable.ic_launcher;
		image13 = R.drawable.imprint;
		image14 = R.drawable.rok;
		image15 = R.drawable.secm;
		
		Eimage1 = R.drawable.seimage;
		Eimage2 = R.drawable.thimage;
		Eimage3 = R.drawable.thirm;
		*/
		i1 = pepo.getInt("IntAvatar1", 0);
		i2 = pepo.getInt("IntAvatar2", 0);
		i3 = pepo.getInt("IntAvatar3", 0);
		i4 = pepo.getInt("IntAvatar4", 0);
		i5 = pepo.getInt("IntAvatar5", 0);
		i6 = pepo.getInt("IntAvatar6", 0);
		i7 = pepo.getInt("IntAvatar7", 0);
		i8 = pepo.getInt("IntAvatar8", 0);
		i9 = pepo.getInt("IntAvatar9", 0);
		i10 = pepo.getInt("IntAvatar10", 0);
		i11 = pepo.getInt("IntAvatar11", 0);
		i12 = pepo.getInt("IntAvatar12", 0);
		i13 = pepo.getInt("IntAvatar13", 0);
		i14 = pepo.getInt("IntAvatar14", 0);
		i15 = pepo.getInt("IntAvatar15", 0);
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bChooseEvil:
			// edit.putInt("MeAvatar1", 1);

			Integer[] Sizes = { i1, i2, i3, i4, i5, i6,
					i7, i8, i9, i10, i11, i12, i13,
					i14, i15 };
			Arrays.sort(Sizes, new Comparator<Integer>() {
				@Override
				public int compare(Integer x, Integer y) {
					// for from min to max  x - y;
					return y - x;
					// for max to min return y - x;
				}
			});

			for(int i=0 ; i<5 ; i++){
			String s = "";
			if(i ==0)
				s = "MeAvatar1";
			if(i == 1)
				s = "MeAvatar2";
			if(i == 2)
				s = "MeAvatar3";
			if(i == 3)
				s = "MeAvatar4";
			if(i == 4)
				s = "MeAvatar5";			
			
			if(i1 == Sizes[i])
				edit.putString(s, "i1");
			if(i2 == Sizes[i])
				edit.putString(s, "i2");
			if(i3 == Sizes[i])
				edit.putString(s, "i3");
			if(i4 == Sizes[i])
				edit.putString(s, "i4");
			if(i5 == Sizes[i])
				edit.putString(s, "i5");
			if(i6 == Sizes[i])
				edit.putString(s, "i6");
			if(i7 == Sizes[i])
				edit.putString(s, "i7");
			if(i8 == Sizes[i])
				edit.putString(s, "i8");
			if(i9 == Sizes[i])
				edit.putString(s, "i9");
			if(i10 == Sizes[i])
				edit.putString(s, "i10");
			if(i11 == Sizes[i])
				edit.putString(s, "i11");
			if(i12 == Sizes[i])
				edit.putString(s, "i12");
			if(i13 == Sizes[i])
				edit.putString(s, "i13");
			if(i14 == Sizes[i])
				edit.putString(s, "i14");
			if(i15 == Sizes[i])
				edit.putString(s, "i15");
			
			}
			Random r = new Random();
			
			edit.putString("EvilBall", "");
			edit.commit();

			Intent i = new Intent(SpaceChoose.this, MainSpace.class);
			startActivity(i);
			break;
		case R.id.bChooseAngle:
			
			Intent iangle = new Intent(SpaceChoose.this, MainSpace.class);
			startActivity(iangle);
			break;
		case R.id.bChooseRandom:
			Intent irandom = new Intent(SpaceChoose.this, MainSpace.class);
			startActivity(irandom);
			break;
		}

	}

}
