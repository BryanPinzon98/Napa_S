package co.edu.konradlorenz.napa_s.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import co.edu.konradlorenz.napa_s.Entities.Project;
import co.edu.konradlorenz.napa_s.R;


public class ProjectTabletDetailFragment extends Fragment {

    private TextView projectTitle;
    private ImageView projectImage;
    private TextView percentageCompleted;
    private Project projectSelected;
    private View actContext;
    private Bundle projectData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        actContext = inflater.inflate(R.layout.project_tablet_detail, container, false);

        findMaterialElements();
        getBundleData();
        setUpLayout();

        return actContext;
    }

    private void getBundleData() {

        projectData = this.getArguments();
        projectSelected = (Project) projectData.getSerializable("PROJECT");
    }


    private void setUpLayout() {
        projectTitle.setText(projectSelected.getProjectName());
        Glide.with(this).load(projectSelected.getPlaceHolder()).into(projectImage);
        percentageCompleted.setText(projectSelected.getPercentageComplete());
    }


    private void findMaterialElements() {
        projectTitle = actContext.findViewById(R.id.detail_project_title);
        projectImage = actContext.findViewById(R.id.detail_project_image);
        percentageCompleted = actContext.findViewById(R.id.detail_project_percentage_completed);
    }
}
