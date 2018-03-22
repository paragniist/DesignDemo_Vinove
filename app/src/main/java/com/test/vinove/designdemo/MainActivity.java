package com.test.vinove.designdemo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private boolean doubleBackToExitPressedOnce = false;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.mail);



        fragmentManager = getSupportFragmentManager();

        mFragmentTransaction = fragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frag1, new SignInFragment());
        mFragmentTransaction.commit();

String mail = editText.getText().toString().trim();

    }



    public void signIn(View v) {
        mFragmentTransaction = fragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frag1, new SignInFragment());
        mFragmentTransaction.commit();
    }

    public void signUp(View v) {

        mFragmentTransaction = fragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frag1, new SignUpFragment());
        mFragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

        if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit.", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();

        }
    }




}

