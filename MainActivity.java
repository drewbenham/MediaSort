package com.example.drew.mediasort;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.drew.mediasort.dialog_fragment.CreateListDialogFragment;
import com.example.drew.mediasort.list_models.MediaList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CreateListDialogFragment.NoticeDialogListener {
    ArrayList<MediaList> collectionOfLists = new ArrayList<MediaList>();
    private ViewHolder viewHolder;
    private ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLayout();
    }

    private void setupLayout() {
        viewHolder = new ViewHolder();

        listAdapter = new ArrayAdapter<MediaList>(this, android.R.layout.simple_list_item_1, (List<MediaList>) collectionOfLists);
        //set adapter for listview
        viewHolder.listPickView.setAdapter(listAdapter);

        viewHolder.listPickView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO: 2/4/18 Change this to go to new activity
                String pickedItem = "You Selected " + adapterView.getItemAtPosition(i);

                Toast.makeText(MainActivity.this, pickedItem, Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showDialog();
            }
        });
    }

    public void showDialog() {
        DialogFragment createListDialog = new CreateListDialogFragment();
        createListDialog.show(getFragmentManager(), "CreateListDialogFragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.settingsMenu) {
            return true;
        } else if (id == R.id.exitApp) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRecordSelection(DialogFragment dialog) {
        collectionOfLists.add(new MediaList("Records", "Vinyl Records"));
    }

    @Override
    public void onOtherSelection(DialogFragment dialog) {
        collectionOfLists.add(new MediaList("Other", "Media Type"));
    }


    private class ViewHolder {
        ListView listPickView;
        ImageButton plusButton;

        public ViewHolder() {
            this.listPickView = (ListView) findViewById(R.id.listPickerView);
            this.plusButton = (ImageButton) findViewById(R.id.plusButton);
        }
    }
}
