package com.algebra.baze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private EditText e_ime, e_prezime, e_index, e_godina;
	private Button sacuvaj, prikazi;

	private DataBase nDatabase;

	private Student newStudent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nDatabase = new DataBase(this);

		e_ime = (EditText) findViewById(R.id.ime_editText);
		e_prezime = (EditText) findViewById(R.id.prezime_editText);
		e_index = (EditText) findViewById(R.id.index_editText);
		e_godina = (EditText) findViewById(R.id.godina_editText);

		sacuvaj = (Button) findViewById(R.id.save_button);
		sacuvaj.setOnClickListener(this);

		prikazi = (Button) findViewById(R.id.view_button);
		prikazi.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.save_button:

			newStudent = new Student();

			newStudent.setStudentIme(e_ime.getText().toString());
			newStudent.setStudentPrezime(e_prezime.getText().toString());
			newStudent.setStudentBrojIndexa(e_index.getText().toString());
			newStudent.setStudentGodina(e_godina.getText().toString());

			nDatabase.helper.insertStudent(newStudent);

			break;

		case R.id.view_button:

			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			startActivity(intent);
			break;
		}

	}
}
