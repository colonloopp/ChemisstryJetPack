package com.chemisstry.chemisstry.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.chemisstry.chemisstry.R;

public class Circle extends View {

    private static final int START_ANGLE_POINT = 90;

    private final Paint paint;
    private final RectF rect;

    private float angle;
    private float density = 0;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        density = context.getResources().getDisplayMetrics().density;
        final int strokeWidth = 14;

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(Color.parseColor("#D782FF"));

        rect = new RectF();
        rect.set(8, 8, dpToPx(((int) ((int) 600 / getResources().getDisplayMetrics().density)), context), dpToPx(((int) ((int) 600 / getResources().getDisplayMetrics().density)), context));

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, 0, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }
}