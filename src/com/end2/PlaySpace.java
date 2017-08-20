package com.end2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.endgame.R;

public class PlaySpace extends Activity implements OnTouchListener {
	private ForGrafexSurFace theViewOfSurFace;
	// Bitmap map;
	float x, y;
	float endX, endY;
	float firstX, firstY;
	boolean TouchDown = false;
	boolean TouchUp = false;
	boolean openTouchDown = false;
	boolean resumeGame = true;
	Button Ball, BoxF, BoxB;
	boolean resume = false;
	boolean Ball1, BoxF1, BoxB1, roky1, Ball2;
	int[] destroy = { R.drawable.ball, R.drawable.ballone, R.drawable.balltwo,
			R.drawable.ballthree, R.drawable.backavatar, R.drawable.boxbefore,
			R.drawable.boxafter };

	boolean paused = false;
	boolean runer = false;
	SharedPreferences pppppp;
	MediaPlayer avatarSound, avatarSound2, avatarSound3, BallSound, BallSound2,
			BallSound3, BallSound4, BallSound5;
	int scorepoint = 0;
	MediaPlayer GameSound;

	private SharedPreferences pref = getSharedPreferences("Play_Data",
			Context.MODE_PRIVATE);
	private Editor edit = pref.edit();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		theViewOfSurFace = new ForGrafexSurFace(this);
		theViewOfSurFace.setOnTouchListener(this);

		// from here
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// to here full Screen Code

		firstX = firstY = endX = endY = 0;

		x = y = 10;
		setContentView(theViewOfSurFace);

		GameSound = MediaPlayer.create(PlaySpace.this, R.raw.gamesong);

		avatarSound = MediaPlayer.create(PlaySpace.this, R.raw.wee);
		avatarSound2 = MediaPlayer.create(PlaySpace.this, R.raw.wee);
		avatarSound3 = MediaPlayer.create(PlaySpace.this, R.raw.wee);

		BallSound = MediaPlayer.create(PlaySpace.this, R.raw.victory);
		BallSound2 = MediaPlayer.create(PlaySpace.this, R.raw.victory);
		BallSound3 = MediaPlayer.create(PlaySpace.this, R.raw.victory);
		BallSound4 = MediaPlayer.create(PlaySpace.this, R.raw.victory);
		BallSound5 = MediaPlayer.create(PlaySpace.this, R.raw.victory);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		theViewOfSurFace.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		theViewOfSurFace.resume();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
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

		openTouchDown = true;

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: // ma3naha bdayat al touch
			TouchDown = true;
			TouchUp = false;
			firstX = event.getX();
			firstY = event.getY();

			break;
		case MotionEvent.ACTION_UP:
			TouchUp = true;
			TouchDown = false;
			endX = event.getX();
			endY = event.getY();

			break;

		}

		return true;
	}

	private class ForGrafexSurFace extends SurfaceView implements Runnable {

		SurfaceHolder holder;
		boolean running = false;

		Thread thread = null;
		Bitmap A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14,
				A15;
		boolean a1b, a2b, a3b, a4b, a5b, a6b, a7b, a8b, a9b, a10b, a11b, a12b,
				a13b, a14b, a15b;
		int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;

		float h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15;
		float w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14, w15;

		Display display = getWindowManager().getDefaultDisplay();
		float ScreenWidth = display.getWidth(); // deprecated
		float ScreenHeight = display.getHeight(); // deprecated

		int bitmap = 0;

		boolean work1, work2, work3, work4, work5, work6, work7, work8, work9,
				work10, work11, work12, work13, work14, work15;

		int avatarInt1, avatarInt2, avatarInt3, avatarInt4, avatarInt5;
		int A1o, A2o, A3o, A4o, A5o;
		int Ball1o, Ball2o, Ball3o, Ball4o, Ball5o;
		
		int[] Ao;

		public ForGrafexSurFace(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			holder = getHolder();
			
			Ao = new int[]{0,0,0,0,0};

			avatarInt1 = avatarInt2 = avatarInt3 = avatarInt4 = avatarInt5 = A1o = A2o = A3o = A4o = A5o = Ball1o = Ball2o = Ball3o = Ball4o = Ball5o = 0;

			work1 = work2 = work3 = work4 = work5 = work6 = work7 = work8 = work9 = work10 = work11 = work12 = work13 = work14 = work15 = false;

			i1 = i2 = i3 = i4 = i5 = i6 = i7 = i8 = i9 = i10 = i11 = i12 = i13 = i14 = i15 = 0;
			a1b = a2b = a3b = a4b = a5b = a6b = a7b = a8b = a9b = a10b = a11b = a12b = a13b = a14b = a15b = false;

			h1 = h2 = h3 = h4 = h5 = h6 = h7 = h8 = h9 = h10 = h11 = h12 = h13 = h14 = h15 = w1 = w2 = w3 = w4 = w5 = w6 = w7 = w8 = w9 = w10 = w11 = w12 = w13 = w14 = w15 = 0;

			i1 = pref.getInt("ImageI1", 0);
			i2 = pref.getInt("ImageI2", 0);
			i3 = pref.getInt("ImageI3", 0);
			i4 = pref.getInt("ImageI4", 0);
			i5 = pref.getInt("ImageI5", 0);
			i6 = pref.getInt("ImageI6", 0);
			i7 = pref.getInt("ImageI7", 0);
			i8 = pref.getInt("ImageI8", 0);
			i9 = pref.getInt("ImageI9", 0);
			i10 = pref.getInt("ImageI10", 0);
			i11 = pref.getInt("ImageI11", 0);
			i12 = pref.getInt("ImageI12", 0);
			i13 = pref.getInt("ImageI13", 0);
			i14 = pref.getInt("ImageI14", 0);
			i15 = pref.getInt("ImageI15", 0);

			a1b = pref.getBoolean("ImageB1", false);
			a2b = pref.getBoolean("ImageB2", false);
			a3b = pref.getBoolean("ImageB3", false);
			a4b = pref.getBoolean("ImageB4", false);
			a5b = pref.getBoolean("ImageB5", false);
			a6b = pref.getBoolean("ImageB6", false);
			a7b = pref.getBoolean("ImageB7", false);
			a8b = pref.getBoolean("ImageB8", false);
			a9b = pref.getBoolean("ImageB9", false);
			a10b = pref.getBoolean("ImageB10", false);
			a11b = pref.getBoolean("ImageB11", false);
			a12b = pref.getBoolean("ImageB12", false);
			a13b = pref.getBoolean("ImageB13", false);
			a14b = pref.getBoolean("ImageB14", false);
			a15b = pref.getBoolean("ImageB15", false);

			A1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bacground);
			A2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.backavatar);
			A3 = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
			A4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ballone);
			A5 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ballthree);
			A6 = BitmapFactory.decodeResource(getResources(),
					R.drawable.balltwo);
			A7 = BitmapFactory.decodeResource(getResources(),
					R.drawable.boxafter);
			A8 = BitmapFactory.decodeResource(getResources(),
					R.drawable.boxbefore);
			A9 = BitmapFactory
					.decodeResource(getResources(), R.drawable.firstm);
			A10 = BitmapFactory.decodeResource(getResources(),
					R.drawable.forimage);
			A11 = BitmapFactory.decodeResource(getResources(),
					R.drawable.hadood);
			A12 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ic_launcher);
			A13 = BitmapFactory.decodeResource(getResources(),
					R.drawable.imprint);
			A14 = BitmapFactory.decodeResource(getResources(), R.drawable.rok);
			A15 = BitmapFactory.decodeResource(getResources(), R.drawable.secm);

			bitmap = (int) ScreenHeight / 6;

			h1 = 0;
			h2 = bitmap;
			h3 = 2 * bitmap;
			h4 = 3 * bitmap;
			h5 = 4 * bitmap;
			h6 = 5 * bitmap;
			h7 = 0;
			h8 = bitmap;
			h9 = 2 * bitmap;
			h10 = 3 * bitmap;
			h11 = 4 * bitmap;
			h12 = 5 * bitmap;
			h13 = 0;
			h14 = bitmap;
			h15 = 2 * bitmap;

			w1 = w2 = w3 = w4 = w5 = w6 = 0;
			w7 = w8 = w9 = w10 = w11 = w12 = bitmap;
			w13 = w14 = w15 = 2 * bitmap;

		}

		public void pause() {
			running = false;

			// if(thread != null){
			while (true) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			thread = null;

		}

		public void resume() {
			// runer = true;
			running = true;

			// thread = null;
			thread = new Thread(this);
			thread.start();
		}

		@Override
		public void run() {

			while (running) {
				if (!holder.getSurface().isValid()) // (!) ma3naha not
					continue; // ma3naha 5aleek fe if l3'ayat lma tb2a if false

				Canvas canvas = holder.lockCanvas(); // ma3naha private
				canvas.drawColor(Color.BLACK);// momkan ta3'ayaroo 3lshan yab2a
												// 2albackground

				
				Bitmap a1 = Bitmap.createScaledBitmap(A1, bitmap, bitmap, true);
				Bitmap a2 = Bitmap.createScaledBitmap(A2, bitmap, bitmap, true);
				Bitmap a3 = Bitmap.createScaledBitmap(A3, bitmap, bitmap, true);
				Bitmap a4 = Bitmap.createScaledBitmap(A4, bitmap, bitmap, true);
				Bitmap a5 = Bitmap.createScaledBitmap(A5, bitmap, bitmap, true);
				Bitmap a6 = Bitmap.createScaledBitmap(A6, bitmap, bitmap, true);
				Bitmap a7 = Bitmap.createScaledBitmap(A7, bitmap, bitmap, true);
				Bitmap a8 = Bitmap.createScaledBitmap(A8, bitmap, bitmap, true);
				Bitmap a9 = Bitmap.createScaledBitmap(A9, bitmap, bitmap, true);
				Bitmap a10 = Bitmap.createScaledBitmap(A10, bitmap, bitmap,
						true);
				Bitmap a11 = Bitmap.createScaledBitmap(A11, bitmap, bitmap,
						true);
				Bitmap a12 = Bitmap.createScaledBitmap(A12, bitmap, bitmap,
						true);
				Bitmap a13 = Bitmap.createScaledBitmap(A13, bitmap, bitmap,
						true);
				Bitmap a14 = Bitmap.createScaledBitmap(A14, bitmap, bitmap,
						true);
				Bitmap a15 = Bitmap.createScaledBitmap(A15, bitmap, bitmap,
						true);

				if (TouchDown) {
					// for the first photo
					if (firstX >= 0 && firstX <= bitmap && firstY >= 0
							&& firstY <= bitmap) {
						work1 = true;
					}
					// btimap2
					if (firstX >= 0 && firstX <= bitmap && firstY >= bitmap
							&& firstY <= 2 * bitmap) {
						work2 = true;
					}
					// bitmap3
					if (firstX >= 0 && firstX <= bitmap && firstY >= 2 * bitmap
							&& firstY <= 3 * bitmap) {
						work3 = true;
					}
					// bitmap4
					if (firstX >= 0 && firstX <= bitmap && firstY >= 3 * bitmap
							&& firstY <= 4 * bitmap) {
						work4 = true;
					}
					// bitmap5
					if (firstX >= 0 && firstX <= bitmap && firstY >= 4 * bitmap
							&& firstY <= 5 * bitmap) {
						work5 = true;
					}
					// bitmap6
					if (firstX >= 0 && firstX <= bitmap && firstY >= 5 * bitmap
							&& firstY <= 6 * bitmap) {
						work6 = true;
					}
					// bitmap7
					if (firstX >= bitmap && firstX <= 2 * bitmap && firstY >= 0
							&& firstY <= bitmap) {
						work7 = true;
					}
					// bitmap8
					if (firstX >= bitmap && firstX <= 2 * bitmap
							&& firstY >= bitmap && firstY <= 2 * bitmap) {
						work8 = true;
					}
					// bitmap9
					if (firstX >= bitmap && firstX <= 2 * bitmap
							&& firstY >= 2 * bitmap && firstY <= 3 * bitmap) {
						work9 = true;
					}
					// bitmap10
					if (firstX >= bitmap && firstX <= 2 * bitmap
							&& firstY >= 3 * bitmap && firstY <= 4 * bitmap) {
						work10 = true;
					}
					// bitmap11
					if (firstX >= bitmap && firstX <= 2 * bitmap
							&& firstY >= 4 * bitmap && firstY <= 5 * bitmap) {
						work11 = true;
					}
					// bitmap12
					if (firstX >= bitmap && firstX <= 2 * bitmap
							&& firstY >= 5 * bitmap && firstY <= 6 * bitmap) {
						work12 = true;
					}
					// bitmap13
					if (firstX >= 2 * bitmap && firstX <= 3 * bitmap
							&& firstY >= 0 && firstY <= bitmap) {
						work13 = true;
					}
					// bitmap14
					if (firstX >= 2 * bitmap && firstX <= 3 * bitmap
							&& firstY >= bitmap && firstY <= 2 * bitmap) {
						work14 = true;
					}
					// bitmap15
					if (firstX >= 2 * bitmap && firstX <= 3 * bitmap
							&& firstY >= 2 * bitmap && firstY <= 3 * bitmap) {
						work15 = true;
					}
					Bitmap ava = Bitmap.createScaledBitmap(a1,
							canvas.getHeight() / 2, canvas.getHeight() / 2,
							true);
					canvas.drawBitmap(ava,
							canvas.getWidth() - (canvas.getWidth() / 4), 0,
							null);

				}

				if (work1) {
					w1 = x;
					h1 = y;

					if (TouchUp) {
						work1 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 1;
								a1b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 1;
								a1b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 1;
								a1b = false;
							}else if(Ao[3] == 0){
								Ao[3] =1;
								a1b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 1;
								a1b = false;
							}else{
								a1b = true;
							}
						}
					}
				}
				if (work2) {
					w2 = x;
					h2 = y;

					if (TouchUp) {
						work2 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 2;
								a2b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 2;
								a2b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 2;
								a2b = false;
							}else if(Ao[3] == 0){
								Ao[3] =2;
								a2b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 2;
								a2b = false;
							}else{
								a2b = true;
							}
						}
					}
				}
				if (work3) {
					w3 = x;
					h3 = y;

					if (TouchUp) {
						work3 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 3;
								a3b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 3;
								a3b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 3;
								a3b = false;
							}else if(Ao[3] == 0){
								Ao[3] =3;
								a3b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 3;
								a3b = false;
							}else{
								a3b = true;
							}
						}
					}
				}
				if (work4) {
					w4 = x;
					h4 = y;

					if (TouchUp) {
						work4 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 4;
								a4b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 4;
								a4b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 4;
								a4b = false;
							}else if(Ao[3] == 0){
								Ao[3] =4;
								a4b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 4;
								a4b = false;
							}else{
								a4b = true;
							}
						}
					}
				}
				if (work5) {
					w5 = x;
					h5 = y;

					if (TouchUp) {
						work5 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 5;
								a5b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 5;
								a5b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 5;
								a5b = false;
							}else if(Ao[3] == 0){
								Ao[3] =5;
								a5b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 5;
								a5b = false;
							}else{
								a5b = true;
							}
						}
					}
				}
				if (work6) {
					w6 = x;
					h6 = y;

					if (TouchUp) {
						work6 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 6;
								a6b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 6;
								a6b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 6;
								a6b = false;
							}else if(Ao[3] == 0){
								Ao[3] =6;
								a6b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 6;
								a6b = false;
							}else{
								a6b = true;
							}
						}
					}
				}
				if (work7) {
					w7 = x;
					h7 = y;

					if (TouchUp) {
						work7 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 7;
								a7b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 7;
								a7b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 7;
								a7b = false;
							}else if(Ao[3] == 0){
								Ao[3] =7;
								a7b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 7;
								a7b = false;
							}else{
								a7b = true;
							}
						}
					}
				}
				if (work8) {
					w8 = x;
					h8 = y;

					if (TouchUp) {
						work8 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 8;
								a8b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 8;
								a8b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 8;
								a8b = false;
							}else if(Ao[3] == 0){
								Ao[3] =8;
								a8b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 8;
								a8b = false;
							}else{
								a8b = true;
							}
						}
					}
				}
				if (work9) {
					w9 = x;
					h9 = y;

					if (TouchUp) {
						work9 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 9;
								a9b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 9;
								a9b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 9;
								a9b = false;
							}else if(Ao[3] == 0){
								Ao[3] =9;
								a9b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 9;
								a9b = false;
							}else{
								a9b = true;
							}
						}
					}
				}
				if (work10) {
					w10 = x;
					h10 = y;

					if (TouchUp) {
						work10 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 10;
								a10b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 10;
								a10b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 10;
								a10b = false;
							}else if(Ao[3] == 0){
								Ao[3] =10;
								a10b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 10;
								a10b = false;
							}else{
								a10b = true;
							}
						}
					}
				}
				if (work11) {
					w11 = x;
					h11 = y;

					if (TouchUp) {
						work11 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 11;
								a11b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 11;
								a11b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 11;
								a11b = false;
							}else if(Ao[3] == 0){
								Ao[3] =11;
								a11b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 11;
								a11b = false;
							}else{
								a11b = true;
							}
						}
					}
				}
				if (work12) {
					w12 = x;
					h12 = y;

					if (TouchUp) {
						work12 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 12;
								a12b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 12;
								a12b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 12;
								a12b = false;
							}else if(Ao[3] == 0){
								Ao[3] =12;
								a12b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 12;
								a12b = false;
							}else{
								a12b = true;
							}
						}
					}
				}
				if (work13) {
					w13 = x;
					h13 = y;

					if (TouchUp) {
						work13 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 13;
								a13b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 13;
								a13b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 13;
								a13b = false;
							}else if(Ao[3] == 0){
								Ao[3] =13;
								a13b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 13;
								a13b = false;
							}else{
								a13b = true;
							}
						}
					}
				}
				if (work14) {
					w14 = x;
					h14 = y;

					if (TouchUp) {
						work14 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 14;
								a14b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 14;
								a14b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 14;
								a14b = false;
							}else if(Ao[3] == 0){
								Ao[3] =14;
								a14b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 14;
								a14b = false;
							}else{
								a14b = true;
							}
						}
					}
				}
				if (work15) {
					w15 = x;
					h15 = y;

					if (TouchUp) {
						work15 = false;
						if (endX >= (canvas.getWidth() - (canvas.getWidth() / 4))
								&& endX <= canvas.getWidth()
								&& endY >= 0
								&& endY <= (canvas.getHeight() / 2)) {
							if(Ao[0] == 0){
								Ao[0] = 15;
								a15b = false;
							}else if(Ao[1] == 0){
								Ao[1] = 15;
								a15b = false;
							}else if(Ao[2] == 0){
								Ao[2] = 15;
								a15b = false;
							}else if(Ao[3] == 0){
								Ao[3] =15;
								a15b = false;
							}else if(Ao[4] == 0){
								Ao[4] = 15;
								a15b = false;
							}else{
								a15b = true;
							}
						}
					}
				}

				if (a1b)
					canvas.drawBitmap(a1, w1, h1, null);
				if (a2b)
					canvas.drawBitmap(a2, w2, h2, null);
				if (a3b)
					canvas.drawBitmap(a3, w3, h3, null);
				if (a4b)
					canvas.drawBitmap(a4, w4, h4, null);
				if (a5b)
					canvas.drawBitmap(a5, w5, h5, null);
				if (a6b)
					canvas.drawBitmap(a6, w6, h6, null);
				if (a7b)
					canvas.drawBitmap(a7, w7, h7, null);
				if (a8b)
					canvas.drawBitmap(a8, w8, h8, null);
				if (a9b)
					canvas.drawBitmap(a9, w9, h9, null);
				if (a10b)
					canvas.drawBitmap(a10, w10, h10, null);
				if (a11b)
					canvas.drawBitmap(a11, w11, h11, null);
				if (a12b)
					canvas.drawBitmap(a12, w12, h12, null);
				if (a13b)
					canvas.drawBitmap(a13, w13, h13, null);
				if (a14b)
					canvas.drawBitmap(a14, w14, h14, null);
				if (a15b)
					canvas.drawBitmap(a15, w15, h15, null);

				holder.unlockCanvasAndPost(canvas); // bya3rad alcanvas
			}

		}

	}

}
