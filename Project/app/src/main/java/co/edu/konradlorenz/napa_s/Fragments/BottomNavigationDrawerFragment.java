package co.edu.konradlorenz.napa_s.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import co.edu.konradlorenz.napa_s.Activities.LoginActivity;
import co.edu.konradlorenz.napa_s.R;

public class BottomNavigationDrawerFragment extends BottomSheetDialogFragment {

    private View view;
    private NavigationView navigationView;
    private ImageView closeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.bottom_navigation_drawer, container, false);

        findMaterialElements();
        menuItemsHandler();
        closeSheetHandler();

        return view;
    }

    public void menuItemsHandler(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_logout_option:
                        Intent newIntent = new Intent(getContext(), LoginActivity.class);
                        startActivity(newIntent);
                        return true;
                }
                return true;
            }
        });
    }

    public void closeSheetHandler(){
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dismiss bottom sheet
                dismiss();
            }
        });
    }

    public void findMaterialElements(){
        navigationView = view.findViewById(R.id.navigation_view);
        closeButton = view.findViewById(R.id.close_menu_sheet);
    }
}
