package co.edu.konradlorenz.napa_s.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import co.edu.konradlorenz.napa_s.Fragments.ProjectDetailPlaceholderFragment;
import co.edu.konradlorenz.napa_s.Fragments.ProjectTabletDetailFragment;
import co.edu.konradlorenz.napa_s.Fragments.ProjectsFragment;
import co.edu.konradlorenz.napa_s.R;

public class ProjectsContainerActivity extends AppCompatActivity {

    private boolean twoPanes;
    private Bundle startMainBundle;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startMainBundle = savedInstanceState;
        setContentView(R.layout.main_layout);

        setUpFragmentManager();
        findMaterialElements();
        fillLayout();
    }



    private void fillLayout() {

        if(startMainBundle == null){
            fragmentManager.beginTransaction().add(R.id.projects_fragment, new ProjectsFragment()).commit();
        }

        Boolean aBoolean = getResources().getBoolean(R.bool.has_two_panes);

        if(getResources().getBoolean(R.bool.has_two_panes)){
            fragmentManager.beginTransaction().add(R.id.tablet_detail_project_fragment, new ProjectDetailPlaceholderFragment()).commit();
        }

    }


    private void findMaterialElements() {
        FrameLayout tabletDetailFragment = findViewById(R.id.tablet_detail_project_fragment);
    }

    private void setUpFragmentManager() {
        fragmentManager = getSupportFragmentManager();
    }


}
