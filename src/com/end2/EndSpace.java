package com.end2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.endgame.R;

public class EndSpace extends Activity {

	int score=0;
	TextView scoreText = null;
	Intent i;
	SharedPreferences pref;
	Button again;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.end);
		
		pref = getSharedPreferences("Space_Data", Context.MODE_PRIVATE);
		Editor e = pref.edit();
		e.putBoolean("pause", false);
		e.commit();
		
		score = pref.getInt("Score", 0);
		
		scoreText = (TextView) findViewById(R.id.textView1);
		again = (Button) findViewById(R.id.bEndPlayAgain);
		//score = i.getIntExtra("score", 0);
		String s = "the Score is =  "+ score;
		scoreText.setText(s);
		scoreText.setTextSize(100);
		scoreText.setTextColor(Color.BLACK);
		
		again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iii = new Intent(EndSpace.this , MainSpace.class);
				//iii.putExtra("+score", score);
				startActivity(iii);
			}
		});
		
	} 

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//Intent ii = new Intent(EndPlay.this , PauseClass.class);
		//ii.putExtra("+score", score);
		//startActivity(ii);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	
}
