package com.myapplication.shopingmarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {

    EditText mail;
    EditText pass;
    EditText confPass;
    TextView mobile;
    Button signUp;
    float fabTemp=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        mail = root.findViewById(R.id.mail_up);
        mobile = root.findViewById(R.id.mobile);
        pass = root.findViewById(R.id.pass_up);
        confPass = root.findViewById(R.id.pass_conf);
        signUp = root.findViewById(R.id.sign_button);

        mail.setTranslationX(800);
        mobile.setTranslationX(800);
        pass.setTranslationX(800);
        confPass.setTranslationX(800);
        signUp.setTranslationX(800);

        mail.setAlpha(fabTemp);
        mobile.setAlpha(fabTemp);
        pass.setAlpha(fabTemp);
        confPass.setAlpha(fabTemp);
        signUp.setAlpha(fabTemp);

        mail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        mobile.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        confPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        signUp.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1100).start();

        return root;
    }
}
