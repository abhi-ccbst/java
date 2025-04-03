package com.example.lecture_3;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(StudentsProvider.GRADE,
                ((EditText)findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }
    private boolean isStudentExists(String studentName) {
        Uri studentUri = Uri.parse("content://com.example.lecture_3.StudentsProvider");
        String[] projection = {"name"};  // We only need the name
        String selection = "name=?";
        String[] selectionArgs = new String[]{studentName};

        Cursor cursor = getContentResolver().query(studentUri, projection, selection, selectionArgs, null);

        boolean exists = (cursor != null && cursor.getCount() > 0);

        if (cursor != null) {
            cursor.close();
        }

        return exists;
    }

    public void onClickDeleteStudent(View view) {
        EditText editTextDelete = findViewById(R.id.editTextDelete);
        String studentName = editTextDelete.getText().toString().trim();

        if (studentName.isEmpty()) {
            Toast.makeText(this, "Please enter a student name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if student exists
        if (!isStudentExists(studentName)) {
            Toast.makeText(this, "Student not found in database", Toast.LENGTH_SHORT).show();
            return;
        }

        // Construct URI for the student
        Uri studentUri = Uri.parse("content://com.example.lecture_3.StudentsProvider/students");

        // Define selection criteria
        String selection = "name=?";
        String[] selectionArgs = new String[]{studentName};

        // Call delete on ContentResolver
        int deletedRows = getContentResolver().delete(studentUri, selection, selectionArgs);

        if (deletedRows > 0) {
            Toast.makeText(this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error deleting student", Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("Range")
    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.lecture_3.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}