package com.example.a21111064248_saiminhhieu_lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList;

    private ArrayAdapter<Person> personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 1"));
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 2"));
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 3"));
        listPerson.add(new Person(R.drawable.avata,"Nguoi thu 4"));

        personAdapter = new PersonAdapter(this,R.layout.list_item_person,listPerson);

        ListView listviewPerson = findViewById(R.id.ListViewPerson);
        listviewPerson.setAdapter(personAdapter);

        registerForContextMenu(listviewPerson);


        listviewPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Person selectedPerson = personAdapter.getItem(position);
                if(selectedPerson != null){
                    String selectedName = selectedPerson.getNamePerson();
                    Toast.makeText(MainActivity.this, "Ban da chon "+selectedName,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==R.id.ListViewPerson){
            AdapterView.AdapterContextMenuInfo Info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            int position = Info.position;

            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem menuitem) {
        AdapterView.AdapterContextMenuInfo Info = (AdapterView.AdapterContextMenuInfo) menuitem.getMenuInfo();
        int position = Info.position;

        switch (menuitem.getItemId()){
            case R.id.menu_view:
                showPersonInfo(position);
                return true;
            case R.id.menu_delete:
                deletePerson(position);
                return true;
            default:
                return super.onContextItemSelected(menuitem);
        }
    }
    private void showPersonInfo(int position){
        Person selectedPerson = personList.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(selectedPerson.getNamePerson())
                .setMessage("ban vua chon thong tin cua"+selectedPerson.getNamePerson())
                .setPositiveButton("ok",((dialog, which) -> dialog.dismiss()))
                .create().show();
    }

    private void deletePerson(int positon){
        personList.remove(positon);
        personAdapter.notifyDataSetChanged();
        Toast.makeText(this,"da xoa",Toast.LENGTH_SHORT).show();
    }
}