package com.example.pripremazakolokvijum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.pripremazakolokvijum.fragments.FirstFragment;
import com.example.pripremazakolokvijum.fragments.SecondFragment;
import com.google.android.material.navigation.NavigationView;

/*
 * ============================================================
 * NAVIGATION DRAWER - OBJAŠNJENJE IMPLEMENTACIJE
 * ============================================================
 *
 * POSTOJE DVA NAČINA IMPLEMENTACIJE:
 *
 * ------------------------------------------------------------
 * 1. BEZ FRAGMENATA (JEDNOSTAVNA VERZIJA)
 * ------------------------------------------------------------
 *
 * - Drawer služi samo kao meni
 * - Klik na item ne menja ekran
 * - Koristi se Log, Toast ili mala UI promena
 *
 * KORACI:
 * 1. Kreirati DrawerLayout kao root layout
 * 2. Dodati Toolbar u glavni layout
 * 3. Dodati NavigationView (meni sa strane)
 * 4. Kreirati menu (drawer_menu.xml)
 * 5. U Activity:
 *    - povezati DrawerLayout, Toolbar, NavigationView
 *    - dodati ActionBarDrawerToggle (hamburger ikonica)
 * 6. Implementirati setNavigationItemSelectedListener
 *    - klik na item → izvršava akciju (Log/Toast)
 *    - zatvoriti drawer sa closeDrawers()
 *
 * REZULTAT:
 * - Drawer radi
 * - Klikovi rade
 * - NEMA promene ekrana
 *
 * ------------------------------------------------------------
 * 2. SA FRAGMENATIMA (REAL APP VERZIJA)
 * ------------------------------------------------------------
 *
 * - Drawer služi za navigaciju između ekrana
 * - Jedna Activity je host (container)
 * - Svaki ekran je Fragment
 *
 * KORACI:
 * 1. Kreirati DrawerLayout kao root layout
 * 2. Dodati Toolbar u main layout
 * 3. Dodati FrameLayout (fragmentContainer)
 *    - tu se prikazuju fragmenti
 * 4. Dodati NavigationView (meni)
 * 5. Kreirati Fragmente (npr. FirstFragment, SecondFragment)
 * 6. Napraviti helper metodu:
 *
 *    loadFragment(Fragment fragment):
 *    - replace(fragmentContainer, fragment)
 *
 * 7. Postaviti default fragment pri startu aplikacije
 * 8. U NavigationView listener-u:
 *    - klik na item → pozvati loadFragment()
 *    - zameni trenutni fragment novim
 *    - zatvori drawer
 *
 * REZULTAT:
 * - Drawer radi
 * - Klik MENJA EKRANE
 * - Jedna Activity + više Fragmenata
 *
 * ------------------------------------------------------------
 * GLAVNA RAZLIKA:
 * ------------------------------------------------------------
 *
 * BEZ FRAGMENATA:
 * - meni samo izvršava akcije
 * - nema navigacije između ekrana
 *
 * SA FRAGMENATIMA:
 * - meni menja ekrane
 * - standardna struktura modernih Android aplikacija
 *
 * ============================================================
 */

public class NavDrawerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nav_drawer);

        // Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
         * NAVIGATION DRAWER SETUP
         */

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // DEFAULT SCREEN (prvi fragment kada se otvori app)
        loadFragment(new FirstFragment());

        /*
         * HANDLE MENU CLICK → SWITCH FRAGMENTS
         */
        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_home) {
                loadFragment(new FirstFragment());
            }

            if (id == R.id.nav_profile) {
                loadFragment(new SecondFragment());
            }

            drawerLayout.closeDrawers();
            return true;
        });
    }

    /*
     * Helper metoda za zamenu fragmenata
     */
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}