package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.myapp3.databinding.ActivityLayoutEx3Binding;

public class LayoutEx3 extends AppCompatActivity
implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{

    ActivityLayoutEx3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_layout_ex3);

        binding = ActivityLayoutEx3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //객체 등록
        binding.bellName.setOnClickListener(this);
        binding.onoff.setOnCheckedChangeListener(this);
        binding.repeatCheck.setOnCheckedChangeListener(this);
        binding.vibrate.setOnCheckedChangeListener(this);

        /*binding.onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if(button == binding.onoff){
                    //Toast.makeText(LayoutEx3.this, "Switch is " + isChecked, Toast.LENGTH_SHORT).show();
                    showToast("Switch is " + isChecked);
                }
            }
        });

        binding.repeatCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if(button == binding.repeatCheck){
                    //Toast.makeText(LayoutEx3.this, "Repeat CheckBox is " + isChecked, Toast.LENGTH_SHORT).show();
                    showToast("Repeat CheckBox is " + isChecked);
                }
            }
        });

        binding.bellName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == binding.bellName){
                    showToast("BellName is clicked");
                }
            }
        });

        binding.vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if(button == binding.vibrate){
                    showToast("Vibration is " + isChecked);
                }
            }
        });*/
    }

    //Toast 메시지 처리 메서드
    private void showToast(String message){
        Toast.makeText(LayoutEx3.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        if(button == binding.onoff){
            showToast("Switch is " + isChecked);
        }else if(button == binding.repeatCheck){
            showToast("Repeat CheckBox is " + isChecked);
        }else if(button == binding.vibrate){
            showToast("Vibration is " + isChecked);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == binding.bellName){
            showToast("BellName is clicked");
        }
    }

    long initTime;
    float initX;    //초기 좌표

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //3초 안에 두번 눌렀을 경우 종료, 그렇지 않으면
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - initTime > 3000){
                showToast("종료하려면 한 번 더 누르세요");
                initTime = System.currentTimeMillis();
            }else{
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //터치 이벤트
    /*
        - getX(), getY(): 이벤트가 발생한 뷰 내에서의 좌표값
        - getRawX(), getRawY(): 화면에서의 좌표값

        ACTION_DOWN: 화면에 터치된 순간의 이벤트
        ACTION_UP: 터치를 때는 순간의 이벤트
        ACTION_MOVE: 터치한 후 이동하는 순간의 이벤트
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            initX = event.getRawX();
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            float diffX = initX - event.getRawX();
            if(diffX > 100){
                showToast("왼쪽으로 화면을 밀었습니다.");
            }else if(diffX < -100){
                showToast("오른쪽으로 화면을 밀었습니다.");
            }
        }

        return super.onTouchEvent(event);
    }
}