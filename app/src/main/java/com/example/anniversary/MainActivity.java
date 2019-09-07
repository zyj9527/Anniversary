package com.example.anniversary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private final String TAG = "Anniverary";

    private ListView listView;
    private Button button;
    private List<Anniversary> anniversaryList = new ArrayList<>();
    private AnniversaryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button_add);
        listView = (ListView) findViewById(R.id.list_view);
        anniversaryList.add(new Anniversary("hello", new Date(1231231)));
        adapter = new AnniversaryAdapter(this, R.layout.anniversary_item, anniversaryList);
        button.setOnClickListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        MainActivity.this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        anniversaryList.add(new Anniversary("aaa", new Date(i - 1900, i1, i2)));
        adapter.notifyDataSetChanged();
    }
}
