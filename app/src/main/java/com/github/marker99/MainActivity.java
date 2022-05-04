package com.github.marker99;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.github.marker99.login_firebase.ui.SignInActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.github.marker99.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private MainActivityViewModel viewModel;

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
                R.id.nav_home, R.id.nav_allHealthInspections, R.id.dogFragment, R.id.settings_dest, R.id.growthTrackFragment)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        checkIfSignedIn();

        //TODO: Dette virker ikke lige nu, få hjælp af Kasper evt?
        bindings();
        textView_dogInfo.setText("dogInfo");
        textView_dogNameDrawer.setText("dogNameDrawer");

        //MaterialDatePicker.Builder.datePicker();
        //MaterialDatePicker.Builder.datePicker().build().sh
    }

    private void bindings() {
        //FIXME: Spørg kasper on navigationDrawer, hvordan vi får hevet data op til det!
        textView_dogInfo = findViewById(R.id.textView_dogInfo);
        textView_dogNameDrawer = findViewById(R.id.textView_dogNameDrawer);


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