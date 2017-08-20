package com.end2;

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

public class PlayPage extends Activity implements OnClickListener {

	Button space, earth, water, crazy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);

		space = (Button) findViewById(R.id.bPlaySpace);
		earth = (Button) findViewById(R.id.bPlayEarth);
		water = (Button) findViewById(R.id.bPlayWater);
		crazy = (Button) findViewById(R.id.bPlayCrazy);

		space.setOnClickListener(this);
		earth.setOnClickListener(this);
		water.setOnClickListener(this);
		crazy.setOnClickListener(this);

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
		case R.id.bPlaySpace:
			Intent iSpace = new Intent(PlayPage.this, com.end2.MainSpace.class);
			startActivity(iSpace);
			break;
		case R.id.bPlayEarth:
			Intent iEarth = new Intent(PlayPage.this, com.end2.MainEarth.class);
			startActivity(iEarth);
			break;
		case R.id.bPlayWater:
			Intent iWater = new Intent(PlayPage.this, com.end2.MainWater.class);
			startActivity(iWater);
			break;
		case R.id.bPlayCrazy:
			Intent iCrazy = new Intent(PlayPage.this, com.end2.MainCrazy.class);
			startActivity(iCrazy);
			break;

		}

	}

}
