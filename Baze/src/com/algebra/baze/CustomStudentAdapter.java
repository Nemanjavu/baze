package com.algebra.baze;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomStudentAdapter extends BaseAdapter {

	private ArrayList<Student> nStudents;
	private Context nContext;
	private LayoutInflater nInflater;

	private ViewHolder nHolder;

	public CustomStudentAdapter(Context context, ArrayList<Student> students) {

		nContext = context;

		nStudents = students;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return nStudents.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return nStudents.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		nHolder = new ViewHolder();

		nInflater = (LayoutInflater) nContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = nInflater.inflate(R.layout.list_item, null);

		nHolder.imeText = (TextView) convertView
				.findViewById(R.id.ime_textView1);
		nHolder.prezimeText = (TextView) convertView
				.findViewById(R.id.prezime_textView2);
		nHolder.brojIndexaTest = (TextView) convertView
				.findViewById(R.id.index_textView3);
		nHolder.godinaStudijaText = (TextView) convertView
				.findViewById(R.id.godina_textView4);

		Student student = nStudents.get(position);

		nHolder.imeText.setText(student.getStudentIme());
		nHolder.prezimeText.setText(student.getStudentPrezime());
		nHolder.brojIndexaTest.setText(student.getStudentBrojIndexa());
		nHolder.godinaStudijaText.setText(student.getStudentGodina());

		return convertView;
	}

	private class ViewHolder {

		TextView imeText;
		TextView prezimeText;
		TextView brojIndexaTest;
		TextView godinaStudijaText;
	}
}
