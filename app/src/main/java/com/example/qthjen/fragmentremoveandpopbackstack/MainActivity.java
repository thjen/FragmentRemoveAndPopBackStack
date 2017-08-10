package com.example.qthjen.fragmentremoveandpopbackstack;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("mykeyA"); // add vào ngăn xếp với key là mykeyA
        fragmentTransaction.add(R.id.fmContent, new FragmentA(), "TagA");
        fragmentTransaction.commit();

    }

    public void AddB(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("mykeyB");
        fragmentTransaction.add(R.id.fmContent, new FragmentB(), "TagB");
        fragmentTransaction.commit();

    }

    public void AddC(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("mykeyC");
        fragmentTransaction.add(R.id.fmContent, new FragmentC(), "TagC");
        fragmentTransaction.commit();

    }

    public void RemoveA(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("TagA");

        if ( fragmentA != null) {
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(MainActivity.this, "Fragment A is null", Toast.LENGTH_SHORT).show();
        }

    }

    public void RemoveB(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentByTag("TagB");

        if ( fragmentB != null) {
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(MainActivity.this, "Fragment B is null", Toast.LENGTH_SHORT).show();
        }

    }

    public void RemoveC(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) getFragmentManager().findFragmentByTag("TagC");

        if ( fragmentC != null) {
            fragmentTransaction.remove(fragmentC);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(MainActivity.this, "Fragment C is null", Toast.LENGTH_SHORT).show();
        }

    }

    public void Back(View view) {

        getFragmentManager().popBackStack();
    }

    public void PopA(View view) {

        getFragmentManager().popBackStack("mykeyA", 0); // quay trở lại fragment A ở vị trí 0
    }

    /** sự kiện phím back cứng trên điện thoại **/
    @Override
    public void onBackPressed() {

        if ( getFragmentManager().getBackStackEntryCount() > 0 ) {  // hàm đếm ngăn xếp xem có bao nhiêu phần
            getFragmentManager().popBackStack();;
        } else {
            super.onBackPressed();
        }

    }
}
