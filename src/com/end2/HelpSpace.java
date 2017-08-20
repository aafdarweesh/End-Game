package com.end2;

import java.util.Random;

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

public class HelpSpace extends Activity {

	Random rrr = new Random();
	SharedPreferences pref = getSharedPreferences("Space_Data", MODE_PRIVATE);
	Editor editor = pref.edit();
	float A1FX = 0, A1FY = 0, A1EX = 0, A1EY = 0, A2FX = 0, A2FY = 0, A2EX = 0,
			A2EY = 0, A3FX = 0, A3FY = 0, A3EX = 0, A3EY = 0;

	public void Go1(boolean firstTime, float width, float height, int sizeW,
			float[] allAWH, int canvasW, int canvasH, int w, int h,
			boolean go1, boolean avatar1, boolean avatar2, boolean avatar3,
			int wallet, int scorepoint, int AsizeW1, int AsizeW2, int AsizeW3,
			int DefBitmapWidth, boolean Awork, boolean Awork2, boolean Awork3,
			boolean actionWork1, Bitmap imprint1, Bitmap A1o, Bitmap A2o,
			Bitmap A3o) {

		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];

		// the place of the GOALKEEPER hand shouldn't be touched
		// at
		// the time
		// number 1
		if (avatar1 || avatar2 || avatar3) {
			if (avatar1) {
				if (((AsizeW1 / DefBitmapWidth) <= ((sizeW / DefBitmapWidth) + 1))// ((sizeW/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW / DefBitmapWidth) - 1))// ((sizeW/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A1FY >= height && A1FY <= (height + sizeW)
							&& A1FX >= width && A1FX <= (width + sizeW))
							// right bottom small
							|| (A1EY >= height && A1EY <= (height + sizeW)
									&& A1EX >= width && A1EX <= (width + sizeW))
							// left bottom small
							|| (A1EY >= height && A1EY <= (height + sizeW)
									&& A1FX >= width && A1FX <= (width + sizeW))
							// right top small
							|| (A1FY >= height && A1FY <= (height + sizeW)
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
						 * if(A1o == theBall) imprint1 = theBall; if(A1o ==
						 * BoxesBefore) imprint1 = BoxesBefore; if(A1o ==
						 * BoxesAfter) imprint1 = BoxesAfter; if(A1o ==
						 * secondball) imprint = secondball; if(A1o == rock)
						 * imprint = rock;
						 */

						// it's work but wants some changes and
						// make
						// three or four balls at the same time
					}
				}

			}

			if (avatar2) {
				if (((AsizeW2 / DefBitmapWidth) <= ((sizeW / DefBitmapWidth) + 1))// ((sizeW/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW / DefBitmapWidth) - 1))// ((sizeW/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A2FY >= height && A2FY <= (height + sizeW)
							&& A2FX >= width && A2FX <= (width + sizeW))
							// right bottom small
							|| (A2EY >= height && A2EY <= (height + sizeW)
									&& A2EX >= width && A2EX <= (width + sizeW))
							// left bottom small
							|| (A2EY >= height && A2EY <= (height + sizeW)
									&& A2FX >= width && A2FX <= (width + sizeW))
							// right top small
							|| (A2FY >= height && A2FY <= (height + sizeW)
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
				if (((AsizeW3 / DefBitmapWidth) <= ((sizeW / DefBitmapWidth) + 1))// ((sizeW/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW / DefBitmapWidth) - 1))// ((sizeW/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A3FY >= height && A3FY <= (height + sizeW)
							&& A3FX >= width && A3FX <= (width + sizeW))
							// right bottom small
							|| (A3EY >= height && A3EY <= (height + sizeW)
									&& A3EX >= width && A3EX <= (width + sizeW))
							// left bottom small
							|| (A3EY >= height && A3EY <= (height + sizeW)
									&& A3FX >= width && A3FX <= (width + sizeW))
							// right top small
							|| (A3FY >= height && A3FY <= (height + sizeW)
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

		int imprintInt = 0;
		if (imprint1 == A1o)
			imprintInt = 1;
		if (imprint1 == A2o)
			imprintInt = 2;
		if (imprint1 == A3o)
			imprintInt = 3;
		editor.putBoolean("actionWork1", actionWork1);
		editor.putInt("imprint1", imprintInt);
		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("FTB1", firstTime);
		editor.putBoolean("GO1", go1);
		//editor.putFloat("BW1", width);
		//editor.putFloat("BH1", height);
		//editor.putInt("BS1", sizeW);
		editor.putInt("Score", scorepoint);
		editor.putInt("Wallet", wallet);
		editor.commit();
		return;
	}

	public void Go2(boolean firstTime2, float width2, float height2,
			int sizeW2, float[] allAWH, int canvasW, int canvasH, int w, int h,
			boolean go2, boolean avatar1, boolean avatar2, boolean avatar3,
			int wallet, int scorepoint, int AsizeW1, int AsizeW2, int AsizeW3,
			int DefBitmapWidth, boolean Awork, boolean Awork2, boolean Awork3,
			boolean actionWork2, Bitmap imprint2, Bitmap A1o, Bitmap A2o,
			Bitmap A3o) {

		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];

		// the place of the GOALKEEPER hand shouldn't be touched
		// at
		// the time
		// this for the second ball
		if (avatar1 || avatar2 || avatar3) {
			if (avatar1) {
				if (((AsizeW1 / DefBitmapWidth) <= ((sizeW2 / DefBitmapWidth) + 1))// ((sizeW2/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW2 / DefBitmapWidth) - 1))// ((sizeW2/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A1FY >= height2 && A1FY <= (height2 + sizeW2)
							&& A1FX >= width2 && A1FX <= (width2 + sizeW2))
							// right bottom small
							|| (A1EY >= height2 && A1EY <= (height2 + sizeW2)
									&& A1EX >= width2 && A1EX <= (width2 + sizeW2))
							// left bottom small
							|| (A1EY >= height2 && A1EY <= (height2 + sizeW2)
									&& A1FX >= width2 && A1FX <= (width2 + sizeW2))
							// right top small
							|| (A1FY >= height2 && A1FY <= (height2 + sizeW2)
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
				if (((AsizeW2 / DefBitmapWidth) <= ((sizeW2 / DefBitmapWidth) + 1))// ((sizeW2/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW2 / DefBitmapWidth) - 1))// ((sizeW2/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A2FY >= height2 && A2FY <= (height2 + sizeW2)
							&& A2FX >= width2 && A2FX <= (width2 + sizeW2))
							// right bottom small
							|| (A2EY >= height2 && A2EY <= (height2 + sizeW2)
									&& A2EX >= width2 && A2EX <= (width2 + sizeW2))
							// left bottom small
							|| (A2EY >= height2 && A2EY <= (height2 + sizeW2)
									&& A2FX >= width2 && A2FX <= (width2 + sizeW2))
							// right top small
							|| (A2FY >= height2 && A2FY <= (height2 + sizeW2)
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
				if (((AsizeW3 / DefBitmapWidth) <= ((sizeW2 / DefBitmapWidth) + 1))// ((sizeW2/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW2 / DefBitmapWidth) - 1))// ((sizeW2/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A3FY >= height2 && A3FY <= (height2 + sizeW2)
							&& A3FX >= width2 && A3FX <= (width2 + sizeW2))
							// right bottom small
							|| (A3EY >= height2 && A3EY <= (height2 + sizeW2)
									&& A3EX >= width2 && A3EX <= (width2 + sizeW2))
							// left bottom small
							|| (A3EY >= height2 && A3EY <= (height2 + sizeW2)
									&& A3FX >= width2 && A3FX <= (width2 + sizeW2))
							// right top small
							|| (A3FY >= height2 && A3FY <= (height2 + sizeW2)
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

		int imprintInt = 0;
		if (imprint2 == A1o)
			imprintInt = 1;
		if (imprint2 == A2o)
			imprintInt = 2;
		if (imprint2 == A3o)
			imprintInt = 3;
		editor.putBoolean("actionWork2", actionWork2);
		editor.putInt("imprint2", imprintInt);
		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("FTB2", firstTime2);
		editor.putBoolean("GO2", go2);
		editor.putBoolean("AWB1", Awork);
		editor.putBoolean("AWB2", Awork2);
		editor.putBoolean("AWB3", Awork3);
		//editor.putInt("AS1", AsizeW1);
		//editor.putInt("AS2", AsizeW2);
		//editor.putInt("AS3", AsizeW3);
		//editor.putFloat("BW2", width2);
		//editor.putFloat("BH1", height2);
		//editor.putInt("BS2", sizeW2);
		//editor.putInt("Score", scorepoint);
		editor.putInt("Wallet", wallet);
		editor.commit();
		return;
	}

	public void Go3(boolean firstTime3, float width3, float height3,
			int sizeW3, float[] allAWH, int canvasW, int canvasH, int w, int h,
			boolean go3, boolean avatar1, boolean avatar2, boolean avatar3,
			int wallet, int scorepoint, int AsizeW1, int AsizeW2, int AsizeW3,
			int DefBitmapWidth, boolean Awork, boolean Awork2, boolean Awork3,
			boolean actionWork3, Bitmap imprint3, Bitmap A1o, Bitmap A2o,
			Bitmap A3o) {

		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];

		// the place of the GOALKEEPER hand shouldn't be touched
		// at
		// the time
		// this for the third ball
		if (avatar1 || avatar2 || avatar3) {
			if (avatar1) {

				if (((AsizeW1 / DefBitmapWidth) <= ((sizeW3 / DefBitmapWidth) + 1))// ((sizeW3/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW3 / DefBitmapWidth) - 1))// ((sizeW3/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A1FY >= height3 && A1FY <= (height3 + sizeW3)
							&& A1FX >= width3 && A1FX <= (width3 + sizeW3))
							// right bottom small
							|| (A1EY >= height3 && A1EY <= (height3 + sizeW3)
									&& A1EX >= width3 && A1EX <= (width3 + sizeW3))
							// left bottom small
							|| (A1EY >= height3 && A1EY <= (height3 + sizeW3)
									&& A1FX >= width3 && A1FX <= (width3 + sizeW3))
							// right top small
							|| (A1FY >= height3 && A1FY <= (height3 + sizeW3)
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
				if (((AsizeW2 / DefBitmapWidth) <= ((sizeW3 / DefBitmapWidth) + 1))// ((sizeW3/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW3 / DefBitmapWidth) - 1))// ((sizeW3/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A2FY >= height3 && A2FY <= (height3 + sizeW3)
							&& A2FX >= width3 && A2FX <= (width3 + sizeW3))
							// right bottom small
							|| (A2EY >= height3 && A2EY <= (height3 + sizeW3)
									&& A2EX >= width3 && A2EX <= (width3 + sizeW3))
							// left bottom small
							|| (A2EY >= height3 && A2EY <= (height3 + sizeW3)
									&& A2FX >= width3 && A2FX <= (width3 + sizeW3))
							// right top small
							|| (A2FY >= height3 && A2FY <= (height3 + sizeW3)
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
				if (((AsizeW3 / DefBitmapWidth) <= ((sizeW3 / DefBitmapWidth) + 1))// ((sizeW3/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW3 / DefBitmapWidth) - 1))// ((sizeW3/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A3FY >= height3 && A3FY <= (height3 + sizeW3)
							&& A3FX >= width3 && A3FX <= (width3 + sizeW3))
							// right bottom small
							|| (A3EY >= height3 && A3EY <= (height3 + sizeW3)
									&& A3EX >= width3 && A3EX <= (width3 + sizeW3))
							// left bottom small
							|| (A3EY >= height3 && A3EY <= (height3 + sizeW3)
									&& A3FX >= width3 && A3FX <= (width3 + sizeW3))
							// right top small
							|| (A3FY >= height3 && A3FY <= (height3 + sizeW3)
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

		int imprintInt = 0;
		if (imprint3 == A1o)
			imprintInt = 1;
		if (imprint3 == A2o)
			imprintInt = 2;
		if (imprint3 == A3o)
			imprintInt = 3;
		editor.putBoolean("actionWork3", actionWork3);
		editor.putInt("imprint3", imprintInt);
		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("FTB3", firstTime3);
		editor.putBoolean("GO3", go3);
		editor.putBoolean("AWB1", Awork);
		editor.putBoolean("AWB2", Awork2);
		editor.putBoolean("AWB3", Awork3);
		//editor.putInt("AS1", AsizeW1);
		//editor.putInt("AS2", AsizeW2);
		//editor.putInt("AS3", AsizeW3);
		//editor.putFloat("BW3", width3);
		//editor.putFloat("BH1", height3);
		//editor.putInt("BS3", sizeW3);
		editor.putInt("Score", scorepoint);
		editor.putInt("Wallet", wallet);
		editor.commit();
		return;
	}

	public void Go4(boolean firstTime4, float width4, float height4,
			int sizeW4, float[] allAWH, int canvasW, int canvasH, int w, int h,
			boolean go4, boolean avatar1, boolean avatar2, boolean avatar3,
			int wallet, int scorepoint, int AsizeW1, int AsizeW2, int AsizeW3,
			int DefBitmapWidth, boolean Awork, boolean Awork2, boolean Awork3,
			boolean actionWork4, Bitmap imprint4, Bitmap A1o, Bitmap A2o,
			Bitmap A3o) {

		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];

		// the place of the GOALKEEPER hand shouldn't be touched
		// at
		// the time
		// this for the fourth ball
		if (avatar1 || avatar2 || avatar3) {
			if (avatar1) {
				if (((AsizeW1 / DefBitmapWidth) <= ((sizeW4 / DefBitmapWidth) + 1))// ((sizeW4/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW4 / DefBitmapWidth) - 1))// ((sizeW4/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A1FY >= height4 && A1FY <= (height4 + sizeW4)
							&& A1FX >= width4 && A1FX <= (width4 + sizeW4))
							// right bottom small
							|| (A1EY >= height4 && A1EY <= (height4 + sizeW4)
									&& A1EX >= width4 && A1EX <= (width4 + sizeW4))
							// left bottom small
							|| (A1EY >= height4 && A1EY <= (height4 + sizeW4)
									&& A1FX >= width4 && A1FX <= (width4 + sizeW4))
							// right top small
							|| (A1FY >= height4 && A1FY <= (height4 + sizeW4)
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
				if (((AsizeW2 / DefBitmapWidth) <= ((sizeW4 / DefBitmapWidth) + 1))// ((sizeW4/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW4 / DefBitmapWidth) - 1))// ((sizeW4/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A2FY >= height4 && A2FY <= (height4 + sizeW4)
							&& A2FX >= width4 && A2FX <= (width4 + sizeW4))
							// right bottom small
							|| (A2EY >= height4 && A2EY <= (height4 + sizeW4)
									&& A2EX >= width4 && A2EX <= (width4 + sizeW4))
							// left bottom small
							|| (A2EY >= height4 && A2EY <= (height4 + sizeW4)
									&& A2FX >= width4 && A2FX <= (width4 + sizeW4))
							// right top small
							|| (A2FY >= height4 && A2FY <= (height4 + sizeW4)
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
				if (((AsizeW3 / DefBitmapWidth) <= ((sizeW4 / DefBitmapWidth) + 1))// ((sizeW4/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW4 / DefBitmapWidth) - 1))// ((sizeW4/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A3FY >= height4 && A3FY <= (height4 + sizeW4)
							&& A3FX >= width4 && A3FX <= (width4 + sizeW4))
							// right bottom small
							|| (A3EY >= height4 && A3EY <= (height4 + sizeW4)
									&& A3EX >= width4 && A3EX <= (width4 + sizeW4))
							// left bottom small
							|| (A3EY >= height4 && A3EY <= (height4 + sizeW4)
									&& A3FX >= width4 && A3FX <= (width4 + sizeW4))
							// right top small
							|| (A3FY >= height4 && A3FY <= (height4 + sizeW4)
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

		int imprintInt = 0;
		if (imprint4 == A1o)
			imprintInt = 1;
		if (imprint4 == A2o)
			imprintInt = 2;
		if (imprint4 == A3o)
			imprintInt = 3;
		editor.putBoolean("actionWork4", actionWork4);
		editor.putInt("imprint4", imprintInt);
		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("FTB4", firstTime4);
		editor.putBoolean("GO4", go4);
		editor.putBoolean("AWB1", Awork);
		editor.putBoolean("AWB2", Awork2);
		editor.putBoolean("AWB3", Awork3);
		//editor.putInt("AS1", AsizeW1);
		//editor.putInt("AS2", AsizeW2);
		//editor.putInt("AS3", AsizeW3);
		//editor.putFloat("BW1", width4);
		//editor.putInt("BS4", sizeW4);
		editor.putInt("Score", scorepoint);
		editor.putInt("Wallet", wallet);
		editor.commit();
		return;
	}

	public void Go5(boolean firstTime5, float width5, float height5,
			int sizeW5, float[] allAWH, int canvasW, int canvasH, int w, int h,
			boolean go5, boolean avatar1, boolean avatar2, boolean avatar3,
			int wallet, int scorepoint, int AsizeW1, int AsizeW2, int AsizeW3,
			int DefBitmapWidth, boolean Awork, boolean Awork2, boolean Awork3,
			boolean actionWork5, Bitmap imprint5, Bitmap A1o, Bitmap A2o,
			Bitmap A3o) {

		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];

		// the place of the GOALKEEPER hand shouldn't be touched
		// at
		// the time
		// this for the fourth ball
		if (avatar1 || avatar2 || avatar3) {
			if (avatar1) {
				if (((AsizeW1 / DefBitmapWidth) <= ((sizeW5 / DefBitmapWidth) + 1))// ((sizeW5/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW1 / DefBitmapWidth) >= ((sizeW5 / DefBitmapWidth) - 1))// ((sizeW5/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A1FY >= height5 && A1FY <= (height5 + sizeW5)
							&& A1FX >= width5 && A1FX <= (width5 + sizeW5))
							// right bottom small
							|| (A1EY >= height5 && A1EY <= (height5 + sizeW5)
									&& A1EX >= width5 && A1EX <= (width5 + sizeW5))
							// left bottom small
							|| (A1EY >= height5 && A1EY <= (height5 + sizeW5)
									&& A1FX >= width5 && A1FX <= (width5 + sizeW5))
							// right top small
							|| (A1FY >= height5 && A1FY <= (height5 + sizeW5)
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
				if (((AsizeW2 / DefBitmapWidth) <= ((sizeW5 / DefBitmapWidth) + 1))// ((sizeW5/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW2 / DefBitmapWidth) >= ((sizeW5 / DefBitmapWidth) - 1))// ((sizeW5/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A2FY >= height5 && A2FY <= (height5 + sizeW5)
							&& A2FX >= width5 && A2FX <= (width5 + sizeW5))
							// right bottom small
							|| (A2EY >= height5 && A2EY <= (height5 + sizeW5)
									&& A2EX >= width5 && A2EX <= (width5 + sizeW5))
							// left bottom small
							|| (A2EY >= height5 && A2EY <= (height5 + sizeW5)
									&& A2FX >= width5 && A2FX <= (width5 + sizeW5))
							// right top small
							|| (A2FY >= height5 && A2FY <= (height5 + sizeW5)
									&& A2EX >= width5 && A2EX <= (width5 + sizeW5))

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
				if (((AsizeW3 / DefBitmapWidth) <= ((sizeW5 / DefBitmapWidth) + 1))// ((sizeW5/canvasW)
																					// +
																					// (canvasW/1000)))
						&& ((AsizeW3 / DefBitmapWidth) >= ((sizeW5 / DefBitmapWidth) - 1))// ((sizeW5/canvasW)
																							// -
																							// (canvasW/1000)))
				) {
					if (
					// left top small
					(A3FY >= height5 && A3FY <= (height5 + sizeW5)
							&& A3FX >= width5 && A3FX <= (width5 + sizeW5))
							// right bottom small
							|| (A3EY >= height5 && A3EY <= (height5 + sizeW5)
									&& A3EX >= width5 && A3EX <= (width5 + sizeW5))
							// left bottom small
							|| (A3EY >= height5 && A3EY <= (height5 + sizeW5)
									&& A3FX >= width5 && A3FX <= (width5 + sizeW5))
							// right top small
							|| (A3FY >= height5 && A3FY <= (height5 + sizeW5)
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

		int imprintInt = 0;
		if (imprint5 == A1o)
			imprintInt = 1;
		if (imprint5 == A2o)
			imprintInt = 2;
		if (imprint5 == A3o)
			imprintInt = 3;
		editor.putBoolean("actionWork5", actionWork5);
		editor.putInt("imprint5", imprintInt);

		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("FTB5", firstTime5);
		editor.putBoolean("GO5", go5);
		editor.putBoolean("AWB1", Awork);
		editor.putBoolean("AWB2", Awork2);
		editor.putBoolean("AWB3", Awork3);
		//editor.putInt("AS1", AsizeW1);
		//editor.putInt("AS2", AsizeW2);
		//editor.putInt("AS3", AsizeW3);
		//editor.putFloat("BW1", width5);
		//editor.putFloat("BH1", height5);
		//editor.putInt("BS5", sizeW5);
		editor.putInt("Score", scorepoint);
		editor.putInt("Wallet", wallet);
		editor.commit();
		return;
	}

	public void Rok1andAvatar(boolean avatar1, boolean avatar2,
			boolean avatar3, int AsizeW1, int AsizeW2, int AsizeW3,
			int roksizeW, float rokW, float rokH, float[] allAWH, int canvasW,
			int canvasH, int wallet, boolean Awork, boolean Awork2,
			boolean Awork3, boolean rok1) {

		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];

		if (avatar1) {
			// for the avatar1
			if (((AsizeW1 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(AsizeW1/canvasW))
																		// <=
																		// ((roksizeW/canvasW)
																		// +
																		// (canvasW/1000)))
					&& ((AsizeW1 / canvasW) >= ((roksizeW / canvasW) - (1)))// ((2*(AsizeW1/canvasW))
																			// >=
																			// ((roksizeW/canvasW)
																			// -
																			// (canvasW/1000)))
					&& ((A1FY >= rokH && A1FY <= (rokH + roksizeW)
							&& A1FX >= rokW && A1FX <= (rokW + roksizeW))
							// right bottom small
							|| (A1EY >= rokH && A1EY <= (rokH + roksizeW)
									&& A1EX >= rokW && A1EX <= (rokW + roksizeW))
							// left bottom small
							|| (A1EY >= rokH && A1EY <= (rokH + roksizeW)
									&& A1FX >= rokW && A1FX <= (rokW + roksizeW))
					// right top small
					|| (A1FY >= rokH && A1FY <= (rokH + roksizeW)
							&& A1EX >= rokW && A1EX <= (rokW + roksizeW)))) {
				avatar1 = false;
				Awork = false;
				wallet += 1;

				rok1 = false;
			}
		}
		if (avatar2) {
			// for the avatar2
			if (((AsizeW2 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(AsizeW2/canvasW))
																		// <=
																		// ((roksizeW/canvasW)
																		// +
																		// (canvasW/1000)))
					&& ((AsizeW2 / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																			// ((2*(AsizeW2/canvasW))
																			// >=
																			// ((roksizeW/canvasW)
																			// -
																			// (canvasW/1000)))
					&& ((A2FY >= rokH && A2FY <= (rokH + roksizeW)
							&& A2FX >= rokW && A2FX <= (rokW + roksizeW))
							// right bottom small
							|| (A2EY >= rokH && A2EY <= (rokH + roksizeW)
									&& A2EX >= rokW && A2EX <= (rokW + roksizeW))
							// left bottom small
							|| (A2EY >= rokH && A2EY <= (rokH + roksizeW)
									&& A2FX >= rokW && A2FX <= (rokW + roksizeW))
					// right top small
					|| (A2FY >= rokH && A2FY <= (rokH + roksizeW)
							&& A2EX >= rokW && A2EX <= (rokW + roksizeW)))) {
				avatar2 = false;
				Awork2 = false;
				wallet += 1;

				rok1 = false;
			}
		}
		if (avatar3) {
			// for the avatar3
			if (((AsizeW3 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(AsizeW3/canvasW))
																		// <=
																		// (((roksizeW/canvasW)
																		// +
																		// (canvasW/1000))))
					&& ((AsizeW3 / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																			// ((2*(AsizeW3/canvasW))
																			// >=
																			// (((roksizeW/canvasW)
																			// -
																			// (canvasW/1000))))
					&& ((A3FY >= rokH && A3FY <= (rokH + roksizeW)
							&& A3FX >= rokW && A3FX <= (rokW + roksizeW))
							// right bottom small
							|| (A3EY >= rokH && A3EY <= (rokH + roksizeW)
									&& A3EX >= rokW && A3EX <= (rokW + roksizeW))
							// left bottom small
							|| (A3EY >= rokH && A3EY <= (rokH + roksizeW)
									&& A3FX >= rokW && A3FX <= (rokW + roksizeW))
					// right top small
					|| (A3FY >= rokH && A3FY <= (rokH + roksizeW)
							&& A3EX >= rokW && A3EX <= (rokW + roksizeW)))) {
				avatar3 = false;
				Awork3 = false;
				wallet += 1;

				rok1 = false;
			}
		}

		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("RB1", rok1);
		editor.putBoolean("AWB1", Awork);
		editor.putBoolean("AWB2", Awork2);
		editor.putBoolean("AWB3", Awork3);
		editor.putInt("Wallet", wallet);
		editor.commit();

		return;
	}

	public void Rok1andGos(boolean go1, boolean go2, boolean go3, boolean go4,
			boolean go5, int sizeW, int sizeW2, int sizeW3, int sizeW4,
			int sizeW5, int roksizeW, float rokW, float rokH, float width,
			float height, float width2, float width3, float width4,
			float width5, float height2, float height3, float height4,
			float height5, int canvasW, int canvasH, boolean rok1) {
		
		
		
		
		if(go1){
			// for the go1
			if (((sizeW / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(sizeW/canvasW))
																			// <=
																			// (((roksizeW/canvasW)
																			// +
																			// (canvasW/1000))))
					&& ((sizeW / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																					// ((2*(sizeW/canvasW))
																					// >=
																					// (((roksizeW/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go2){
			// for the go2
			if (((sizeW2 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(sizeW2/canvasW))
																			// <=
																			// (((roksizeW/canvasW)
																			// +
																			// (canvasW/1000))))
					&& ((sizeW2 / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																					// ((2*(sizeW2/canvasW))
																					// >=
																					// (((roksizeW/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go3){
			// for the go3
			if (((sizeW3 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(sizeW3/canvasW))
																			// <=
																			// (((roksizeW/canvasW)
																			// +
																			// (canvasW/1000))))
					&& ((sizeW3 / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																					// ((2*(sizeW3/canvasW))
																					// >=
																					// (((roksizeW/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go4){
			// for the go4
			if (((sizeW4 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(sizeW4/canvasW))
																			// <=
																			// (((roksizeW/canvasW)
																			// +
																			// (canvasW/1000))))
					&& ((sizeW4 / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																					// ((2*(sizeW4/canvasW))
																					// >=
																					// (((roksizeW/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go5){
			// for the go5
			if (((sizeW5 / canvasW) <= ((roksizeW / canvasW) + (1)))// ((2*(sizeW5/canvasW))
																			// <=
																			// (((roksizeW/canvasW)
																			// +
																			// (canvasW/1000))))
					&& ((sizeW5 / canvasW) >= ((roksizeW / canvasW) - (1)))// &&
																					// ((2*(sizeW5/canvasW))
																					// >=
																					// (((roksizeW/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
		
		
			
			editor.putBoolean("GO1", go1);
			editor.putBoolean("GO2", go2);
			editor.putBoolean("GO3", go3);
			editor.putBoolean("GO4", go4);
			editor.putBoolean("GO5", go5);
			editor.putBoolean("RB1", rok1);
			editor.commit();
		
		return;
	}

	public void Rok2andAvatar(boolean avatar1, boolean avatar2,
			boolean avatar3, int AsizeW1, int AsizeW2, int AsizeW3,
			int roksizeW2, float rokW2, float rokH2, float[] allAWH, int canvasW,
			int canvasH, int wallet, boolean Awork, boolean Awork2,
			boolean Awork3, boolean rok2) {
		
		
		A1FX = allAWH[0];
		A1FY = allAWH[1];
		A1EX = allAWH[2];
		A1EY = allAWH[3];
		A2FX = allAWH[4];
		A2FY = allAWH[5];
		A2EX = allAWH[6];
		A2EY = allAWH[7];
		A3FX = allAWH[8];
		A3FY = allAWH[9];
		A3EX = allAWH[10];
		A3EY = allAWH[11];
		
		
		if(avatar1){
			if (((AsizeW1 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(AsizeW1/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((AsizeW1 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																						// ((2*(AsizeW1/canvasW))
																						// >=
																						// (((roksizeW2/canvasW)
																						// -
																						// (canvasW/1000))))
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
			}
			if(avatar2){
			// for the avatar2
			if (((AsizeW2 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(AsizeW2/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((AsizeW2 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																						// ((2*(AsizeW2/canvasW))
																						// >=
																						// (((roksizeW2/canvasW)
																						// -
																						// (canvasW/1000))))
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
			}
			if(avatar3){
			// for the avatar3
			if (((AsizeW3 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(AsizeW3/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((AsizeW3 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																						// ((2*(AsizeW3/canvasW))
																						// >=
																						// (((roksizeW2/canvasW)
																						// -
																						// (canvasW/1000))))
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
			}
		
		
		
		editor.putBoolean("AB1", avatar1);
		editor.putBoolean("AB2", avatar2);
		editor.putBoolean("AB3", avatar3);
		editor.putBoolean("RB2", rok2);
		editor.putBoolean("AWB1", Awork);
		editor.putBoolean("AWB2", Awork2);
		editor.putBoolean("AWB3", Awork3);
		editor.putInt("Wallet", wallet);
		editor.commit();

		
		
		return;
	}

	public void Rok2andGos(boolean go1, boolean go2, boolean go3, boolean go4,
			boolean go5, int sizeW, int sizeW2, int sizeW3, int sizeW4,
			int sizeW5, int roksizeW2, float rokW2, float rokH2, float width,
			float height, float width2, float width3, float width4,
			float width5, float height2, float height3, float height4,
			float height5, int canvasW, int canvasH, boolean rok2) {
		
		
		
		if(go1){
			// for the go1
			if (((sizeW / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(sizeW/canvasW))
																			// <=
																			// (((roksizeW2/canvasW)
																			// +
																			// (canvasW/1000))))
					&& ((sizeW / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																					// ((2*(sizeW/canvasW))
																					// >=
																					// (((roksizeW2/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}
			if(go2){
			// for the go2
			if (((sizeW2 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(sizeW2/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((sizeW2 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																					// ((2*(sizeW2/canvasW))
																					// >=
																					// (((roksizeW2/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go3){
			// for the go3
			if (((sizeW3 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(sizeW3/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((sizeW3 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																					// ((2*(sizeW3/canvasW))
																					// >=
																					// (((roksizeW2/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go4){
			// for the go4
			if (((sizeW4 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(sizeW4/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((sizeW4 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																					// ((2*(sizeW4/canvasW))
																					// >=
																					// (((roksizeW2/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}}
			if(go5){
			// for the go5
			if (((sizeW5 / canvasW) <= ((roksizeW2 / canvasW) + (1)))// ((2*(sizeW5/canvasW))
																				// <=
																				// (((roksizeW2/canvasW)
																				// +
																				// (canvasW/1000))))
					&& ((sizeW5 / canvasW) >= ((roksizeW2 / canvasW) - (1)))// &&
																					// ((2*(sizeW5/canvasW))
																					// >=
																					// (((roksizeW2/canvasW)
																					// -
																					// (canvasW/1000))))
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
			}
		
		
		editor.putBoolean("GO1", go1);
		editor.putBoolean("GO2", go2);
		editor.putBoolean("GO3", go3);
		editor.putBoolean("GO4", go4);
		editor.putBoolean("GO5", go5);
		editor.putBoolean("RB2", rok2);
		editor.commit();
	
		
		return;
	}

}
