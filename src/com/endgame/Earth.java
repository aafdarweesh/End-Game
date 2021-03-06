package com.endgame;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Canvas.VertexMode;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Earth extends Activity implements OnTouchListener{
	//this class for the goal keeper so he must save his goal from any attack by the ball
	//this class may help for another game that (save yourself from any attack)
	
	//until now it is not work the problem in the touch method or in if conditionals of it
	//lazam 2a3mal 7asab 2eza kan 2alkora 2abl 2altanya wala ba3deha fe canvas ta7t 5als
	
	//3ala 2al2akal 5 2aw 6 kowar
	//2al kora 2altanya mash sha3'ala w 2alimprint bardoo

	ForGrafexSurFace theViewOfSurFace;
	Bitmap map;
	float x,y;
	float endX,endY;
	float firstX,firstY;
	boolean TouchDown = false;
	boolean TouchUp = false;
	boolean openTouchDown = false;
	 Button Ball , BoxF , BoxB;
	 boolean Ball1 , BoxF1 , BoxB1 , roky1 , Ball2;
	 int[] destroy = {R.drawable.ball , R.drawable.ballone , R.drawable.balltwo , R.drawable.ballthree , R.drawable.backavatar , R.drawable.boxbefore , R.drawable.boxafter};


	
	int scorepoint = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		theViewOfSurFace = new ForGrafexSurFace(this);
		theViewOfSurFace.setOnTouchListener(this);

		map = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		
		// from here
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
						WindowManager.LayoutParams.FLAG_FULLSCREEN);
				// to here full Screen Code

				firstX = firstY = endX = endY =0;

		x = y =  10;
		setContentView(theViewOfSurFace);
		
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


	public class ForGrafexSurFace extends SurfaceView implements Runnable {

		SurfaceHolder holder;
		Thread thread = null;
		boolean running = false;
		
		Bitmap theBall, BoxesBefore , BoxesAfter, CanvasBall , DrawBoxes;
		float width, height, DefBitmapWidth, DefBitmapHeight, SpaceTop,
				SpaceLeft, SpaceRight, SpaceBottom;
		float changingBallW, changingBallH, changingCanvasW, changingCanvasH;
		float touchX,touchY;
		float changH,changW;
		boolean firstComPlay = false;
		int sizeW, sizeH;
		float counteSpaceL = 0;
		float counteSpaceT = 0;
		float avatarX , avatarY;
		//for the imprint in the screen
		boolean makeImprint = false;
		long startimprint, stopimprint , resultimprint;
		float impH1,impW1;
		//for the second one 
		boolean makeImprint2 = false;
		long startimprint2, stopimprint2 , resultimprint2;
		float impH2,impW2;
		//for the third one 
		boolean makeImprint3 = false;
		long startimprint3, stopimprint3 , resultimprint3;
		float impH3,impW3;
		//for the fourth
		boolean makeImprint4 = false;
		long startimprint4, stopimprint4 , resultimprint4;
		float impH4,impW4;
		boolean screenNumber = true;
		float touchHandx , touchHandy;
		boolean negativeW = false;
		boolean negativeH = false;
		boolean SizeisBig = false;
		boolean isTouched = false;
		boolean CanvasisBig = false;
		boolean firstTime = false;
		boolean one , two;
		boolean firstchange = false;
		//for second ball and the third
		long start2 , stop2 , result2;
		long start3 , stop3 , result3;
		long start4 , stop4 , result4;

		//the game time 
		long gameTime;
		long endTime = 0;
		long resultTime;
		boolean negativeW2 = false;
		boolean negativeH2 = false;
		boolean negativeW3 = false;
		boolean negativeH3 = false;
		boolean SizeisBig2 = false;
		boolean SizeisBig3 = false;
		boolean firstTime2 = false;
		boolean firstTime3 = false;
		boolean firstchange2 = false;
		boolean firstchange3 = false;
		boolean go2 = false;
		boolean go3 = false;
		boolean go1 = false;
		boolean negativeW4 = false;
		boolean negativeH4 = false;
		boolean SizeisBig4 = false;
		boolean firstTime4 = false;
		boolean firstchange4 = false;
		boolean go4 = false;
		int ballsTime = 0;
		int gameslowly = 5;
		boolean time2 = false;
		boolean time4 = false;
		boolean time3 = false;
		boolean time = true;
		boolean fball1 = true;
		int theTime = 60000;
		boolean reset = false;
		long start , stop , result;
		Bitmap hadood ;
		Bitmap secondball, thirdball;
		Bitmap backavatar;
		float backAW , backAH;
		int backsizeH , backsizeW;
		Bitmap firstball;
		boolean eat1;
		boolean eat2;
		boolean eat3;
		boolean test = false;
		boolean eat4;
		float eat1W , eat1H , eat2W , eat2H , eat3W , eat3H , eat4W , eat4H;

		float SpaceTop2 ,SpaceLeft2 , SpaceBottom2, SpaceRight2 , height2 , width2;
		int sizeW2 , sizeH2;
		float SpaceTop3 ,SpaceLeft3 , SpaceBottom3, SpaceRight3 , height3 , width3;
		int sizeW3 , sizeH3;
		float SpaceTop4 ,SpaceLeft4 , SpaceBottom4, SpaceRight4 , height4 , width4;
		int sizeW4 , sizeH4;
		
		int desW1 , desW2 , desW3 , desW4 , desH1, desH2 , desH3 , desH4;
		
		boolean avatar1 = false;
		boolean avatar2 = false;
		boolean avatar3 = false;
		
		float A1EX , A1FX , A2EX , A2FX ;
		float A1FY , A1EY ,  A2FY , A2EY ;
		float A3FX , A3EX , A3FY , A3EY;
		boolean Awork = false;
		boolean Awork2 = false;
		boolean Awork3 = false;
		boolean play1 = true;
		boolean play2 = false;

		
		float markAW1 , markAW2 , markAH1 , markAH2 , MarkAsizeW1 , MarkAsizeH1 , MarkAsizeW2 , MarkAsizeH2 ;
		float markAW3 , markAH3 , MarkAsizeW3 , MarkAsizeH3;
		
		int w=0;
		int h=0;
		
		int i =0;
		
		Random rrr = new Random();
		
		Typeface font;
		String s;
		Display display = getWindowManager().getDefaultDisplay();
		float ScreenWidth = display.getWidth(); // deprecated
		float ScreenHeight = display.getHeight(); // deprecated
		Bitmap avatar;
		float avatarH1 , avatarW1 ,avatarH2 , avatarW2 , avatarW3 , avatarH3;
		float desAW1 , desAH1 , desAW2 , desAH2 , desAW3 , desAH3;
		int AsizeW1 , AsizeH1 , AsizeW2 , AsizeH2 , AsizeW3 , AsizeH3;
		long Astart1 , Astop1 , Aresult1 , Astart2 , Astop2 , Aresult2;
		boolean firstTime5 = false;
		 int height5 = 0;
		 int width5 = 0;
		 int desW5 = 0;
		 int desH5 = 0;
		 int sizeW5 = 0;
		 int sizeH5 = 0;
		 long start5 = 0 ;
		 boolean time5 =false;
		 float impW5;
		 float impH5;
		 long startimprint5 = 0;
		 boolean makeImprint5 = false;
		 boolean go5 = false;
		private long stopimprint5 = 0;
		private long resultimprint5 = 0;
		private boolean SizeisBig5 = false;
		private long stop5;
		private long result5;
		private boolean firstchange5;
		boolean onlyone = true;
		boolean AVtime1 , AVtime2 , AVtime3;
		
		long AVstart , AVstop , AVresult , AVstart2 , AVstop2 , AVresult2 , AVstart3 , AVstop3 , AVresult3;
		 boolean timeAV1 = true;
		 boolean A1 , A2 , A3;
		 

		 int chooseAsizeW , chooseAsizeH ; 
		 Bitmap A1o , A2o ,A3o;
		 Bitmap pause;
		 Bitmap rock;
		 int roksizeW , roksizeH , rokW , rokH , roksizeW2 , roksizeH2 , rokW2 , rokH2;
		 boolean rok1 , rok2;
		 boolean oneR1 , oneR2;
		 boolean pauseResume;
		 
		 int BallInt , BoxFInt , BoxBInt , rokyInt , Ball2Int;
		 Bitmap all , anything;
		 int wallet = 3;
		 int rotation = 0;
		 boolean workR2 = false;
		 int pointAH , pointAH2 , pointAH3 , pointAW , pointAW2 , pointAW3 ;
		 int pointBH , pointBH2 , pointBH3 , pointBH4 , pointBH5 , pointBW , pointBW2 , pointBW3 , pointBW4 , pointBW5 ;
		 int pointRH , pointRH2 , pointRW , pointRW2 ;
		 int actionInt = 0;
		 boolean action1 , action2 , action3 , action4 , action5;
		 float AcW1 , AcW2 , AcW3 , AcW4 , AcW5 , AcH1 , AcH2 , AcH3 , AcH4, AcH5;
		 int AcSize1 , AcSize2 , AcSize3 , AcSize4 , AcSize5;
		 long Acstart1 , Acstart2 , Acstart3 , Acstart4 , Acstart5 ;



		public ForGrafexSurFace(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			holder = getHolder();
			
			Ball1 = BoxF1 = BoxB1 = roky1 = Ball2 = false;
			pauseResume = true;
			
			rok1 = rok2 = true;
			oneR1 = oneR2 = true;
			
			BallInt = BoxBInt = BoxFInt = rokyInt = Ball2Int = 15;
			
			AcW1 = AcW2= AcW3 = AcW4 = AcW5 = AcH1 = AcH2 = AcH3 = AcH4= AcH5 =0;


		 roksizeW = roksizeH = rokW = rokH = roksizeW2 = roksizeH2 = rokW2 = rokH2 = 5;
		 

			
			//to make the avatar in the center of the screen 
			avatarW1 = avatarW2 = avatarW3 =(ScreenWidth/2);
			avatarH1 = avatarH2 = avatarH3 = (ScreenHeight/2);
			
			 chooseAsizeW = chooseAsizeH = 0 ; 
			
			desAW1 = desAW2 = desAH1 = desAH2  = desW3 = desH3 = 0;
			 AVstart = AVstop = AVresult = AVstart2 = AVstop2 = AVresult2 = AVstart3 = AVstop3 = AVresult3 =0;
			 
		   AVtime1 = AVtime2 = AVtime3 = false;
		   A1 = A2 = A3 = false;

			//The Ball from resources
			theBall = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball);
			
			//for drawing some rocks in the space or in the sea or in lava planet
			rock = BitmapFactory.decodeResource(getResources(), R.drawable.rok);
			
			//The Ball from resources
			firstball = BitmapFactory.decodeResource(getResources(),
					R.drawable.ballone);
			
			//The Ball from resources
			backavatar = BitmapFactory.decodeResource(getResources(),
					R.drawable.backavatar);
			
			//The Ball from resources
			secondball = BitmapFactory.decodeResource(getResources(),
					R.drawable.balltwo);
			
			//The Ball from resources
			thirdball = BitmapFactory.decodeResource(getResources(),
					R.drawable.ballthree);

			//The Box Before from resources
			BoxesBefore = BitmapFactory.decodeResource(getResources(),
					R.drawable.boxbefore);
			//The Box After from resources
			BoxesAfter = BitmapFactory.decodeResource(getResources(),
					R.drawable.boxafter);
			
			//llhodood
			hadood = BitmapFactory.decodeResource(getResources(),
					R.drawable.hadood);
			
			anything = BitmapFactory.decodeResource(getResources(),R.drawable.firstm);
			
			
			// A1o =  theBall;
			// A1o = A3o = A2o = BoxesAfter;
			Ball1 = true;
			// A3o = BoxesBefore;

			
			
			height = SpaceTop = SpaceLeft = SpaceRight = SpaceBottom = width = 0;
			height2 = SpaceTop2 = SpaceLeft2 = SpaceRight2 = SpaceBottom2 = width2 = 0;
			height3 = SpaceTop3 = SpaceLeft3 = SpaceRight3 = SpaceBottom3 = width3 = 0;
			
			height5 = width5 = 0;

			// Changing Numbers = 0
			changingBallW = changingBallH = changingCanvasW = changingCanvasH = 0;
            //for the touch avatar
			touchHandx = x+25;
			touchHandy = y+25;
			
			// Boxes boolean
			one =two =  true;
			//The touch float
			
			//avatar 
			backsizeW = (int) (ScreenWidth/5);
			backsizeH = (int) ((ScreenHeight/1)/3);
			
			AsizeW1 = AsizeW2 = AsizeW3 = backsizeW;
			AsizeH1 = AsizeH2 = AsizeH3 = backsizeH = AsizeW1 = AsizeW2 = AsizeW3 = backsizeW;
			
			chooseAsizeW = backsizeW/4 ;
			chooseAsizeH = backsizeH/4 ;
			
			//for the eating the balls
			eat1W = eat1H = eat2W = eat2H = eat3W = eat3H = eat4W = eat4H =0;
			
			//sizeW = theBall.getWidth()/3;
			sizeW = (int) ((ScreenWidth/8)/20);
			sizeH = (int) ((ScreenHeight/8)/12);
			
			sizeH = sizeW;
			
			
			//sizeH = theBall.getHeight()/3;
			//DefBitmapWidth = theBall.getWidth();
			DefBitmapWidth =  (int) (ScreenWidth/5);
			//DefBitmapHeight = theBall.getHeight();
			//DefBitmapHeight = (int) (ScreenHeight/3);
			
			DefBitmapHeight = DefBitmapWidth;
			
			
			//For changes in width and height
			changH = changW = 0;
			//for the game time
			gameTime = 0;
			//for ball number 2 and 3
			sizeW2 = sizeW3 =sizeW4 = sizeW5 =  sizeW;
			 MarkAsizeW1 = MarkAsizeW2 = MarkAsizeW3 = (ScreenWidth/100);
			sizeH2 = sizeH3 =sizeH4= sizeH5 =  sizeH;
			MarkAsizeH1 = MarkAsizeH2 = MarkAsizeH3 = (ScreenHeight/70);
			//Touched
			touchX = touchY = 0;
			//avatr floats 
			avatarX = avatarY = 0;
			//imprint default 
			impH1 = impW1 = impH2 = impW2 = impH3 = impW4 = impH4 = impW3 = impW5 = impH5 = 0;
			//for the Time between the balls
			ballsTime = 900;
			
			
			w =  (int) ( ScreenWidth - DefBitmapWidth);
			h = (int) ( ScreenHeight - DefBitmapHeight);
			
		}
			

		public void pause() {
			running = false;

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
			running = true;

			thread = new Thread(this);
			thread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			gameTime = System.currentTimeMillis();

			while (running) {
				if (!holder.getSurface().isValid()) // (!) ma3naha not
					continue; // ma3naha 5aleek fe if l3'ayat lma tb2a if false

				Canvas canvas = holder.lockCanvas(); // ma3naha private
				canvas.drawColor(Color.WHITE);//momkan ta3'ayaroo 3lshan yab2a 2albackground
				
				//to calculate the game Time
				endTime=System.currentTimeMillis();
				resultTime = endTime - gameTime;
				
				
				
				if(TouchDown){
					if((firstX >= 0 && firstX <= chooseAsizeW && firstY >= (2*chooseAsizeH) && firstY <= (3*chooseAsizeH)) && BallInt > 0){
						Ball1 = true;
						BoxF1 = false;
						BoxB1 = false;
						roky1 = false;
						Ball2 = false;
						
						//A1o = A2o = A3o = theBall;

					}
					if((firstX >= 0 && firstX <= chooseAsizeW && firstY >= (3*chooseAsizeH) && firstY <= (4*chooseAsizeH)) && BoxFInt > 0){
						Ball1 = false;
						BoxF1 = true;
						BoxB1 = false;
						roky1 = false;
						Ball2 = false;
						
						//A1o = A2o = A3o = BoxesAfter;

					}
					if((firstX >= 0 && firstX <= chooseAsizeW && firstY >= (4*chooseAsizeH) && firstY <= (5*chooseAsizeH)) && BoxBInt > 0){
						Ball1 = false;
						BoxF1 = false;
						BoxB1 = true;
						roky1 = false;
						Ball2 = false;
						
						//A1o = A2o = A3o = BoxesBefore;

						}
					if((firstX >= 0 && firstX <= chooseAsizeW && firstY >= (5*chooseAsizeH) && firstY <= (6*chooseAsizeH)) && BoxBInt > 0){
						Ball1 = false;
						BoxF1 = false;
						BoxB1 = false;
						roky1 = true;
						Ball2 = false;
						
						//A1o = A2o = A3o = BoxesBefore;

						}
					if((firstX >= 0 && firstX <= chooseAsizeW && firstY >= (6*chooseAsizeH) && firstY <= (7*chooseAsizeH)) && BoxBInt > 0){
						Ball1 = false;
						BoxF1 = false;
						BoxB1 = false;
						roky1 = false;
						Ball2 = true;
						
						//A1o = A2o = A3o = BoxesBefore;

						}
					
					//pause the game 
					if(firstX >= (canvas.getWidth()-chooseAsizeW) && firstX <= canvas.getWidth() && firstY >= 0 && firstY <= chooseAsizeH){
						if(pauseResume){
							theViewOfSurFace.resume();
						}else{
							theViewOfSurFace.pause();
						}
					}
					
						
				}
				
				
				
				
				//if the avatar finished what will happenned here
				if(BallInt == 0){
					BoxF1 = true;
				}
				if(BoxFInt == 0){
					BoxB1 = true;
				}
				if(BoxBInt == 0){
					roky1 = true;
				}
				if(rokyInt == 0){
					Ball2 = true;
				}
				if(Ball2Int == 0){
					Ball1 = true;
				}
				if(BallInt == 0 && BoxFInt == 0 && BoxBInt == 0 && rokyInt == 0 && Ball2Int == 0 && !avatar1 && !avatar2 && !avatar3){
					theViewOfSurFace.pause();
				}
				
				
				
				
				// Changing Numbers Ball and Canvas ....				
				changingBallW =(DefBitmapWidth / 25);
				//changingBallH =(DefBitmapHeight / 25);
				changingBallH = changingBallW;
				
				
				/*
				changingCanvasW =(canvas.getWidth() / 60);
				changingCanvasH = (canvas.getHeight() / 60);
				*/
				//change height and width
				//changW = theBall.getWidth()/4;
				//changH = theBall.getHeight()/4;
	
				
				
				//to make the ball slower
				try {
					Thread.sleep(gameslowly);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				if(TouchDown && firstX > chooseAsizeW && wallet > 0){
					
					
					if(!avatar1 && !avatar2 && !avatar3 && !Awork && !Awork2 && !Awork3){
						wallet = 3;
					}
					
					
					
			//	if(TouchDown && firstX > chooseAsizeW){
					if((!avatar1 && !Awork)//&& A1)//|| (!avatar2 && !avatar3))//&& !Awork) //&& A1)  
							//|| (avatar1 && avatar3 && TouchDown)
							){
					avatarW1 = firstX;
					avatarH1 = firstY;
					AsizeW1 = backsizeW;
					AsizeH1 = backsizeH;
					//for the pray mark
					markAH1 = avatarH1 - (y - firstY);
					markAW1 = avatarW1 - (x - firstX);
					Awork = true;
					wallet-=1;

					
					A2 = true;
					A1 = false;
					
					
					if(Ball1 && BallInt > 0){
						A1o = theBall;
						BallInt -=1;
					}
					if(BoxF1 && BoxFInt > 0){
						A1o = BoxesAfter;
						BoxFInt -=1;
					}
					if(BoxB1 && BoxBInt > 0){
						A1o = BoxesBefore;
						BoxBInt -=1;
					}
					if(Ball2 && Ball2Int > 0){
						A1o = secondball;
						Ball2Int -=1;
					}
					if(roky1 && rokyInt > 0){
						A1o = rock;
						rokyInt -=1;
					}
										
					
				//	play1 = false;
					
				}
				
					if((!avatar2 && avatar1 && !Awork2))//||(avatar1 && avatar3))//&& A2)//&& !Awork2 )//&& A2)
						{
							avatarW2 = firstX;
							avatarH2 = firstY;
							AsizeW2 = backsizeW;
							AsizeH2 = backsizeH;
							//for the pray mark
							markAH2 = avatarH2 - (y - firstY);
							markAW2 = avatarW2 - (x - firstX);
							Awork2 = true;
							
							A3 = true;
							A2 = false;
							wallet-=1;

							
						
							
							if(Ball1 && BallInt > 0){
								 A2o = theBall;
								 BallInt -=1;
							}
							if(BoxF1 && BoxFInt > 0){
								A2o =BoxesAfter;
								BoxFInt -=1;
							}
							if(BoxB1 && BoxBInt > 0){
								 A2o = BoxesBefore;
								 BoxBInt -=1;
							}
							if(Ball2 && Ball2Int > 0){
								A2o = secondball;
								Ball2Int -=1;
							}
							if(roky1 && rokyInt > 0){
								A2o = rock;
								rokyInt -=1;
							}
						
					}
					
					if((!avatar3 && avatar1 && avatar2 && !Awork && !Awork2 && !Awork3))//||(avatar1 && avatar2))//&& A3)//&& !Awork3 )// && A3)
						{
						avatarW3 = firstX;
						avatarH3 = firstY;
						AsizeW3 = backsizeW;
						AsizeH3 = backsizeH;
						//for the pray mark
						markAH3 = avatarH3 - (y - firstY);
						markAW3 = avatarW3 - (x - firstX);
						Awork3 = true;
						
						A1 = true;
						A3 = false;
						
						wallet-=1;

						
						if(Ball1 && BallInt > 0){
							A3o = theBall;
							//BallInt -=1;
						}
						if(BoxF1 && BoxFInt > 0){
							A3o = BoxesAfter;
							//BoxFInt -=1;
						}
						if(BoxB1 && BoxBInt > 0){
							A3o = BoxesBefore;
							BoxBInt -=1;
						}
						if(Ball2 && Ball2Int > 0){
							A3o = secondball;
							Ball2Int -=1;
						}
						if(roky1 && rokyInt > 0){
							A3o = rock;
							rokyInt -=1;
						}
												
					}
				
				}

				
				if(Awork){
					//for the pray mark
					markAH1 = avatarH1 - (y - firstY);
					markAW1 = avatarW1 - (x - firstX);
					
				}
				
				if(Awork2){
					//for the pray mark
					markAH2 = avatarH2 - (y - firstY);
					markAW2 = avatarW2 - (x - firstX);
				
				}
				
				if(Awork3){
					//for the pray mark
					markAH3 = avatarH3 - (y - firstY);
					markAW3 = avatarW3 - (x - firstX);
					
				}
				
				if(TouchUp){
					TouchDown = false;
					if(Awork) {
					avatar1 = true;
					//for the distance of the avatar 
					desAW1 = endX - firstX;
					desAH1 = endY - firstY;
					Awork = false;
					}
					if(Awork2) {
						avatar2 = true;
						//for the distance of the avatar 
						desAW2 = endX - firstX;
						desAH2 = endY - firstY;
						Awork2 = false;
					}
					if(Awork3) {
						avatar3 = true;
						//for the distance of the avatar 
						desAW3 = endX - firstX;
						desAH3 = endY - firstY;
						Awork3 = false;
					}	
					TouchUp = false;
				}
				
				//for the first avatar
				if(avatar1){
					//for the size
					AsizeW1 -= changingBallW;
					AsizeH1 -= changingBallH;
					//for the height and width
					avatarW1 -= (desAW1 /30);
					avatarH1 -= (desAH1 /20);
					//for the pray mark
					markAH1 = avatarH1 - (y - firstY);
					markAW1 = avatarW1 - (x - firstX);
					//for the top left right bottom
					A1FY = avatarH1 - (AsizeH1/2);
					A1EY = avatarH1 + (AsizeH1/2);
					A1FX = avatarW1 - (AsizeW1/2);
					A1EX = avatarW1 + (AsizeW1/2);
					Awork = false;
					
					A1 = false;
					
					AVstart2 = System.currentTimeMillis();
				}
				
				//for the second avatar
				if(avatar2){
					//for the size
					AsizeW2 -= changingBallW;
					AsizeH2 -= changingBallH;
					//for the height and width
					avatarW2 -= (desAW2 /30);
					avatarH2 -= (desAH2 /20);
					//for the pray mark
					markAH2 = avatarH2 - (y - firstY);
					markAW2 = avatarW2 - (x - firstX);
					//for the top left right bottom
					A2FY = avatarH2 - (AsizeH2/2);
					A2EY = avatarH2 + (AsizeH2/2);
					A2FX = avatarW2 - (AsizeW2/2);
					A2EX = avatarW2 + (AsizeW2/2);
					Awork2 = false;
					
					A2 = false;
					
					AVstart3 = System.currentTimeMillis();
				}
				
				//for the second avatar
				if(avatar3){
					//for the size
					AsizeW3 -= changingBallW;
					AsizeH3 -= changingBallH;
					//for the height and width
					avatarW3 -= (desAW3 /30);
					avatarH3 -= (desAH3 /20);
					//for the pray mark
					markAH3 = avatarH3 - (y - firstY);
					markAW3 = avatarW3 - (x - firstX);
					//for the top left right bottom
					A3FY = avatarH3 - (AsizeH3/2);
					A3EY = avatarH3 + (AsizeH3/2);
					A3FX = avatarW3 - (AsizeW3/2);
					A3EX = avatarW3 + (AsizeW3/2);
					Awork3 = false;
					
					A3 = false;
					
					AVstart = System.currentTimeMillis();
				}
				
				
				
				
				
				if(fball1){
					start = System.currentTimeMillis();
					fball1 = false;
				}
				
				//start the first ball again
				if(time){
					stop = System.currentTimeMillis();
					result = stop- start;
					
					if(result >= (3*ballsTime)){
						//start again
						firstTime = true;
						//for the firstChange
						firstchange = true;
						go1 = true;
						
						time = false;
					}
				}
				//start the second ball time
				if(time2){
					stop2 = System.currentTimeMillis();
					result2 = stop2-start2;
					
				if(result2 >= ballsTime){
				firstTime2 = true;
				firstchange2 = true;
				go2 = true;
				time2 = false;
				}}
				
				//for start the third ball
				if(time3){
					stop3 = System.currentTimeMillis();
					result3 = stop3-start3;

				if(result3 >= ballsTime){
				firstTime3 = true;
				firstchange3 = true;
				go3 = true;
				time3 = false;
				}}
				
				//for start the fourth ball
				if(time4){
					stop4 = System.currentTimeMillis();
					result4 = stop4-start4;

				if(result4 >= ballsTime){
				firstTime4 = true;
				firstchange4 = true;
				go4 = true;
				time4 = false;
				}}
				
				//for start the fourth ball
				if(time5){
					stop5 = System.currentTimeMillis();
					result5 = stop5-start5;

				if(result5 >= ballsTime){
				firstTime5 = true;
				firstchange5 = true;
				go5 = true;
				time5 = false;
				}}
				
				
				// Insert the Valuables
				if (firstTime) {	
					
					height = canvas.getHeight()/2;
					width = canvas.getWidth()/2;
					
					int desW11 =  rrr.nextInt(w);
					int desH11 =  rrr.nextInt(h);
					
					desW1 = desW11 ; 
					desH1 = desH11;
					
					//sizeW = theBall.getWidth()/3;
					sizeW = (int) ((canvas.getWidth()/8)/20);
					//sizeH = (int) ((canvas.getHeight()/8)/12);
					
					sizeH = sizeW;
					
					//to load the second ball
					start2 = System.currentTimeMillis();
					time2 = true;
					
					if(theTime <= 0) go1 = false;
					
					firstTime = false;
				}
				
				//Insert the Valuables for the second ball
				if (firstTime2) {	
					
					//default height and width for the ball
					height2 = canvas.getHeight()/2;
					width2 = canvas.getWidth()/2;
					
					
					int desW22 = (int) (((rrr.nextInt(w)) - width)/30);
					int desH22 = (int) (((rrr.nextInt(h)) - height)/30);
					
					desW2 = desW22;
					desH2 = desH22;
					
					
					//sizeW = theBall.getWidth()/3;
					sizeW2 = (int) ((canvas.getWidth()/8)/20);
					//sizeH2 = (int) ((canvas.getHeight()/8)/12);
					
					sizeH2 = sizeW2;
					
					//load the third ball
					start3 = System.currentTimeMillis();
					time3 = true;
					
					if(theTime <= 0) go2 = false;
					
					firstTime2 = false;
				}
				
				//Insert the Valuables for the third ball
				if (firstTime3) {	
					
					//default height and width for the ball
					height3 = canvas.getHeight()/2;
					width3 = canvas.getWidth()/2;
					
					
					int desW33 = (int) (((rrr.nextInt(w)) - width)/30);
					int desH33 = (int) (((rrr.nextInt(h)) - height)/30);
					
					desW3 = desW33 ; 
					desH3 = desH33;
					
					//sizeW = theBall.getWidth()/3;
					sizeW3 = (int) ((canvas.getWidth()/8)/20);
					//sizeH3 = (int) ((canvas.getHeight()/8)/12);
					
					sizeH3 = sizeW3;
					
					//to start the first one again
					start4 = System.currentTimeMillis();
					time4 = true;
					
					if(theTime <= 0) go3 = false;
					
					firstTime3 = false;
				}
				
				//Insert the Valuables for the third ball
				if (firstTime4) {	
					
					//default height and width for the ball
					height4 = canvas.getHeight()/2;
					width4 = canvas.getWidth()/2;
					
					
					int desW44 = (int) (((rrr.nextInt(w)) - width)/30);
					int desH44 = (int) (((rrr.nextInt(h)) - height)/30);
					
					desW4 = desW44;
					desH4 = desH44;
					
					//sizeW = theBall.getWidth()/3;
					sizeW4 = (int) ((canvas.getWidth()/8)/20);
					//sizeH4 = (int) ((canvas.getHeight()/8)/12);
					
					sizeH4 = sizeW4;
					
					//to start the first one again
					start5 = System.currentTimeMillis();
					time5 = true;
					
					if(theTime <= 0) go4 = false;
					
					firstTime4 = false;
				}
				
				//Insert the Valuables for the third ball
				if (firstTime5) {	
					
					//default height and width for the ball
					height5 = canvas.getHeight()/2;
					width5 = canvas.getWidth()/2;
					
					int desW33 = (int) (((rrr.nextInt(w)) - width)/30);
					int desH33 = (int) (((rrr.nextInt(h)) - height)/30);
					
					
					
					desW5 = desW33;
					desH5 = desH33;
					
					
					//sizeW = theBall.getWidth()/3;
					sizeW5 = (int) ((canvas.getWidth()/8)/20);
					//sizeH5 = (int) ((canvas.getHeight()/8)/12);
					
					sizeH5 = sizeW5;
					//to start the first one again
					start = System.currentTimeMillis();
					time = true;
					
					if(theTime <= 0) go5 = false;
					
					firstTime5 = false;
				}
				
				
				//the ball center 
				float ballcenterH = ((height+(height+sizeH))/2);
				float ballcenterW = ((width+(width+sizeW))/2);
				//the avatar center 
				float avatarcenterH = (y-25);
				float avatarcenterW = (x-25);
				
				if(go1){
				//the place of the GOALKEEPER hand shouldn't be touched at the time 
				//number 1
					if(avatar1 || avatar2 || avatar3){
				if(avatar1){
				if(((AsizeW1/ScreenWidth) <= ((sizeW/ScreenWidth) + (1)))// ((sizeW/ScreenWidth) + (ScreenWidth/1000)))
						&& ((AsizeW1/ScreenWidth) >= ((sizeW/ScreenWidth) - (1)))// ((sizeW/ScreenWidth) - (ScreenWidth/1000)))
						){
					if(
							//left top small
							(A1FY >= height && A1FY <= (height+sizeH) && A1FX >= width && A1FX <= (width+sizeW))
							//right bottom small
							|| (A1EY >= height && A1EY <= (height+sizeH) && A1EX >= width && A1EX <= (width+sizeW))
							//left bottom small
							|| (A1EY >= height && A1EY <= (height+sizeH) && A1FX >= width && A1FX <= (width+sizeW))
							//right top small
							|| (A1FY >= height && A1FY <= (height+sizeH) && A1EX >= width && A1EX <= (width+sizeW))
							
							){
						
						actionInt = 1;
						Acstart1 = System.currentTimeMillis();

						avatar1 = false;
						Awork = false;
						wallet+=1;
						
						Bitmap m = Bitmap.createScaledBitmap(anything, sizeW, sizeH, true);
						canvas.drawBitmap(m, width, height, null);
						
				//for destroy
						/*
						if(A1o == theBall){
						//	Bitmap mp = Bitmap.createBitmap(destroyy, (sizeW*sizeH), sizeW, sizeH, AsizeH1, null);
							//canvas.drawBitmap(destroy, 0, 0, width, height , sizeW, sizeH, false,null);
						//	canvas.drawBitmap(all,width,height,null);
							scorepoint = scorepoint +10;
						}else if(A1o == BoxesAfter){
							scorepoint = scorepoint +8;
							//canvas.drawBitmap(destroy, 3, 0, 1, height, sizeW, sizeH, true, null);
						}else if(A1o == BoxesBefore){
							scorepoint = scorepoint +7;
							//canvas.drawBitmap(destroy, 3, 0, 1, height, sizeW, sizeH, true, null);
						}else if(A1o == rock){
							scorepoint = scorepoint +5;
							//canvas.drawBitmap(destroy, 3, 0, 1, height, sizeW, sizeH, true, null);
						}else if(A1o == secondball){
							scorepoint = scorepoint +9;
							//canvas.drawBitmap(destroy, 3, 0, 1, height, sizeW, sizeH, true, null);
						}
						*/
						
						//canvas.drawBitmap(destroy, sizeW, sizeW, width, height, sizeW, sizeH, true, null);
						
						
						//end go1
						go1 = false;
						
						scorepoint = scorepoint +1;
						
						//it's work but wants some changes and make three or four balls at the same time
					}
					}
					
					}
 
						if(avatar2){
							if(((AsizeW2/ScreenWidth) <= ((sizeW/ScreenWidth) + (1)))// ((sizeW/ScreenWidth) + (ScreenWidth/1000)))
									&& ((AsizeW2/ScreenWidth) >= ((sizeW/ScreenWidth) - (1)))// ((sizeW/ScreenWidth) - (ScreenWidth/1000)))
									){
								if(
										//left top small
										(A2FY >= height && A2FY <= (height+sizeH) && A2FX >= width && A2FX <= (width+sizeW))
										//right bottom small
										|| (A2EY >= height && A2EY <= (height+sizeH) && A2EX >= width && A2EX <= (width+sizeW))
										//left bottom small
										|| (A2EY >= height && A2EY <= (height+sizeH) && A2FX >= width && A2FX <= (width+sizeW))
										//right top small
										|| (A2FY >= height && A2FY <= (height+sizeH) && A2EX >= width && A2EX <= (width+sizeW))
										
										){
									actionInt = 1;
									Acstart1 = System.currentTimeMillis();

								
									avatar2 = false;		
									Awork2 = false;				
									wallet+=1;

									/*
									//for destroy
									if(A2o == theBall){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A2o == BoxesAfter){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A2o == BoxesBefore){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A2o == rock){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A2o == secondball){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}
									*/
									
									
									Bitmap m = Bitmap.createScaledBitmap(anything, sizeW, sizeH, true);
									canvas.drawBitmap(m, width, height, null);

									
									//end go1
									go1 = false;
									
									scorepoint = scorepoint +1;
									
									//it's work but wants some changes and make three or four balls at the same time
								}
							
								}
							
						}
						
						if(avatar3){
							if(((AsizeW3/ScreenWidth) <= ((sizeW/ScreenWidth) + (1)))// ((sizeW/ScreenWidth) + (ScreenWidth/1000)))
									&& ((AsizeW3/ScreenWidth) >= ((sizeW/ScreenWidth) - (1)))// ((sizeW/ScreenWidth) - (ScreenWidth/1000)))
									){
								if(
										//left top small
										(A3FY >= height && A3FY <= (height+sizeH) && A3FX >= width && A3FX <= (width+sizeW))
										//right bottom small
										|| (A3EY >= height && A3EY <= (height+sizeH) && A3EX >= width && A3EX <= (width+sizeW))
										//left bottom small
										|| (A3EY >= height && A3EY <= (height+sizeH) && A3FX >= width && A3FX <= (width+sizeW))
										//right top small
										|| (A3FY >= height && A3FY <= (height+sizeH) && A3EX >= width && A3EX <= (width+sizeW))
										
										
										){
									actionInt = 1;		
									Acstart1 = System.currentTimeMillis();

									avatar3 = false;
									Awork3 = false;
									wallet+=1;

									
									Bitmap m = Bitmap.createScaledBitmap(anything, sizeW, sizeH, true);
									canvas.drawBitmap(m, width, height, null);

									//end go3
									go1 = false;
									
									scorepoint = scorepoint +1;
									
									//it's work but wants some changes and make three or four balls at the same time
								}
							}
								}
						
				}
					if(sizeW >= DefBitmapWidth){
					

					scorepoint =scorepoint-1;
					
					//end go1
					go1 = false;
					//height and width for the imprint
					makeImprint = true;
					impH1 = height;
					impW1 = width;
					startimprint = System.currentTimeMillis();
					
				}
				}
				
				
				if(go2){
				//the place of the GOALKEEPER hand shouldn't be touched at the time 
				//this for the second ball
					if(avatar1 || avatar2 || avatar3){
					if(avatar1){
						if(((AsizeW1/ScreenWidth) <= ((sizeW2/ScreenWidth) + (1)))// ((sizeW2/ScreenWidth) + (ScreenWidth/1000)))
								&& ((AsizeW1/ScreenWidth) >= ((sizeW2/ScreenWidth) - (1)))//((sizeW2/ScreenWidth) - (ScreenWidth/1000)))
								){
							if(
									//left top small
									(A1FY >= height2 && A1FY <= (height2+sizeH2) && A1FX >= width2 && A1FX <= (width2+sizeW2))
									//right bottom small
									|| (A1EY >= height2 && A1EY <= (height2+sizeH2) && A1EX >= width2 && A1EX <= (width2+sizeW2))
									//left bottom small
									|| (A1EY >= height2 && A1EY <= (height2+sizeH2) && A1FX >= width2 && A1FX <= (width2+sizeW2))
									//right top small
									|| (A1FY >= height2 && A1FY <= (height2+sizeH2) && A1EX >= width2 && A1EX <= (width2+sizeW2))
									
								
									){
								actionInt = 2;
								Acstart2 = System.currentTimeMillis();

								
								avatar1 = false;
								Awork = false;
								wallet+=1;

								/*
								//for destroy
								if(A1o == theBall){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == BoxesAfter){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == BoxesBefore){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == rock){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == secondball){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}*/
								
								Bitmap m = Bitmap.createScaledBitmap(anything, sizeW2, sizeH2, true);
								canvas.drawBitmap(m, width2, height2, null);
								
								//end go1
								go2 = false;
								
								scorepoint = scorepoint +1;
								
								//it's work but wants some changes and make three or four balls at the same time
							}
						}
							} 
								if(avatar2){
									if(((AsizeW2/ScreenWidth) <= ((sizeW2/ScreenWidth) + (1)))//((sizeW2/ScreenWidth) + (ScreenWidth/1000)))
											&& ((AsizeW2/ScreenWidth) >= ((sizeW2/ScreenWidth) - (1)))//((sizeW2/ScreenWidth) - (ScreenWidth/1000)))
											){
										if(
												//left top small
												(A2FY >= height2 && A2FY <= (height2+sizeH2) && A2FX >= width2 && A2FX <= (width2+sizeW2))
												//right bottom small
												|| (A2EY >= height2 && A2EY <= (height2+sizeH2) && A2EX >= width2 && A2EX <= (width2+sizeW2))
												//left bottom small
												|| (A2EY >= height2 && A2EY <= (height2+sizeH2) && A2FX >= width2 && A2FX <= (width2+sizeW2))
												//right top small
												|| (A2FY >= height2 && A2FY <= (height2+sizeH2) && A2EX >= width2 && A2EX <= (width2+sizeW2))
												
												){
											actionInt = 2;
											Acstart2 = System.currentTimeMillis();

											
											avatar2 = false;
											Awork2 = false;
											wallet+=1;			
											/*
											//for destroy
											if(A2o == theBall){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == BoxesAfter){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == BoxesBefore){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == rock){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == secondball){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}*/
											
											Bitmap m = Bitmap.createScaledBitmap(anything, sizeW2, sizeH2, true);
											canvas.drawBitmap(m, width2, height2, null);


											//end go2
											go2 = false;
											
											scorepoint = scorepoint +1;
											
											//it's work but wants some changes and make three or four balls at the same time
										}
									}
									}
								
								if(avatar3){
									if(((AsizeW3/ScreenWidth) <= ((sizeW2/ScreenWidth) + (1)))//((sizeW2/ScreenWidth) + (ScreenWidth/1000)))
											&& ((AsizeW3/ScreenWidth) >= ((sizeW2/ScreenWidth) - (1)))//((sizeW2/ScreenWidth) - (ScreenWidth/1000)))
											){
										if(
												//left top small
												(A3FY >= height2 && A3FY <= (height2+sizeH2) && A3FX >= width2 && A3FX <= (width2+sizeW2))
												//right bottom small
												|| (A3EY >= height2 && A3EY <= (height2+sizeH2) && A3EX >= width2 && A3EX <= (width2+sizeW2))
												//left bottom small
												|| (A3EY >= height2 && A3EY <= (height2+sizeH2) && A3FX >= width2 && A3FX <= (width2+sizeW2))
												//right top small
												|| (A3FY >= height2 && A3FY <= (height2+sizeH2) && A3EX >= width2 && A3EX <= (width2+sizeW2))
												
												
												){
											actionInt = 2;
											Acstart2 = System.currentTimeMillis();

											
											avatar3 = false;
											Awork3 = false;
											wallet+=1;

											
											/*
											//for destroy
											if(A3o == theBall){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == BoxesAfter){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == BoxesBefore){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == rock){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == secondball){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}*/
											
											Bitmap m = Bitmap.createScaledBitmap(anything, sizeW2, sizeH2, true);
											canvas.drawBitmap(m, width2, height2, null);

											//end go3
											go2 = false;
											
											scorepoint = scorepoint +1;
											
											//it's work but wants some changes and make three or four balls at the same time
										}
									
									}
										}
								
								
					}
					
					if(sizeW2 >= DefBitmapWidth){
						

						scorepoint =scorepoint-1;
						
						//end go2
						go2 = false;
						//height and width for the imprint
						makeImprint2 = true;
						impH2 = height2;
						impW2 = width2;
						startimprint2 = System.currentTimeMillis();
						
					}
				}
				
				if(go3){
				//the place of the GOALKEEPER hand shouldn't be touched at the time 
				//this for the third ball
					if(avatar1 || avatar2 || avatar3){
					if(avatar1){

						if(((AsizeW1/ScreenWidth) <= ((sizeW3/ScreenWidth) + (1)))//((sizeW3/ScreenWidth) + (ScreenWidth/1000)))
								&& ((AsizeW1/ScreenWidth) >= ((sizeW3/ScreenWidth) - (1)))//((sizeW3/ScreenWidth) - (ScreenWidth/1000)))
								){
							if(
									//left top small
									(A1FY >= height3 && A1FY <= (height3+sizeH3) && A1FX >= width3 && A1FX <= (width3+sizeW3))
									//right bottom small
									|| (A1EY >= height3 && A1EY <= (height3+sizeH3) && A1EX >= width3 && A1EX <= (width3+sizeW3))
									//left bottom small
									|| (A1EY >= height3 && A1EY <= (height3+sizeH3) && A1FX >= width3 && A1FX <= (width3+sizeW3))
									//right top small
									|| (A1FY >= height3 && A1FY <= (height3+sizeH3) && A1EX >= width3 && A1EX <= (width3+sizeW3))
									
									
									){
								actionInt = 3;
								Acstart3 = System.currentTimeMillis();

								
							
								avatar1 = false;
								Awork = false;
								wallet+=1;								
								/*
								//for destroy and you must edit the width to width3 and the height to height3 sizeW3 , sizeH3
								if(A1o == theBall){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == BoxesAfter){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == BoxesBefore){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == rock){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == secondball){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}*/
								
								Bitmap m = Bitmap.createScaledBitmap(anything, sizeW3, sizeH3, true);
								canvas.drawBitmap(m, width3, height3, null);

								//end go3
								go3 = false;
								
								scorepoint = scorepoint +1;
								
								//it's work but wants some changes and make three or four balls at the same time
							}
						}
						} 
								if(avatar2){
									if(((AsizeW2/ScreenWidth) <= ((sizeW3/ScreenWidth) + (1)))//((sizeW3/ScreenWidth) + (ScreenWidth/1000)))
											&& ((AsizeW2/ScreenWidth) >= ((sizeW3/ScreenWidth) - (1)))//((sizeW3/ScreenWidth) - (ScreenWidth/1000)))	
											){
										if(
												//left top small
												(A2FY >= height3 && A2FY <= (height3+sizeH3) && A2FX >= width3 && A2FX <= (width3+sizeW3))
												//right bottom small
												|| (A2EY >= height3 && A2EY <= (height3+sizeH3) && A2EX >= width3 && A2EX <= (width3+sizeW3))
												//left bottom small
												|| (A2EY >= height3 && A2EY <= (height3+sizeH3) && A2FX >= width3 && A2FX <= (width3+sizeW3))
												//right top small
												|| (A2FY >= height3 && A2FY <= (height3+sizeH3) && A2EX >= width3 && A2EX <= (width3+sizeW3))
												
												){
											actionInt = 3;
											Acstart3 = System.currentTimeMillis();

											
											avatar2 = false;
											Awork2 = false;	
											wallet+=1;

											/*
											//for destroy
											if(A2o == theBall){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == BoxesAfter){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == BoxesBefore){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == rock){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == secondball){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}*/
											
											Bitmap m = Bitmap.createScaledBitmap(anything, sizeW3, sizeH3, true);
											canvas.drawBitmap(m, width3, height3, null);


											//end go3
											go3 = false;
											
											
											scorepoint = scorepoint +1;
											
											//it's work but wants some changes and make three or four balls at the same time
										}
									}
									
										}
								
								
								if(avatar3){
									if(((AsizeW3/ScreenWidth) <= ((sizeW3/ScreenWidth) + (1)))//((sizeW3/ScreenWidth) + (ScreenWidth/1000)))
											&& ((AsizeW3/ScreenWidth) >= ((sizeW3/ScreenWidth) - (1)))//((sizeW3/ScreenWidth) - (ScreenWidth/1000)))
											){
										if(
												//left top small
												(A3FY >= height3 && A3FY <= (height3+sizeH3) && A3FX >= width3 && A3FX <= (width3+sizeW3))
												//right bottom small
												|| (A3EY >= height3 && A3EY <= (height3+sizeH3) && A3EX >= width3 && A3EX <= (width3+sizeW3))
												//left bottom small
												|| (A3EY >= height3 && A3EY <= (height3+sizeH3) && A3FX >= width3 && A3FX <= (width3+sizeW3))
												//right top small
												|| (A3FY >= height3 && A3FY <= (height3+sizeH3) && A3EX >= width3 && A3EX <= (width3+sizeW3))
												
												
												){
											actionInt = 3;
											Acstart3 = System.currentTimeMillis();

											
											avatar3 = false;
											Awork3 = false;
											wallet+=1;

											
											/*
											//for destroy
											if(A3o == theBall){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == BoxesAfter){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == BoxesBefore){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == rock){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A3o == secondball){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}*/
											
											Bitmap m = Bitmap.createScaledBitmap(anything, sizeW3, sizeH3, true);
											canvas.drawBitmap(m, width3, height3, null);

											//end go3
											go3 = false;
											
											scorepoint = scorepoint +1;
											
											//it's work but wants some changes and make three or four balls at the same time
										}
									}
										}
								
								
					}
					
					if(sizeW3 >= DefBitmapWidth){
						

						scorepoint =scorepoint-1;
						
						//end go3
						go3 = false;
						//height and width for the imprint
						makeImprint3 = true;
						impH3 = height3;
						impW3 = width3;
						startimprint3 = System.currentTimeMillis();
						
					}
				}
				
				if(go4){
				//the place of the GOALKEEPER hand shouldn't be touched at the time 
				//this for the fourth ball
					if(avatar1 || avatar2 || avatar3){
					if(avatar1){
						if(((AsizeW1/ScreenWidth) <= ((sizeW4/ScreenWidth) + (1)))//((sizeW4/ScreenWidth) + (ScreenWidth/1000)))
								&& ((AsizeW1/ScreenWidth) >= ((sizeW4/ScreenWidth) - (1)))//((sizeW4/ScreenWidth) - (ScreenWidth/1000)))	
								){
							if(
									//left top small
									(A1FY >= height4 && A1FY <= (height4+sizeH4) && A1FX >= width4 && A1FX <= (width4+sizeW4))
									//right bottom small
									|| (A1EY >= height4 && A1EY <= (height4+sizeH4) && A1EX >= width4 && A1EX <= (width4+sizeW4))
									//left bottom small
									|| (A1EY >= height4 && A1EY <= (height4+sizeH4) && A1FX >= width4 && A1FX <= (width4+sizeW4))
									//right top small
									|| (A1FY >= height4 && A1FY <= (height4+sizeH4) && A1EX >= width4 && A1EX <= (width4+sizeW4))
									
									
									){
								actionInt = 4;
								Acstart4 = System.currentTimeMillis();

								
								avatar1 = false;
								Awork = false;
								wallet+=1;
								/*
								//for destroy
								if(A1o == theBall){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == BoxesAfter){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == BoxesBefore){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == rock){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A1o == secondball){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}*/
								
								Bitmap m = Bitmap.createScaledBitmap(anything, sizeW4, sizeH4, true);
								canvas.drawBitmap(m, width4, height4, null);

								
								//end go4
								go4 = false;
								
								scorepoint = scorepoint +1;
								
								//it's work but wants some changes and make three or four balls at the same time
							}
							} 
					}
								if(avatar2){
								if(((AsizeW2/ScreenWidth) <= ((sizeW4/ScreenWidth) + (1)))//((sizeW4/ScreenWidth) + (ScreenWidth/1000)))
										&& ((AsizeW2/ScreenWidth) >= ((sizeW4/ScreenWidth) - (1)))//((sizeW4/ScreenWidth) - (ScreenWidth/1000)))
										){
										if(
												//left top small
												(A2FY >= height4 && A2FY <= (height4+sizeH4) && A2FX >= width4 && A2FX <= (width4+sizeW4))
												//right bottom small
												|| (A2EY >= height4 && A2EY <= (height4+sizeH4) && A2EX >= width4 && A2EX <= (width4+sizeW4))
												//left bottom small
												|| (A2EY >= height4 && A2EY <= (height4+sizeH4) && A2FX >= width4 && A2FX <= (width4+sizeW4))
												//right top small
												|| (A2FY >= height4 && A2FY <= (height4+sizeH4) && A2EX >= width4 && A2EX <= (width4+sizeW4))
												
												){
											actionInt = 4;
											Acstart4 = System.currentTimeMillis();

											avatar2 = false;
											Awork2 = false;
											wallet+=1;
											/*
											//for destroy
											if(A2o == theBall){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == BoxesAfter){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == BoxesBefore){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == rock){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}else if(A2o == secondball){
												canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
											}*/
											
											Bitmap m = Bitmap.createScaledBitmap(anything, sizeW4, sizeH4, true);
											canvas.drawBitmap(m, width4, height4, null);


											//end go4
											go4 = false;
											scorepoint = scorepoint +1;
											
											//it's work but wants some changes and make three or four balls at the same time
										}
									}
									
										}
					
					
					if(avatar3){
						if(((AsizeW3/ScreenWidth) <= ((sizeW4/ScreenWidth) + (1)))//((sizeW4/ScreenWidth) + (ScreenWidth/1000)))
								&& ((AsizeW3/ScreenWidth) >= ((sizeW4/ScreenWidth) - (1)))//((sizeW4/ScreenWidth) - (ScreenWidth/1000)))
								){
							if(
									//left top small
									(A3FY >= height4 && A3FY <= (height4+sizeH4) && A3FX >= width4 && A3FX <= (width4+sizeW4))
									//right bottom small
									|| (A3EY >= height4 && A3EY <= (height4+sizeH4) && A3EX >= width4 && A3EX <= (width4+sizeW4))
									//left bottom small
									|| (A3EY >= height4 && A3EY <= (height4+sizeH4) && A3FX >= width4 && A3FX <= (width4+sizeW4))
									//right top small
									|| (A3FY >= height4 && A3FY <= (height4+sizeH4) && A3EX >= width4 && A3EX <= (width4+sizeW4))
									
									
									){
								actionInt = 4;
								Acstart4 = System.currentTimeMillis();

								
								avatar3 = false;
								Awork3 = false;
								wallet+=1;

								/*
								//for destroy
								if(A3o == theBall){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A3o == BoxesAfter){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A3o == BoxesBefore){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A3o == rock){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}else if(A3o == secondball){
									canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
								}
								*/
								
								Bitmap m = Bitmap.createScaledBitmap(anything, sizeW4, sizeH4, true);
								canvas.drawBitmap(m, width4, height4, null);

								//end go3
								go4 = false;
								
								scorepoint = scorepoint +1;
								
								//it's work but wants some changes and make three or four balls at the same time
							}
						}
							}
					
					
					}
					
					if(sizeW4 >= DefBitmapWidth){
						

						scorepoint =scorepoint-1;
						
						//end go4
						go4 = false;
						//height and width for the imprint
						makeImprint4 = true;
						impH4 = height4;
						impW4 = width4;
						startimprint4 = System.currentTimeMillis();
						
					}
				}
				
				
				if(go5){
					//the place of the GOALKEEPER hand shouldn't be touched at the time 
					//this for the fourth ball
						if(avatar1 || avatar2 || avatar3){
						if(avatar1){
						if(((AsizeW1/ScreenWidth) <= ((sizeW5/ScreenWidth) + (1)))//((sizeW5/ScreenWidth) + (ScreenWidth/1000)))
								&& ((AsizeW1/ScreenWidth) >= ((sizeW5/ScreenWidth) - (1)))//((sizeW5/ScreenWidth) - (ScreenWidth/1000)))		
								){
								if(
										//left top small
										(A1FY >= height5 && A1FY <= (height5+sizeH5) && A1FX >= width5 && A1FX <= (width5+sizeW5))
										//right bottom small
										|| (A1EY >= height5 && A1EY <= (height5+sizeH5) && A1EX >= width5 && A1EX <= (width5+sizeW5))
										//left bottom small
										|| (A1EY >= height5 && A1EY <= (height5+sizeH5) && A1FX >= width5 && A1FX <= (width5+sizeW5))
										//right top small
										|| (A1FY >= height5 && A1FY <= (height5+sizeH5) && A1EX >= width5 && A1EX <= (width5+sizeW5))
										
										
										){
									actionInt = 5;
									Acstart5 = System.currentTimeMillis();

									avatar1 = false;
									Awork = false;
									wallet+=1;

									/*
									//for destroy
									if(A1o == theBall){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A1o == BoxesAfter){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A1o == BoxesBefore){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A1o == rock){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A1o == secondball){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}*/
									
									Bitmap m = Bitmap.createScaledBitmap(anything, sizeW5, sizeH5, true);
									canvas.drawBitmap(m, width5, height5, null);

									
									//end go4
									go5 = false;
									
									scorepoint = scorepoint +1;
									
									//it's work but wants some changes and make three or four balls at the same time
								}
							}
								} 
									if(avatar2){
										if(((AsizeW2/ScreenWidth) <= ((sizeW5/ScreenWidth) + (1)))//((sizeW5/ScreenWidth) + (ScreenWidth/1000)))
												&& ((AsizeW2/ScreenWidth) >= ((sizeW5/ScreenWidth) - (1)))//((sizeW5/ScreenWidth) - (ScreenWidth/1000)))
												){
											if(
													//left top small
													(A2FY >= height5 && A2FY <= (height5+sizeH5) && A2FX >= width5 && A2FX <= (width5+sizeW5))
													//right bottom small
													|| (A2EY >= height5 && A2EY <= (height5+sizeH5) && A2EX >= width5 && A2EX <= (width5+sizeW5))
													//left bottom small
													|| (A2EY >= height5 && A2EY <= (height5+sizeH5) && A2FX >= width5 && A2FX <= (width5+sizeW5))
													//right top small
													|| (A2FY >= height5 && A2FY <= (height5+sizeH5) && A2EX >= width5 && A2EX <= (width4+sizeW5))
													
													){
												
												actionInt = 5;
												Acstart5 = System.currentTimeMillis();

												avatar2 = false;
												Awork2 = false;
												wallet+=1;

												/*
												//for destroy
												if(A2o == theBall){
													canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
												}else if(A2o == BoxesAfter){
													canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
												}else if(A2o == BoxesBefore){
													canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
												}else if(A2o == rock){
													canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
												}else if(A2o == secondball){
													canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
												}*/
												
												Bitmap m = Bitmap.createScaledBitmap(anything, sizeW5, sizeH5, true);
												canvas.drawBitmap(m, width5, height5, null);

												//end go4
												go5 = false;
												
												
												scorepoint = scorepoint +1;
												
												//it's work but wants some changes and make three or four balls at the same time
											}
										}
										
											}
						
						
						if(avatar3){
							if(((AsizeW3/ScreenWidth) <= ((sizeW5/ScreenWidth) + (1)))//((sizeW5/ScreenWidth) + (ScreenWidth/1000)))
									&& ((AsizeW3/ScreenWidth) >= ((sizeW5/ScreenWidth) - (1)))//((sizeW5/ScreenWidth) - (ScreenWidth/1000)))
									){
								if(
										//left top small
										(A3FY >= height5 && A3FY <= (height5+sizeH5) && A3FX >= width5 && A3FX <= (width5+sizeW5))
										//right bottom small
										|| (A3EY >= height5 && A3EY <= (height5+sizeH5) && A3EX >= width5 && A3EX <= (width5+sizeW5))
										//left bottom small
										|| (A3EY >= height5 && A3EY <= (height5+sizeH5) && A3FX >= width5 && A3FX <= (width5+sizeW5))
										//right top small
										|| (A3FY >= height5 && A3FY <= (height5+sizeH5) && A3EX >= width5 && A3EX <= (width5+sizeW5))
										
										
										){
									actionInt = 5;
									Acstart5 = System.currentTimeMillis();

									avatar3 = false;
									Awork3 = false;
									wallet+=1;

									/*
									//for destroy
									if(A3o == theBall){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A3o == BoxesAfter){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A3o == BoxesBefore){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A3o == rock){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}else if(A3o == secondball){
										canvas.drawBitmap(destroy, 3, 0, width, height, sizeW, sizeH, true, null);
									}*/
									
									Bitmap m = Bitmap.createScaledBitmap(anything, sizeW5, sizeH5, true);
									canvas.drawBitmap(m, width5, height5, null);

									//end go3
									go5 = false;
									
									scorepoint = scorepoint +1;
									
									//it's work but wants some changes and make three or four balls at the same time
								}
							}
								}
						
						
						}
						
						if(sizeW5 >= DefBitmapWidth){
							

							scorepoint =scorepoint-1;
							
							//end go4
							go5 = false;
							//height and width for the imprint
							makeImprint5 = true;
							impH5 = height5;
							impW5 = width5;
							startimprint5 = System.currentTimeMillis();
							
						}
					}

				
				
				if(go1){
					
					height -= ((desH1 - (canvas.getHeight()/2))/30);
					width -= ((desW1 - (canvas.getWidth()/2))/30);
					
						// The Bitmap Size
						sizeH += changingBallH;
						sizeW += changingBallW;
					
					}
				
				
				
				
				if(go2){
				
					height2 -= desH2;
					width2 -= desW2;
				
					// The Bitmap Size
					sizeH2 += changingBallH;
					sizeW2 += changingBallW;
				}
				
				
				
				
				
				if(go3){
				
					height3 -= desH3;
					width3 -= desW3;
				
					// The Bitmap Size
					sizeH3 += changingBallH;
					sizeW3 += changingBallW;
				}
				
				
				if(go4){
				
					
					height4 -= desH4;
					width4 -= desW4;
					
					
						// The Bitmap Size
						sizeH4 += changingBallH;
						sizeW4 += changingBallW;
				}
				

				if(go5){
					
					height5 -= desH5;
					width5 -= desW5;
					
						// The Bitmap Size
						sizeH5 += changingBallH;
						sizeW5 += changingBallW;
				}
				//for the first rock
				if(oneR1){
					rokH = rrr.nextInt(h);
					//rokW = rrr.nextInt(w);
					roksizeH = rrr.nextInt(backsizeH);
					roksizeW = roksizeH;
					rokW = canvas.getWidth();
					//rokH = canvas.getHeight();
					oneR1 = false;
					}
				
				//for the rocks and else like fish or lava .....
				if(rok1){
					//to make the rock move in the horizantle 
					int desx = ((canvas.getWidth())/100);					
					rokW -= desx;
					//rokH -= desx;
					//for the avatar1
					if(((AsizeW1/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(AsizeW1/ScreenWidth)) <= ((roksizeW/ScreenWidth) + (ScreenWidth/1000)))
							&& ((AsizeW1/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//((2*(AsizeW1/ScreenWidth)) >= ((roksizeW/ScreenWidth) - (ScreenWidth/1000)))
							&&((A1FY >= rokH && A1FY <= (rokH+roksizeH) && A1FX >= rokW && A1FX <= (rokW+roksizeW))
								//right bottom small
								|| (A1EY >= rokH && A1EY <= (rokH+roksizeH) && A1EX >= rokW && A1EX <= (rokW+roksizeW))
								//left bottom small
								|| (A1EY >= rokH && A1EY <= (rokH+roksizeH) && A1FX >= rokW && A1FX <= (rokW+roksizeW))
								//right top small
								|| (A1FY >= rokH && A1FY <= (rokH+roksizeH) && A1EX >= rokW && A1EX <= (rokW+roksizeW)))){
						avatar1 = false;
						Awork = false;
						wallet+=1;

						rok1 = false;
					}
					//for the avatar2
					if(((AsizeW2/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(AsizeW2/ScreenWidth)) <= ((roksizeW/ScreenWidth) + (ScreenWidth/1000)))
							&& ((AsizeW2/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(AsizeW2/ScreenWidth)) >= ((roksizeW/ScreenWidth) - (ScreenWidth/1000)))
							&&((A2FY >= rokH && A2FY <= (rokH+roksizeH) && A2FX >= rokW && A2FX <= (rokW+roksizeW))
								//right bottom small
								|| (A2EY >= rokH && A2EY <= (rokH+roksizeH) && A2EX >= rokW && A2EX <= (rokW+roksizeW))
								//left bottom small
								|| (A2EY >= rokH && A2EY <= (rokH+roksizeH) && A2FX >= rokW && A2FX <= (rokW+roksizeW))
								//right top small
								|| (A2FY >= rokH && A2FY <= (rokH+roksizeH) && A2EX >= rokW && A2EX <= (rokW+roksizeW)))){
						avatar2 = false;
						Awork2 = false;
						wallet+=1;

						rok1 = false;
					}
					//for the avatar3
					if(((AsizeW3/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(AsizeW3/ScreenWidth)) <= (((roksizeW/ScreenWidth) + (ScreenWidth/1000))))
							&& ((AsizeW3/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(AsizeW3/ScreenWidth)) >= (((roksizeW/ScreenWidth) - (ScreenWidth/1000))))
							&&((A3FY >= rokH && A3FY <= (rokH+roksizeH) && A3FX >= rokW && A3FX <= (rokW+roksizeW))
								//right bottom small
								|| (A3EY >= rokH && A3EY <= (rokH+roksizeH) && A3EX >= rokW && A3EX <= (rokW+roksizeW))
								//left bottom small
								|| (A3EY >= rokH && A3EY <= (rokH+roksizeH) && A3FX >= rokW && A3FX <= (rokW+roksizeW))
								//right top small
								|| (A3FY >= rokH && A3FY <= (rokH+roksizeH) && A3EX >= rokW && A3EX <= (rokW+roksizeW)))){
						avatar3 = false;
						Awork3 = false;
						wallet+=1;

						rok1 = false;
					}
					//for the go1
					if(((sizeW/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(sizeW/ScreenWidth)) <= (((roksizeW/ScreenWidth) + (ScreenWidth/1000))))
							&& ((sizeW/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(sizeW/ScreenWidth)) >= (((roksizeW/ScreenWidth) - (ScreenWidth/1000))))
							&&((height >= rokH && height <= (rokH+roksizeH) && width >= rokW && width <= (rokW+roksizeW))
								//right bottom small
								|| ((height+sizeH) >= rokH && (height+sizeH) <= (rokH+roksizeH) && (width+sizeW) >= rokW && (width+sizeW) <= (rokW+roksizeW))
								//left bottom small
								|| ((height+sizeH) >= rokH && (height+sizeH) <= (rokH+roksizeH) && width >= rokW && width <= (rokW+roksizeW))
								//right top small
								|| (height >= rokH && height <= (rokH+roksizeH) && (width+sizeW) >= rokW && (width+sizeW) <= (rokW+roksizeW)))){
						go1 = false;
						
						//rok1 = false;
					}
					//for the go2
					if(((sizeW2/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(sizeW2/ScreenWidth)) <= (((roksizeW/ScreenWidth) + (ScreenWidth/1000))))
							&& ((sizeW2/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(sizeW2/ScreenWidth)) >= (((roksizeW/ScreenWidth) - (ScreenWidth/1000))))
							&&((height2 >= rokH && height2 <= (rokH+roksizeH) && width2 >= rokW && width2 <= (rokW+roksizeW))
								//right bottom small
								|| ((height2+sizeH2) >= rokH && (height2+sizeH2) <= (rokH+roksizeH) && (width2+sizeW2) >= rokW && (width2+sizeW2) <= (rokW+roksizeW))
								//left bottom small
								|| ((height2+sizeH2) >= rokH && (height2+sizeH2) <= (rokH+roksizeH) && width2 >= rokW && width2 <= (rokW+roksizeW))
								//right top small
								|| (height2 >= rokH && height2 <= (rokH+roksizeH) && (width2+sizeW2) >= rokW && (width2+sizeW2) <= (rokW+roksizeW)))){
						go2 = false;
						
						//rok1 = false;
					}
					//for the go3
					if(((sizeW3/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(sizeW3/ScreenWidth)) <= (((roksizeW/ScreenWidth) + (ScreenWidth/1000))))
							&& ((sizeW3/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(sizeW3/ScreenWidth)) >= (((roksizeW/ScreenWidth) - (ScreenWidth/1000))))
							&&((height3 >= rokH && height3 <= (rokH+roksizeH) && width3 >= rokW && width3 <= (rokW+roksizeW))
								//right bottom small
								|| ((height3+sizeH3) >= rokH && (height3+sizeH3) <= (rokH+roksizeH) && (width3+sizeW3) >= rokW && (width3+sizeW3) <= (rokW+roksizeW))
								//left bottom small
								|| ((height3+sizeH3) >= rokH && (height3+sizeH3) <= (rokH+roksizeH) && width3 >= rokW && width3 <= (rokW+roksizeW))
								//right top small
								|| (height3 >= rokH && height3 <= (rokH+roksizeH) && (width3+sizeW3) >= rokW && (width3+sizeW3) <= (rokW+roksizeW)))){
						go3 = false;
						
						//rok1 = false;
					}
					//for the go4
					if(((sizeW4/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(sizeW4/ScreenWidth)) <= (((roksizeW/ScreenWidth) + (ScreenWidth/1000))))
							&& ((sizeW4/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(sizeW4/ScreenWidth)) >= (((roksizeW/ScreenWidth) - (ScreenWidth/1000))))
							&&((height4 >= rokH && height4 <= (rokH+roksizeH) && width4 >= rokW && width4 <= (rokW+roksizeW))
								//right bottom small
								|| ((height4+sizeH4) >= rokH && (height4+sizeH4) <= (rokH+roksizeH) && (width4+sizeW4) >= rokW && (width4+sizeW4) <= (rokW+roksizeW))
								//left bottom small
								|| ((height4+sizeH4) >= rokH && (height4+sizeH4) <= (rokH+roksizeH) && width4 >= rokW && width4 <= (rokW+roksizeW))
								//right top small
								|| (height4 >= rokH && height4 <= (rokH+roksizeH) && (width4+sizeW4) >= rokW && (width4+sizeW4) <= (rokW+roksizeW)))){
						go4 = false;
						
						//rok1 = false;
					}
					//for the go5
					if(((sizeW5/ScreenWidth) <= ((roksizeW/ScreenWidth) + (1)))//((2*(sizeW5/ScreenWidth)) <= (((roksizeW/ScreenWidth) + (ScreenWidth/1000))))
							&& ((sizeW5/ScreenWidth) >= ((roksizeW/ScreenWidth) - (1)))//&& ((2*(sizeW5/ScreenWidth)) >= (((roksizeW/ScreenWidth) - (ScreenWidth/1000))))
							&&((height5 >= rokH && height5 <= (rokH+roksizeH) && width5 >= rokW && width5 <= (rokW+roksizeW))
								//right bottom small
								|| ((height5+sizeH5) >= rokH && (height5+sizeH5) <= (rokH+roksizeH) && (width5+sizeW5) >= rokW && (width5+sizeW5) <= (rokW+roksizeW))
								//left bottom small
								|| ((height5+sizeH5) >= rokH && (height5+sizeH5) <= (rokH+roksizeH) && width5 >= rokW && width5 <= (rokW+roksizeW))
								//right top small
								|| (height5 >= rokH && height5 <= (rokH+roksizeH) && (width5+sizeW5) >= rokW && (width5+sizeW5) <= (rokW+roksizeW)))){
						go5 = false;
						
						//rok1 = false;
					}
					
					if((rokW+roksizeW) <= 0){
						rok1 = false;
					}
													
				}else{
					oneR1 = true;
					rok1 = true;
				}
				
				
				//for the second rock
				if(oneR2){
					rokH2 = rrr.nextInt(h);
					//rokW = rrr.nextInt(w);
					roksizeH2 = rrr.nextInt(backsizeH);
					roksizeW2 = roksizeH2;
					rokW2 = canvas.getWidth();
					//rokH2 = canvas.getHeight();
					
					oneR2 = false;
					}
				
				//for the rocks and else like fish or lava .....
				if(rok2 ){//&& workR2){//&& rokW <= (canvas.getWidth()-(canvas.getWidth()/4))){
					
					int desx = ((canvas.getWidth())/100);					
					rokW2 -= desx;
					//rokH2 -= desx;
					
					//to make the rock move in the horizantle 
					//int desx2 = ((canvas.getWidth())/32);					
					//rokW2 -= desx2;
					//for the avatar1
					if(((AsizeW1/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(AsizeW1/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((AsizeW1/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(AsizeW1/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((A1FY >= rokH2 && A1FY <= (rokH2+roksizeH2) && A1FX >= rokW2 && A1FX <= (rokW2+roksizeW2))
								//right bottom small
								|| (A1EY >= rokH2 && A1EY <= (rokH2+roksizeH2) && A1EX >= rokW2 && A1EX <= (rokW2+roksizeW2))
								//left bottom small
								|| (A1EY >= rokH2 && A1EY <= (rokH2+roksizeH2) && A1FX >= rokW2 && A1FX <= (rokW2+roksizeW2))
								//right top small
								|| (A1FY >= rokH2 && A1FY <= (rokH2+roksizeH2) && A1EX >= rokW2 && A1EX <= (rokW2+roksizeW2)))){
						avatar1 = false;
						Awork = false;
						wallet+=1;

						rok2 = false;
					}
					//for the avatar2
					if(((AsizeW2/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(AsizeW2/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((AsizeW2/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(AsizeW2/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((A2FY >= rokH2 && A2FY <= (rokH2+roksizeH2) && A2FX >= rokW2 && A2FX <= (rokW2+roksizeW2))
								//right bottom small
								|| (A2EY >= rokH2 && A2EY <= (rokH2+roksizeH2) && A2EX >= rokW2 && A2EX <= (rokW2+roksizeW2))
								//left bottom small
								|| (A2EY >= rokH2 && A2EY <= (rokH2+roksizeH2) && A2FX >= rokW2 && A2FX <= (rokW2+roksizeW2))
								//right top small
								|| (A2FY >= rokH2 && A2FY <= (rokH2+roksizeH2) && A2EX >= rokW2 && A2EX <= (rokW2+roksizeW2)))){
						avatar2 = false;
						Awork2 = false;
						wallet+=1;

						rok2 = false;
					}
					//for the avatar3
					if(((AsizeW3/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(AsizeW3/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((AsizeW3/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(AsizeW3/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((A3FY >= rokH2 && A3FY <= (rokH2+roksizeH2) && A3FX >= rokW2 && A3FX <= (rokW2+roksizeW2))
								//right bottom small
								|| (A3EY >= rokH2 && A3EY <= (rokH2+roksizeH2) && A3EX >= rokW2 && A3EX <= (rokW2+roksizeW2))
								//left bottom small
								|| (A3EY >= rokH2 && A3EY <= (rokH2+roksizeH2) && A3FX >= rokW2 && A3FX <= (rokW2+roksizeW2))
								//right top small
								|| (A3FY >= rokH2 && A3FY <= (rokH2+roksizeH2) && A3EX >= rokW2 && A3EX <= (rokW2+roksizeW2)))){
						avatar3 = false;
						Awork3 = false;
						wallet+=1;

						rok2 = false;
					}
					//for the go1
					if(((sizeW/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(sizeW/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((sizeW/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(sizeW/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((height >= rokH2 && height <= (rokH2+roksizeH2) && width >= rokW2 && width <= (rokW2+roksizeW2))
								//right bottom small
								|| ((height+sizeH) >= rokH2 && (height+sizeH) <= (rokH2+roksizeH2) && (width+sizeW) >= rokW2 && (width+sizeW) <= (rokW2+roksizeW2))
								//left bottom small
								|| ((height+sizeH) >= rokH2 && (height+sizeH) <= (rokH2+roksizeH2) && width >= rokW2 && width <= (rokW2+roksizeW2))
								//right top small
								|| (height >= rokH2 && height <= (rokH2+roksizeH2) && (width+sizeW) >= rokW2 && (width+sizeW) <= (rokW2+roksizeW2)))){
						go1 = false;
						
						//rok2 = false;
					}
					//for the go2
					if(((sizeW2/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(sizeW2/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((sizeW2/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(sizeW2/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((height2 >= rokH2 && height2 <= (rokH2+roksizeH2) && width2 >= rokW2 && width2 <= (rokW2+roksizeW2))
								//right bottom small
								|| ((height2+sizeH2) >= rokH2 && (height2+sizeH2) <= (rokH2+roksizeH2) && (width2+sizeW2) >= rokW2 && (width2+sizeW2) <= (rokW2+roksizeW2))
								//left bottom small
								|| ((height2+sizeH2) >= rokH2 && (height2+sizeH2) <= (rokH2+roksizeH2) && width2 >= rokW2 && width2 <= (rokW2+roksizeW2))
								//right top small
								|| (height2 >= rokH2 && height2 <= (rokH2+roksizeH2) && (width2+sizeW2) >= rokW2 && (width2+sizeW2) <= (rokW2+roksizeW2)))){
						go2 = false;
						
						//rok2 = false;
					}
					//for the go3
					if(((sizeW3/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(sizeW3/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((sizeW3/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(sizeW3/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((height3 >= rokH2 && height3 <= (rokH2+roksizeH2) && width3 >= rokW2 && width3 <= (rokW2+roksizeW2))
								//right bottom small
								|| ((height3+sizeH3) >= rokH2 && (height3+sizeH3) <= (rokH2+roksizeH2) && (width3+sizeW3) >= rokW2 && (width3+sizeW3) <= (rokW2+roksizeW2))
								//left bottom small
								|| ((height3+sizeH3) >= rokH2 && (height3+sizeH3) <= (rokH2+roksizeH2) && width3 >= rokW2 && width3 <= (rokW2+roksizeW2))
								//right top small
								|| (height3 >= rokH2 && height3 <= (rokH2+roksizeH2) && (width3+sizeW3) >= rokW2 && (width3+sizeW3) <= (rokW2+roksizeW2)))){
						go3 = false;
						
						//rok2 = false;
					}
					//for the go4
					if(((sizeW4/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(sizeW4/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((sizeW4/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(sizeW4/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((height4 >= rokH2 && height4 <= (rokH2+roksizeH2) && width4 >= rokW2 && width4 <= (rokW2+roksizeW2))
								//right bottom small
								|| ((height4+sizeH4) >= rokH2 && (height4+sizeH4) <= (rokH2+roksizeH2) && (width4+sizeW4) >= rokW2 && (width4+sizeW4) <= (rokW2+roksizeW2))
								//left bottom small
								|| ((height4+sizeH4) >= rokH2 && (height4+sizeH4) <= (rokH2+roksizeH2) && width4 >= rokW2 && width4 <= (rokW2+roksizeW2))
								//right top small
								|| (height4 >= rokH2 && height4 <= (rokH2+roksizeH2) && (width4+sizeW4) >= rokW2 && (width4+sizeW4) <= (rokW2+roksizeW2)))){
						go4 = false;
						
						//rok2 = false;
					}
					//for the go5
					if(((sizeW5/ScreenWidth) <= ((roksizeW2/ScreenWidth) + (1)))//((2*(sizeW5/ScreenWidth)) <= (((roksizeW2/ScreenWidth) + (ScreenWidth/1000))))
							&&((sizeW5/ScreenWidth) >= ((roksizeW2/ScreenWidth) - (1)))//&& ((2*(sizeW5/ScreenWidth)) >= (((roksizeW2/ScreenWidth) - (ScreenWidth/1000))))
							&&((height5 >= rokH2 && height5 <= (rokH2+roksizeH2) && width5 >= rokW2 && width5 <= (rokW2+roksizeW2))
								//right bottom small
								|| ((height5+sizeH5) >= rokH2 && (height5+sizeH5) <= (rokH2+roksizeH2) && (width5+sizeW5) >= rokW2 && (width5+sizeW5) <= (rokW2+roksizeW2))
								//left bottom small
								|| ((height5+sizeH5) >= rokH2 && (height5+sizeH5) <= (rokH2+roksizeH2) && width5 >= rokW2 && width5 <= (rokW2+roksizeW2))
								//right top small
								|| (height5 >= rokH2 && height5 <= (rokH2+roksizeH2) && (width5+sizeW5) >= rokW2 && (width5+sizeW5) <= (rokW2+roksizeW2)))){
						go5 = false;
						
						//rok2 = false;
					}
					
					if((rokW2+roksizeW2) <= 0){
						rok2 = false;
					}
													
				}else{
					oneR2 = true;
					rok2 = true;
					workR2 = true;

				}
				
				
				

				if(actionInt >= 0){
				//for all actions 
			//	if(actionInt == 1){
					
					float widthx = 0 , heightx = 0 , sizex = 0;
					if(actionInt == 1) {
						widthx = width;
						heightx = height;
						sizex = sizeW;
					}else
					if(actionInt == 2) {
						widthx = width2;
						heightx = height2;
						sizex = sizeW2;
					}else
					if(actionInt == 3) {
						widthx = width3;
						heightx = height3;
						sizex = sizeW3;
					}else
					if(actionInt == 4) {
						widthx = width4;
						heightx = height4;
						sizex = sizeW4;
					}else
					if(actionInt == 5) {
						widthx = width5;
						heightx = height5;
						sizex = sizeW5;
					}
					
					if(!action1){
						AcW1 = widthx;
						AcH1 = heightx;
						AcSize1 = (int) sizex;
						action1 = true;
					}else if(!action2){
						AcW2 = widthx;
						AcH2 = heightx;
						AcSize2 = (int) sizex;
						action2 = true;
					}else if(!action3){
						AcW3 = widthx;
						AcH3 = heightx;
						AcSize3 = (int) sizex;
						action3 = true;
					}else if(!action4){
						AcW4 = widthx;
						AcH4 = heightx;
						AcSize4 = (int) sizex;
						action4 = true;
					}else if(!action5){
						AcW5 = widthx;
						AcH5 = heightx;
						AcSize5 = (int) sizex;
						action5 = true;
					}
					actionInt = 0;
				//}
					/*
				if(actionInt == 2){
					if(!action1){
						AcW1 = width2;
						AcH1 = height2;
						AcSize1 = sizeW2;
						action1 = true;
					}else if(!action2){
						AcW2 = width2;
						AcH2 = height2;
						AcSize2 = sizeW2;
						action2 = true;
					}else if(!action3){
						AcW3 = width2;
						AcH3 = height2;
						AcSize3 = sizeW2;
						action3 = true;
					}else if(!action4){
						AcW4 = width2;
						AcH4 = height2;
						AcSize4 = sizeW2;
						action4 = true;
					}else if(!action5){
						AcW5 = width2;
						AcH5 = height2;
						AcSize5 = sizeW2;
						action5 = true;
					}
					actionInt = 0;
				}
				if(actionInt == 3){
					if(!action1){
						AcW1 = width3;
						AcH1 = height3;
						AcSize1 = sizeW3;
						action1 = true;
					}else if(!action2){
						AcW2 = width3;
						AcH2 = height3;
						AcSize2 = sizeW3;
						action2 = true;
					}else if(!action3){
						AcW3 = width3;
						AcH3 = height3;
						AcSize3 = sizeW3;
						action3 = true;
					}else if(!action4){
						AcW4 = width3;
						AcH4 = height3;
						AcSize4 = sizeW3;
						action4 = true;
					}else if(!action5){
						AcW5 = width3;
						AcH5 = height3;
						AcSize5 = sizeW3;
						action5 = true;
					}
					actionInt = 0;
				}
				if(actionInt == 4){
					if(!action1){
						AcW1 = width4;
						AcH1 = height4;
						AcSize1 = sizeW4;
						action1 = true;
					}else if(!action2){
						AcW2 = width4;
						AcH2 = height4;
						AcSize2 = sizeW4;
						action2 = true;
					}else if(!action3){
						AcW3 = width4;
						AcH3 = height4;
						AcSize3 = sizeW4;
						action3 = true;
					}else if(!action4){
						AcW4 = width4;
						AcH4 = height4;
						AcSize4 = sizeW4;
						action4 = true;
					}else if(!action5){
						AcW5 = width4;
						AcH5 = height4;
						AcSize5 = sizeW4;
						action5 = true;
					}
					actionInt = 0;
				}
				if(actionInt == 5){
					if(!action1){
						AcW1 = width5;
						AcH1 = height5;
						AcSize1 = sizeW5;
						action1 = true;
					}else if(!action2){
						AcW2 = width5;
						AcH2 = height5;
						AcSize2 = sizeW5;
						action2 = true;
					}else if(!action3){
						AcW3 = width5;
						AcH3 = height5;
						AcSize3 = sizeW5;
						action3 = true;
					}else if(!action4){
						AcW4 = width5;
						AcH4 = height5;
						AcSize4 = sizeW5;
						action4 = true;
					}else if(!action5){
						AcW5 = width5;
						AcH5 = height5;
						AcSize5 = sizeW5;
						action5 = true;
					}
					actionInt = 0;
				}*/
				}
				
				/*
				//draw the Actions all of them 
				if(action1){
					long stop = System.currentTimeMillis();
					long result =  stop - Acstart1;
					Bitmap action = Bitmap.createScaledBitmap(theBall, AcSize1, AcSize1, true);
					canvas.drawBitmap(action, AcW1, AcH1, null);
					//canvas.drawBitmap(rock, 0, 0, AcW1, AcH1, AcSize1, AcSize1, false, null);
					AcH1 -= (AcSize1/4);
					if(result >= 2000) action1 = false;
					if(AcH1 >= canvas.getHeight()) action1 = false;
				}
				if(action2){
					long stop = System.currentTimeMillis();
					long result =  stop - Acstart2;
					Bitmap action = Bitmap.createScaledBitmap(theBall, AcSize2, AcSize2, true);
					canvas.drawBitmap(action, AcW2, AcH2, null);
					AcH2 -= (AcSize2/4);
					if(result >= 2000) action2 = false;
					if(AcH2 >= canvas.getHeight()) action2 = false;
				}
				if(action3){
					long stop = System.currentTimeMillis();
					long result =  stop - Acstart3;
					Bitmap action = Bitmap.createScaledBitmap(theBall, AcSize3, AcSize3, true);
					canvas.drawBitmap(action, AcW3, AcH3, null);
					AcH3 -= (AcSize3/4);
					if(result >= 2000) action3 = false;
					if(AcH3 >= canvas.getHeight()) action3 = false;
				}
				if(action4){
					long stop = System.currentTimeMillis();
					long result =  stop - Acstart4;
					Bitmap action = Bitmap.createScaledBitmap(theBall, AcSize4, AcSize4, true);
					canvas.drawBitmap(action, AcW4, AcH4, null);
					AcH4 -= (AcSize4/4);
					if(result >= 2000) action4 = false;
					if(AcH4 >= canvas.getHeight()) action4 = false;
				}
				if(action5){
					long stop = System.currentTimeMillis();
					long result =  stop - Acstart5;
					Bitmap action = Bitmap.createScaledBitmap(theBall, AcSize5, AcSize5, true);
					canvas.drawBitmap(action, AcW5, AcH5, null);
					AcH5 -= (AcSize5/4);
					if(result >= 2000) action5 = false;
					if(AcH5 >= canvas.getHeight()) action5 = false;
				}
				*/
				
				
				//2al7odood bata3at 2almakan 
				
				//2aly bara
				Bitmap hadooddd = Bitmap.createScaledBitmap(hadood, canvas.getWidth()-((canvas.getWidth() / 3) / 16), canvas.getHeight()-((canvas.getHeight() / 3) / 16), true);
				canvas.drawBitmap(hadooddd, ((canvas.getWidth() / 3) / 16), ((canvas.getHeight() / 3) / 16),new Paint());
				//2aly fe2alnoos
				Bitmap hadoodddd = Bitmap.createScaledBitmap(hadood,canvas.getWidth()-(canvas.getWidth()/3),canvas.getHeight()- (canvas.getHeight()/3), true);
				canvas.drawBitmap(hadoodddd, canvas.getWidth()/6, canvas.getHeight()/6, new Paint());
				//2aly gowaa
				Bitmap hadoodd = Bitmap.createScaledBitmap(hadood, canvas.getWidth()/3, canvas.getHeight()/3, true);
				canvas.drawBitmap(hadoodd, canvas.getWidth()/3, canvas.getHeight()/3,new Paint());
					
				// Draw Text
				Paint textPaint = new Paint();
				textPaint.setColor(Color.BLUE);
				textPaint.setTextAlign(Align.CENTER);
				textPaint.setTextSize(20);
				textPaint.setTypeface(font);
				//find the small point in the canvas of SpaceLeft and SpaceTop to find statistics 
				if(SpaceLeft >= counteSpaceL) counteSpaceL = SpaceLeft;
				if(SpaceTop >= counteSpaceT) counteSpaceT = SpaceTop;
				float SmallSpaceCanvasT = canvas.getHeight()/counteSpaceT;
				float SmallSpaceCanvasL = canvas.getWidth()/counteSpaceL;
				//s ="the Small Space left for the canvas = " +SmallSpaceCanvasL+"       the Space Top for the canvas = " + SmallSpaceCanvasT;
				s = "x = "+x +"    y = " +y;
				String aaaa = ""+wallet;

				canvas.drawText(aaaa, canvas.getWidth() / 2, 200, textPaint);

				
				//for all balls before canvas
				//number 1
				CanvasBall = Bitmap.createScaledBitmap(firstball, sizeW, sizeH, true);
				//number 2
				Bitmap CanvasBall2 = Bitmap.createScaledBitmap(secondball, sizeW2, sizeH2, true);
				//number 3
				Bitmap CanvasBall3 = Bitmap.createScaledBitmap(thirdball, sizeW3, sizeH3, true);
				//number 4
				Bitmap CanvasBall4 = Bitmap.createScaledBitmap(theBall, sizeW4, sizeH4, true);
				
				//number 5
				Bitmap CanvasBall5 = Bitmap.createScaledBitmap(theBall, sizeW5, sizeH5, true);
				
				
				
				if (go1 || go2 || go3 || go4 || go5){
					
					//lazam 2altarteeb 3lshan dah bta3 2al3ard 
				if(go5)
				// To Draw The Bitmap(Ball) number4
				canvas.drawBitmap(CanvasBall5, width5, height5, null);
					
				if(go4)
				// To Draw The Bitmap(Ball) number4
				canvas.drawBitmap(CanvasBall4, width4, height4, null);
				if(go3)
					// To Draw The Bitmap(Ball) number3
					canvas.drawBitmap(CanvasBall3, width3, height3, null);
				if(go2)
					// To Draw The Bitmap(Ball) number 2
					canvas.drawBitmap(CanvasBall2, width2, height2, null);
				//to draw the balls but the if 2aly foo2 mash sha3'ala mash 3araf leh ya3ny batshta3'al ba3deha bashwaya
				if(go1)
				// To Draw The Bitmap(Ball)
				canvas.drawBitmap(CanvasBall, width, height, null);
				
				}
				
				/*
				Matrix matrix = new Matrix();

				matrix.postRotate(90);

				Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmapOrg,width,height,true);

				Bitmap rotatedBitmap2 = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);
				*/
				
				
				//Matrix matrix = new Matrix();
				//matrix.postRotate(90);
				
				Matrix matrix = new Matrix();
				rotation += 1;
				//float px = canvas.getWidth()/2;
				//float py = canvas.getHeight()/2;
				
				try{
				//to draw the rocks
				Bitmap rok11= Bitmap.createScaledBitmap(rock, roksizeW, roksizeH, true);
				//Bitmap rotatedBitmap = Bitmap.createBitmap(rok11 , 0, 0, rok11 .getWidth(), rok11 .getHeight(), matrix, true);

				//matrix.postTranslate(-rok11.getWidth()/2, -rok11.getHeight()/2);
				//matrix.postTranslate(roksizeW, roksizeH);
				//matrix.postRotate(rotation);
				//matrix.setRotate(rotation,roksizeW/2,roksizeH/2);
				matrix.setRotate(rotation,roksizeW,roksizeH);
				//matrix.postTranslate(rokW, rokH);
				Bitmap rotatedBitmap = Bitmap.createBitmap(rok11 , 0, 0, rok11 .getWidth(), rok11 .getHeight(), matrix, true);
				//canvas.drawBitmap(rok11, matrix, null);
				
				canvas.drawBitmap(rotatedBitmap, rokW, rokH, null);
				}catch(Exception e){
					e.printStackTrace();
				}
				//canvas.rotate(180, 1, 1);
				
				//if((rok2 && rokW <= (canvas.getWidth()-(canvas.getWidth()/4)))){
				//	workR2 = true;
				//}
				//if(workR2){
				try{
					Bitmap rok22= Bitmap.createScaledBitmap(rock, roksizeW2, roksizeH2, true);
					//matrix.postTranslate(-rok2.getWidth()/2, -rok2.getHeight()/2);
					//matrix.postTranslate(roksizeW2, roksizeH2);
					//matrix.postRotate(rotation);
					matrix.setRotate(rotation,roksizeW2,roksizeH2);
					//matrix.postTranslate(rokW2, rokH2);
					Bitmap rotatedBitmap2 = Bitmap.createBitmap(rok22 , 0, 0, rok22 .getWidth(), rok22 .getHeight(), matrix, true);
				canvas.drawBitmap(rotatedBitmap2, rokW2, rokH2, null);
			}catch(Exception e){
				e.printStackTrace();
			}
				//}

				
				
				if(avatar1){
				// canvas.drawCircle(width, height, sizeH, textPaint);
				//To Draw the avatar 
					if(AsizeW1 > 0 && AsizeH1 > 0){
				avatar = Bitmap.createScaledBitmap(A1o, AsizeW1, AsizeH1, true);
				canvas.drawBitmap(avatar, (avatarW1-(AsizeW1/2)), (avatarH1-(AsizeH1/2)),null);
					}else{
						avatar1 = false;
						wallet+=1;
					//	Awork = false;
					}
				}
				
				
				if(avatar2){
				//To Draw the avatar2 
					if(AsizeW2 > 0 && AsizeH2 > 0){
				Bitmap avatar2 = Bitmap.createScaledBitmap(A2o, AsizeW2, AsizeH2, true);
				canvas.drawBitmap(avatar2, (avatarW2-(AsizeW2/2)), (avatarH2-(AsizeH2/2)),null);
				}else{
						avatar2 = false;
						wallet+=1;
					//	Awork2 = false;
					}
				}
				
				
				if(avatar3){
					// canvas.drawCircle(width, height, sizeH, textPaint);
					//To Draw the avatar 
						if(AsizeW3 > 0 && AsizeH3 > 0){
					Bitmap avatar33 = Bitmap.createScaledBitmap(A3o, AsizeW3, AsizeH3, true);
					canvas.drawBitmap(avatar33, (avatarW3-(AsizeW3/2)), (avatarH3-(AsizeH3/2)),null);
						}else{
							avatar3 = false;
							wallet+=1;
							//Awork3 = false;
						}
				}
				//for the avatar back
				//backAH = (y+25)-(backsizeH/2);
				//backAW = (x+25)-(backsizeW/2);
				//To Draw the avatar back
				//now it's the mark
				if(Awork){
				Bitmap backavatar1 = Bitmap.createScaledBitmap(backavatar,(int)MarkAsizeW1 ,(int) MarkAsizeH1, true);
				canvas.drawBitmap(backavatar1, markAW1, markAH1,null);
				//To Draw the avatar 
				avatar = Bitmap.createScaledBitmap(A1o, AsizeW1, AsizeH1, true);
				canvas.drawBitmap(avatar, (avatarW1-(AsizeW1/2)), (avatarH1-(AsizeH1/2)),null);
				}
				//now it's the mark2
				if(Awork2){
				Bitmap backavatar2 = Bitmap.createScaledBitmap(backavatar,(int) MarkAsizeW2 ,(int) MarkAsizeH2, true);
				canvas.drawBitmap(backavatar2, markAW2, markAH2,null);
				//To Draw the avatar2 
				Bitmap avatar2 = Bitmap.createScaledBitmap(A2o, AsizeW2, AsizeH2, true);
				canvas.drawBitmap(avatar2, (avatarW2-(AsizeW2/2)), (avatarH2-(AsizeH2/2)),null);
				}
				if(Awork3){
					Bitmap backavatar13 = Bitmap.createScaledBitmap(backavatar,(int)MarkAsizeW3 ,(int) MarkAsizeH3, true);
					canvas.drawBitmap(backavatar13, markAW3, markAH3,null);
					//To Draw the avatar 
					Bitmap avatar33 = Bitmap.createScaledBitmap(A3o, AsizeW3, AsizeH3, true);
					canvas.drawBitmap(avatar33, (avatarW3-(AsizeW3/2)), (avatarH3-(AsizeH3/2)),null);
					}
				
				//the Score
				Paint score = new Paint();
				score.setColor(Color.GREEN);
				score.setTextSize(30);
				score.setTypeface(font);
				String ss = "the score is       "  +scorepoint;
				canvas.drawText(ss, canvas.getWidth() / 2-100, 30, score);
				
				//the game time
				Paint time = new Paint();
				time.setColor(Color.RED);
				time.setTextSize(30);
				time.setTypeface(font);
				theTime = theTime-80;
				String sss = "the game time is       "  +theTime;
				canvas.drawText(sss, 30, 30, time);
				
				
				//if(ballsTime <= 500){
				//	ballsTime = 700;
				//}

				
				//for all imprints
				//imprint 1
				if(makeImprint){
					
					stopimprint = System.currentTimeMillis();
					resultimprint = stopimprint - startimprint ; 
					
					if(resultimprint <= 1000){
					Bitmap imprint = BitmapFactory.decodeResource(getResources(),
							R.drawable.imprint);
					Bitmap imprint2 = Bitmap.createScaledBitmap(imprint,(2*sizeW),(2*sizeH), true);
					canvas.drawBitmap(imprint2, impW1, impH1, new Paint());
				}else{
					makeImprint = false;
				}
				}
				//imprint 2
				if(makeImprint2){
					
					stopimprint2 = System.currentTimeMillis();
					resultimprint2 = stopimprint2 - startimprint2 ; 
					
					if(resultimprint2 <= 1000){
					Bitmap imprint = BitmapFactory.decodeResource(getResources(),
							R.drawable.imprint);
					Bitmap imprint2 = Bitmap.createScaledBitmap(imprint,(2*sizeW2),(2*sizeH2), true);

					canvas.drawBitmap(imprint2, impW2, impH2, new Paint());
				}else{
					makeImprint2 = false;
				}
				}
				//imprint 3
				if(makeImprint3){
					
					stopimprint3 = System.currentTimeMillis();
					resultimprint3 = stopimprint3 - startimprint3 ; 
					
					if(resultimprint3 <= 1000){
					Bitmap imprint = BitmapFactory.decodeResource(getResources(),
							R.drawable.imprint);
					Bitmap imprint2 = Bitmap.createScaledBitmap(imprint,(2*sizeW3),(2*sizeH3), true);

					canvas.drawBitmap(imprint2, impW3, impH3, new Paint());
				}else{
					makeImprint3 = false;
				}
				}
				//imprint 4
				if(makeImprint4){
					
					stopimprint4 = System.currentTimeMillis();
					resultimprint4 = stopimprint4 - startimprint4 ; 
					
					if(resultimprint4 <= 1000){
					Bitmap imprint = BitmapFactory.decodeResource(getResources(),
							R.drawable.imprint);
					Bitmap imprint2 = Bitmap.createScaledBitmap(imprint,(2*sizeW4),(2*sizeH4), true);

					canvas.drawBitmap(imprint2, impW4, impH4, new Paint());
				}else{
					makeImprint4 = false;
				}
				}
				
				//imprint 5
				if(makeImprint5){
					
					stopimprint5 = System.currentTimeMillis();
					resultimprint5 = stopimprint5 - startimprint5 ; 
					
					if(resultimprint5 <= 1000){
					Bitmap imprint = BitmapFactory.decodeResource(getResources(),
							R.drawable.imprint);
					Bitmap imprint2 = Bitmap.createScaledBitmap(imprint,(2*sizeW5),(2*sizeH5), true);

					canvas.drawBitmap(imprint2, impW5, impH5, new Paint());
				}else{
					makeImprint5 = false;
				}
				}
				
				if((!avatar3 && avatar1 && avatar2 && wallet > 0)//||(avatar2 && avatar1 && wallet > 0)// && !Awork3 )//&& A3)
						){
				Paint green = new Paint();
				green.setColor(Color.BLUE);
				canvas.drawRect(canvas.getWidth() - (ScreenWidth/10) , 0,
						canvas.getWidth(),(ScreenHeight/10), green);
			} else if((!avatar2 && avatar1 && wallet >0)//||(avatar1 && avatar3 && wallet > 0)//&& !Awork2 )// && A2)
							){
					Paint green = new Paint();
					green.setColor(Color.MAGENTA);
					canvas.drawRect(canvas.getWidth() - (ScreenWidth/10) , 0,
							canvas.getWidth(),(ScreenHeight/10), green);
				}else if((!avatar1 && wallet > 0)//&& !Awork )// && A1)
						){
					Paint green = new Paint();
					green.setColor(Color.GREEN);
					canvas.drawRect(canvas.getWidth() - (ScreenWidth/10) , 0,
							canvas.getWidth(),(ScreenHeight/10), green);
				}else{
					Paint red = new Paint();
					red.setColor(Color.RED);
					canvas.drawRect(canvas.getWidth() - (ScreenWidth/10) , 0,
							canvas.getWidth(),(ScreenHeight/10), red);
				}
				
				if(TouchDown){
					Paint green = new Paint();
					green.setColor(Color.BLACK);
					canvas.drawRect(0 , (ScreenWidth/10),
							canvas.getWidth(),(ScreenHeight/10), green);
				}
				
				test = false;
				test = false;
				
				
				//show the avatar true and false
				//the Score
				Paint avatar = new Paint();
				avatar.setColor(Color.GRAY);
				avatar.setTextSize(10);
				avatar.setTypeface(font);
				String as = "avatar1 = "  +avatar1 +'\n' + "avatar2 = " + avatar2 + '\n' + "avatar3" 
				+ avatar3 + '\n' + "TouchDown = " + TouchDown +"        Awork3 = " + Awork3 ;
				canvas.drawText(as, (canvas.getWidth() /2)-300, (canvas.getHeight() /2) + 100, avatar);
				
				Paint avatar33 = new Paint();
				//avatar3.setColor(Color.RED);
				//avatar3.setTextSize(10);
				//avatar3.setTypeface(font);
				String as3 = "Awork = "  +Awork +'\n' + " Awork2 = " + Awork2 + '\n' +"  Awrok3 =" 
				+ Awork3 + '\n' + "A1 = " + A1 +"   A2 = " + A2 + "   A3 = " + A3;
				canvas.drawText(as3, (canvas.getWidth() /3), (canvas.getHeight() /2) + 300, avatar33);
				
				
				
				//for the Buttons and the Avatars
				if(BallInt > 0){
				Bitmap first = Bitmap.createScaledBitmap(theBall, chooseAsizeW , chooseAsizeH, true);
				canvas.drawBitmap(first, 0, 2*chooseAsizeH, null);
				}
				if(BoxFInt > 0){
				Bitmap second = Bitmap.createScaledBitmap(BoxesAfter, chooseAsizeW, chooseAsizeH, true);
				canvas.drawBitmap(second, 0, 3*chooseAsizeH , null);
				}
				if(BoxBInt > 0){
				Bitmap third = Bitmap.createScaledBitmap(BoxesBefore, chooseAsizeW, chooseAsizeH, true);
				canvas.drawBitmap(third, 0, 4*chooseAsizeH, null);		
				}
				if(rokyInt > 0){
				Bitmap second = Bitmap.createScaledBitmap(rock, chooseAsizeW, chooseAsizeH, true);
				canvas.drawBitmap(second, 0, 5*chooseAsizeH , null);
				}
				if(Ball2Int > 0){
				Bitmap third = Bitmap.createScaledBitmap(secondball, chooseAsizeW, chooseAsizeH, true);
				canvas.drawBitmap(third, 0, 6*chooseAsizeH, null);		
				}
				//the player photo
						Bitmap photo = Bitmap.createScaledBitmap(rock, chooseAsizeW/2, chooseAsizeH/2, true);
						canvas.drawBitmap(photo, canvas.getWidth()/2,0, null);
						
						pause = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
						Bitmap pause2 = Bitmap.createScaledBitmap(pause, chooseAsizeW, chooseAsizeH, true);
						canvas.drawBitmap(pause2, 0, 0, null);
						
						
						//canvas.drawBitmap(destroy, 0, (int) (DefBitmapWidth), width, height, sizeW, sizeH, true, null);

						
						//to stop the game and it will be intent soon in sha2 2allah
						if(theTime <= 0){
							if(!go1 && !go2 && !go3 && !go4 && !go5){
							theViewOfSurFace.pause();
							}
						}
						
						
						//for the map 
						Bitmap Map = Bitmap.createScaledBitmap(hadoodd, (canvas.getWidth()/4), (canvas.getHeight()/2), true);
						int mapW =  canvas.getWidth()-Map.getWidth();
						int mapH =  canvas.getHeight()-Map.getHeight();
						canvas.drawBitmap(Map,mapW, mapH,null);
						
						//for the avatars on the map
						if(avatar1){
						pointAW = (int) ((Map.getWidth()*avatarW1)/canvas.getWidth());
						pointAH = (int)((Map.getHeight()*AsizeH1)/canvas.getHeight());
						Bitmap point = Bitmap.createScaledBitmap(theBall, Map.getWidth()/8, Map.getWidth()/8, true);
						canvas.drawBitmap(point, pointAW + mapW, pointAH + mapH, null);
						}
						if(avatar2){
							pointAW2 = (int) ((Map.getWidth()*avatarW2)/canvas.getWidth());
							pointAH2 = (int)((Map.getHeight()*AsizeH2)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(theBall, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointAW2+ mapW, pointAH2 + mapH, null);
							}
						if(avatar3){
							pointAW3 = (int) ((Map.getWidth()*avatarW3)/canvas.getWidth());
							pointAH3 = (int)((Map.getHeight()*AsizeH3)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(theBall, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointAW3+ mapW, pointAH3 + mapH, null);
							}
						if(go1){
							pointBW = (int) ((Map.getWidth()*width)/canvas.getWidth());
							pointBH = (int)((Map.getHeight()*sizeH)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(backavatar, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointBW+ mapW, pointBH + mapH, null);
							}
						if(go2){
							pointBW2 = (int) ((Map.getWidth()*width2)/canvas.getWidth());
							pointBH2 = (int)((Map.getHeight()*sizeH2)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(backavatar, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointBW2+ mapW, pointBH2 + mapH, null);
							}
						if(go3){
							pointBW3 = (int) ((Map.getWidth()*width3)/canvas.getWidth());
							pointBH3 = (int)((Map.getHeight()*sizeH3)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(backavatar, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointBW3+ mapW, pointBH3 + mapH, null);
							}
						if(go4){
							pointBW4 = (int) ((Map.getWidth()*width4)/canvas.getWidth());
							pointBH4 = (int)((Map.getHeight()*sizeH4)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(backavatar, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointBW4+ mapW, pointBH4 + mapH, null);
							}
						if(go5){
							pointBW5 = (int) ((Map.getWidth()*width5)/canvas.getWidth());
							pointBH5 = (int)((Map.getHeight()*sizeH5)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(backavatar, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointBW5+ mapW, pointBH5 + mapH, null);
							}
						if(rok1){
							pointRW = (int) ((Map.getWidth()*rokW)/canvas.getWidth());
							pointRH = (int)((Map.getHeight()*roksizeH)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(rock, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointRW+ mapW, pointRH + mapH, null);
							}
						if(rok2){
							pointRW2 = (int) ((Map.getWidth()*rokW2)/canvas.getWidth());
							pointRH2 = (int)((Map.getHeight()*roksizeH2)/canvas.getHeight());
							Bitmap point = Bitmap.createScaledBitmap(rock, Map.getWidth()/8, Map.getWidth()/8, true);
							canvas.drawBitmap(point, pointRW2+ mapW, pointRH2 + mapH, null);
							}
						
				holder.unlockCanvasAndPost(canvas); // bya3rad alcanvas

			}

		}

	}


	

}

