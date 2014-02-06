package de.time_lapse_diary.photo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class GridOverlayView extends View {

    private static String TAG = "tld";

    Paint paint = new Paint();

    public GridOverlayView(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawGrid(canvas);
    }

    private void drawGrid(final Canvas canvas) {
        // TODO draw grid

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawRect(30, 30, 80, 80, paint);
    }
}
