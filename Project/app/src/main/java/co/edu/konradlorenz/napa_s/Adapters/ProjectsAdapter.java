package co.edu.konradlorenz.napa_s.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.edu.konradlorenz.napa_s.Entities.Project;
import co.edu.konradlorenz.napa_s.Fragments.ProjectTabletDetailFragment;
import co.edu.konradlorenz.napa_s.R;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder> {

    private Context actualContext;
    private List<Project> projectsList;
    private FragmentManager fragmentManager;


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView placeHolder;
        public TextView projectName, percentageComplete;
        private View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.placeHolder = itemView.findViewById(R.id.placeholder_image_item);
            this.projectName = itemView.findViewById(R.id.project_name_item);
            this.percentageComplete = itemView.findViewById(R.id.percentage_complete_item);
            this.view = itemView;
        }
    }

    public ProjectsAdapter(Context actualContext) {
        this.actualContext = actualContext;
        this.projectsList = Project.prepareProjects(
                actualContext.getResources().obtainTypedArray(R.array.placeHolders),
                actualContext.getResources().getStringArray(R.array.projectNames),
                actualContext.getResources().getStringArray(R.array.percentagesComplete)
        );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);

        return new MyViewHolder(view);
    }

    private void loadProjectDetail(int id, FragmentManager manager, Project newProject){

        Bundle bundle = new Bundle();
        bundle.putSerializable("PROJECT", newProject);

        ProjectTabletDetailFragment pTDF = new ProjectTabletDetailFragment();
        pTDF.setArguments(bundle);

        if(id == R.id.projects_fragment){
            manager.beginTransaction().add(id, pTDF).addToBackStack(null).commit();
        }else{
            manager.beginTransaction().add(id, pTDF).commit();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Project newProject = projectsList.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = ((AppCompatActivity) actualContext).getSupportFragmentManager();

                if(actualContext.getResources().getBoolean(R.bool.has_two_panes)){

                    //Toast.makeText(actualContext, "Está en modo Landscape", Toast.LENGTH_SHORT).show();
                    loadProjectDetail(R.id.tablet_detail_project_fragment, manager, newProject);

                }else{

                    //Toast.makeText(actualContext, "Está en modo Portrait", Toast.LENGTH_SHORT).show();
                    loadProjectDetail(R.id.projects_fragment, manager, newProject);
                }
            }
        });

        Glide.with(actualContext).load(newProject.getPlaceHolder()).into(holder.placeHolder);
        holder.projectName.setText(newProject.getProjectName());
        holder.percentageComplete.setText(newProject.getPercentageComplete());
    }

    @Override
    public int getItemCount() {
        return projectsList.size();
    }
}
