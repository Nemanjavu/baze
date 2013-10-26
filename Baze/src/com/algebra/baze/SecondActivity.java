package com.algebra.baze;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SecondActivity extends Activity {

	private ListView nListView;
	private CustomStudentAdapter nAdapter;
	private ArrayList<Student> nStudents;
	private DataBase nDataBase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		nDataBase = new DataBase(this);

		nStudents = nDataBase.helper.getAllStudents();

		nListView = (ListView) findViewById(R.id.listView_student);

		nAdapter = new CustomStudentAdapter(this, nStudents);

		nListView.setAdapter(nAdapter);
	}

}
