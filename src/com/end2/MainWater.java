package com.end2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import com.endgame.R;
import com.endgame.Space;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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

public class MainWater extends Activity implements OnTouchListener {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		theViewOfSurFace = new ForGrafexSurFace(this);
		theViewOfSurFace.setOnTouchListener(this);

		// map = BitmapFactory.decodeResource(getResources(), R.drawable.ball);

		// from here
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// to here full Screen Code

		firstX = firstY = endX = endY = 0;

		x = y = 10;
		setContentView(theViewOfSurFace);

		GameSound = MediaPlayer.create(MainWater.this, R.raw.gamesong);

		avatarSound = MediaPlayer.create(MainWater.this, R.raw.wee);
		avatarSound2 = MediaPlayer.create(MainWater.this, R.raw.wee);
		avatarSound3 = MediaPlayer.create(MainWater.this, R.raw.wee);

		BallSound = MediaPlayer.create(MainWater.this, R.raw.victory);
		BallSound2 = MediaPlayer.create(MainWater.this, R.raw.victory);
		BallSound3 = MediaPlayer.create(MainWater.this, R.raw.victory);
		BallSound4 = MediaPlayer.create(MainWater.this, R.raw.victory);
		BallSound5 = MediaPlayer.create(MainWater.this, R.raw.victory);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		// Intent iPause = new Intent(MainWater.this , EndPlay.class);
		// startActivity(iPause);
		super.onPause();
		theViewOfSurFace.pause();

		if (paused) {
			avatarSound.pause();
			avatarSound2.pause();
			avatarSound3.pause();

			BallSound.pause();
			BallSound2.pause();
			BallSound3.pause();
			BallSound4.pause();
			BallSound5.pause();
			GameSound.pause();
		}
		Intent iPause = new Intent(MainWater.this, PauseWater.class);
		// iPause.putExtra("pause", paused);
		startActivity(iPause);

		paused = true;

		pppppp = getSharedPreferences("Water_Data", Context.MODE_PRIVATE);

		Editor editor2 = pppppp.edit();

		editor2.putBoolean("pause", true);
		editor2.commit();

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

		avatarSound.release();
		avatarSound2.release();
		avatarSound3.release();

		BallSound.release();
		BallSound2.release();
		BallSound3.release();
		BallSound4.release();
		BallSound5.release();

		GameSound.release();

		Intent end = new Intent(MainWater.this, PauseWater.class);
		startActivity(end);
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
		int[] d = { R.drawable.ball, R.drawable.ballone, R.drawable.balltwo,
				R.drawable.ballthree };
		long resultTime2 = 0;

		int TimeCounter = 0;

		Bitmap theBall, BoxesBefore, BoxesAfter, CanvasBall, DrawBoxes;
		float touchX, touchY;
		float changH, changW;
		boolean firstComPlay = false;
		float avatarX, avatarY;
		long startimprint, stopimprint, resultimprint;
		long startimprint2, stopimprint2, resultimprint2;
		long startimprint3, stopimprint3, resultimprint3;
		long startimprint4, stopimprint4, resultimprint4;
		boolean screenNumber = true;
		boolean one, two;
		// for second ball and the third
		long start2, stop2, result2;
		long start3, stop3, result3;
		long start4, stop4, result4;

		// the game time
		long gameTime;
		long endTime = 0;
		long resultTime = 0;

		boolean time = true;
		boolean fball1 = true;
		int theTime = 60;
		boolean reset = false;
		long start, stop, result;
		Bitmap hadood;
		Bitmap secondball, thirdball;
		Bitmap backavatar;
		float backAW, backAH;
		Bitmap firstball;
		boolean eat1;
		boolean eat2;
		boolean eat3;
		boolean test = false;
		boolean eat4;
		float eat1W, eat1H, eat2W, eat2H, eat3W, eat3H, eat4W, eat4H;

		Random rrr = new Random();

		Typeface font;
		String s;
		Display display = getWindowManager().getDefaultDisplay();
		float ScreenWidth = display.getWidth(); // deprecated
		float ScreenHeight = display.getHeight(); // deprecated
		Bitmap avatar;
		long Astart1, Astop1, Aresult1, Astart2, Astop2, Aresult2;
		long start5 = 0;
		long startimprint5 = 0;
		private long stopimprint5 = 0;
		private long resultimprint5 = 0;
		private long stop5;
		private long result5;
		boolean onlyone = true;
		boolean timeAV1 = true;
		boolean A1, A2, A3;

		Bitmap A1o, A2o, A3o;
		Bitmap pause;
		Bitmap rock;
		boolean pauseResume;

		Bitmap all, anything;
		int rotation = 0;
		boolean workR2 = false;
		int actionInt = 0;
		boolean action1 = false, action2 = false, action3 = false,
				action4 = false, action5 = false;
		float AcW1, AcW2, AcW3, AcW4, AcW5, AcH1, AcH2, AcH3, AcH4, AcH5;
		int AcSize1, AcSize2, AcSize3, AcSize4, AcSize5;
		long Acstart1, Acstart2, Acstart3, Acstart4, Acstart5;
		private Bitmap Bavatar2;
		private Bitmap Bavatar;
		private Bitmap Bavatar3;
		private Bitmap CanvasBall2;
		private Bitmap mark1;
		Bitmap imprint;
		private Bitmap CanvasBall3;
		private Bitmap CanvasBall4;
		private Bitmap CanvasBall5;
		private SharedPreferences preferences, pref;
		private Editor editor;
		Bitmap imprint1, imprint2, imprint3, imprint4, imprint5;
		private Bitmap Map;
		private Bitmap point;
		private Bitmap pointB;
		private Bitmap pointR;
		private Bitmap pause2;
		private boolean doSecound = false;
		private int counter = 0;
		private boolean actionWork1, actionWork2, actionWork3, actionWork4,
				actionWork5;

		int avatarSoundInt = 0, BallSoundInt = 0;

		boolean Asound1, Asound2, Asound3, Bsound1, Bsound2, Bsound3, Bsound4,
				Bsound5, Ball1, BoxF1, BoxB1, roky1, Ball2, rok1, rok2, oneR1,
				oneR2, makeImprint, makeImprint2, makeImprint3, makeImprint4,
				makeImprint5, firstTime, firstTime2, firstTime3, firstTime4,
				firstTime5, time2, time3, time4, time5, firstchange,
				firstchange2, firstchange3, firstchange4, firstchange5, go1,
				go2, go3, go4, go5, avatar1, avatar2, avatar3, Awork, Awork2,
				Awork3;
		float width, height, SpaceTop, SpaceLeft, SpaceRight, SpaceBottom,
				changingBallW, changingBallH, changingCanvasW, changingCanvasH,
				impH1, impW1, impH2, impW2, impH3, impW3, impH4, impW4, impW5,
				impH5, height2, width2, height3, width3, height4, height5,
				width4, width5, A1EX, A1FX, A2EX, A2FX, A1FY, A1EY, A2FY, A2EY,
				A3FX, A3EX, A3FY, A3EY, markAW1, markAW2, markAH1, markAH2,
				markAW3, markAH3, avatarH1, avatarW1, avatarH2, avatarW2,
				avatarW3, avatarH3, desAW1, desAH1, desAW2, desAH2, desAW3,
				desAH3, rokW, rokW2, rokH, rokH2;
		int DefBitmapWidth, sizeW, sizeW2, sizeW4, sizeW5, sizeW3, ballsTime,
				gameslowly, desW1, desW2, desW3, desW4, desH1, desH2, desH3,
				desH4, w, h, desW5, desH5, chooseAsizeW, MarkAsizeW1, AsizeW1,
				AsizeW2, AsizeW3, roksizeW, roksizeW2, BallInt, BoxFInt,
				BoxBInt, rokyInt, Ball2Int, wallet = 3, pointAH, pointAH2,
				pointAH3, pointAW, pointAW2, pointAW3, pointBH, pointBH2,
				pointBH3, pointBH4, pointBH5, pointBW, pointBW2, pointBW3,
				pointBW4, pointBW5, pointRH, pointRH2, pointRW, pointRW2, mapW,
				mapH;

		HelpSpace hs;

		public ForGrafexSurFace(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			holder = getHolder();
			makeImprint = false;

			Asound1 = Asound2 = Asound3 = Bsound1 = Bsound2 = Bsound3 = Bsound4 = Bsound5 = false;

			Ball1 = BoxF1 = BoxB1 = roky1 = Ball2 = false;
			actionWork1 = actionWork2 = actionWork3 = actionWork4 = actionWork5 = false;
			pauseResume = true;

			rok1 = rok2 = true;
			oneR1 = oneR2 = true;

			BallInt = BoxBInt = BoxFInt = rokyInt = Ball2Int = 15;

			AcW1 = AcW2 = AcW3 = AcW4 = AcW5 = AcH1 = AcH2 = AcH3 = AcH4 = AcH5 = 0;

			roksizeW = roksizeW2 = 5;
			rokW = rokH = rokW2 = rokH2 = 0;

			// to make the avatar in the center of the screen
			avatarW1 = avatarW2 = avatarW3 = (ScreenWidth / 2);
			avatarH1 = avatarH2 = avatarH3 = (ScreenHeight / 2);

			chooseAsizeW = 0;

			desAW1 = desAW2 = desAH1 = desAH2 = desW3 = desH3 = 0;

			// A1o = theBall;
			// A1o = A3o = A2o = BoxesAfter;
			Ball1 = true;
			// A3o = BoxesBefore;

			height = SpaceTop = SpaceLeft = SpaceRight = SpaceBottom = width = 0;
			height2 = width2 = 0;
			height3 = width3 = 0;

			height5 = width5 = 0;

			// Changing Numbers = 0
			changingBallW = changingBallH = changingCanvasW = changingCanvasH = 0;

			// Boxes boolean
			one = two = true;
			// The touch float

			// for the eating the balls
			eat1W = eat1H = eat2W = eat2H = eat3W = eat3H = eat4W = eat4H = 0;

			// sizeW = theBall.getWidth()/3;
			// sizeW = (int) ((ScreenWidth/8)/20);
			// sizeW = (int) ((ScreenHeight/8)/12);

			sizeW = 0;

			// sizeW = theBall.getHeight()/3;
			// DefBitmapWidth = theBall.getWidth();
			DefBitmapWidth = (int) (ScreenWidth / 5);
			// DefBitmapWidth = theBall.getHeight();
			// DefBitmapWidth = (int) (ScreenHeight/3);
			chooseAsizeW = DefBitmapWidth / 4;
			chooseAsizeW = DefBitmapWidth / 4;
			// AsizeW1 = AsizeW2 = AsizeW3 = backsizeW;
			AsizeW1 = AsizeW2 = AsizeW3 = AsizeW1 = AsizeW2 = AsizeW3 = (int) DefBitmapWidth;

			// For changes in width and height
			changH = changW = 0;
			// for the game time
			gameTime = 0;
			// for ball number 2 and 3
			sizeW2 = sizeW3 = sizeW4 = sizeW5 = sizeW;
			sizeW2 = sizeW3 = sizeW4 = sizeW5 = sizeW;
			MarkAsizeW1 = (int) (ScreenHeight / 70);
			// Touched
			touchX = touchY = 0;
			// avatr floats
			avatarX = avatarY = 0;
			// imprint default
			impH1 = impW1 = impH2 = impW2 = impH3 = impW4 = impH4 = impW3 = impW5 = impH5 = 0;
			// for the Time between the balls
			ballsTime = 900;

			w = (int) (ScreenWidth - DefBitmapWidth);
			h = (int) (ScreenHeight - DefBitmapWidth);

			// Changing Numbers Ball and Canvas ....
			changingBallW = (DefBitmapWidth / 30);
			// changingBallH =(DefBitmapWidth / 25);
			changingBallH = changingBallW;

			// The Ball from resources
			theBall = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball);

			// for drawing some rocks in the space or in the sea or in lava
			// planet
			rock = BitmapFactory.decodeResource(getResources(), R.drawable.rok);

			// The Ball from resources
			firstball = BitmapFactory.decodeResource(getResources(),
					R.drawable.ballone);

			// The Ball from resources
			backavatar = BitmapFactory.decodeResource(getResources(),
					R.drawable.backavatar);

			// The Ball from resources
			secondball = BitmapFactory.decodeResource(getResources(),
					R.drawable.balltwo);

			// The Ball from resources
			thirdball = BitmapFactory.decodeResource(getResources(),
					R.drawable.ballthree);

			// The Box Before from resources
			BoxesBefore = BitmapFactory.decodeResource(getResources(),
					R.drawable.boxbefore);
			// The Box After from resources
			BoxesAfter = BitmapFactory.decodeResource(getResources(),
					R.drawable.boxafter);

			// llhodood
			// hadood = BitmapFactory.decodeResource(getResources(),
			// R.drawable.hadood);

			anything = BitmapFactory.decodeResource(getResources(),
					R.drawable.firstm);

			imprint = BitmapFactory.decodeResource(getResources(),
					R.drawable.imprint);

			A1o = A2o = A3o = theBall;

			mark1 = Bitmap.createScaledBitmap(backavatar, (int) MarkAsizeW1,
					(int) MarkAsizeW1, true);

			imprint1 = Bitmap.createScaledBitmap(imprint, (2 * DefBitmapWidth),
					(2 * DefBitmapWidth), true);
			imprint2 = imprint3 = imprint4 = imprint5 = imprint1;

			pause = BitmapFactory.decodeResource(getResources(),
					R.drawable.ic_launcher);
			pause2 = Bitmap.createScaledBitmap(pause, chooseAsizeW,
					chooseAsizeW, true);

			pref = getSharedPreferences("Water_Data", Context.MODE_PRIVATE);

			paused = pref.getBoolean("pause", false);

			if (paused) {

				// to read
				/*
				 * SharedPreferences prfs =
				 * getSharedPreferences("AUTHENTICATION_FILE_NAME",
				 * Context.MODE_PRIVATE); String Astatus =
				 * prfs.getString("Authentication_Status", "");
				 */

				avatar1 = pref.getBoolean("AB1", false);
				avatar2 = pref.getBoolean("AB2", false);
				avatar3 = pref.getBoolean("AB3", false);
				firstTime = pref.getBoolean("FTB1", false);
				firstTime2 = pref.getBoolean("FTB2", false);
				firstTime3 = pref.getBoolean("FTB3", false);
				firstTime4 = pref.getBoolean("FTB4", false);
				firstTime5 = pref.getBoolean("FTB5", false);
				go1 = pref.getBoolean("GO1", false);
				go2 = pref.getBoolean("GO2", false);
				go3 = pref.getBoolean("GO3", false);
				go4 = pref.getBoolean("GO4", false);
				go5 = pref.getBoolean("GO5", false);
				rok1 = pref.getBoolean("RB1", false);
				rok2 = pref.getBoolean("RB2", false);
				makeImprint = pref.getBoolean("IMP1", false);
				makeImprint2 = pref.getBoolean("IMP2", false);
				makeImprint3 = pref.getBoolean("IMP3", false);
				makeImprint4 = pref.getBoolean("IMP4", false);
				makeImprint5 = pref.getBoolean("IMP5", false);
				time = pref.getBoolean("TB1", false);
				time2 = pref.getBoolean("TB2", false);
				time3 = pref.getBoolean("TB3", false);
				time4 = pref.getBoolean("TB4", false);
				time5 = pref.getBoolean("TB5", false);
				// pref.getBoolean("TB1", time);
				Awork = pref.getBoolean("AWB1", false);
				Awork2 = pref.getBoolean("AWB2", false);
				Awork3 = pref.getBoolean("AWB3", false);
				avatarW1 = pref.getFloat("AW1", 0);
				avatarW2 = pref.getFloat("AW2", 0);
				avatarW3 = pref.getFloat("AW3", 0);
				avatarH1 = pref.getFloat("AH1", 0);
				avatarH2 = pref.getFloat("AH2", 0);
				avatarH3 = pref.getFloat("AH3", 0);
				AsizeW1 = pref.getInt("AS1", 0);
				AsizeW2 = pref.getInt("AS2", 0);
				AsizeW3 = pref.getInt("AS3", 0);
				result = pref.getLong("RL1", 0);
				result2 = pref.getLong("RL2", 0);
				result3 = pref.getLong("RL3", 0);
				result4 = pref.getLong("RL4", 0);
				result5 = pref.getLong("RL5", 0);
				start = pref.getLong("SL1", 0);
				start2 = pref.getLong("SL2", 0);
				start3 = pref.getLong("SL3", 0);
				start4 = pref.getLong("SL4", 0);
				start5 = pref.getLong("SL5", 0);
				width = pref.getFloat("BW1", 0);
				width2 = pref.getFloat("BW2", 0);
				width3 = pref.getFloat("BW3", 0);
				width4 = pref.getFloat("BW1", 0);
				width5 = pref.getFloat("BW1", 0);
				height = pref.getFloat("BH1", 0);
				height2 = pref.getFloat("BH1", 0);
				height3 = pref.getFloat("BH1", 0);
				height4 = pref.getFloat("BH1", 0);
				height5 = pref.getFloat("BH1", 0);
				sizeW = pref.getInt("BS1", 0);
				sizeW2 = pref.getInt("BS2", 0);
				sizeW3 = pref.getInt("BS3", 0);
				sizeW4 = pref.getInt("BS4", 0);
				sizeW5 = pref.getInt("BS5", 0);
				desW1 = pref.getInt("BDW1", 0);
				desW2 = pref.getInt("BDW2", 0);
				desW3 = pref.getInt("BDW3", 0);
				desW4 = pref.getInt("BDW4", 0);
				desW5 = pref.getInt("BDW5", 0);
				desH1 = pref.getInt("BDH1", 0);
				desH2 = pref.getInt("BDH2", 0);
				desH3 = pref.getInt("BDH3", 0);
				desH4 = pref.getInt("BDH4", 0);
				desH5 = pref.getInt("BDH5", 0);
				desAW1 = pref.getFloat("ADW1", 0);
				desAW2 = pref.getFloat("ADW2", 0);
				desAW3 = pref.getFloat("ADW3", 0);
				desAH1 = pref.getFloat("ADH1", 0);
				desAH2 = pref.getFloat("ADH2", 0);
				desAH3 = pref.getFloat("ADH3", 0);
				// theTime = pref.getInt("Time", 60);
				scorepoint = pref.getInt("Score", 0);
				wallet = pref.getInt("Wallet", 3);
				TimeCounter = pref.getInt("TimeCounter", 0);
				Asound1 = pref.getBoolean("Asound1", Asound1);
				Asound2 = pref.getBoolean("Asound2", Asound2);
				Asound3 = pref.getBoolean("Asound3", Asound3);
				Bsound1 = pref.getBoolean("Bsound1", Bsound1);
				Bsound2 = pref.getBoolean("Bsound2", Bsound2);
				Bsound3 = pref.getBoolean("Bsound3", Bsound3);
				Bsound4 = pref.getBoolean("Bsound4", Bsound4);
				Bsound5 = pref.getBoolean("Bsound5", Bsound5);
				rokW = pref.getFloat("rokW1", 0);
				rokH = pref.getFloat("rokH1", 0);
				rokW2 = pref.getFloat("rokW2", 0);
				rokH2 = pref.getFloat("rokH2", 0);
				roksizeW = pref.getInt("roksizeW1", 0);
				roksizeW2 = pref.getInt("roksizeW2", 0);
				startimprint = pref.getLong("startimprint", 0);
				startimprint2 = pref.getLong("startimprint2", 0);
				startimprint3 = pref.getLong("startimprint3", 0);
				startimprint4 = pref.getLong("startimprint4", 0);
				startimprint5 = pref.getLong("startimprint5", 0);

				paused = false;
			}
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
			// thread.destroy();
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

			gameTime = System.currentTimeMillis();

			while (running) {
				if (!holder.getSurface().isValid()) // (!) ma3naha not
					continue; // ma3naha 5aleek fe if l3'ayat lma tb2a if false

				Canvas canvas = holder.lockCanvas(); // ma3naha private
				canvas.drawColor(Color.BLUE);// momkan ta3'ayaroo 3lshan yab2a
												// 2albackground

				GameSound.start();

				// to calculate the game Time
				endTime = System.currentTimeMillis();
				resultTime = (endTime - gameTime);

				if (doSecound) {

					if (resultTime >= 1000) {
						TimeCounter += 1;
						gameTime = System.currentTimeMillis();
						resultTime = 0;
					}

					if (TouchDown) {
						if ((firstX >= 0 && firstX <= chooseAsizeW
								&& firstY >= (2 * chooseAsizeW) && firstY <= (3 * chooseAsizeW))
								&& BallInt > 0) {
							Ball1 = true;
							BoxF1 = false;
							BoxB1 = false;
							roky1 = false;
							Ball2 = false;
							// A1o = A2o = A3o = theBall;
						}
						if ((firstX >= 0 && firstX <= chooseAsizeW
								&& firstY >= (3 * chooseAsizeW) && firstY <= (4 * chooseAsizeW))
								&& BoxFInt > 0) {
							Ball1 = false;
							BoxF1 = true;
							BoxB1 = false;
							roky1 = false;
							Ball2 = false;
							// A1o = A2o = A3o = BoxesAfter;
						}
						if ((firstX >= 0 && firstX <= chooseAsizeW
								&& firstY >= (4 * chooseAsizeW) && firstY <= (5 * chooseAsizeW))
								&& BoxBInt > 0) {
							Ball1 = false;
							BoxF1 = false;
							BoxB1 = true;
							roky1 = false;
							Ball2 = false;
							// A1o = A2o = A3o = BoxesBefore;
						}
						if ((firstX >= 0 && firstX <= chooseAsizeW
								&& firstY >= (5 * chooseAsizeW) && firstY <= (6 * chooseAsizeW))
								&& BoxBInt > 0) {
							Ball1 = false;
							BoxF1 = false;
							BoxB1 = false;
							roky1 = true;
							Ball2 = false;
							// A1o = A2o = A3o = BoxesBefore;
						}
						if ((firstX >= 0 && firstX <= chooseAsizeW
								&& firstY >= (6 * chooseAsizeW) && firstY <= (7 * chooseAsizeW))
								&& BoxBInt > 0) {
							Ball1 = false;
							BoxF1 = false;
							BoxB1 = false;
							roky1 = false;
							Ball2 = true;
							// A1o = A2o = A3o = BoxesBefore;
						}
						// pause the game
						if (firstX >= (canvas.getWidth() - chooseAsizeW)
								&& firstX <= canvas.getWidth() && firstY >= 0
								&& firstY <= chooseAsizeW) {
							paused = true;

							if (Awork) {
								Awork = false;
								wallet += 1;
							}
							if (Awork2) {
								Awork2 = false;
								wallet += 1;
							}
							if (Awork3) {
								Awork3 = false;
								wallet += 1;
							}
							editor.putBoolean("AWB1", Awork);
							editor.putBoolean("AWB2", Awork2);
							editor.putBoolean("AWB3", Awork3);
							editor.putInt("Wallet", wallet);
							editor.putBoolean("pause", paused);
							editor.commit();

							GameSound.pause();

							Intent toP = new Intent(MainWater.this,
									PauseWater.class);
							startActivity(toP);

							// theViewOfSurFace.pause();
							// resumeGame = false;

							/*
							 * if(pauseResume){ theViewOfSurFace.resume();
							 * }else{ theViewOfSurFace.pause(); }
							 */
						}
					}

					// to make the ball slower
					try {
						Thread.sleep(gameslowly);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (TouchDown && firstX > chooseAsizeW && wallet > 0) {

						if (!avatar1 && !avatar2 && !avatar3 && !Awork
								&& !Awork2 && !Awork3) {
							wallet = 3;
						}

						// if(TouchDown && firstX > chooseAsizeW){
						if ((!avatar1 && !Awork)// && A1)//|| (!avatar2 &&
												// !avatar3))//&& !Awork) //&&
												// A1)
						// || (avatar1 && avatar3 && TouchDown)
						) {
							avatarW1 = firstX;
							avatarH1 = firstY;
							AsizeW1 = (int) DefBitmapWidth;
							// AsizeW1 = backsizeW;
							// for the pray mark
							// markAH1 = avatarH1 - (y - firstY);
							// markAW1 = avatarW1 - (x - firstX);
							Awork = true;
							wallet -= 1;

							if (Ball1 && BallInt > 0) {
								A1o = theBall;
								BallInt -= 1;
							}
							if (BoxF1 && BoxFInt > 0) {
								A1o = BoxesAfter;
								BoxFInt -= 1;
							}
							if (BoxB1 && BoxBInt > 0) {
								A1o = BoxesBefore;
								BoxBInt -= 1;
							}
							if (Ball2 && Ball2Int > 0) {
								A1o = secondball;
								Ball2Int -= 1;
							}
							if (roky1 && rokyInt > 0) {
								A1o = rock;
								rokyInt -= 1;
							}
						}

						if ((!avatar2 && avatar1 && !Awork2))// ||(avatar1 &&
																// avatar3))//&&
																// A2)//&&
																// !Awork2
																// )//&& A2)
						{
							avatarW2 = firstX;
							avatarH2 = firstY;
							AsizeW2 = (int) DefBitmapWidth;
							// AsizeW2 = backsizeW;
							// for the pray mark
							// markAH2 = avatarH2 - (y - firstY);
							// markAW2 = avatarW2 - (x - firstX);
							Awork2 = true;
							wallet -= 1;

							if (Ball1 && BallInt > 0) {
								A2o = theBall;
								BallInt -= 1;
							}
							if (BoxF1 && BoxFInt > 0) {
								A2o = BoxesAfter;
								BoxFInt -= 1;
							}
							if (BoxB1 && BoxBInt > 0) {
								A2o = BoxesBefore;
								BoxBInt -= 1;
							}
							if (Ball2 && Ball2Int > 0) {
								A2o = secondball;
								Ball2Int -= 1;
							}
							if (roky1 && rokyInt > 0) {
								A2o = rock;
								rokyInt -= 1;
							}
						}

						if ((!avatar3 && avatar1 && avatar2 && !Awork
								&& !Awork2 && !Awork3))// ||(avatar1
														// &&
														// avatar2))//&&
														// A3)//&&
														// !Awork3
														// )//
														// &&
														// A3)
						{
							avatarW3 = firstX;
							avatarH3 = firstY;
							AsizeW3 = (int) DefBitmapWidth;
							// AsizeW3 = backsizeW;
							// for the pray mark
							// markAH3 = avatarH3 - (y - firstY);
							// markAW3 = avatarW3 - (x - firstX);
							Awork3 = true;
							wallet -= 1;

							if (Ball1 && BallInt > 0) {
								A3o = theBall;
								// BallInt -=1;
							}
							if (BoxF1 && BoxFInt > 0) {
								A3o = BoxesAfter;
								// BoxFInt -=1;
							}
							if (BoxB1 && BoxBInt > 0) {
								A3o = BoxesBefore;
								BoxBInt -= 1;
							}
							if (Ball2 && Ball2Int > 0) {
								A3o = secondball;
								Ball2Int -= 1;
							}
							if (roky1 && rokyInt > 0) {
								A3o = rock;
								rokyInt -= 1;
							}
						}
					}

					// to draw the marks for shoot
					if (Awork) {
						// for the pray mark
						// markAH1 = avatarH1 - (y - firstY);
						markAH1 = firstY
								+ ((AsizeW1 / (2 * changingBallW)) * ((avatarH1 - (y - firstY)) - (AsizeW1 / 4)));
						markAW1 = avatarW1 - (x - firstX);

					}
					if (Awork2) {
						// for the pray mark
						// markAH2 = avatarH2 - (y - firstY);
						markAH2 = firstY
								+ ((AsizeW2 / (2 * changingBallW)) * ((avatarH2 - (y - firstY)) - (AsizeW2 / 4)));
						markAW2 = avatarW2 - (x - firstX);

					}
					if (Awork3) {
						// for the pray mark
						// markAH3 = avatarH3 - (y - firstY);
						markAH3 = firstY
								+ ((AsizeW3 / (2 * changingBallW)) * ((avatarH3 - (y - firstY)) - (AsizeW3 / 4)));
						markAW3 = avatarW3 - (x - firstX);

					}

					if (TouchUp) {
						TouchDown = false;
						if (Awork) {
							avatar1 = true;
							// for the distance of the avatar
							desAW1 = endX - firstX;
							desAH1 = endY - firstY;
							Awork = false;
							Asound1 = true;
							avatarSound = MediaPlayer.create(MainWater.this,
									R.raw.wee);
							avatarSound.setVolume(0.2f, 0.2f);

						}
						if (Awork2) {
							avatar2 = true;
							// for the distance of the avatar
							desAW2 = endX - firstX;
							desAH2 = endY - firstY;
							Awork2 = false;
							Asound2 = true;
							avatarSound2 = MediaPlayer.create(MainWater.this,
									R.raw.wee);
							avatarSound2.setVolume(0.2f, 0.2f);
						}
						if (Awork3) {
							avatar3 = true;
							// for the distance of the avatar
							desAW3 = endX - firstX;
							desAH3 = endY - firstY;
							Awork3 = false;
							Asound3 = true;
							avatarSound3 = MediaPlayer.create(MainWater.this,
									R.raw.wee);
							avatarSound3.setVolume(0.2f, 0.2f);
						}
						TouchUp = false;
					}

					// for the first avatar
					if (avatar1) {
						// for the size
						AsizeW1 -= changingBallW;
						// AsizeW1 -= changingBallH;
						// for the height and width

						//desAH1 -= (canvas.getHeight() / 300);
						avatarW1 -= (desAW1 / (DefBitmapWidth / changingBallW));
						avatarH1 -= (desAH1 / (DefBitmapWidth / changingBallW));

						// for the pray mark
						// markAH1 = avatarH1 - (y - firstY);
						// markAW1 = avatarW1 - (x - firstX);
						// for the top left right bottom
						A1FY = avatarH1 - (AsizeW1 / 2);
						A1EY = avatarH1 + (AsizeW1 / 2);
						A1FX = avatarW1 - (AsizeW1 / 2);
						A1EX = avatarW1 + (AsizeW1 / 2);
						Awork = false;
						// Bavatar = Bitmap.createScaledBitmap(A1o, AsizeW1,
						// AsizeW1, true);

						if (AsizeW1 <= 0) {
							avatar1 = false;
							wallet += 1;
							// Awork = false;
						}

						avatarSound.start();
						
						// if (Asound1) {
						// Asound1 = false;
						// }
					}
					

					/*
					 * else { avatarSound.start(); avatarSound.stop(); }
					 */
					// for the second avatar
					if (avatar2) {
						// for the size
						AsizeW2 -= changingBallW;
						// AsizeW2 -= changingBallH;
						// for the height and width

						//desAH2 -= (canvas.getHeight() / 300);
						avatarW2 -= (desAW2 / (DefBitmapWidth / changingBallW));
						avatarH2 -= (desAH2 / (DefBitmapWidth / changingBallW));

						// for the pray mark
						// markAH2 = avatarH2 - (y - firstY);
						// markAW2 = avatarW2 - (x - firstX);
						// for the top left right bottom
						A2FY = avatarH2 - (AsizeW2 / 2);
						A2EY = avatarH2 + (AsizeW2 / 2);
						A2FX = avatarW2 - (AsizeW2 / 2);
						A2EX = avatarW2 + (AsizeW2 / 2);
						Awork2 = false;
						// Bavatar2 = Bitmap.createScaledBitmap(A2o, AsizeW2,
						// AsizeW2, true);

						if (AsizeW2 <= 0) {
							avatar2 = false;
							wallet += 1;
							// Awork2 = false;
						}
						avatarSound2.start();

						// if (Asound2) {
						// Asound2 = false;
						// }
					}/*
					 * else { avatarSound2.start(); avatarSound2.stop();
					 * 
					 * }
					 */
					// for the second avatar
					if (avatar3) {
						// for the size
						AsizeW3 -= changingBallW;
						// AsizeW3 -= changingBallH;
						// for the height and width

						//desAH3 -= (canvas.getHeight() / 300);
						avatarW3 -= (desAW3 / (DefBitmapWidth / changingBallW));
						avatarH3 -= (desAH3 / (DefBitmapWidth / changingBallW));
						// for the pray mark
						// markAH3 = avatarH3 - (y - firstY);
						// markAW3 = avatarW3 - (x - firstX);
						// for the top left right bottom
						A3FY = avatarH3 - (AsizeW3 / 2);
						A3EY = avatarH3 + (AsizeW3 / 2);
						A3FX = avatarW3 - (AsizeW3 / 2);
						A3EX = avatarW3 + (AsizeW3 / 2);
						Awork3 = false;
						// Bavatar3 = Bitmap.createScaledBitmap(A3o, AsizeW3,
						// AsizeW3, true);

						if (AsizeW3 <= 0) {
							avatar3 = false;
							wallet += 1;
							// Awork3 = false;
						}
						avatarSound3.start();
						
						// if (Asound3) {
						// Asound3 = false;
						// }
					} /*
					 * else { avatarSound3.start(); avatarSound3.stop(); }
					 */

					if (fball1) {
						start = System.currentTimeMillis();
						fball1 = false;
					}
					// start the first ball again
					if (time) {
						stop = System.currentTimeMillis();
						result = stop - start;

						if (result >= (3 * ballsTime)) {
							// start again
							firstTime = true;
							go1 = true;
							time = false;
						}
					}
					// start the second ball time
					if (time2) {
						stop2 = System.currentTimeMillis();
						result2 = stop2 - start2;

						if (result2 >= ballsTime) {
							firstTime2 = true;
							go2 = true;
							time2 = false;
						}
					}
					// for start the third ball
					if (time3) {
						stop3 = System.currentTimeMillis();
						result3 = stop3 - start3;

						if (result3 >= ballsTime) {
							firstTime3 = true;
							go3 = true;
							time3 = false;
						}
					}
					// for start the fourth ball
					if (time4) {
						stop4 = System.currentTimeMillis();
						result4 = stop4 - start4;

						if (result4 >= ballsTime) {
							firstTime4 = true;
							go4 = true;
							time4 = false;
						}
					}
					// for start the fourth ball
					if (time5) {
						stop5 = System.currentTimeMillis();
						result5 = stop5 - start5;

						if (result5 >= ballsTime) {
							firstTime5 = true;
							go5 = true;
							time5 = false;
						}
					}

					// float[] allAWH = { A1FX, A1FY, A1EX, A1EY, A2FX, A2FY,
					// A2EX, A2EY, A3FX, A3FY, A3EX, A3EY };

					if (firstTime) {

						height = rrr.nextInt(h);// canvas.getHeight() / 2;
						width = rrr.nextInt(w);// canvas.getWidth() / 2;
						desW1 = (int) (((rrr.nextInt(w)) - width) / (DefBitmapWidth / changingBallW));
						desH1 = (int) (((rrr.nextInt(h)) - height) / (DefBitmapWidth / changingBallW));
						// sizeW = theBall.getWidth()/3;
						// sizeW = (int) ((canvas.getWidth()/8)/20);
						// sizeW = (int) ((canvas.getHeight()/8)/12);
						sizeW = 0;
						// to load the second ball
						start2 = System.currentTimeMillis();
						time2 = true;
						if (theTime <= 0)
							go1 = false;

						if (height > (canvas.getHeight() - (canvas.getHeight() / 4)))
							height -= (canvas.getHeight() / 4);
						if (height < (canvas.getHeight() / 4))
							height += (canvas.getHeight() / 4);

						if (width > (canvas.getWidth() - (canvas.getWidth() / 4)))
							width -= (canvas.getWidth() / 4);
						if (width < (canvas.getWidth() / 4))
							width += (canvas.getWidth() / 4);

						// if (Bsound1) {
						// BallSound.start();
						// Bsound1 = false;
						// }
						BallSound = MediaPlayer.create(MainWater.this,
								R.raw.victory);
						BallSound.setVolume(0.2f, 0.2f);

						firstTime = false;
					}

					// Insert the Valuables for the second ball
					if (firstTime2) {
						// default height and width for the ball
						height2 = rrr.nextInt(h);// canvas.getHeight() / 2;
						width2 = rrr.nextInt(w);// canvas.getWidth() / 2;
						desW2 = (int) (((rrr.nextInt(w)) - width2) / (DefBitmapWidth / changingBallW));
						desH2 = (int) (((rrr.nextInt(h)) - height2) / (DefBitmapWidth / changingBallW));
						// sizeW = theBall.getWidth()/3;
						// sizeW2 = (int) ((canvas.getWidth()/8)/20);
						// sizeW2 = (int) ((canvas.getHeight()/8)/12);
						sizeW2 = 0;
						// load the third ball
						start3 = System.currentTimeMillis();
						time3 = true;
						if (theTime <= 0)
							go2 = false;

						if (height2 > (canvas.getHeight() - (canvas.getHeight() / 4)))
							height2 -= (canvas.getHeight() / 4);
						if (height2 < (canvas.getHeight() / 4))
							height2 += (canvas.getHeight() / 4);

						if (width2 > (canvas.getWidth() - (canvas.getWidth() / 4)))
							width2 -= (canvas.getWidth() / 4);
						if (width2 < (canvas.getWidth() / 4))
							width2 += (canvas.getWidth() / 4);

						// if (Bsound2) {
						// BallSound2.start();
						// Bsound2 = false;
						// }
						BallSound2 = MediaPlayer.create(MainWater.this,
								R.raw.victory);
						BallSound2.setVolume(0.2f, 0.2f);

						firstTime2 = false;
					}

					// Insert the Valuables for the third ball
					if (firstTime3) {
						// default height and width for the ball
						height3 = rrr.nextInt(h);// canvas.getHeight() / 2;
						width3 = rrr.nextInt(w);// canvas.getWidth() / 2;
						desW3 = (int) (((rrr.nextInt(w)) - width3) / (DefBitmapWidth / changingBallW));
						desH3 = (int) (((rrr.nextInt(h)) - height3) / (DefBitmapWidth / changingBallW));
						// sizeW = theBall.getWidth()/3;
						// sizeW3 = (int) ((canvas.getWidth()/8)/20);
						// sizeW3 = (int) ((canvas.getHeight()/8)/12);
						sizeW3 = 0;
						// to start the first one again
						start4 = System.currentTimeMillis();
						time4 = true;
						if (theTime <= 0)
							go3 = false;

						if (height3 > (canvas.getHeight() - (canvas.getHeight() / 4)))
							height3 -= (canvas.getHeight() / 4);
						if (height3 < (canvas.getHeight() / 4))
							height3 += (canvas.getHeight() / 4);

						if (width3 > (canvas.getWidth() - (canvas.getWidth() / 4)))
							width3 -= (canvas.getWidth() / 4);
						if (width3 < (canvas.getWidth() / 4))
							width3 += (canvas.getWidth() / 4);

						// if (Bsound3) {
						// BallSound3.start();
						// Bsound3 = false;
						// }
						
						BallSound3 = MediaPlayer.create(MainWater.this,
								R.raw.victory);
						BallSound3.setVolume(0.2f, 0.2f);

						firstTime3 = false;
					}

					// Insert the Valuables for the third ball
					if (firstTime4) {
						// default height and width for the ball
						height4 = rrr.nextInt(h);// canvas.getHeight() / 2;
						width4 = rrr.nextInt(w);// canvas.getWidth() / 2;
						desW4 = (int) (((rrr.nextInt(w)) - width4) / (DefBitmapWidth / changingBallW));
						desH4 = (int) (((rrr.nextInt(h)) - height4) / (DefBitmapWidth / changingBallW));
						// sizeW = theBall.getWidth()/3;
						// sizeW4 = (int) ((canvas.getWidth()/8)/20);
						// sizeW4 = (int) ((canvas.getHeight()/8)/12);
						sizeW4 = 0;
						// to start the first one again
						start5 = System.currentTimeMillis();
						time5 = true;
						if (theTime <= 0)
							go4 = false;

						if (height4 > (canvas.getHeight() - (canvas.getHeight() / 4)))
							height4 -= (canvas.getHeight() / 4);
						if (height4 < (canvas.getHeight() / 4))
							height4 += (canvas.getHeight() / 4);

						if (width4 > (canvas.getWidth() - (canvas.getWidth() / 4)))
							width4 -= (canvas.getWidth() / 4);
						if (width4 < (canvas.getWidth() / 4))
							width4 += (canvas.getWidth() / 4);

						// if (Bsound4) {
						// BallSound4.start();
						// Bsound4 = false;
						// }
						BallSound4 = MediaPlayer.create(MainWater.this,
								R.raw.victory);
						BallSound4.setVolume(0.2f, 0.2f);

						firstTime4 = false;
					}

					// Insert the Valuables for the third ball
					if (firstTime5) {
						// default height and width for the ball
						height5 = rrr.nextInt(h);// canvas.getHeight() / 2;
						width5 = rrr.nextInt(w);// canvas.getWidth() / 2;
						desW5 = (int) (((rrr.nextInt(w)) - width5) / (DefBitmapWidth / changingBallW));
						desH5 = (int) (((rrr.nextInt(h)) - height5) / (DefBitmapWidth / changingBallW));
						// sizeW = theBall.getWidth()/3;
						// sizeW5 = (int) ((canvas.getWidth()/8)/20);
						// sizeW5 = (int) ((canvas.getHeight()/8)/12);
						sizeW5 = 0;
						// to start the first one again
						start = System.currentTimeMillis();
						time = true;
						if (theTime <= 0)
							go5 = false;

						if (height5 > (canvas.getHeight() - (canvas.getHeight() / 4)))
							height5 -= (canvas.getHeight() / 4);
						if (height5 < (canvas.getHeight() / 4))
							height5 += (canvas.getHeight() / 4);

						if (width5 > (canvas.getWidth() - (canvas.getWidth() / 4)))
							width5 -= (canvas.getWidth() / 4);
						if (width5 < (canvas.getWidth() / 4))
							width5 += (canvas.getWidth() / 4);

						// if (Bsound5) {
						// BallSound5.start();
						// Bsound5 = false;
						// }
						BallSound5 = MediaPlayer.create(MainWater.this,
								R.raw.victory);
						BallSound5.setVolume(0.2f, 0.2f);

						firstTime5 = false;
					}

					if (go1) {

						desH1 += (canvas.getHeight() / 300);
						height -= desH1;

						width -= desW1;// ((desW1 - (canvas.getWidth()/2))/30);

						// The Bitmap Size
						// sizeW += changingBallH;
						sizeW += changingBallW;
						
						BallSound.start();

						if (avatar1 || avatar2 || avatar3) {
							if (avatar1) {
								if (((AsizeW1 / DefBitmapWidth) <= ((sizeW / DefBitmapWidth) + 1))// ((sizeW/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW / DefBitmapWidth) - 1))// ((sizeW/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A1FY >= height && A1FY <= (height + sizeW)
											&& A1FX >= width && A1FX <= (width + sizeW))
											// right bottom small
											|| (A1EY >= height
													&& A1EY <= (height + sizeW)
													&& A1EX >= width && A1EX <= (width + sizeW))
											// left bottom small
											|| (A1EY >= height
													&& A1EY <= (height + sizeW)
													&& A1FX >= width && A1FX <= (width + sizeW))
											// right top small
											|| (A1FY >= height
													&& A1FY <= (height + sizeW)
													&& A1EX >= width && A1EX <= (width + sizeW))

									) {

										avatar1 = false;
										Awork = false;
										wallet += 1;

										avatarSound.stop();

										// end go1
										go1 = false;

										scorepoint = scorepoint + 1;

										actionWork1 = true;
										imprint1 = A1o;

									}
								}

							}

							if (avatar2) {
								if (((AsizeW2 / DefBitmapWidth) <= ((sizeW / DefBitmapWidth) + 1))// ((sizeW/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW / DefBitmapWidth) - 1))// ((sizeW/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A2FY >= height && A2FY <= (height + sizeW)
											&& A2FX >= width && A2FX <= (width + sizeW))
											// right bottom small
											|| (A2EY >= height
													&& A2EY <= (height + sizeW)
													&& A2EX >= width && A2EX <= (width + sizeW))
											// left bottom small
											|| (A2EY >= height
													&& A2EY <= (height + sizeW)
													&& A2FX >= width && A2FX <= (width + sizeW))
											// right top small
											|| (A2FY >= height
													&& A2FY <= (height + sizeW)
													&& A2EX >= width && A2EX <= (width + sizeW))

									) {
										avatar2 = false;
										Awork2 = false;
										wallet += 1;

										avatarSound2.stop();

										// end go1
										go1 = false;
										scorepoint = scorepoint + 1;

										actionWork1 = true;
										imprint1 = A2o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}

								}

							}

							if (avatar3) {
								if (((AsizeW3 / DefBitmapWidth) <= ((sizeW / DefBitmapWidth) + 1))// ((sizeW/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW / DefBitmapWidth) - 1))// ((sizeW/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A3FY >= height && A3FY <= (height + sizeW)
											&& A3FX >= width && A3FX <= (width + sizeW))
											// right bottom small
											|| (A3EY >= height
													&& A3EY <= (height + sizeW)
													&& A3EX >= width && A3EX <= (width + sizeW))
											// left bottom small
											|| (A3EY >= height
													&& A3EY <= (height + sizeW)
													&& A3FX >= width && A3FX <= (width + sizeW))
											// right top small
											|| (A3FY >= height
													&& A3FY <= (height + sizeW)
													&& A3EX >= width && A3EX <= (width + sizeW))

									) {
										avatar3 = false;
										Awork3 = false;
										wallet += 1;

										avatarSound3.stop();

										// end go3
										go1 = false;
										scorepoint = scorepoint + 1;

										actionWork1 = true;
										imprint1 = A3o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}

						}
						if (sizeW >= DefBitmapWidth) {
							scorepoint = scorepoint - 1;
							// end go1
							go1 = false;
							actionWork1 = true;
							imprint1 = imprint;
						}
						if (actionWork1) {
							// height and width for the imprint
							makeImprint = true;
							impH1 = height;
							impW1 = width;
							startimprint = System.currentTimeMillis();
							actionWork1 = false;
						}
					} else {
						BallSound.stop();
					}

					if (go2) {

						desH2 += (canvas.getHeight() / 300);
						height2 -= desH2;

						width2 -= desW2;// ((desW1 - (canvas.getWidth()/2))/30);

						BallSound2.start();

						// The Bitmap Size
						// sizeW += changingBallH;
						sizeW2 += changingBallW;

						if (avatar1 || avatar2 || avatar3) {
							if (avatar1) {
								if (((AsizeW1 / DefBitmapWidth) <= ((sizeW2 / DefBitmapWidth) + 1))// ((sizeW2/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW2 / DefBitmapWidth) - 1))// ((sizeW2/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A1FY >= height2
											&& A1FY <= (height2 + sizeW2)
											&& A1FX >= width2 && A1FX <= (width2 + sizeW2))
											// right bottom small
											|| (A1EY >= height2
													&& A1EY <= (height2 + sizeW2)
													&& A1EX >= width2 && A1EX <= (width2 + sizeW2))
											// left bottom small
											|| (A1EY >= height2
													&& A1EY <= (height2 + sizeW2)
													&& A1FX >= width2 && A1FX <= (width2 + sizeW2))
											// right top small
											|| (A1FY >= height2
													&& A1FY <= (height2 + sizeW2)
													&& A1EX >= width2 && A1EX <= (width2 + sizeW2))

									) {
										avatar1 = false;
										Awork = false;
										wallet += 1;

										avatarSound.stop();

										// end go1
										go2 = false;

										scorepoint = scorepoint + 1;

										actionWork2 = true;
										imprint2 = A1o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}
							if (avatar2) {
								if (((AsizeW2 / DefBitmapWidth) <= ((sizeW2 / DefBitmapWidth) + 1))// ((sizeW2/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW2 / DefBitmapWidth) - 1))// ((sizeW2/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A2FY >= height2
											&& A2FY <= (height2 + sizeW2)
											&& A2FX >= width2 && A2FX <= (width2 + sizeW2))
											// right bottom small
											|| (A2EY >= height2
													&& A2EY <= (height2 + sizeW2)
													&& A2EX >= width2 && A2EX <= (width2 + sizeW2))
											// left bottom small
											|| (A2EY >= height2
													&& A2EY <= (height2 + sizeW2)
													&& A2FX >= width2 && A2FX <= (width2 + sizeW2))
											// right top small
											|| (A2FY >= height2
													&& A2FY <= (height2 + sizeW2)
													&& A2EX >= width2 && A2EX <= (width2 + sizeW2))

									) {
										avatar2 = false;
										Awork2 = false;
										wallet += 1;

										avatarSound2.stop();

										// end go2
										go2 = false;

										scorepoint = scorepoint + 1;

										actionWork2 = true;
										imprint2 = A2o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}

							if (avatar3) {
								if (((AsizeW3 / DefBitmapWidth) <= ((sizeW2 / DefBitmapWidth) + 1))// ((sizeW2/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW2 / DefBitmapWidth) - 1))// ((sizeW2/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A3FY >= height2
											&& A3FY <= (height2 + sizeW2)
											&& A3FX >= width2 && A3FX <= (width2 + sizeW2))
											// right bottom small
											|| (A3EY >= height2
													&& A3EY <= (height2 + sizeW2)
													&& A3EX >= width2 && A3EX <= (width2 + sizeW2))
											// left bottom small
											|| (A3EY >= height2
													&& A3EY <= (height2 + sizeW2)
													&& A3FX >= width2 && A3FX <= (width2 + sizeW2))
											// right top small
											|| (A3FY >= height2
													&& A3FY <= (height2 + sizeW2)
													&& A3EX >= width2 && A3EX <= (width2 + sizeW2))

									) {
										avatar3 = false;
										Awork3 = false;
										wallet += 1;

										avatarSound3.stop();

										// end go3
										go2 = false;

										scorepoint = scorepoint + 1;

										actionWork2 = true;
										imprint2 = A3o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}

								}
							}

						}

						if (sizeW2 >= DefBitmapWidth) {

							scorepoint = scorepoint - 1;
							actionWork2 = true;
							imprint2 = imprint;
							// end go2
							go2 = false;
						}
						if (actionWork2) {
							// height and width for the imprint
							makeImprint2 = true;
							impH2 = height2;
							impW2 = width2;
							startimprint2 = System.currentTimeMillis();
							actionWork2 = false;
						}
					} else {
						BallSound2.stop();
					}

					if (go3) {

						desH3 += (canvas.getHeight() / 300);
						height3 -= desH3;

						width3 -= desW3;

						// The Bitmap Size
						// sizeW3 += changingBallH;
						sizeW3 += changingBallW;
						
						BallSound3.start();

						if (avatar1 || avatar2 || avatar3) {
							if (avatar1) {

								if (((AsizeW1 / DefBitmapWidth) <= ((sizeW3 / DefBitmapWidth) + 1))// ((sizeW3/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW3 / DefBitmapWidth) - 1))// ((sizeW3/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A1FY >= height3
											&& A1FY <= (height3 + sizeW3)
											&& A1FX >= width3 && A1FX <= (width3 + sizeW3))
											// right bottom small
											|| (A1EY >= height3
													&& A1EY <= (height3 + sizeW3)
													&& A1EX >= width3 && A1EX <= (width3 + sizeW3))
											// left bottom small
											|| (A1EY >= height3
													&& A1EY <= (height3 + sizeW3)
													&& A1FX >= width3 && A1FX <= (width3 + sizeW3))
											// right top small
											|| (A1FY >= height3
													&& A1FY <= (height3 + sizeW3)
													&& A1EX >= width3 && A1EX <= (width3 + sizeW3))

									) {
										avatar1 = false;
										Awork = false;
										wallet += 1;

										avatarSound.stop();

										// end go3
										go3 = false;

										scorepoint = scorepoint + 1;
										actionWork3 = true;
										imprint3 = A1o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}
							if (avatar2) {
								if (((AsizeW2 / DefBitmapWidth) <= ((sizeW3 / DefBitmapWidth) + 1))// ((sizeW3/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW3 / DefBitmapWidth) - 1))// ((sizeW3/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A2FY >= height3
											&& A2FY <= (height3 + sizeW3)
											&& A2FX >= width3 && A2FX <= (width3 + sizeW3))
											// right bottom small
											|| (A2EY >= height3
													&& A2EY <= (height3 + sizeW3)
													&& A2EX >= width3 && A2EX <= (width3 + sizeW3))
											// left bottom small
											|| (A2EY >= height3
													&& A2EY <= (height3 + sizeW3)
													&& A2FX >= width3 && A2FX <= (width3 + sizeW3))
											// right top small
											|| (A2FY >= height3
													&& A2FY <= (height3 + sizeW3)
													&& A2EX >= width3 && A2EX <= (width3 + sizeW3))

									) {
										avatar2 = false;
										Awork2 = false;
										wallet += 1;

										avatarSound2.stop();

										// end go3
										go3 = false;

										scorepoint = scorepoint + 1;
										actionWork3 = true;
										imprint3 = A2o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}

							}

							if (avatar3) {
								if (((AsizeW3 / DefBitmapWidth) <= ((sizeW3 / DefBitmapWidth) + 1))// ((sizeW3/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW3 / DefBitmapWidth) - 1))// ((sizeW3/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A3FY >= height3
											&& A3FY <= (height3 + sizeW3)
											&& A3FX >= width3 && A3FX <= (width3 + sizeW3))
											// right bottom small
											|| (A3EY >= height3
													&& A3EY <= (height3 + sizeW3)
													&& A3EX >= width3 && A3EX <= (width3 + sizeW3))
											// left bottom small
											|| (A3EY >= height3
													&& A3EY <= (height3 + sizeW3)
													&& A3FX >= width3 && A3FX <= (width3 + sizeW3))
											// right top small
											|| (A3FY >= height3
													&& A3FY <= (height3 + sizeW3)
													&& A3EX >= width3 && A3EX <= (width3 + sizeW3))

									) {
										avatar3 = false;
										Awork3 = false;
										wallet += 1;

										avatarSound3.stop();

										// end go3
										go3 = false;

										scorepoint = scorepoint + 1;
										actionWork3 = true;
										imprint3 = A3o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}

						}

						if (sizeW3 >= DefBitmapWidth) {

							scorepoint = scorepoint - 1;
							actionWork3 = true;
							imprint3 = imprint;
							// end go3
							go3 = false;
						}
						if (actionWork3) {
							// height and width for the imprint
							makeImprint3 = true;
							impH3 = height3;
							impW3 = width3;
							startimprint3 = System.currentTimeMillis();
							actionWork3 = false;
						}

					} else {
						BallSound3.stop();
					}

					if (go4) {

						desH4 += (canvas.getHeight() / 300);
						height4 -= desH4;

						width4 -= desW4;

						// The Bitmap Size
						// sizeW4 += changingBallH;
						sizeW4 += changingBallW;
						
						BallSound4.start();

						if (avatar1 || avatar2 || avatar3) {
							if (avatar1) {
								if (((AsizeW1 / DefBitmapWidth) <= ((sizeW4 / DefBitmapWidth) + 1))// ((sizeW4/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW4 / DefBitmapWidth) - 1))// ((sizeW4/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A1FY >= height4
											&& A1FY <= (height4 + sizeW4)
											&& A1FX >= width4 && A1FX <= (width4 + sizeW4))
											// right bottom small
											|| (A1EY >= height4
													&& A1EY <= (height4 + sizeW4)
													&& A1EX >= width4 && A1EX <= (width4 + sizeW4))
											// left bottom small
											|| (A1EY >= height4
													&& A1EY <= (height4 + sizeW4)
													&& A1FX >= width4 && A1FX <= (width4 + sizeW4))
											// right top small
											|| (A1FY >= height4
													&& A1FY <= (height4 + sizeW4)
													&& A1EX >= width4 && A1EX <= (width4 + sizeW4))

									) {
										avatar1 = false;
										Awork = false;
										wallet += 1;

										avatarSound.stop();

										// end go4
										go4 = false;

										scorepoint = scorepoint + 1;
										actionWork4 = true;
										imprint4 = A1o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}
							if (avatar2) {
								if (((AsizeW2 / DefBitmapWidth) <= ((sizeW4 / DefBitmapWidth) + 1))// ((sizeW4/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW4 / DefBitmapWidth) - 1))// ((sizeW4/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A2FY >= height4
											&& A2FY <= (height4 + sizeW4)
											&& A2FX >= width4 && A2FX <= (width4 + sizeW4))
											// right bottom small
											|| (A2EY >= height4
													&& A2EY <= (height4 + sizeW4)
													&& A2EX >= width4 && A2EX <= (width4 + sizeW4))
											// left bottom small
											|| (A2EY >= height4
													&& A2EY <= (height4 + sizeW4)
													&& A2FX >= width4 && A2FX <= (width4 + sizeW4))
											// right top small
											|| (A2FY >= height4
													&& A2FY <= (height4 + sizeW4)
													&& A2EX >= width4 && A2EX <= (width4 + sizeW4))

									) {
										avatar2 = false;
										Awork2 = false;
										wallet += 1;

										avatarSound2.stop();

										// end go4
										go4 = false;
										scorepoint = scorepoint + 1;
										actionWork4 = true;
										imprint4 = A2o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}

							}

							if (avatar3) {
								if (((AsizeW3 / DefBitmapWidth) <= ((sizeW4 / DefBitmapWidth) + 1))// ((sizeW4/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW4 / DefBitmapWidth) - 1))// ((sizeW4/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A3FY >= height4
											&& A3FY <= (height4 + sizeW4)
											&& A3FX >= width4 && A3FX <= (width4 + sizeW4))
											// right bottom small
											|| (A3EY >= height4
													&& A3EY <= (height4 + sizeW4)
													&& A3EX >= width4 && A3EX <= (width4 + sizeW4))
											// left bottom small
											|| (A3EY >= height4
													&& A3EY <= (height4 + sizeW4)
													&& A3FX >= width4 && A3FX <= (width4 + sizeW4))
											// right top small
											|| (A3FY >= height4
													&& A3FY <= (height4 + sizeW4)
													&& A3EX >= width4 && A3EX <= (width4 + sizeW4))

									) {
										avatar3 = false;
										Awork3 = false;
										wallet += 1;

										avatarSound3.stop();

										// end go3
										go4 = false;

										scorepoint = scorepoint + 1;
										actionWork4 = true;
										imprint4 = A3o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}
							}

						}

						if (sizeW4 >= DefBitmapWidth) {

							scorepoint = scorepoint - 1;
							actionWork4 = true;
							imprint4 = imprint;
							// end go4
							go4 = false;
						}
						if (actionWork4) {
							// height and width for the imprint
							makeImprint4 = true;
							impH4 = height4;
							impW4 = width4;
							startimprint4 = System.currentTimeMillis();
							actionWork4 = false;
						}
					} else {
						BallSound4.stop();
					}

					if (go5) {

						desH5 += (canvas.getHeight() / 300);
						height5 -= desH5;

						width5 -= desW5;

						// The Bitmap Size
						// sizeW5 += changingBallH;
						sizeW5 += changingBallW;
						
						BallSound5.start();

						if (avatar1 || avatar2 || avatar3) {
							if (avatar1) {
								if (((AsizeW1 / DefBitmapWidth) <= ((sizeW5 / DefBitmapWidth) + 1))// ((sizeW5/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW5 / DefBitmapWidth) - 1))// ((sizeW5/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A1FY >= height5
											&& A1FY <= (height5 + sizeW5)
											&& A1FX >= width5 && A1FX <= (width5 + sizeW5))
											// right bottom small
											|| (A1EY >= height5
													&& A1EY <= (height5 + sizeW5)
													&& A1EX >= width5 && A1EX <= (width5 + sizeW5))
											// left bottom small
											|| (A1EY >= height5
													&& A1EY <= (height5 + sizeW5)
													&& A1FX >= width5 && A1FX <= (width5 + sizeW5))
											// right top small
											|| (A1FY >= height5
													&& A1FY <= (height5 + sizeW5)
													&& A1EX >= width5 && A1EX <= (width5 + sizeW5))

									) {
										avatar1 = false;
										Awork = false;
										wallet += 1;

										avatarSound.stop();

										// end go4
										go5 = false;

										scorepoint = scorepoint + 1;
										actionWork5 = true;
										imprint5 = A1o;

									}
								}
							}
							if (avatar2) {
								if (((AsizeW2 / DefBitmapWidth) <= ((sizeW5 / DefBitmapWidth) + 1))// ((sizeW5/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW5 / DefBitmapWidth) - 1))// ((sizeW5/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A2FY >= height5
											&& A2FY <= (height5 + sizeW5)
											&& A2FX >= width5 && A2FX <= (width5 + sizeW5))
											// right bottom small
											|| (A2EY >= height5
													&& A2EY <= (height5 + sizeW5)
													&& A2EX >= width5 && A2EX <= (width5 + sizeW5))
											// left bottom small
											|| (A2EY >= height5
													&& A2EY <= (height5 + sizeW5)
													&& A2FX >= width5 && A2FX <= (width5 + sizeW5))
											// right top small
											|| (A2FY >= height5
													&& A2FY <= (height5 + sizeW5)
													&& A2EX >= width5 && A2EX <= (width4 + sizeW5))

									) {

										avatar2 = false;
										Awork2 = false;
										wallet += 1;

										avatarSound2.stop();

										// end go4
										go5 = false;

										scorepoint = scorepoint + 1;
										actionWork5 = true;
										imprint5 = A2o;

										// it's work but wants some changes and
										// make
										// three or four balls at the same time
									}
								}

							}

							if (avatar3) {
								if (((AsizeW3 / DefBitmapWidth) <= ((sizeW5 / DefBitmapWidth) + 1))// ((sizeW5/ScreenWidth)
																									// +
																									// (ScreenWidth/1000)))
										&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW5 / DefBitmapWidth) - 1))// ((sizeW5/ScreenWidth)
																											// -
																											// (ScreenWidth/1000)))
								) {
									if (
									// left top small
									(A3FY >= height5
											&& A3FY <= (height5 + sizeW5)
											&& A3FX >= width5 && A3FX <= (width5 + sizeW5))
											// right bottom small
											|| (A3EY >= height5
													&& A3EY <= (height5 + sizeW5)
													&& A3EX >= width5 && A3EX <= (width5 + sizeW5))
											// left bottom small
											|| (A3EY >= height5
													&& A3EY <= (height5 + sizeW5)
													&& A3FX >= width5 && A3FX <= (width5 + sizeW5))
											// right top small
											|| (A3FY >= height5
													&& A3FY <= (height5 + sizeW5)
													&& A3EX >= width5 && A3EX <= (width5 + sizeW5))

									) {
										avatar3 = false;
										Awork3 = false;
										wallet += 1;

										avatarSound3.stop();

										// end go3
										go5 = false;

										scorepoint = scorepoint + 1;
										actionWork5 = true;
										imprint5 = A3o;

									}
								}
							}

						}

						if (sizeW5 >= DefBitmapWidth) {

							scorepoint = scorepoint - 1;
							actionWork5 = true;
							imprint5 = imprint;
							// end go4
							go5 = false;
						}
						if (actionWork5) {
							// height and width for the imprint
							makeImprint5 = true;
							impH5 = height5;
							impW5 = width5;
							startimprint5 = System.currentTimeMillis();
							actionWork5 = false;
						}
					} else {
						BallSound5.stop();
					}

					// for the first rock
					if (oneR1) {
						rokH = rrr.nextInt(h);
						// rokW = rrr.nextInt(w);
						roksizeW = rrr.nextInt(DefBitmapWidth);
						rokW = canvas.getWidth();
						// rokH = canvas.getHeight();
						oneR1 = false;
					}

					// for the rocks and else like fish or lava .....
					if (rok1) {
						// to make the rock move in the horizantle
						int desx = ((canvas.getWidth()) / 300);
						rokW -= desx;
						// rokH -= desx;

						if (avatar1 || avatar2 || avatar3) {

							if (avatar1) {
								// for the avatar1
								if (((AsizeW1 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((AsizeW1 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((A1FY >= rokH
												&& A1FY <= (rokH + roksizeW)
												&& A1FX >= rokW && A1FX <= (rokW + roksizeW))
												// right bottom small
												|| (A1EY >= rokH
														&& A1EY <= (rokH + roksizeW)
														&& A1EX >= rokW && A1EX <= (rokW + roksizeW))
												// left bottom small
												|| (A1EY >= rokH
														&& A1EY <= (rokH + roksizeW)
														&& A1FX >= rokW && A1FX <= (rokW + roksizeW))
										// right top small
										|| (A1FY >= rokH
												&& A1FY <= (rokH + roksizeW)
												&& A1EX >= rokW && A1EX <= (rokW + roksizeW)))) {
									avatar1 = false;
									Awork = false;
									wallet += 1;

									avatarSound.stop();

									rok1 = false;
								}
							}
							if (avatar2) {
								// for the avatar2
								if (((AsizeW2 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((AsizeW2 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((A2FY >= rokH
												&& A2FY <= (rokH + roksizeW)
												&& A2FX >= rokW && A2FX <= (rokW + roksizeW))
												// right bottom small
												|| (A2EY >= rokH
														&& A2EY <= (rokH + roksizeW)
														&& A2EX >= rokW && A2EX <= (rokW + roksizeW))
												// left bottom small
												|| (A2EY >= rokH
														&& A2EY <= (rokH + roksizeW)
														&& A2FX >= rokW && A2FX <= (rokW + roksizeW))
										// right top small
										|| (A2FY >= rokH
												&& A2FY <= (rokH + roksizeW)
												&& A2EX >= rokW && A2EX <= (rokW + roksizeW)))) {
									avatar2 = false;
									Awork2 = false;
									wallet += 1;

									avatarSound2.stop();

									rok1 = false;
								}
							}
							if (avatar3) {
								// for the avatar3
								if (((AsizeW3 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((AsizeW3 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((A3FY >= rokH
												&& A3FY <= (rokH + roksizeW)
												&& A3FX >= rokW && A3FX <= (rokW + roksizeW))
												// right bottom small
												|| (A3EY >= rokH
														&& A3EY <= (rokH + roksizeW)
														&& A3EX >= rokW && A3EX <= (rokW + roksizeW))
												// left bottom small
												|| (A3EY >= rokH
														&& A3EY <= (rokH + roksizeW)
														&& A3FX >= rokW && A3FX <= (rokW + roksizeW))
										// right top small
										|| (A3FY >= rokH
												&& A3FY <= (rokH + roksizeW)
												&& A3EX >= rokW && A3EX <= (rokW + roksizeW)))) {
									avatar3 = false;
									Awork3 = false;
									wallet += 1;

									avatarSound3.stop();
									rok1 = false;
								}
							}

						}

						if (go1 || go2 || go3 || go4 || go5) {

							if (go1) {
								// for the go1
								if (((sizeW / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((sizeW / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((height >= rokH
												&& height <= (rokH + roksizeW)
												&& width >= rokW && width <= (rokW + roksizeW))
												// right bottom small
												|| ((height + sizeW) >= rokH
														&& (height + sizeW) <= (rokH + roksizeW)
														&& (width + sizeW) >= rokW && (width + sizeW) <= (rokW + roksizeW))
												// left bottom small
												|| ((height + sizeW) >= rokH
														&& (height + sizeW) <= (rokH + roksizeW)
														&& width >= rokW && width <= (rokW + roksizeW))
										// right top small
										|| (height >= rokH
												&& height <= (rokH + roksizeW)
												&& (width + sizeW) >= rokW && (width + sizeW) <= (rokW + roksizeW)))) {
									go1 = false;
									BallSound.stop();

								}
							}
							if (go2) {
								// for the go2
								if (((sizeW2 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((sizeW2 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((height2 >= rokH
												&& height2 <= (rokH + roksizeW)
												&& width2 >= rokW && width2 <= (rokW + roksizeW))
												// right bottom small
												|| ((height2 + sizeW2) >= rokH
														&& (height2 + sizeW2) <= (rokH + roksizeW)
														&& (width2 + sizeW2) >= rokW && (width2 + sizeW2) <= (rokW + roksizeW))
												// left bottom small
												|| ((height2 + sizeW2) >= rokH
														&& (height2 + sizeW2) <= (rokH + roksizeW)
														&& width2 >= rokW && width2 <= (rokW + roksizeW))
										// right top small
										|| (height2 >= rokH
												&& height2 <= (rokH + roksizeW)
												&& (width2 + sizeW2) >= rokW && (width2 + sizeW2) <= (rokW + roksizeW)))) {
									go2 = false;
									BallSound2.stop();

								}
							}
							if (go3) {
								// for the go3
								if (((sizeW3 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((sizeW3 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((height3 >= rokH
												&& height3 <= (rokH + roksizeW)
												&& width3 >= rokW && width3 <= (rokW + roksizeW))
												// right bottom small
												|| ((height3 + sizeW3) >= rokH
														&& (height3 + sizeW3) <= (rokH + roksizeW)
														&& (width3 + sizeW3) >= rokW && (width3 + sizeW3) <= (rokW + roksizeW))
												// left bottom small
												|| ((height3 + sizeW3) >= rokH
														&& (height3 + sizeW3) <= (rokH + roksizeW)
														&& width3 >= rokW && width3 <= (rokW + roksizeW))
										// right top small
										|| (height3 >= rokH
												&& height3 <= (rokH + roksizeW)
												&& (width3 + sizeW3) >= rokW && (width3 + sizeW3) <= (rokW + roksizeW)))) {
									go3 = false;
									BallSound3.stop();
								}
							}
							if (go4) {
								// for the go4
								if (((sizeW4 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((sizeW4 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((height4 >= rokH
												&& height4 <= (rokH + roksizeW)
												&& width4 >= rokW && width4 <= (rokW + roksizeW))
												// right bottom small
												|| ((height4 + sizeW4) >= rokH
														&& (height4 + sizeW4) <= (rokH + roksizeW)
														&& (width4 + sizeW4) >= rokW && (width4 + sizeW4) <= (rokW + roksizeW))
												// left bottom small
												|| ((height4 + sizeW4) >= rokH
														&& (height4 + sizeW4) <= (rokH + roksizeW)
														&& width4 >= rokW && width4 <= (rokW + roksizeW))
										// right top small
										|| (height4 >= rokH
												&& height4 <= (rokH + roksizeW)
												&& (width4 + sizeW4) >= rokW && (width4 + sizeW4) <= (rokW + roksizeW)))) {
									go4 = false;
									BallSound4.stop();

									// rok1 = false;
								}
							}
							if (go5) {
								// for the go5
								if (((sizeW5 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))
										&& ((sizeW5 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))
										&& ((height5 >= rokH
												&& height5 <= (rokH + roksizeW)
												&& width5 >= rokW && width5 <= (rokW + roksizeW))
												// right bottom small
												|| ((height5 + sizeW5) >= rokH
														&& (height5 + sizeW5) <= (rokH + roksizeW)
														&& (width5 + sizeW5) >= rokW && (width5 + sizeW5) <= (rokW + roksizeW))
												// left bottom small
												|| ((height5 + sizeW5) >= rokH
														&& (height5 + sizeW5) <= (rokH + roksizeW)
														&& width5 >= rokW && width5 <= (rokW + roksizeW))
										// right top small
										|| (height5 >= rokH
												&& height5 <= (rokH + roksizeW)
												&& (width5 + sizeW5) >= rokW && (width5 + sizeW5) <= (rokW + roksizeW)))) {
									go5 = false;
									BallSound5.stop();

									// rok1 = false;
								}
							}

						}

						if ((rokW + roksizeW) <= 0) {
							rok1 = false;
						}

					} else {
						oneR1 = true;
						rok1 = true;
					}

					// for the second rock
					if (oneR2) {
						rokH2 = rrr.nextInt(h);
						// rokW = rrr.nextInt(w);
						roksizeW2 = rrr.nextInt(DefBitmapWidth);
						rokW2 = canvas.getWidth();
						// rokH2 = canvas.getHeight();

						oneR2 = false;
					}

					// for the rocks and else like fish or lava .....
					if (rok2) {// && workR2){//&& rokW <=
								// (canvas.getWidth()-(canvas.getWidth()/4))){

						int desx = ((canvas.getWidth()) / 300);
						rokW2 -= desx;
						// rokH2 -= desx;

						if (avatar1 || avatar2 || avatar3) {

							if (avatar1) {
								if (((AsizeW1 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((AsizeW1 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((A1FY >= rokH2
												&& A1FY <= (rokH2 + roksizeW2)
												&& A1FX >= rokW2 && A1FX <= (rokW2 + roksizeW2))
												// right bottom small
												|| (A1EY >= rokH2
														&& A1EY <= (rokH2 + roksizeW2)
														&& A1EX >= rokW2 && A1EX <= (rokW2 + roksizeW2))
												// left bottom small
												|| (A1EY >= rokH2
														&& A1EY <= (rokH2 + roksizeW2)
														&& A1FX >= rokW2 && A1FX <= (rokW2 + roksizeW2))
										// right top small
										|| (A1FY >= rokH2
												&& A1FY <= (rokH2 + roksizeW2)
												&& A1EX >= rokW2 && A1EX <= (rokW2 + roksizeW2)))) {
									avatar1 = false;
									Awork = false;
									wallet += 1;

									avatarSound.stop();

									rok2 = false;
								}
							}
							if (avatar2) {
								// for the avatar2
								if (((AsizeW2 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((AsizeW2 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((A2FY >= rokH2
												&& A2FY <= (rokH2 + roksizeW2)
												&& A2FX >= rokW2 && A2FX <= (rokW2 + roksizeW2))
												// right bottom small
												|| (A2EY >= rokH2
														&& A2EY <= (rokH2 + roksizeW2)
														&& A2EX >= rokW2 && A2EX <= (rokW2 + roksizeW2))
												// left bottom small
												|| (A2EY >= rokH2
														&& A2EY <= (rokH2 + roksizeW2)
														&& A2FX >= rokW2 && A2FX <= (rokW2 + roksizeW2))
										// right top small
										|| (A2FY >= rokH2
												&& A2FY <= (rokH2 + roksizeW2)
												&& A2EX >= rokW2 && A2EX <= (rokW2 + roksizeW2)))) {
									avatar2 = false;
									Awork2 = false;
									wallet += 1;

									avatarSound2.stop();

									rok2 = false;
								}
							}
							if (avatar3) {
								// for the avatar3
								if (((AsizeW3 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((AsizeW3 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((A3FY >= rokH2
												&& A3FY <= (rokH2 + roksizeW2)
												&& A3FX >= rokW2 && A3FX <= (rokW2 + roksizeW2))
												// right bottom small
												|| (A3EY >= rokH2
														&& A3EY <= (rokH2 + roksizeW2)
														&& A3EX >= rokW2 && A3EX <= (rokW2 + roksizeW2))
												// left bottom small
												|| (A3EY >= rokH2
														&& A3EY <= (rokH2 + roksizeW2)
														&& A3FX >= rokW2 && A3FX <= (rokW2 + roksizeW2))
										// right top small
										|| (A3FY >= rokH2
												&& A3FY <= (rokH2 + roksizeW2)
												&& A3EX >= rokW2 && A3EX <= (rokW2 + roksizeW2)))) {
									avatar3 = false;
									Awork3 = false;
									wallet += 1;

									avatarSound3.stop();

									rok2 = false;
								}
							}
						}

						if (go1 || go2 || go3 || go4 || go5) {
							if (go1) {
								// for the go1
								if (((sizeW / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((sizeW / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((height >= rokH2
												&& height <= (rokH2 + roksizeW2)
												&& width >= rokW2 && width <= (rokW2 + roksizeW2))
												// right bottom small
												|| ((height + sizeW) >= rokH2
														&& (height + sizeW) <= (rokH2 + roksizeW2)
														&& (width + sizeW) >= rokW2 && (width + sizeW) <= (rokW2 + roksizeW2))
												// left bottom small
												|| ((height + sizeW) >= rokH2
														&& (height + sizeW) <= (rokH2 + roksizeW2)
														&& width >= rokW2 && width <= (rokW2 + roksizeW2))
										// right top small
										|| (height >= rokH2
												&& height <= (rokH2 + roksizeW2)
												&& (width + sizeW) >= rokW2 && (width + sizeW) <= (rokW2 + roksizeW2)))) {
									go1 = false;
									BallSound.stop();

								}
							}
							if (go2) {
								// for the go2
								if (((sizeW2 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((sizeW2 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((height2 >= rokH2
												&& height2 <= (rokH2 + roksizeW2)
												&& width2 >= rokW2 && width2 <= (rokW2 + roksizeW2))
												// right bottom small
												|| ((height2 + sizeW2) >= rokH2
														&& (height2 + sizeW2) <= (rokH2 + roksizeW2)
														&& (width2 + sizeW2) >= rokW2 && (width2 + sizeW2) <= (rokW2 + roksizeW2))
												// left bottom small
												|| ((height2 + sizeW2) >= rokH2
														&& (height2 + sizeW2) <= (rokH2 + roksizeW2)
														&& width2 >= rokW2 && width2 <= (rokW2 + roksizeW2))
										// right top small
										|| (height2 >= rokH2
												&& height2 <= (rokH2 + roksizeW2)
												&& (width2 + sizeW2) >= rokW2 && (width2 + sizeW2) <= (rokW2 + roksizeW2)))) {
									go2 = false;
									BallSound2.stop();

									// rok2 = false;
								}
							}
							if (go3) {
								// for the go3
								if (((sizeW3 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((sizeW3 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((height3 >= rokH2
												&& height3 <= (rokH2 + roksizeW2)
												&& width3 >= rokW2 && width3 <= (rokW2 + roksizeW2))
												// right bottom small
												|| ((height3 + sizeW3) >= rokH2
														&& (height3 + sizeW3) <= (rokH2 + roksizeW2)
														&& (width3 + sizeW3) >= rokW2 && (width3 + sizeW3) <= (rokW2 + roksizeW2))
												// left bottom small
												|| ((height3 + sizeW3) >= rokH2
														&& (height3 + sizeW3) <= (rokH2 + roksizeW2)
														&& width3 >= rokW2 && width3 <= (rokW2 + roksizeW2))
										// right top small
										|| (height3 >= rokH2
												&& height3 <= (rokH2 + roksizeW2)
												&& (width3 + sizeW3) >= rokW2 && (width3 + sizeW3) <= (rokW2 + roksizeW2)))) {
									go3 = false;
									BallSound3.stop();

									// rok2 = false;
								}
							}
							if (go4) {
								// for the go4
								if (((sizeW4 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((sizeW4 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((height4 >= rokH2
												&& height4 <= (rokH2 + roksizeW2)
												&& width4 >= rokW2 && width4 <= (rokW2 + roksizeW2))
												// right bottom small
												|| ((height4 + sizeW4) >= rokH2
														&& (height4 + sizeW4) <= (rokH2 + roksizeW2)
														&& (width4 + sizeW4) >= rokW2 && (width4 + sizeW4) <= (rokW2 + roksizeW2))
												// left bottom small
												|| ((height4 + sizeW4) >= rokH2
														&& (height4 + sizeW4) <= (rokH2 + roksizeW2)
														&& width4 >= rokW2 && width4 <= (rokW2 + roksizeW2))
										// right top small
										|| (height4 >= rokH2
												&& height4 <= (rokH2 + roksizeW2)
												&& (width4 + sizeW4) >= rokW2 && (width4 + sizeW4) <= (rokW2 + roksizeW2)))) {
									go4 = false;
									BallSound4.stop();

								}
							}
							if (go5) {
								// for the go5
								if (((sizeW5 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))
										&& ((sizeW5 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))
										&& ((height5 >= rokH2
												&& height5 <= (rokH2 + roksizeW2)
												&& width5 >= rokW2 && width5 <= (rokW2 + roksizeW2))
												// right bottom small
												|| ((height5 + sizeW5) >= rokH2
														&& (height5 + sizeW5) <= (rokH2 + roksizeW2)
														&& (width5 + sizeW5) >= rokW2 && (width5 + sizeW5) <= (rokW2 + roksizeW2))
												// left bottom small
												|| ((height5 + sizeW5) >= rokH2
														&& (height5 + sizeW5) <= (rokH2 + roksizeW2)
														&& width5 >= rokW2 && width5 <= (rokW2 + roksizeW2))
										// right top small
										|| (height5 >= rokH2
												&& height5 <= (rokH2 + roksizeW2)
												&& (width5 + sizeW5) >= rokW2 && (width5 + sizeW5) <= (rokW2 + roksizeW2)))) {
									go5 = false;
									BallSound5.stop();
								}
							}

						}

						if ((rokW2 + roksizeW2) <= 0) {
							rok2 = false;
						}

					} else {
						oneR2 = true;
						rok2 = true;
						workR2 = true;

					}

					// Draw Text
					Paint textPaint = new Paint();
					textPaint.setColor(Color.BLUE);
					textPaint.setTextAlign(Align.CENTER);
					textPaint.setTextSize(20);
					textPaint.setTypeface(font);
					s = "x = " + x + "    y = " + y;
					// String aaaa = "" + wallet;
					String aaaaaaa = "Action1 = " + action1 + "Action2 = "
							+ action2 + "Action3 =" + action3 + "Action4 ="
							+ action4 + "Action5 =" + action5;

					canvas.drawText(aaaaaaa, canvas.getWidth() / 2, 200,
							textPaint);

				}

				Integer[] Sizes = { sizeW, sizeW2, sizeW3, sizeW4, sizeW5,
						roksizeW, roksizeW2, AsizeW1, AsizeW2, AsizeW3 };
				Arrays.sort(Sizes, new Comparator<Integer>() {
					@Override
					public int compare(Integer x, Integer y) {
						// for from min to max
						return x - y;
						// for max to min return y - x;
					}
				});

				// for the rocks
				Matrix matrix = new Matrix();
				rotation -= 1;

				for (int i = 0; i < Sizes.length; i++) {
					if (sizeW == Sizes[i] && go1) {
						CanvasBall = Bitmap.createScaledBitmap(firstball,
								sizeW, sizeW, true);
						canvas.drawBitmap(CanvasBall, width, height, null);
					}
					if (sizeW2 == Sizes[i] && go2) {
						CanvasBall2 = Bitmap.createScaledBitmap(secondball,
								sizeW2, sizeW2, true);
						canvas.drawBitmap(CanvasBall2, width2, height2, null);
					}
					if (sizeW3 == Sizes[i] && go3) {
						CanvasBall3 = Bitmap.createScaledBitmap(thirdball,
								sizeW3, sizeW3, true);
						canvas.drawBitmap(CanvasBall3, width3, height3, null);
					}
					if (sizeW4 == Sizes[i] && go4) {
						CanvasBall4 = Bitmap.createScaledBitmap(theBall,
								sizeW4, sizeW4, true);
						canvas.drawBitmap(CanvasBall4, width4, height4, null);
					}
					if (sizeW5 == Sizes[i] && go5) {
						CanvasBall5 = Bitmap.createScaledBitmap(theBall,
								sizeW5, sizeW5, true);
						canvas.drawBitmap(CanvasBall5, width5, height5, null);
					}
					if (roksizeW == Sizes[i] && rok1) {
						Bitmap rok11 = Bitmap.createScaledBitmap(rock,
								roksizeW, roksizeW, true);
						matrix.setRotate(rotation, roksizeW, roksizeW);
						Bitmap rotatedBitmap = Bitmap.createBitmap(rok11, 0, 0,
								roksizeW, roksizeW, matrix, true);
						canvas.drawBitmap(rotatedBitmap, rokW, rokH, null);
					}
					if (roksizeW2 == Sizes[i] && rok2) {
						Bitmap rok22 = Bitmap.createScaledBitmap(rock,
								roksizeW2, roksizeW2, true);
						matrix.setRotate(rotation, roksizeW2, roksizeW2);
						Bitmap rotatedBitmap2 = Bitmap.createBitmap(rok22, 0,
								0, roksizeW2, roksizeW2, matrix, true);
						canvas.drawBitmap(rotatedBitmap2, rokW2, rokH2, null);
					}
					if (AsizeW1 == Sizes[i] && avatar1) {
						Bavatar = Bitmap.createScaledBitmap(A1o, AsizeW1,
								AsizeW1, true);
						canvas.drawBitmap(Bavatar, (avatarW1 - (AsizeW1 / 2)),
								(avatarH1 - (AsizeW1 / 2)), null);
					}
					if (AsizeW2 == Sizes[i] && avatar2) {
						Bavatar2 = Bitmap.createScaledBitmap(A2o, AsizeW2,
								AsizeW2, true);
						canvas.drawBitmap(Bavatar2, (avatarW2 - (AsizeW2 / 2)),
								(avatarH2 - (AsizeW2 / 2)), null);
					}
					if (AsizeW3 == Sizes[i] && avatar3) {
						Bavatar3 = Bitmap.createScaledBitmap(A3o, AsizeW3,
								AsizeW3, true);
						canvas.drawBitmap(Bavatar3, (avatarW3 - (AsizeW3 / 2)),
								(avatarH3 - (AsizeW3 / 2)), null);
					}
					if (sizeW == Sizes[i] && makeImprint) {
						Bitmap print = Bitmap.createScaledBitmap(imprint1, sizeW,
								sizeW, true);
						canvas.drawBitmap(print, impW1, impH1, new Paint());
					}
					if (sizeW2 == Sizes[i] && makeImprint2) {
						Bitmap print = Bitmap.createScaledBitmap(imprint2, sizeW2,
								sizeW2, true);
						canvas.drawBitmap(print, impW2, impH2, new Paint());
					}
					if (sizeW3 == Sizes[i] && makeImprint3) {
						Bitmap print = Bitmap.createScaledBitmap(imprint3, sizeW3,
								sizeW3, true);
						canvas.drawBitmap(print, impW3, impH3, new Paint());
					}
					if (sizeW4 == Sizes[i] && makeImprint4) {
						Bitmap print = Bitmap.createScaledBitmap(imprint4, sizeW4,
								sizeW4, true);
						canvas.drawBitmap(print, impW4, impH4, new Paint());
					}
					if (sizeW5 == Sizes[i] && makeImprint5) {
						Bitmap print = Bitmap.createScaledBitmap(imprint5, sizeW5,
								sizeW5, true);
						canvas.drawBitmap(print, impW5, impH5, new Paint());
					}

				}

				if (Awork) {
					Bavatar = Bitmap.createScaledBitmap(A1o, AsizeW1, AsizeW1,
							true);
					canvas.drawBitmap(mark1, markAW1, markAH1, null);
					canvas.drawBitmap(Bavatar, (avatarW1 - (AsizeW1 / 2)),
							(avatarH1 - (AsizeW1 / 2)), null);
				}
				if (Awork2) {
					Bavatar2 = Bitmap.createScaledBitmap(A2o, AsizeW2, AsizeW2,
							true);
					canvas.drawBitmap(mark1, markAW2, markAH2, null);
					canvas.drawBitmap(Bavatar2, (avatarW2 - (AsizeW2 / 2)),
							(avatarH2 - (AsizeW2 / 2)), null);
				}
				if (Awork3) {
					Bavatar3 = Bitmap.createScaledBitmap(A3o, AsizeW3, AsizeW3,
							true);
					canvas.drawBitmap(mark1, markAW3, markAH3, null);
					canvas.drawBitmap(Bavatar3, (avatarW3 - (AsizeW3 / 2)),
							(avatarH3 - (AsizeW3 / 2)), null);
				}

				if (doSecound) {
					theTime = 60 - TimeCounter;

					// for all imprints
					// imprint 1
					if (makeImprint) {

						stopimprint = System.currentTimeMillis();
						resultimprint = stopimprint - startimprint;

						if (resultimprint >= 1000) {
							makeImprint = false;
						}
					}
					// imprint 2
					if (makeImprint2) {

						stopimprint2 = System.currentTimeMillis();
						resultimprint2 = stopimprint2 - startimprint2;

						if (resultimprint2 >= 1000) {
							makeImprint2 = false;
						}
					}
					// imprint 3
					if (makeImprint3) {

						stopimprint3 = System.currentTimeMillis();
						resultimprint3 = stopimprint3 - startimprint3;

						if (resultimprint3 >= 1000) {
							makeImprint3 = false;
						}
					}
					// imprint 4
					if (makeImprint4) {

						stopimprint4 = System.currentTimeMillis();
						resultimprint4 = stopimprint4 - startimprint4;

						if (resultimprint4 >= 1000) {
							makeImprint4 = false;
						}
					}

					// imprint 5
					if (makeImprint5) {

						stopimprint5 = System.currentTimeMillis();
						resultimprint5 = stopimprint5 - startimprint5;

						if (resultimprint5 >= 1000) {
							makeImprint5 = false;
						}
					}
				}

				
				// the Score
				Paint score = new Paint();
				score.setColor(Color.GREEN);
				score.setTextSize(30);
				score.setTypeface(font);
				String ss = "the score is       " + scorepoint;
				canvas.drawText(ss, canvas.getWidth() / 2 - 100, 30, score);

				// the game time
				Paint timep = new Paint();
				timep.setColor(Color.RED);
				timep.setTextSize(30);
				timep.setTypeface(font);

				String sss = "the game time is       " + (theTime);
				canvas.drawText(sss, 30, 30, timep);

				canvas.drawBitmap(pause2, canvas.getWidth() - chooseAsizeW,
						chooseAsizeW, null);

				// to stop the game and it will be intent soon in sha2 2allah
				if (theTime <= 0) {
					if (!go1 && !go2 && !go3 && !go4 && !go5) {
						// theViewOfSurFace.pause();

						if (avatar1)
							avatarSound.release();
						if (avatar2)
							avatarSound2.release();
						if (avatar3)
							avatarSound3.release();
						if (go1)
							BallSound.release();
						if (go2)
							BallSound2.release();
						if (go3)
							BallSound3.release();
						if (go4)
							BallSound4.release();
						if (go5)
							BallSound5.release();

						paused = false;
						editor.putBoolean("pause", paused);
						editor.commit();
						// Intent endInt = new Intent(MainWater.this,
						// com.end2.EndSpace.class);

						GameSound.release();

						Intent endInt = new Intent(MainWater.this,
								com.end2.PauseWater.class);
						// endInt.putExtra("score", scorepoint);
						startActivity(endInt);
					}
				}

				// for the Buttons and the Avatars
				if (BallInt > 0) {
					Bitmap first = Bitmap.createScaledBitmap(theBall,
							chooseAsizeW, chooseAsizeW, true);
					canvas.drawBitmap(first, 0, 2 * chooseAsizeW, null);
				}
				if (BoxFInt > 0) {
					Bitmap second = Bitmap.createScaledBitmap(BoxesAfter,
							chooseAsizeW, chooseAsizeW, true);
					canvas.drawBitmap(second, 0, 3 * chooseAsizeW, null);
				}
				if (BoxBInt > 0) {
					Bitmap third = Bitmap.createScaledBitmap(BoxesBefore,
							chooseAsizeW, chooseAsizeW, true);
					canvas.drawBitmap(third, 0, 4 * chooseAsizeW, null);
				}
				if (rokyInt > 0) {
					Bitmap second = Bitmap.createScaledBitmap(rock,
							chooseAsizeW, chooseAsizeW, true);
					canvas.drawBitmap(second, 0, 5 * chooseAsizeW, null);
				}
				if (Ball2Int > 0) {
					Bitmap third = Bitmap.createScaledBitmap(secondball,
							chooseAsizeW, chooseAsizeW, true);
					canvas.drawBitmap(third, 0, 6 * chooseAsizeW, null);
				}

				// if the avatar finished what will happenned here
				if (BallInt == 0) {
					BoxF1 = true;
				}
				if (BoxFInt == 0) {
					BoxB1 = true;
				}
				if (BoxBInt == 0) {
					roky1 = true;
				}
				if (rokyInt == 0) {
					Ball2 = true;
				}
				if (Ball2Int == 0) {
					Ball1 = true;
				}
				if (BallInt == 0 && BoxFInt == 0 && BoxBInt == 0
						&& rokyInt == 0 && Ball2Int == 0 && !avatar1
						&& !avatar2 && !avatar3) {
					// theViewOfSurFace.pause();
					// finish();
					paused = false;
					editor = pref.edit();
					editor.putBoolean("pause", paused);
					editor.commit();

					avatarSound.release();
					avatarSound2.release();
					avatarSound3.release();

					BallSound.release();
					BallSound2.release();
					BallSound3.release();
					BallSound4.release();
					BallSound5.release();

					GameSound.release();

					// Intent iend = new Intent(MainWater.this ,
					// com.end2.EndSpace.class);
					Intent iend = new Intent(MainWater.this, PauseWater.class);
					startActivity(iend);
				}

				// to draw numbers before play the game
				if (!doSecound) {

					if (resultTime >= 1000) {
						counter += 1;
						gameTime = System.currentTimeMillis();
						resultTime = 0;
					}

					Paint p = new Paint();
					p.setTextSize(40);
					p.setColor(Color.GREEN);
					// draw the number
					if (counter == 1) {
						canvas.drawText("3", canvas.getWidth() / 2,
								canvas.getHeight() / 2, p);
					} else if (counter == 2) {
						canvas.drawText("2", canvas.getWidth() / 2,
								canvas.getHeight() / 2, p);
					} else if (counter == 3) {
						canvas.drawText("1", canvas.getWidth() / 2,
								canvas.getHeight() / 2, p);
					}
					// finish the start Time
					if (counter == 3) {
						doSecound = true;
					}
				}
				
				preferences = getSharedPreferences("Water_Data",
						Context.MODE_PRIVATE);
				editor = preferences.edit();
				editor.putBoolean("AB1", avatar1);
				editor.putBoolean("AB2", avatar2);
				editor.putBoolean("AB3", avatar3);
				editor.putBoolean("FTB1", firstTime);
				editor.putBoolean("FTB2", firstTime2);
				editor.putBoolean("FTB3", firstTime3);
				editor.putBoolean("FTB4", firstTime4);
				editor.putBoolean("FTB5", firstTime5);
				editor.putBoolean("GO1", go1);
				editor.putBoolean("GO2", go2);
				editor.putBoolean("GO3", go3);
				editor.putBoolean("GO4", go4);
				editor.putBoolean("GO5", go5);
				editor.putBoolean("RB1", rok1);
				editor.putBoolean("RB2", rok2);
				editor.putBoolean("IMP1", makeImprint);
				editor.putBoolean("IMP2", makeImprint2);
				editor.putBoolean("IMP3", makeImprint3);
				editor.putBoolean("IMP4", makeImprint4);
				editor.putBoolean("IMP5", makeImprint5);
				editor.putBoolean("TB1", time);
				editor.putBoolean("TB2", time2);
				editor.putBoolean("TB3", time3);
				editor.putBoolean("TB4", time4);
				editor.putBoolean("TB5", time5);
				editor.putBoolean("TB1", time);
				editor.putBoolean("AWB1", Awork);
				editor.putBoolean("AWB2", Awork2);
				editor.putBoolean("AWB3", Awork3);
				editor.putFloat("AW1", avatarW1);
				editor.putFloat("AW2", avatarW2);
				editor.putFloat("AW3", avatarW3);
				editor.putFloat("AH1", avatarH1);
				editor.putFloat("AH2", avatarH2);
				editor.putFloat("AH3", avatarH3);
				editor.putInt("AS1", AsizeW1);
				editor.putInt("AS2", AsizeW2);
				editor.putInt("AS3", AsizeW3);
				editor.putLong("RL1", result);
				editor.putLong("RL2", result2);
				editor.putLong("RL3", result3);
				editor.putLong("RL4", result4);
				editor.putLong("RL5", result5);
				editor.putLong("SL1", start);
				editor.putLong("SL2", start2);
				editor.putLong("SL3", start3);
				editor.putLong("SL4", start4);
				editor.putLong("SL5", start5);
				editor.putFloat("BW1", width);
				editor.putFloat("BW2", width2);
				editor.putFloat("BW3", width3);
				editor.putFloat("BW1", width4);
				editor.putFloat("BW1", width5);
				editor.putFloat("BH1", height);
				editor.putFloat("BH1", height2);
				editor.putFloat("BH1", height3);
				editor.putFloat("BH1", height4);
				editor.putFloat("BH1", height5);
				editor.putInt("BS1", sizeW);
				editor.putInt("BS2", sizeW2);
				editor.putInt("BS3", sizeW3);
				editor.putInt("BS4", sizeW4);
				editor.putInt("BS5", sizeW5);
				editor.putInt("BDW1", desW1);
				editor.putInt("BDW2", desW2);
				editor.putInt("BDW3", desW3);
				editor.putInt("BDW4", desW4);
				editor.putInt("BDW5", desW5);
				editor.putInt("BDH1", desH1);
				editor.putInt("BDH2", desH2);
				editor.putInt("BDH3", desH3);
				editor.putInt("BDH4", desH4);
				editor.putInt("BDH5", desH5);
				editor.putFloat("ADW1", desAW1);
				editor.putFloat("ADW2", desAW2);
				editor.putFloat("ADW3", desAW3);
				editor.putFloat("ADH1", desAH1);
				editor.putFloat("ADH2", desAH2);
				editor.putFloat("ADH3", desAH3);
				// editor.putInt("Time", theTime);
				editor.putInt("Score", scorepoint);
				editor.putInt("Wallet", wallet);
				editor.putInt("TimeCounter", TimeCounter);
				editor.putBoolean("Asound1", Asound1);
				editor.putBoolean("Asound2", Asound2);
				editor.putBoolean("Asound3", Asound3);
				editor.putBoolean("Bsound1", Bsound1);
				editor.putBoolean("Bsound2", Bsound2);
				editor.putBoolean("Bsound3", Bsound3);
				editor.putBoolean("Bsound4", Bsound4);
				editor.putBoolean("Bsound5", Bsound5);
				editor.putFloat("rokW1", rokW);
				editor.putFloat("rokH1", rokH);
				editor.putFloat("rokW2", rokW2);
				editor.putFloat("rokH2", rokH2);
				editor.putInt("roksizeW1", roksizeW);
				editor.putInt("roksizeW2", roksizeW2);
				editor.putLong("startimprint", startimprint);
				editor.putLong("startimprint2", startimprint2);
				editor.putLong("startimprint3", startimprint3);
				editor.putLong("startimprint4", startimprint4);
				editor.putLong("startimprint5", startimprint5);

				editor.putBoolean("pause", paused);

				editor.commit();

				// ViewClass i ;
				// i.ViewClass(this, A1, A2, A3, B1, B2, B3, B4, B5, R1, R2,
				// AW1, AH1, AW2, AH2, AW3, AH3, BW1, BH1, BW2, BH2, BW3, BW4,
				// BW5, BH3, BH4, BH5, RW1, RH1, RW2, RH2, Time, Score, A1B,
				// A2B, A3B, B1B, B2B, B3B, B4B, B5B, R1B, R2B);

				holder.unlockCanvasAndPost(canvas); // bya3rad alcanvas
			}

		}

	}

}
