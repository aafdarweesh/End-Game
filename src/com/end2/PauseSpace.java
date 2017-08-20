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
import android.widget.TextView;

import com.endgame.R;

public class PauseSpace extends Activity{

	Button Rb , Again , Home;
	TextView tx;
	//boolean paused = true;
	Intent i;
	 SharedPreferences preff ;
	 int Time=0;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			
			
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.pause);
			Rb = (Button) findViewById(R.id.bResume);
			Again = (Button) findViewById(R.id.bPlayAgain);
			Home = (Button) findViewById(R.id.bHome);
			
			tx = (TextView) findViewById(R.id.ScoreText);
			
			Again.setText("Restart");
			
			preff = getSharedPreferences("Space_Data", Context.MODE_PRIVATE);

			Time = preff.getInt("TimeCounter", 0);
			boolean paused = preff.getBoolean("pause", false);
			if(Time >= 60 ||  paused == false){
				Editor e = preff.edit();
				e.putBoolean("pause", false);
				e.commit();
				//Intent i = new Intent(PauseSpace.this , EndSpace.class);
				//startActivity(i);
				Rb.setText("Play Again");
				
			}
			
			int integer = preff.getInt("Score", 0);
			tx.setText("this is the result of your match     =    " + integer);
			//paused = i.getBooleanExtra("pause", true);
			
			
			
			Rb.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					i = new Intent(PauseSpace.this , MainSpace.class);
					//space.paused = true;
					//space.PauseSpace(true);
					//i.putExtra("pp", true);
					startActivity(i);

				}
			});
			
			Again.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Editor e = preff.edit();
					e.putBoolean("pause", false);
					e.commit();
					
					Intent iAgain = new Intent(PauseSpace.this , PlayPage.class);
					startActivity(iAgain);
				}
			});
			
			Home.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent iHome = new Intent(PauseSpace.this , HomePage.class);
					startActivity(iHome);
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
			//i = new Intent(PauseSpace.this , MainSpace.class);
			//space.paused = true;
			//space.PauseSpace(true);
			//i.putExtra("pp", true);
			//startActivity(i);
		}

	
}
