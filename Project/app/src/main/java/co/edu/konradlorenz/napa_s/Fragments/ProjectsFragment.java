package co.edu.konradlorenz.napa_s.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import co.edu.konradlorenz.napa_s.Activities.CreateProjectActivity;
import co.edu.konradlorenz.napa_s.Activities.ProfileActivity;
import co.edu.konradlorenz.napa_s.Activities.SprintsActivity;
import co.edu.konradlorenz.napa_s.Adapters.ProjectsAdapter;
import co.edu.konradlorenz.napa_s.Entities.Project;
import co.edu.konradlorenz.napa_s.Fragments.BottomNavigationDrawerFragment;
import co.edu.konradlorenz.napa_s.R;

public class ProjectsFragment extends Fragment {

    private RecyclerView projectsRecycler;
    private ProjectsAdapter projectsAdapter;
    private BottomAppBar projectsBottomAppBar;
    private FloatingActionButton floatingActionButton;
    private View actContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        actContext = inflater.inflate(R.layout.projects_layout, container, false);

        findMaterials();
        setUpSupportActionBar();
        fabHandler();
        recyclerSetUp();

        return actContext;
    }

    private void setUpSupportActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(projectsBottomAppBar);
    }

    private void recyclerSetUp() {

        projectsRecycler.setHasFixedSize(true);
        //----- getACTIVITY VS getContext
        RecyclerView.LayoutManager recycleManager = new LinearLayoutManager(getContext());
        projectsRecycler.setLayoutManager(recycleManager);

        //----- getACTIVITY VS getContext
        projectsAdapter = new ProjectsAdapter(getContext());
        projectsRecycler.setAdapter(projectsAdapter);
    }

    public void fabHandler() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getContext(), CreateProjectActivity.class);
                startActivity(newIntent);
            }
        });
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.bottom_bar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_profile:
                //----- getACTIVITY VS getContext
                Intent newIntent = new Intent(getContext(), ProfileActivity.class);
                startActivity(newIntent);
                break;
            case android.R.id.home:
                BottomNavigationDrawerFragment bottomNavigationDrawerFragment = new BottomNavigationDrawerFragment();
                bottomNavigationDrawerFragment.show(getFragmentManager(), bottomNavigationDrawerFragment.getTag());
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
        projectsBottomAppBar = actContext.findViewById(R.id.bottom_app_bar_projects_layout);
        floatingActionButton = actContext.findViewById(R.id.fab_projects_layout);
        projectsRecycler = actContext.findViewById(R.id.projects_recycler);
    }

    public void openSprint(View view) {
        Intent newIntent = new Intent(getActivity(), SprintsActivity.class);
        startActivity(newIntent);
    }
}
