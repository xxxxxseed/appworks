package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapp3.databinding.ActivityViewBindingExBinding;

public class ViewBindingEx extends AppCompatActivity {

    //CheckBox checkbox;
    ActivityViewBindingExBinding binding;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //binding 객체 생성
        binding = ActivityViewBindingExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //checkbox = findViewById(R.id.checkbox);

        binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.checkbox.setText("체크");
                }else{
                    binding.checkbox.setText("해제");
                }
            }
        });

        //이미지를 클릭시 toast 사용
        binding.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(ViewBindingEx.this,
                        "이미지를 클릭하셨습니다.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}