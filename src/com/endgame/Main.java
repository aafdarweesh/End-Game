package com.endgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class Main extends Activity implements OnTouchListener {

	ViewClass theClass;
	private float x , y , firstX , firstY , endX , endY;
	private boolean TouchDown = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		theClass = new ViewClass(this);
		theClass.setOnTouchListener(this);
		// from here
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
						WindowManager.LayoutParams.FLAG_FULLSCREEN);
				// to here full Screen Code
		setContentView(theClass);
		x = y = firstX = firstY = endX = endY = 0;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		theClass.Pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		theClass.Resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x = event.getX();
		y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: // ma3naha bdayat al touch
			TouchDown = true;
			
			firstX = event.getX();
			firstY = event.getY();

			break;
		case MotionEvent.ACTION_UP:
			TouchDown = false;
			endX = event.getX();
			endY = event.getY();

			break;

		}
		return false;
	}

	private class ViewClass extends SurfaceView implements Runnable {
		private SurfaceHolder holder;
		private Thread MainThread;
		private boolean runClass = false;
		private Bitmap setting , shop , play , score , coins;
		private Display display = getWindowManager().getDefaultDisplay();
		private float ScreenWidth = display.getWidth(); // deprecated
		private float ScreenHeight = display.getHeight(); // deprecated
		

		public ViewClass(Context context) {
			super(context);
			holder = getHolder();
			// TODO Auto-generated constructor stub
			setting = BitmapFactory.decodeResource(getResources(), R.drawable.backavatar);
			shop = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
			
		}

		public void Pause() {
			runClass = false;

			while (true) {
				try {
				MainThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			MainThread = null;
		}

		public void Resume() {
			runClass = true;

			MainThread = new Thread(this);
			MainThread.start();
		}

		@Override
		public void run() {

			while (runClass) {
				if (!holder.getSurface().isValid()) // (!) ma3naha not
					continue; // ma3naha 5aleek fe if l3'ayat lma tb2a if false

				Canvas canvas = holder.lockCanvas(); // ma3naha private
				canvas.drawColor(R.drawable.bacground);// momkan ta3'ayaroo 3lshan yab2a
												// 2albackground

				if(TouchDown){
					Intent i = new Intent(Main.this , Space.class);
					startActivity(i);
				}
				
				holder.unlockCanvasAndPost(canvas); // bya3rad alcanvas

	}

}
	}
}
