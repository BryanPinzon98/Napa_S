package co.edu.konradlorenz.napa_s.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import co.edu.konradlorenz.napa_s.R;

public class PasswordRecoveryFragment extends Fragment {

    private Button resetPasswordButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_password_recovery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findMaterialElements();
        dialogHandler();
    }

    public void dialogHandler(){
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
            }
        });
    }

    private void closeDialog() {
        FragmentManager manager = ((Fragment) PasswordRecoveryFragment.this).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) PasswordRecoveryFragment.this);
        trans.commit();
    }

    public void findMaterialElements(){
        resetPasswordButton = getView().findViewById(R.id.reset_password_button);
    }

    public void closeDialog(View view) {
        FragmentManager manager = ((Fragment) PasswordRecoveryFragment.this).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) PasswordRecoveryFragment.this);
        trans.commit();
    }
}
