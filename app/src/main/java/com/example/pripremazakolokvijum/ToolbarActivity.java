package com.example.pripremazakolokvijum;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/*
 * TOOLBAR IMPLEMENTACIJA - KORACI (Android)
 *
 * 1. Dodati Toolbar u XML layout (activity_main.xml ili drugi layout):
 *
 *    <androidx.appcompat.widget.Toolbar
 *        android:id="@+id/toolbar"
 *        android:layout_width="match_parent"
 *        android:layout_height="wrap_content"
 *        android:background="?attr/colorPrimary"
 *        android:title="My App"
 *        android:titleTextColor="@android:color/white"/>
 *
 *    -> Ovo je UI komponenta koja se prikazuje na vrhu ekrana.
 *
 * ------------------------------------------------------------
 *
 * 2. Povezati Toolbar u Activity klasi:
 *
 *    Toolbar toolbar = findViewById(R.id.toolbar);
 *    setSupportActionBar(toolbar);
 *
 *    -> Ovo kaže Android-u da koristi ovaj Toolbar kao ActionBar.
 *
 * ------------------------------------------------------------
 *
 * 3. Kreirati menu folder:
 *
 *    res → New → Android Resource Directory → type: menu
 *
 *    -> Ovo pravi folder u koji idu stavke menija (ikonice).
 *
 * ------------------------------------------------------------
 *
 * 4. Kreirati menu XML fajl (npr. menu_main.xml):
 *
 *    <menu xmlns:android="http://schemas.android.com/apk/res/android"
 *          xmlns:app="http://schemas.android.com/apk/res-auto">
 *
 *        <item
 *            android:id="@+id/action_search"
 *            android:title="Search"
 *            android:icon="@android:drawable/ic_menu_search"
 *            app:showAsAction="ifRoom"/>
 *
 *        <item
 *            android:id="@+id/action_settings"
 *            android:title="Settings"
 *            android:icon="@android:drawable/ic_menu_preferences"
 *            app:showAsAction="ifRoom"/>
 *
 *    </menu>
 *
 *    -> Definišu se ikonice koje će biti u Toolbar-u.
 *
 * ------------------------------------------------------------
 *
 * 5. Povezati menu sa Toolbar-om u Activity:
 *
 *    @Override
 *    public boolean onCreateOptionsMenu(Menu menu) {
 *        getMenuInflater().inflate(R.menu.menu_main, menu);
 *        return true;
 *    }
 *
 *    -> Ovo ubacuje XML meni u Toolbar.
 *
 * ------------------------------------------------------------
 *
 * 6. Obrada klikova na ikonice:
 *
 *    @Override
 *    public boolean onOptionsItemSelected(MenuItem item) {
 *
 *        if (item.getItemId() == R.id.action_search) {
 *            Log.i("Toolbar", "Search clicked");
 *            return true;
 *        }
 *
 *        if (item.getItemId() == R.id.action_settings) {
 *            Log.i("Toolbar", "Settings clicked");
 *            return true;
 *        }
 *
 *        return super.onOptionsItemSelected(item);
 *    }
 *
 * ------------------------------------------------------------
 *
 * REZULTAT:
 * - Toolbar na vrhu ekrana
 * - Title aplikacije
 * - Ikonice (search, settings)
 * - Klik eventi na ikonice
 *
 */

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        if (item.getItemId() == R.id.action_search) {
            Log.i("Toolbar", "Search clicked");
            return true;
        }

        if (item.getItemId() == R.id.action_settings) {
            Log.i("Toolbar", "Settings clicked");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}