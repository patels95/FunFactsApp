package com.example.funfacts;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends Activity {
	
	public static final String TAG = FunFactsActivity.class.getSimpleName(); 
	
	private FactBook mFactBook = new FactBook();
	private ColorWheel mColorWheel = new ColorWheel();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fun_facts);
		
		//Declare View variables and assign them the Views from the layout file
		final TextView factLabel = (TextView) findViewById(R.id.factTextView);
		final Button showFactButton = (Button) findViewById(R.id.showFactButton);
		final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
		
		View.OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String fact = mFactBook.getFact();
				int color = mColorWheel.getColor();
				factLabel.setText(fact);
				relativeLayout.setBackgroundColor(color);
				showFactButton.setTextColor(color);
				
			}
		};
		showFactButton.setOnClickListener(listener);
		
		
		
		
	}
}
