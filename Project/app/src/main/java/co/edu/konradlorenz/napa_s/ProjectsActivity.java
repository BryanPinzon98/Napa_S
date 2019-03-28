package co.edu.konradlorenz.napa_s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProjectsActivity extends AppCompatActivity {

    private BottomAppBar projectsBottomAppBar;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projects_layout);

        findMaterials();
        setSupportActionBar(projectsBottomAppBar);
        fabHandler();
    }

    public void fabHandler() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(ProjectsActivity.this, CreateProjectActivity.class);
                startActivity(newIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_profile:
                Intent newIntent = new Intent(ProjectsActivity.this, ProfileActivity.class);
                startActivity(newIntent);
                break;
            case android.R.id.home:
                BottomNavigationDrawerFragment bottomNavigationDrawerFragment = new BottomNavigationDrawerFragment();
                bottomNavigationDrawerFragment.show(getSupportFragmentManager(), bottomNavigationDrawerFragment.getTag());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void runEffectBAB(View view) {
        if (projectsBottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_END) {
            projectsBottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        } else {
            projectsBottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        }
    }

    public void findMaterials() {
        projectsBottomAppBar = findViewById(R.id.bottom_app_bar_projects_layout);
        floatingActionButton = findViewById(R.id.fab_projects_layout);
    }

    public void openSprint(View view) {
        Intent newIntent = new Intent(ProjectsActivity.this, SprintsActivity.class);
        startActivity(newIntent);
    }
}
