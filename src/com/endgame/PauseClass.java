package com.endgame;

import com.endgame.Space.ForGrafexSurFace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PauseClass extends Activity{
Button Rb;
ForGrafexSurFace s ;
//boolean paused = true;
Space space;
Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pause);
		Rb = (Button) findViewById(R.id.bResume);
		
		
		//paused = i.getBooleanExtra("pause", true);
		
		Rb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent(PauseClass.this , Space.class);
				//space.paused = true;
				//space.PauseClass(true);
				//i.putExtra("pp", true);
				startActivity(i);

			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		i = new Intent(PauseClass.this , Space.class);
		//space.paused = true;
		//space.PauseClass(true);
		//i.putExtra("pp", true);
		startActivity(i);
	}

	
}
