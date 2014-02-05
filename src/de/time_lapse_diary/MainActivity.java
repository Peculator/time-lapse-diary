package de.time_lapse_diary;

import java.util.ArrayList;
import android.content.Intent;
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
	private GridviewAdapter mAdapter;
    private ArrayList<String> listNames;
    private ArrayList<Integer> listIDs;
    
    private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 // prepared arraylist and passed it to the Adapter class
		prepareList();
		
        mAdapter = new GridviewAdapter(this,listNames, listIDs);
 
        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(mAdapter);

        gridView.setAdapter(new ImageAdapter(this));

        OnItemClickListener v =	new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(MainActivity.this, PhotoActivity.class);
                    startActivity(myIntent);
                } else
                    Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        };
        gridview.setOnItemClickListener(v);

	}
	
	public void prepareList()
    {
          listNames = new ArrayList<String>();
 
          listNames.add("india");
          listNames.add("Brazil");
          
          listIDs = new ArrayList<Integer>();
          listIDs.add(R.drawable.ic_launcher);
          listIDs.add(R.drawable.ic_launcher);
          
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
			Log.w(tag, "Unknown Option selected");
		}

		return true;
	}
}
