package com.endgame;

import java.util.Arrays;
import java.util.Comparator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.SurfaceHolder;

public class ViewClass extends Activity {

	SurfaceHolder holder;
	// Bitmap A1 , A2 , A3 , B1 , B2 , B3 , B4 , B5 , AW1 , AH1 , AW2 , AH2 ,
	// AW3 , AH3 , BW1 , BH1 , BW2 , BH2 , BW3 , BW4 , BW5 , BH3 , BH4 , BH5 ;
	// int Time , Score;
	private int rotation = 0;

	public void ViewClass(Context context, Bitmap A1, Bitmap A2, Bitmap A3,
			Bitmap B1, Bitmap B2, Bitmap B3, Bitmap B4, Bitmap B5, Bitmap R1,
			Bitmap R2, float AW1, float AH1, float AW2, float AH2, float AW3,
			float AH3, float BW1, float BH1, float BW2, float BH2, float BW3,
			float BW4, float BW5, float BH3, float BH4, float BH5, float RW1,
			float RH1, float RW2, float RH2, int Time, int Score, boolean A1B,
			boolean A2B, boolean A3B, boolean B1B, boolean B2B, boolean B3B,
			boolean B4B, boolean B5B, boolean R1B, boolean R2B ) {
		// TODO Auto-generated constructor stub
		Canvas canvas = holder.lockCanvas(); // ma3naha private
		canvas.drawColor(Color.BLACK);// momkan ta3'ayaroo 3lshan yab2a
										// 2albackground

		Integer[] Sizes = { A1.getWidth(), A2.getWidth(), A3.getWidth(),
				B1.getWidth(), B2.getWidth(), B3.getWidth(), B4.getWidth(),
				B5.getWidth(), R1.getWidth(), R2.getWidth() };
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
			if (B1.getWidth() == Sizes[i] && B1B) {
				canvas.drawBitmap(B1, BW1, BH1, null);
			}
			if (B2.getWidth() == Sizes[i] && B2B) {
				canvas.drawBitmap(B2, BW2, BH2, null);
			}
			if (B3.getWidth() == Sizes[i] && B3B) {
				canvas.drawBitmap(B3, BW3, BH3, null);
			}
			if (B4.getWidth() == Sizes[i] && B4B) {
				canvas.drawBitmap(B4, BW4, BH4, null);
			}
			if (B5.getWidth() == Sizes[i] && B5B) {
				canvas.drawBitmap(B5, BW5, BH5, null);
			}
			if (R1.getWidth() == Sizes[i] && R1B) {
				Bitmap rok11 = Bitmap.createScaledBitmap(R1, R1.getWidth(),
						R1.getWidth(), true);
				matrix.setRotate(rotation, R1.getWidth(), R1.getWidth());
				Bitmap rotatedBitmap = Bitmap.createBitmap(rok11, 0, 0, R1.getWidth(),
						R1.getWidth(), matrix, true);
				canvas.drawBitmap(rotatedBitmap, RW1, RH1, null);
			}
			if (R2.getWidth() == Sizes[i] && R2B) {
				Bitmap rok22 = Bitmap.createScaledBitmap(R2, R2.getWidth(),
						R2.getWidth(), true);
				matrix.setRotate(rotation, R2.getWidth(), R2.getWidth());
				Bitmap rotatedBitmap2 = Bitmap.createBitmap(rok22, 0, 0,
						R2.getWidth(), R2.getWidth(), matrix, true);
				canvas.drawBitmap(rotatedBitmap2, RW2, RH2, null);
			}
			if (A1.getWidth() == Sizes[i] && A1B) {
				canvas.drawBitmap(A1, (AW1 - (A1.getWidth() / 2)),
						(AH1 - (A1.getWidth() / 2)), null);
			}
			if (A2.getWidth() == Sizes[i] && A2B) {
				canvas.drawBitmap(A2, (AW2 - (A2.getWidth() / 2)),
						(AH2 - (A2.getWidth() / 2)), null);
			}
			if (A3.getWidth() == Sizes[i] && A3B) {
				canvas.drawBitmap(A3, (AW3 - (A3.getWidth() / 2)),
						(AH3 - (A3.getWidth() / 2)), null);

			}
		}
		

		holder.unlockCanvasAndPost(canvas); // bya3rad alcanvas
		// Intent i = new Intent(ViewClass.this , WorkClassEdited.class);
		// startActivity(i);
		return;
	}

}
