package de.time_lapse_diary;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static String tag = "tld";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 GridView gridview = (GridView) findViewById(R.id.gridview);
		    gridview.setAdapter(new ImageAdapter(this));
		    		
		    	OnItemClickListener v =	new AdapterView.OnItemClickListener() {
		        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
		        }
		    };
		    gridview.setOnItemClickListener(v);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                // settings clicked
                break;
            default:
                Log.w(tag,"Unknown Option selected");
        }

        return true;
    }
}
