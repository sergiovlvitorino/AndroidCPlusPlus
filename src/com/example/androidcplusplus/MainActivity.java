package com.example.androidcplusplus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText edResult;
	private EditText edValue1;
	private EditText edValue2;
	private Button btSum;
	private Button btSub;
	private Button btMult;
	private Button btDiv;
	private Button btClear;
	private Calculator calculator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		initializeComponents();
		configureButtons();
	}

	private void configureButtons() {
		btSum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final float value1 = parseValue(edValue1.getText().toString());
				final float value2 = parseValue(edValue2.getText().toString());
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						edResult.setText(Float.toString(calculator.sum(value1, value2)));
					}
				});
			}
		});
		
		btSub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final float value1 = parseValue(edValue1.getText().toString());
				final float value2 = parseValue(edValue2.getText().toString());
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						edResult.setText(Float.toString(calculator.sub(value1, value2)));
					}
				});
			}
		});
		
		btMult.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final float value1 = parseValue(edValue1.getText().toString());
				final float value2 = parseValue(edValue2.getText().toString());
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						edResult.setText(Float.toString(calculator.mult(value1, value2)));
					}
				});
			}
		});
		
		btDiv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final float value1 = parseValue(edValue1.getText().toString());
				final float value2 = parseValue(edValue2.getText().toString());
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if(value2 == 0.0f){
							Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.division_per_zero), Toast.LENGTH_SHORT).show();
						}else{
							edResult.setText(Float.toString(calculator.div(value1, value2)));
						}
					}
				});
			}
		});
		
		btClear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						edResult.setText("");
						edValue1.setText("");
						edValue2.setText("");
					}
				});
			}
		});
	}

	private void initializeComponents() {
		edResult = (EditText) findViewById(R.id.edResult);
		edValue1 = (EditText) findViewById(R.id.edValue1);
		edValue2 = (EditText) findViewById(R.id.edValue2);
		btSum = (Button) findViewById(R.id.btSum);
		btSub = (Button) findViewById(R.id.btSub);
		btMult = (Button) findViewById(R.id.btMult);
		btDiv = (Button) findViewById(R.id.btDiv);
		btClear = (Button) findViewById(R.id.btClear);
		calculator = new Calculator();
	}
	
	public float parseValue(String value){
		return Float.parseFloat(value == null || "".equals(value) ? "0" : value);
	}
	
}
