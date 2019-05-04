package co.edu.konradlorenz.napa_s.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.IOException;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import co.edu.konradlorenz.napa_s.R;


public class RegisterActivity extends AppCompatActivity {

    private Button chooseImageButton;
    private static final int PICK_IMAGE_REQUEST = 100;
    private Uri selectedImage;
    private ImageView imageRegisterInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findMaterialElements();
    }

    private void findMaterialElements() {
        chooseImageButton = findViewById(R.id.select_image_button);
        imageRegisterInput = findViewById(R.id.image_selected_view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case PICK_IMAGE_REQUEST:
                if(resultCode == RESULT_OK){
                    selectedImage = data.getData();

                    try{
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        imageRegisterInput.setImageBitmap(bitmap);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void chooseImage(View view) {
        Intent newIntent = new Intent(Intent.ACTION_GET_CONTENT);
        newIntent.setType("image/*");
        startActivityForResult(newIntent, PICK_IMAGE_REQUEST);
    }

    public void signInHandler(View view) {
        Intent newIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(newIntent);
    }
}
