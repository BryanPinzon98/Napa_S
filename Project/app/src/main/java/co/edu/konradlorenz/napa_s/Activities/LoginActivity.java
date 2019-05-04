package co.edu.konradlorenz.napa_s.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import co.edu.konradlorenz.napa_s.Fragments.PasswordRecoveryFragment;
import co.edu.konradlorenz.napa_s.R;


public class LoginActivity extends AppCompatActivity {

    private ProgressBar loginProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findMaterialElements();
    }

    public void findMaterialElements() {
        loginProgressBar = findViewById(R.id.loading_spinner);
    }

    public void openMainActivity(View view) {
        loginProgressBar.setVisibility(View.VISIBLE);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // SplashActivity screen pause time
                    while (waited < 1000) {
                        sleep(250);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                } finally {
                    Intent newIntent = new Intent(LoginActivity.this, ProjectsContainerActivity.class);
                    startActivity(newIntent);
                    LoginActivity.this.finish();
                }
            }
        };
        splashTread.start();
    }

    public void signUpHandler(View view) {
        Intent newIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(newIntent);
    }

    public void openDialogFragment(View view) {
        Fragment fragment = new PasswordRecoveryFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.login_layout, fragment);
        ft.commit();
    }


}
