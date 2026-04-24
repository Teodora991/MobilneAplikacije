package com.example.pripremazakolokvijum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pripremazakolokvijum.fragments.BlankFragment;

public class AddFragmentActivity extends AppCompatActivity {

    /*
STEPS FOR ADDING A FRAGMENT TO ACTIVITY:

1. Create a Fragment class (e.g. BlankFragment)
2. Create a layout file for the fragment (fragment_blank.xml)
3. Add a FragmentContainerView (or FrameLayout) in Activity XML with an id (e.g. fragmentContainer)
4. Create fragment instance (optionally using newInstance() if passing data)
5. Get FragmentManager using getSupportFragmentManager()
6. Start transaction using beginTransaction()
7. Add/Replace fragment in container using replace(R.id.fragmentContainer, fragment)
8. Commit transaction using commit()
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment);
        String message = "Hello from activity";

        BlankFragment fragment =  BlankFragment.newInstance(message);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}