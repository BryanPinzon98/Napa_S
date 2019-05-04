package co.edu.konradlorenz.napa_s.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

import co.edu.konradlorenz.napa_s.Activities.TaskDetailActivity;
import co.edu.konradlorenz.napa_s.R;


public class ToDoFragment extends Fragment {

    private View view;
    private MaterialCardView materialCardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_to_do, container, false);

        findMaterialElements();
        cardHandler();

        return view;
    }

    public void cardHandler(){
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getContext(), TaskDetailActivity.class);
                startActivity(newIntent);
            }
        });
    }

    public void findMaterialElements(){
        materialCardView = view.findViewById(R.id.toDoCard);
    }
}
