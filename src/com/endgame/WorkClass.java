package com.endgame;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;

public class WorkClass extends Activity{
/*
	boolean Asound1 , Asound2 , Asound3 , Bsound1 , Bsound2 , Bsound3 , Bsound4 , Bsound5 , Ball1 , BoxF1 , BoxB1 , roky1 , Ball2 , rok1 , rok2 , oneR1 , oneR2 , makeImprint ,
	makeImprint2 , makeImprint3 , makeImprint4 , makeImprint5 , firstTime , firstTime2 , firstTime3 , firstTime4 , firstTime5 ,  time2 , time3 , time4 , time5 , 
	firstchange , firstchange2 , firstchange3 , firstchange4 , firstchange5 , go1 , go2 , go3 , go4 , go5 , avatar1 , avatar2 , avatar3 , Awork , Awork2 , Awork3 ;
	float width, height, SpaceTop, SpaceLeft, SpaceRight, SpaceBottom , changingBallW, changingBallH, changingCanvasW, changingCanvasH , impH1, impW1 , impH2, impW2 ,
	impH3, impW3 , impH4, impW4 , impW5 , impH5 , height2 , width2 , height3, width3 , height4 , height5 , width4 , width5 , A1EX, A1FX, A2EX, A2FX , A1FY, A1EY, A2FY, A2EY , 
	A3FX, A3EX, A3FY, A3EY , markAW1, markAW2, markAH1, markAH2 , markAW3, markAH3 , avatarH1, avatarW1, avatarH2, avatarW2, avatarW3, avatarH3 , desAW1, desAH1, desAW2, desAH2,
	desAW3, desAH3 ;
	int DefBitmapWidth, DefBitmapHeight , sizeW, sizeW2 ,  sizeW4 , sizeW5 , sizeW3 , ballsTime , gameslowly , desW1, desW2, desW3, desW4, desH1, desH2, desH3, desH4 ,
	w , h ,desW5 , desH5 , chooseAsizeW, chooseAsizeW , MarkAsizeW1 , AsizeW1 , AsizeW2 , AsizeW3 , roksizeW , roksizeW2 , BallInt, BoxFInt, BoxBInt, rokyInt, Ball2Int , wallet = 3
	, pointAH, pointAH2, pointAH3, pointAW, pointAW2, pointAW3 , pointBH, pointBH2, pointBH3, pointBH4, pointBH5, pointBW, pointBW2, pointBW3, pointBW4, pointBW5 , 
	 pointRH, pointRH2, pointRW, pointRW2 , mapW , mapH , rokW , rokW2 , rokH , rokH2 ;
	
	Thread thread = null;
	boolean fball1 = true , time = true;
	int[] d = { R.drawable.ball, R.drawable.ballone, R.drawable.balltwo,
			R.drawable.ballthree };

	//int i = 0;

	Random rrr = new Random();

	Typeface font;
	String s;
	Display display = getWindowManager().getDefaultDisplay();
	float ScreenWidth = display.getWidth(); // deprecated
	float ScreenHeight = display.getHeight(); // deprecated
	private SharedPreferences preferences, pref;
	private Editor editor;
	MediaPlayer avatarSound , avatarSound2 , avatarSound3 , BallSound , BallSound2 , BallSound3 , BallSound4 , BallSound5;
	boolean paused = false;
	int scorepoint = 0;
	Bitmap A1o, A2o, A3o;
	Bitmap pause;
	Bitmap rock;
	private Bitmap Bavatar2;
	private Bitmap Bavatar;
	private Bitmap Bavatar3;
	private Bitmap CanvasBall2;
	private Bitmap mark1;
	private Bitmap mark2;
	private Bitmap mark3;
	Bitmap imprint;
	private Bitmap CanvasBall3;
	private Bitmap CanvasBall4;
	private Bitmap CanvasBall5;
	Bitmap theBall, BoxesBefore, BoxesAfter, CanvasBall, DrawBoxes;
	Bitmap hadood;
	Bitmap secondball, thirdball;
	Bitmap backavatar , firstball;
	long startimprint, stopimprint, resultimprint;
	long start2, stop2, result2;
	long start3, stop3, result3;
	long start4, stop4, result4;
	long start, stop, result;
	boolean actionWork , actionWork2 , actionWork3 , actionWork4 , actionWork5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Asound1 = Asound2 = Asound3 = Bsound1 = Bsound2 = Bsound3 = Bsound4 = Bsound5 = false;
		
		//for the game sounds the avatar & the Balls sounds 
		//avatarSound = new SoundPool(2, AudioManager.STREAM_MUSIC, 0); // video 79
		//avatarSoundInt = avatarSound.load(Space.this, R.raw.sound, 1);
		//avatarSound2 = avatarSound3 = avatarSound;
		avatarSound = MediaPlayer.create(this, R.raw.kelma);
		avatarSound2 = MediaPlayer.create(this, R.raw.kelma);
		avatarSound3 = MediaPlayer.create(this, R.raw.kelma);
		
		//BallSound = new SoundPool(2, AudioManager.STREAM_MUSIC, 0); // video 79
		//BallSoundInt = BallSound.load(Space.this, R.raw.kelma, 1);
		//BallSound2 = BallSound3 = BallSound4 = BallSound5 = BallSound;
		BallSound = MediaPlayer.create(this, R.raw.sound);
		BallSound2 = MediaPlayer.create(this, R.raw.sound);
		BallSound4 = MediaPlayer.create(this, R.raw.sound);
		BallSound5 = MediaPlayer.create(this, R.raw.sound);

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
					hadood = BitmapFactory.decodeResource(getResources(),
							R.drawable.hadood);

				
					imprint = BitmapFactory.decodeResource(getResources(),
							R.drawable.imprint);


		Ball1 = BoxF1 = BoxB1 = roky1 = Ball2 = false;

		rok1 = rok2 = true;
		oneR1 = oneR2 = true;

		BallInt = BoxBInt = BoxFInt = rokyInt = Ball2Int = 15;


		roksizeW = roksizeW = rokW = rokH = roksizeW2 = roksizeW2 = rokW2 = rokH2 = 5;

		// to make the avatar in the center of the screen
		avatarW1 = avatarW2 = avatarW3 = (ScreenWidth / 2);
		avatarH1 = avatarH2 = avatarH3 = (ScreenHeight / 2);

		chooseAsizeW = chooseAsizeW = 0;

		desAW1 = desAW2 = desAH1 = desAH2 = desW3 = desH3 = 0;

		// A1o = theBall;
		// A1o = A3o = A2o = BoxesAfter;
		Ball1 = true;
		// A3o = BoxesBefore;

		height = SpaceTop = SpaceLeft = SpaceRight = SpaceBottom = width = 0;
		height2 =  width2 = 0;
		height3 =  width3 = 0;

		height5 = width5 = 0;

		// Changing Numbers = 0
		changingBallW = changingBallH = changingCanvasW = changingCanvasH = 0;
		
		sizeW = 0;
		// sizeW = theBall.getHeight()/3;
		// DefBitmapWidth = theBall.getWidth();
		DefBitmapWidth = (int) (ScreenWidth / 5);
		// DefBitmapHeight = theBall.getHeight();
		// DefBitmapHeight = (int) (ScreenHeight/3);

		DefBitmapHeight = DefBitmapWidth;
		chooseAsizeW = DefBitmapWidth / 4;
		chooseAsizeW = DefBitmapWidth / 4;

		// AsizeW1 = AsizeW2 = AsizeW3 = backsizeW;
		AsizeW1 = AsizeW2 = AsizeW3 = AsizeW1 = AsizeW2 = AsizeW3 = (int) DefBitmapWidth;

		
		// for ball number 2 and 3
		sizeW2 = sizeW3 = sizeW4 = sizeW5 = sizeW;
		MarkAsizeW1 = (ScreenHeight / 70);
		// imprint default
		impH1 = impW1 = impH2 = impW2 = impH3 = impW4 = impH4 = impW3 = impW5 = impH5 = 0;
		// for the Time between the balls
		ballsTime = 900;

		w = (int) (ScreenWidth - DefBitmapWidth);
		h = (int) (ScreenHeight - DefBitmapHeight);

		// Changing Numbers Ball and Canvas ....
		changingBallW = (DefBitmapWidth / 30);
		// changingBallH =(DefBitmapHeight / 25);
		changingBallH = changingBallW;
		
		mapW = (int) ScreenWidth - (ScreenWidth / 4);
		mapH = (int) ScreenHeight - (ScreenHeight / 2);
		// canvas.drawBitmap(Map, mapW, mapH, null);

		pref = getSharedPreferences("Space_Data", Context.MODE_PRIVATE);

		paused = pref.getBoolean("pause", false);

		if (paused) {

			// to read
			

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
			scorepoint = pref.getInt("Score", 0);
			wallet = pref.getInt("Wallet", 3);
			Asound1 = pref.getBoolean("Asound1", Asound1);
			Asound2 = pref.getBoolean("Asound2", Asound2);
			Asound3 = pref.getBoolean("Asound3", Asound3);
			Bsound1 = pref.getBoolean("Bsound1", Bsound1);
			Bsound2 = pref.getBoolean("Bsound2", Bsound2);
			Bsound3 = pref.getBoolean("Bsound3", Bsound3);
			Bsound4 = pref.getBoolean("Bsound4", Bsound4);
			Bsound5 = pref.getBoolean("Bsound5", Bsound5);

			paused = false;
		}
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
	
	public WorkClass(boolean TouchDown , boolean TouchUp , float firstX , float firstY , float x , float y , float endX , float endY , int canvasW , int canvasH , int theTime){
		
		
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
				if (firstX >= (canvasW - chooseAsizeW)
						&& firstX <= canvasW && firstY >= 0
						&& firstY <= chooseAsizeW) {
					Intent toP = new Intent(WorkClass.this,
							ViewClass.class);
					startActivity(toP);
					paused = true;

					// theViewOfSurFace.pause();
					// resumeGame = false;

				
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
					AsizeW1 = AsizeW1;
					// for the pray mark
					markAH1 = avatarH1 - (y - firstY);
					markAW1 = avatarW1 - (x - firstX);
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
					AsizeW2 = AsizeW2;
					// for the pray mark
					markAH2 = avatarH2 - (y - firstY);
					markAW2 = avatarW2 - (x - firstX);
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
					AsizeW3 = AsizeW3;
					// for the pray mark
					markAH3 = avatarH3 - (y - firstY);
					markAW3 = avatarW3 - (x - firstX);
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
				markAH1 = avatarH1 - (y - firstY);
				markAW1 = avatarW1 - (x - firstX);
			}
			if (Awork2) {
				// for the pray mark
				markAH2 = avatarH2 - (y - firstY);
				markAW2 = avatarW2 - (x - firstX);
			}
			if (Awork3) {
				// for the pray mark
				markAH3 = avatarH3 - (y - firstY);
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
				}
				if (Awork2) {
					avatar2 = true;
					// for the distance of the avatar
					desAW2 = endX - firstX;
					desAH2 = endY - firstY;
					Awork2 = false;
					Asound2 = true;
				}
				if (Awork3) {
					avatar3 = true;
					// for the distance of the avatar
					desAW3 = endX - firstX;
					desAH3 = endY - firstY;
					Awork3 = false;
					Asound3 = true;
				}
				TouchUp = false;
			}

			// for the first avatar
			if (avatar1) {
				// for the size
				AsizeW1 -= changingBallW;
				// AsizeW1 -= changingBallH;
				AsizeW1 = AsizeW1;
				// for the height and width
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

				if (AsizeW1 > 0) {
				} else {
					avatar1 = false;
					wallet += 1;
					// Awork = false;
				}
				
				if(Asound1){
					avatarSound.start();
				   // Asound1 = false;
				}
			}else{
				avatarSound.stop();
			}
			// for the second avatar
			if (avatar2) {
				// for the size
				AsizeW2 -= changingBallW;
				// AsizeW2 -= changingBallH;
				AsizeW2 = AsizeW2;
				// for the height and width
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

				if (AsizeW2 > 0) {
				} else {
					avatar2 = false;
					wallet += 1;
					// Awork2 = false;
				}
				if(Asound2){
					avatarSound2.start();
				   // Asound2 = false;
				}
			}else{
				avatarSound2.stop();
			
			}
			// for the second avatar
			if (avatar3) {
				// for the size
				AsizeW3 -= changingBallW;
				// AsizeW3 -= changingBallH;
				AsizeW3 = AsizeW3;
				// for the height and width
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

				if (AsizeW3 > 0) {
				} else {
					avatar3 = false;
					wallet += 1;
					// Awork3 = false;
				}
				if(Asound3){
					avatarSound3.start();
				   // Asound3 = false;
				}
			}else{
				avatarSound3.stop();
			}

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

			// Insert the Valuables
			if (firstTime) {
				height = rrr.nextInt(h);// canvasH / 2;
				width = rrr.nextInt(w);// canvasW / 2;
				desW1 = (int) (((rrr.nextInt(w)) - width) / (DefBitmapWidth / changingBallW));
				desH1 = (int) (((rrr.nextInt(h)) - height) / (DefBitmapWidth / changingBallW));
				// sizeW = theBall.getWidth()/3;
				// sizeW = (int) ((canvasW/8)/20);
				// sizeW = (int) ((canvasH/8)/12);
				sizeW = 0;
				// to load the second ball
				start2 = System.currentTimeMillis();
				time2 = true;
				if (theTime <= 0)
					go1 = false;

				if (height > (canvasH - (canvasH / 4)))
					height -= (canvasH / 4);
				if (height < (canvasH / 4))
					height += (canvasH / 4);

				if (width > (canvasW - (canvasW / 4)))
					width -= (canvasW / 4);
				if (width < (canvasW / 4))
					width += (canvasW / 4);

				if(Bsound1){
					BallSound.start();
				   // Bsound1 = false;
				}
				
				firstTime = false;
			}

			// Insert the Valuables for the second ball
			if (firstTime2) {
				// default height and width for the ball
				height2 = rrr.nextInt(h);// canvasH / 2;
				width2 = rrr.nextInt(w);// canvasW / 2;
				desW2 = (int) (((rrr.nextInt(w)) - width2) / (DefBitmapWidth / changingBallW));
				desH2 = (int) (((rrr.nextInt(h)) - height2) / (DefBitmapWidth / changingBallW));
				// sizeW = theBall.getWidth()/3;
				// sizeW2 = (int) ((canvasW/8)/20);
				// sizeW2 = (int) ((canvasH/8)/12);
				sizeW2 = 0;
				// load the third ball
				start3 = System.currentTimeMillis();
				time3 = true;
				if (theTime <= 0)
					go2 = false;

				if (height2 > (canvasH - (canvasH / 4)))
					height2 -= (canvasH / 4);
				if (height2 < (canvasH / 4))
					height2 += (canvasH / 4);

				if (width2 > (canvasW - (canvasW / 4)))
					width2 -= (canvasW / 4);
				if (width2 < (canvasW / 4))
					width2 += (canvasW / 4);

				if(Bsound2){
					BallSound2.start();
				   // Bsound2 = false;
				}
				firstTime2 = false;
			}

			// Insert the Valuables for the third ball
			if (firstTime3) {
				// default height and width for the ball
				height3 = rrr.nextInt(h);// canvasH / 2;
				width3 = rrr.nextInt(w);// canvasW / 2;
				desW3 = (int) (((rrr.nextInt(w)) - width3) / (DefBitmapWidth / changingBallW));
				desH3 = (int) (((rrr.nextInt(h)) - height3) / (DefBitmapWidth / changingBallW));
				// sizeW = theBall.getWidth()/3;
				// sizeW3 = (int) ((canvasW/8)/20);
				// sizeW3 = (int) ((canvasH/8)/12);
				sizeW3 = sizeW3 = 0;
				// to start the first one again
				start4 = System.currentTimeMillis();
				time4 = true;
				if (theTime <= 0)
					go3 = false;

				if (height3 > (canvasH - (canvasH / 4)))
					height3 -= (canvasH / 4);
				if (height3 < (canvasH / 4))
					height3 += (canvasH / 4);

				if (width3 > (canvasW - (canvasW / 4)))
					width3 -= (canvasW / 4);
				if (width3 < (canvasW / 4))
					width3 += (canvasW / 4);

				if(Bsound3){
					BallSound3.start();
				   // Bsound3 = false;
				}
				firstTime3 = false;
			}

			// Insert the Valuables for the third ball
			if (firstTime4) {
				// default height and width for the ball
				height4 = rrr.nextInt(h);// canvasH / 2;
				width4 = rrr.nextInt(w);// canvasW / 2;
				desW4 = (int) (((rrr.nextInt(w)) - width4) / (DefBitmapWidth / changingBallW));
				desH4 = (int) (((rrr.nextInt(h)) - height4) / (DefBitmapWidth / changingBallW));
				// sizeW = theBall.getWidth()/3;
				// sizeW4 = (int) ((canvasW/8)/20);
				// sizeW4 = (int) ((canvasH/8)/12);
				 sizeW4 = 0;
				// to start the first one again
				start5 = System.currentTimeMillis();
				time5 = true;
				if (theTime <= 0)
					go4 = false;

				if (height4 > (canvasH - (canvasH / 4)))
					height4 -= (canvasH / 4);
				if (height4 < (canvasH / 4))
					height4 += (canvasH / 4);

				if (width4 > (canvasW - (canvasW / 4)))
					width4 -= (canvasW / 4);
				if (width4 < (canvasW / 4))
					width4 += (canvasW / 4);

				if(Bsound4){
					BallSound4.start();
				   // Bsound4 = false;
				}
				firstTime4 = false;
			}

			// Insert the Valuables for the third ball
			if (firstTime5) {
				// default height and width for the ball
				height5 = rrr.nextInt(h);// canvasH / 2;
				width5 = rrr.nextInt(w);// canvasW / 2;
				desW5 = (int) (((rrr.nextInt(w)) - width5) / (DefBitmapWidth / changingBallW));
				desH5 = (int) (((rrr.nextInt(h)) - height5) / (DefBitmapWidth / changingBallW));
				// sizeW = theBall.getWidth()/3;
				// sizeW5 = (int) ((canvasW/8)/20);
				// sizeW5 = (int) ((canvasH/8)/12);
				 sizeW5 = 0;
				// to start the first one again
				start = System.currentTimeMillis();
				time = true;
				if (theTime <= 0)
					go5 = false;

				if (height5 > (canvasH - (canvasH / 4)))
					height5 -= (canvasH / 4);
				if (height5 < (canvasH / 4))
					height5 += (canvasH / 4);

				if (width5 > (canvasW - (canvasW / 4)))
					width5 -= (canvasW / 4);
				if (width5 < (canvasW / 4))
					width5 += (canvasW / 4);
				
				if(Bsound5){
					BallSound5.start();
				   // Bsound5 = false;
				}
				firstTime5 = false;
			}

			// for the balls
			if (go1) {

				height -= desH1;// ((desH1 -
								// (canvasH/2))/30);
				width -= desW1;// ((desW1 - (canvasW/2))/30);

				// The Bitmap Size
				// sizeW += changingBallH;
				sizeW += changingBallW;

				// the place of the GOALKEEPER hand shouldn't be touched
				// at
				// the time
				// number 1
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

								// end go1
								go1 = false;

								scorepoint = scorepoint + 1;
								
								actionWork1 = true;
								imprint1 = A1o;
								/*
								if(A1o == theBall)
								imprint1 = theBall;
								if(A1o == BoxesBefore)
								imprint1 = BoxesBefore;
								if(A1o == BoxesAfter)
								imprint1 = BoxesAfter;
								if(A1o == secondball)
								imprint = secondball;
								if(A1o == rock)
								imprint = rock;
								

								// it's work but wants some changes and
								// make
								// three or four balls at the same time
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
				if(actionWork1){
					// height and width for the imprint
					makeImprint = true;
					impH1 = height;
					impW1 = width;
					startimprint = System.currentTimeMillis();
					actionWork1 = false;
				}
			}else{
				BallSound.stop();
			}

			if (go2) {

				height2 -= desH2;
				width2 -= desW2;

				// The Bitmap Size
				// sizeW2 += changingBallH;
				sizeW2 += changingBallW;
				sizeW2 = sizeW2;

				// the place of the GOALKEEPER hand shouldn't be touched
				// at
				// the time
				// this for the second ball
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
				if(actionWork2){
					// height and width for the imprint
					makeImprint2 = true;
					impH2 = height2;
					impW2 = width2;
					startimprint2 = System.currentTimeMillis();
					actionWork2 = false;
				}
			}else{
				BallSound2.stop();
			}

			if (go3) {

				height3 -= desH3;
				width3 -= desW3;

				// The Bitmap Size
				// sizeW3 += changingBallH;
				sizeW3 += changingBallW;
				sizeW3 = sizeW3;


				// the place of the GOALKEEPER hand shouldn't be touched
				// at
				// the time
				// this for the third ball
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
				if(actionWork3){
					// height and width for the imprint
					makeImprint3 = true;
					impH3 = height3;
					impW3 = width3;
					startimprint3 = System.currentTimeMillis();
					actionWork3 = false;
				}

			}else{
				BallSound3.stop();
			}

			if (go4) {

				height4 -= desH4;
				width4 -= desW4;

				// The Bitmap Size
				// sizeW4 += changingBallH;
				sizeW4 += changingBallW;


				// the place of the GOALKEEPER hand shouldn't be touched
				// at
				// the time
				// this for the fourth ball
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
				if(actionWork4){
					// height and width for the imprint
					makeImprint4 = true;
					impH4 = height4;
					impW4 = width4;
					startimprint4 = System.currentTimeMillis();
					actionWork4 = false;
				}
			}else{
				BallSound4.stop();
			}

			if (go5) {

				height5 -= desH5;
				width5 -= desW5;

				// The Bitmap Size
				// sizeW5 += changingBallH;
				sizeW5 += changingBallW;
				sizeW5 = sizeW5;


				// the place of the GOALKEEPER hand shouldn't be touched
				// at
				// the time
				// this for the fourth ball
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

								// end go4
								go5 = false;

								scorepoint = scorepoint + 1;
								actionWork5 = true;
								imprint5 = A1o;

								// it's work but wants some changes and
								// make
								// three or four balls at the same time
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

								// end go3
								go5 = false;

								scorepoint = scorepoint + 1;
								actionWork5 = true;
								imprint5 = A3o;

								// it's work but wants some changes and
								// make
								// three or four balls at the same time
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
				if(actionWork5){
					// height and width for the imprint
					makeImprint5 = true;
					impH5 = height5;
					impW5 = width5;
					startimprint5 = System.currentTimeMillis();
					actionWork5 = false;
				}
			}else{
				BallSound5.stop();
			}

			// for the first rock
			if (oneR1) {
				rokH = rrr.nextInt(h);
				// rokW = rrr.nextInt(w);
				roksizeW = rrr.nextInt(backsizeW);
				roksizeW = roksizeW;
				rokW = canvasW;
				// rokH = canvasH;
				oneR1 = false;
			}

			// for the rocks and else like fish or lava .....
			if (rok1) {
				// to make the rock move in the horizantle
				int desx = ((canvasW) / 300);
				rokW -= desx;
				// rokH -= desx;
				// for the avatar1
				if (((AsizeW1 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(AsizeW1/ScreenWidth))
																					// <=
																					// ((roksizeW/ScreenWidth)
																					// +
																					// (ScreenWidth/1000)))
						&& ((AsizeW1 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// ((2*(AsizeW1/ScreenWidth))
																						// >=
																						// ((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000)))
						&& ((A1FY >= rokH && A1FY <= (rokH + roksizeW)
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
						|| (A1FY >= rokH && A1FY <= (rokH + roksizeW)
								&& A1EX >= rokW && A1EX <= (rokW + roksizeW)))) {
					avatar1 = false;
					Awork = false;
					wallet += 1;

					rok1 = false;
				}
				// for the avatar2
				if (((AsizeW2 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(AsizeW2/ScreenWidth))
																					// <=
																					// ((roksizeW/ScreenWidth)
																					// +
																					// (ScreenWidth/1000)))
						&& ((AsizeW2 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(AsizeW2/ScreenWidth))
																						// >=
																						// ((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000)))
						&& ((A2FY >= rokH && A2FY <= (rokH + roksizeW)
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
						|| (A2FY >= rokH && A2FY <= (rokH + roksizeW)
								&& A2EX >= rokW && A2EX <= (rokW + roksizeW)))) {
					avatar2 = false;
					Awork2 = false;
					wallet += 1;

					rok1 = false;
				}
				// for the avatar3
				if (((AsizeW3 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(AsizeW3/ScreenWidth))
																					// <=
																					// (((roksizeW/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((AsizeW3 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(AsizeW3/ScreenWidth))
																						// >=
																						// (((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
						&& ((A3FY >= rokH && A3FY <= (rokH + roksizeW)
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
						|| (A3FY >= rokH && A3FY <= (rokH + roksizeW)
								&& A3EX >= rokW && A3EX <= (rokW + roksizeW)))) {
					avatar3 = false;
					Awork3 = false;
					wallet += 1;

					rok1 = false;
				}
				// for the go1
				if (((sizeW / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(sizeW/ScreenWidth))
																				// <=
																				// (((roksizeW/ScreenWidth)
																				// +
																				// (ScreenWidth/1000))))
						&& ((sizeW / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW/ScreenWidth))
																						// >=
																						// (((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok1 = false;
				}
				// for the go2
				if (((sizeW2 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(sizeW2/ScreenWidth))
																				// <=
																				// (((roksizeW/ScreenWidth)
																				// +
																				// (ScreenWidth/1000))))
						&& ((sizeW2 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW2/ScreenWidth))
																						// >=
																						// (((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok1 = false;
				}
				// for the go3
				if (((sizeW3 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(sizeW3/ScreenWidth))
																				// <=
																				// (((roksizeW/ScreenWidth)
																				// +
																				// (ScreenWidth/1000))))
						&& ((sizeW3 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW3/ScreenWidth))
																						// >=
																						// (((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok1 = false;
				}
				// for the go4
				if (((sizeW4 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(sizeW4/ScreenWidth))
																				// <=
																				// (((roksizeW/ScreenWidth)
																				// +
																				// (ScreenWidth/1000))))
						&& ((sizeW4 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW4/ScreenWidth))
																						// >=
																						// (((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok1 = false;
				}
				// for the go5
				if (((sizeW5 / ScreenWidth) <= ((roksizeW / ScreenWidth) + (1)))// ((2*(sizeW5/ScreenWidth))
																				// <=
																				// (((roksizeW/ScreenWidth)
																				// +
																				// (ScreenWidth/1000))))
						&& ((sizeW5 / ScreenWidth) >= ((roksizeW / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW5/ScreenWidth))
																						// >=
																						// (((roksizeW/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok1 = false;
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
				rokW2 = canvasW;
				// rokH2 = canvasH;

				oneR2 = false;
			}

			// for the rocks and else like fish or lava .....
			if (rok2) {// && workR2){//&& rokW <=
						// (canvasW-(canvasW/4))){

				int desx = ((canvasW) / 300);
				rokW2 -= desx;
				// rokH2 -= desx;

				// to make the rock move in the horizantle
				// int desx2 = ((canvasW)/32);
				// rokW2 -= desx2;
				// for the avatar1
				if (((AsizeW1 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(AsizeW1/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((AsizeW1 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																							// ((2*(AsizeW1/ScreenWidth))
																							// >=
																							// (((roksizeW2/ScreenWidth)
																							// -
																							// (ScreenWidth/1000))))
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

					rok2 = false;
				}
				// for the avatar2
				if (((AsizeW2 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(AsizeW2/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((AsizeW2 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																							// ((2*(AsizeW2/ScreenWidth))
																							// >=
																							// (((roksizeW2/ScreenWidth)
																							// -
																							// (ScreenWidth/1000))))
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

					rok2 = false;
				}
				// for the avatar3
				if (((AsizeW3 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(AsizeW3/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((AsizeW3 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																							// ((2*(AsizeW3/ScreenWidth))
																							// >=
																							// (((roksizeW2/ScreenWidth)
																							// -
																							// (ScreenWidth/1000))))
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

					rok2 = false;
				}
				// for the go1
				if (((sizeW / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(sizeW/ScreenWidth))
																				// <=
																				// (((roksizeW2/ScreenWidth)
																				// +
																				// (ScreenWidth/1000))))
						&& ((sizeW / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW/ScreenWidth))
																						// >=
																						// (((roksizeW2/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok2 = false;
				}
				// for the go2
				if (((sizeW2 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(sizeW2/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((sizeW2 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW2/ScreenWidth))
																						// >=
																						// (((roksizeW2/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok2 = false;
				}
				// for the go3
				if (((sizeW3 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(sizeW3/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((sizeW3 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW3/ScreenWidth))
																						// >=
																						// (((roksizeW2/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok2 = false;
				}
				// for the go4
				if (((sizeW4 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(sizeW4/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((sizeW4 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW4/ScreenWidth))
																						// >=
																						// (((roksizeW2/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok2 = false;
				}
				// for the go5
				if (((sizeW5 / ScreenWidth) <= ((roksizeW2 / ScreenWidth) + (1)))// ((2*(sizeW5/ScreenWidth))
																					// <=
																					// (((roksizeW2/ScreenWidth)
																					// +
																					// (ScreenWidth/1000))))
						&& ((sizeW5 / ScreenWidth) >= ((roksizeW2 / ScreenWidth) - (1)))// &&
																						// ((2*(sizeW5/ScreenWidth))
																						// >=
																						// (((roksizeW2/ScreenWidth)
																						// -
																						// (ScreenWidth/1000))))
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

					// rok2 = false;
				}

				if ((rokW2 + roksizeW2) <= 0) {
					rok2 = false;
				}

			} else {
				oneR2 = true;
				rok2 = true;

			}

			/*
			 * 
			 * Integer[] arr = { 12, 67, 1, 34, 9, 78, 6, 31 };
			 * Arrays.sort(arr, new Comparator<Integer>() {
			 * 
			 * @Override public int compare(Integer x, Integer y) {
			 * //for from min to max return x - y; //for max to min
			 * return y - x; } }); Paint p = new Paint();
			 * 
			 * String a = ""+arr[0]+"   "+arr[1] + "   "+arr[2] +
			 * "   "+arr[3]; canvas.drawText(a, 100, 200, p);
			 

		

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
		

		
		// to stop the game and it will be intent soon in sha2 2allah
		if (theTime <= 0) {
			if (!go1 && !go2 && !go3 && !go4 && !go5) {
				theViewOfSurFace.pause();
				paused = false;
				Intent endInt = new Intent(Space.this , EndPlay.class);
				//endInt.putExtra("score", scorepoint);
				startActivity(endInt);
			}
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
			finish();
			paused = false;
		}		
		
		
		if(paused){
			if(Asound1){
				avatarSound.pause();
				Asound1 = false;
			}
			if(Asound2){
				avatarSound2.pause();
				Asound2 = false;
			}
			if(Asound3){
				avatarSound3.pause();
				Asound3 = false;
			}
			if(Bsound1){
				BallSound.pause();
				Bsound1 = false;
			}
			if(Bsound2){
				BallSound2.pause();
				Bsound2 = false;
			}
			if(Bsound3){
				BallSound3.pause();
				Bsound3 = false;
			}
			if(Bsound4){
				BallSound4.pause();
				Bsound4 = false;
			}
			if(Bsound5){
				BallSound5.pause();
				Bsound5 = false;
		}
		}
		

		// to write
		/*
		 * SharedPreferences preferences =
		 * getSharedPreferences("AUTHENTICATION_FILE_NAME",
		 * Context.MODE_WORLD_WRITEABLE); SharedPreferences.Editor
		 * editor = preferences.edit();
		 * editor.putString("Authentication_Id"
		 * ,userid.getText().toString());
		 * editor.putString("Authentication_Password"
		 * ,password.getText().toString());
		 * editor.putString("Authentication_Status","true");
		 * editor.commit();
		 */
		// to read
		/*
		 * SharedPreferences prfs =
		 * getSharedPreferences("AUTHENTICATION_FILE_NAME",
		 * Context.MODE_PRIVATE); String Astatus =
		 * prfs.getString("Authentication_Status", "");
		 

		// canvas.drawBitmap(d, 0, 0, 0, 0, chooseAsizeW, chooseAsizeW,
		// true, null);
		
		preferences = getSharedPreferences("Space_Data",
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


		editor.putBoolean("pause", paused);

		editor.commit();

		
	}
}
*/
}
