package co.edu.konradlorenz.napa_s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateProjectActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        findMaterialElements();
        fabHandler();
    }

    public void fabHandler(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(CreateProjectActivity.this, ProjectsActivity.class);
                startActivity(newIntent);
                CreateProjectActivity.this.finish();
            }
        });
    }

    public void findMaterialElements(){
        floatingActionButton = findViewById(R.id.createProjectFAB);
    }
}
