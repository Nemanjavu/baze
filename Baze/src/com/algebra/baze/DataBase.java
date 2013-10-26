package com.algebra.baze;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase {

	public static final String DB_NAME = "database.db";
	public static final int DB_VERSION = 1;
	public static final String STUDENT_TABLE = "studenti";

	public static final String STUDENT_ID = "_id";
	public static final String STUDENT_IME = "student_ime";
	public static final String STUDENT_PREZIME = "student_prezime";
	public static final String STUDENT_BROJ_INDEX = "student_indexa";
	public static final String STUDENT_GODINA_STUDIJA = "student_godina";

	private Context nContext;
	private SQLiteDatabase db;
	public DbHelper helper;

	public DataBase(Context context) {

		nContext = context; // context = jedinstveni id pojedinog activity-a
		helper = new DbHelper();
	}

	public class DbHelper extends SQLiteOpenHelper {

		public DbHelper() {
			super(nContext, DB_NAME, null, DB_VERSION);

		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			String studentSql = "CREATE TABLE " + STUDENT_TABLE + "("
					+ STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ STUDENT_IME + " TEXT, " + STUDENT_PREZIME + "  TEXT, "
					+ STUDENT_BROJ_INDEX + " TEXT, " + STUDENT_GODINA_STUDIJA
					+ " TEXT );";

			db.execSQL(studentSql);

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			db.execSQL("DROP TABLE IF EXIST" + STUDENT_TABLE);

			onCreate(db);

		}

		public void insertStudent(Student student) {

			db = helper.getWritableDatabase();

			ContentValues cv = new ContentValues(); // Bundle = ContentValues za
													// db
			cv.put(STUDENT_IME, student.getStudentIme());
			cv.put(STUDENT_PREZIME, student.getStudentPrezime());
			cv.put(STUDENT_BROJ_INDEX, student.getStudentBrojIndexa());
			cv.put(STUDENT_GODINA_STUDIJA, student.getStudentGodina());

			db.insert(STUDENT_TABLE, null, cv);
			db.close();

		}

		public ArrayList<Student> getAllStudents() {

			ArrayList<Student> items = new ArrayList<Student>();

			db = helper.getReadableDatabase();

			Cursor c = db.query(STUDENT_TABLE, null, null, null, null, null,
					null);

			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

				Student student = new Student();

				student.setStudentIme(c.getString(c.getColumnIndex(STUDENT_IME)));
				student.setStudentPrezime(c.getString(c
						.getColumnIndex(STUDENT_PREZIME)));
				student.setStudentBrojIndexa(c.getString(c
						.getColumnIndex(STUDENT_BROJ_INDEX)));
				student.setStudentGodina(c.getString(c
						.getColumnIndex(STUDENT_GODINA_STUDIJA)));

				items.add(student);

			}
			db.close();
			return items;
		}
	}

}
