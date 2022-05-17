package com.github.marker99;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.github.marker99.databinding.ActivityMainBinding;
import com.github.marker99.login_firebase.ui.SignInActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private MainActivityViewModelImpl viewModel;

    NavController navController;

    //DrawerInfo
    private TextView textView_dogNameDrawer, textView_dogInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Use the Toolbar as your ActionBar
        setSupportActionBar(binding.appBarMain.toolbar);

        //Floating Action Button /FAB
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Does nothing yet", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Adding new elements to drawer
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //R.id.nav_signalement er fjernet fra listen!
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_allHealthInspections, R.id.dogFragment, R.id.settings_dest, R.id.growthTrackFragment
                , R.id.nav_signalement)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModelImpl.class);
        checkIfSignedIn();

        bindings();
    }

    //Stolen from: https://stackoverflow.com/questions/15412943/hide-soft-keyboard-on-losing-focus
    //Method to hide keyboard and lose focus from editTextViews, whenever elsewhere clicked!
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            /**
             * It gets into the above IF-BLOCK if anywhere the screen is touched.
             */

            View v = getCurrentFocus();
            if (v instanceof EditText) {

                /**
                 * Now, it gets into the above IF-BLOCK if an EditText is already in focus, and you tap somewhere else
                 * to take the focus away from that particular EditText. It could have 2 cases after tapping:
                 * 1. No EditText has focus
                 * 2. Focus is just shifted to the other EditText
                 */

                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void bindings() {
        //Den skal være binding.navView, for at den ved det er fra navView
        textView_dogInfo = binding.navView.getHeaderView(0).findViewById(R.id.textView_dogInfo);
        textView_dogNameDrawer = binding.navView.getHeaderView(0).findViewById(R.id.textView_dogNameDrawer);

        //FIXME: BAD SOLUTION, doesn't work live! :( --> FUCKA DIZ
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String petName = preferences.getString("petName", "No Pet Selected");

        viewModel.getCurrentUser().observe(this, user -> {
            textView_dogNameDrawer.setText(user.getDisplayName());
        });

        /*
        viewModel.getCurrentPet().observe(this, pet -> {
                textView_dogInfo.setText(pet.getPetName());
        });

         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }

    //Responding to User Interaction for appbar / toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                /*String message = "Welcome " + user.getDisplayName();
                welcomeMessage.setText(message);*/
            } else
                startLoginActivity();
        });
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }


}