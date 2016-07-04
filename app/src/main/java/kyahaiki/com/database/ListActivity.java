package kyahaiki.com.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView l = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.listitem, getNames());
        l.setAdapter(a);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public List<String> getNames(){
        List<String> s = new ArrayList<String>();
        SQLiteDatabase db;
        db=openOrCreateDatabase("Detailsdb", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("select name from Detailsdb", null);
        while(c.moveToNext())
            s.add(c.getString(0));
        return s;
    }

}
