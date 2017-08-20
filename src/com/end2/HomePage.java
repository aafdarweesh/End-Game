package com.end2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.endgame.R;

public class HomePage extends Activity implements OnClickListener {

	Button play, setting, shop , me;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		play = (Button) findViewById(R.id.bHomePlay);
		setting = (Button) findViewById(R.id.bHomeSetting);
		shop = (Button) findViewById(R.id.bHomeShop);
		me = (Button) findViewById(R.id.bHomeMe);
		
		play.setOnClickListener(this);
		setting.setOnClickListener(this);
		shop.setOnClickListener(this);
		me.setOnClickListener(this);

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
		case R.id.bHomePlay:
			Intent i = new Intent(HomePage.this, com.end2.PlayPage.class);
			startActivity(i);
			break;

		case R.id.bHomeSetting:
			Intent iS = new Intent(HomePage.this, com.end2.Setting.class);
			startActivity(iS);

			break;

		case R.id.bHomeShop:
			Intent iSh = new Intent(HomePage.this, com.end2.Shop.class);
			startActivity(iSh);

			break;
		case R.id.bHomeMe:
			Intent iMe = new Intent(HomePage.this, com.end2.Me.class);
			startActivity(iMe);
			break;
		}

	}

}
