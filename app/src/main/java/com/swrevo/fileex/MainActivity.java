package com.swrevo.fileex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.button.*;
import android.widget.EditText;
import com.swrevo.fileex.ExFilePicker;
import android.view.View;
import android.widget.CompoundButton;
import com.bumptech.glide.Glide;
import com.allenliu.badgeview.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.appcompat.widget.*;

public class MainActivity extends  AppCompatActivity  { 
	
	
	private  static final int EX_FILE_PICKER_RESULT = 0;
	private String STR = "";
	private boolean setOnlyExtention = false;
	private boolean setExcludeExtention = false;
	private boolean setStartPath = false;
	
	private ArrayList<String> ls = new ArrayList<>();
	
	private LinearLayout linear1;
	private CardView cardview1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private ImageView imageview1;
	private LinearLayout linear3;
	private AppCompatCheckBox checkbox1;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private AppCompatCheckBox checkbox4;
	private AppCompatCheckBox checkbox5;
	private AppCompatCheckBox checkbox6;
	private AppCompatCheckBox checkbox7;
	private LinearLayout linear4;
	private AppCompatCheckBox checkbox9;
	private AppCompatCheckBox checkbox10;
	private AppCompatTextView textview1;
	private AppCompatRadioButton radiobutton1;
	private AppCompatRadioButton radiobutton2;
	private TextView tv1;
	private MaterialButton materialbutton1;
	private AppCompatCheckBox checkbox2;
	private EditText ext_type1;
	private TextView and;
	private EditText ext_type2;
	private AppCompatCheckBox checkbox3;
	private EditText ext_exclude;
	private AppCompatCheckBox checkbox8;
	private EditText path_name;
	
	private ExFilePicker exFilePicker;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		checkbox1 = (AppCompatCheckBox) findViewById(R.id.checkbox1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		checkbox4 = (AppCompatCheckBox) findViewById(R.id.checkbox4);
		checkbox5 = (AppCompatCheckBox) findViewById(R.id.checkbox5);
		checkbox6 = (AppCompatCheckBox) findViewById(R.id.checkbox6);
		checkbox7 = (AppCompatCheckBox) findViewById(R.id.checkbox7);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		checkbox9 = (AppCompatCheckBox) findViewById(R.id.checkbox9);
		checkbox10 = (AppCompatCheckBox) findViewById(R.id.checkbox10);
		textview1 = (AppCompatTextView) findViewById(R.id.textview1);
		radiobutton1 = (AppCompatRadioButton) findViewById(R.id.radiobutton1);
		radiobutton2 = (AppCompatRadioButton) findViewById(R.id.radiobutton2);
		tv1 = (TextView) findViewById(R.id.tv1);
		materialbutton1 = (MaterialButton) findViewById(R.id.materialbutton1);
		checkbox2 = (AppCompatCheckBox) findViewById(R.id.checkbox2);
		ext_type1 = (EditText) findViewById(R.id.ext_type1);
		and = (TextView) findViewById(R.id.and);
		ext_type2 = (EditText) findViewById(R.id.ext_type2);
		checkbox3 = (AppCompatCheckBox) findViewById(R.id.checkbox3);
		ext_exclude = (EditText) findViewById(R.id.ext_exclude);
		checkbox8 = (AppCompatCheckBox) findViewById(R.id.checkbox8);
		path_name = (EditText) findViewById(R.id.path_name);
		
		radiobutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					if (radiobutton2.isChecked()) {
						radiobutton2.setChecked(false);
					}
				}
			}
		});
		
		radiobutton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					if (radiobutton1.isChecked()) {
						radiobutton1.setChecked(false);
					}
				}
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				exFilePicker = new ExFilePicker();
				if (checkbox1.isChecked()) {
					exFilePicker.setCanChooseOnlyOneItem(true);
				}
				if (checkbox2.isChecked()) {
					exFilePicker.setShowOnlyExtensions(ext_type1.getText().toString(), ext_type2.getText().toString());
				}
				if (checkbox3.isChecked()) {
					exFilePicker.setExceptExtensions(ext_exclude.getText().toString());
				}
				if (checkbox4.isChecked()) {
					exFilePicker.setNewFolderButtonDisabled(true);
				}
				if (checkbox5.isChecked()) {
					exFilePicker.setSortButtonDisabled(true);
				}
				if (checkbox6.isChecked()) {
					exFilePicker.setQuitButtonEnabled(true);
				}
				if (checkbox7.isChecked()) {
					exFilePicker.setSortingType(ExFilePicker.SortingType.NAME_DESC);
				}
				if (checkbox8.isChecked()) {
					exFilePicker.setStartDirectory("/storage/emulated/0/".concat(path_name.getText().toString().concat("/")));
				}
				if (checkbox9.isChecked()) {
					exFilePicker.setUseFirstItemAsUpEnabled(true);
				}
				if (checkbox10.isChecked()) {
					exFilePicker.setHideHiddenFilesEnabled(true);
				}
				if (radiobutton1.isChecked()) {
					exFilePicker.setChoiceType(ExFilePicker.ChoiceType.FILES);
				}
				if (radiobutton2.isChecked()) {
					exFilePicker.setChoiceType(ExFilePicker.ChoiceType.DIRECTORIES);
				}
				exFilePicker.start(MainActivity.this, EX_FILE_PICKER_RESULT);
			}
		});
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					ext_type1.setVisibility(View.VISIBLE);
					ext_type2.setVisibility(View.VISIBLE);
					and.setVisibility(View.VISIBLE);
				}
				else {
					ext_type1.setVisibility(View.GONE);
					ext_type2.setVisibility(View.GONE);
					and.setVisibility(View.GONE);
				}
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					ext_exclude.setVisibility(View.VISIBLE);
				}
				else {
					ext_exclude.setVisibility(View.GONE);
				}
			}
		});
		
		checkbox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					path_name.setVisibility(View.VISIBLE);
				}
				else {
					path_name.setVisibility(View.GONE);
				}
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		AJCode.setBackgroundGradient(linear1, 0xFFE1F5FE, 0xFFF9FBE7);
		Glide.with(getApplicationContext()).load(Uri.parse("https://cdn.dribbble.com/users/527271/screenshots/6090255/file_explorer_icon_animation_3.gif")).into(imageview1);
		
		ext_exclude.setVisibility(View.GONE);
		path_name.setVisibility(View.GONE);
		ext_type1.setVisibility(View.GONE);
		ext_type2.setVisibility(View.GONE);
		and.setVisibility(View.GONE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); getWindow().setStatusBarColor(Color.TRANSPARENT);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
