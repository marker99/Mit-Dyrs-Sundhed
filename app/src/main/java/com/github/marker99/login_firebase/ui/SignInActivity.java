package com.github.marker99.login_firebase.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.firebase.ui.auth.AuthUI;
import com.github.marker99.MainActivity;
import com.github.marker99.R;

import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {

    private Button signInButton;

    private SignInViewModel viewModel;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK)
                    goToMainActivity();
                else
                    Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);

        signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(view -> {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());

            Intent signInIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setLogo(R.mipmap.ic_app_icon)
                    .build();

            activityResultLauncher.launch(signInIntent);
        });

        checkIfSignedIn();
    }

    public void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null)
                goToMainActivity();
        });
    }


    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
