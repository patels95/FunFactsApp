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
	private static final String KEY_FACT = "KEY_FACT";
	private static final String KEY_COLOR = "KEY_COLOR";

	private FactBook mFactBook = new FactBook();
	private ColorWheel mColorWheel = new ColorWheel();
	private String mFact = mFactBook.mfacts[0];
	private int mColor = Color.parseColor(mColorWheel.mColors[0]);

	private TextView mFactLabel;
	private Button mShowFactButton;
	private RelativeLayout mRelativeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fun_facts);
		
		//Declare View variables and assign them the Views from the layout file
		mFactLabel = (TextView) findViewById(R.id.factTextView);
		mShowFactButton = (Button) findViewById(R.id.showFactButton);
		mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
		
		View.OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mFact = mFactBook.getFact();
				mColor = mColorWheel.getColor();
				mFactLabel.setText(mFact);
				mRelativeLayout.setBackgroundColor(mColor);
				mShowFactButton.setTextColor(mColor);
				
			}
		};
		mShowFactButton.setOnClickListener(listener);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString(KEY_FACT, mFact);
		outState.putInt(KEY_COLOR, mColor);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		mFact = savedInstanceState.getString(KEY_FACT);
		mColor = savedInstanceState.getInt(KEY_COLOR);

		// update view
		mFactLabel.setText(mFact);
		mRelativeLayout.setBackgroundColor(mColor);
		mShowFactButton.setTextColor(mColor);
	}
}
