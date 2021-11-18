package com.myapplication.shopingmarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    EditText mail;
    EditText pass;
    TextView forgetPass;
    Button login;
    float fabTemp=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        mail = root.findViewById(R.id.mail);
        pass = root.findViewById(R.id.pass);
        forgetPass = root.findViewById(R.id.forget_Pass);
        login = root.findViewById(R.id.login_btn);

        mail.setTranslationX(800);
        pass.setTranslationX(800);
        forgetPass.setTranslationX(800);
        login.setTranslationX(800);

        mail.setAlpha(fabTemp);
        pass.setAlpha(fabTemp);
        forgetPass.setAlpha(fabTemp);
        login.setAlpha(fabTemp);

        mail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}
