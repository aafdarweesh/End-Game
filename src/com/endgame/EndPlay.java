package com.endgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class EndPlay extends Activity implements OnTouchListener{

	int score=0;
	TextView scoreText = null;
	Intent i;
	SharedPreferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.end);
		
		pref = getSharedPreferences("Space_Data", Context.MODE_PRIVATE);
		
		score = pref.getInt("Score", 0);
		
		scoreText = (TextView) findViewById(R.id.textView1);
		//score = i.getIntExtra("score", 0);
		String s = "the Score is =  "+ score;
		scoreText.setText(s);
		scoreText.setTextSize(100);
		scoreText.setTextColor(Color.BLACK);
		
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		Intent iii = new Intent(EndPlay.this , Space.class);
		//iii.putExtra("+score", score);
		startActivity(iii);
		
		return true;
	}

	
}
