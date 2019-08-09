package com.nicolletnjora.samsunga50.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.nicolletnjora.samsunga50.Activities.MainActivity;
import com.nicolletnjora.samsunga50.Database.UssdCodesDatabase;
import com.nicolletnjora.samsunga50.Models.UssdCode;
import com.nicolletnjora.samsunga50.R;


public class AddUssdFragment extends Fragment {

    @BindView(R.id.et_company)
    EditText editTextCompany;

    @BindView(R.id.et_purpose_ussd)
    EditText editTextPurpose;

    @BindView(R.id.et_ussd_code)
    EditText editTextUssdCode;

    private Unbinder unbinder;

    private UssdCodesDatabase db;


    public AddUssdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_ussd, container, false);

        unbinder = ButterKnife.bind(this, view);

        view.findViewById(R.id.btn_save_ussd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUssd();
            }
        });


        db = UssdCodesDatabase.getDatabaseInstance(getContext());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void saveUssd() {

        //first getting the values
        final String company = editTextCompany.getText().toString();
        final String purpose = editTextPurpose.getText().toString();
        final String ussdCode = editTextUssdCode.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(company)) {
            editTextCompany.setError("Please enter the company");
            editTextCompany.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(purpose)) {
            editTextPurpose.setError("Please enter the purpose");
            editTextPurpose.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(ussdCode)) {
            editTextUssdCode.setError("Please enter the ussd code");
            editTextUssdCode.requestFocus();
            return;
        }

        // Auto increment id
        UssdCode UssdCode = new UssdCode();
        UssdCode.setServiceProvider(company);
        UssdCode.setServiceType(purpose);
        UssdCode.setUssdCodePathDescription(company+ " " +purpose);
        UssdCode.setUssdCodePath(ussdCode);

        addUssdCode(UssdCode);

        startActivity(new Intent(getContext(), MainActivity.class));
    }

    private UssdCode addUssdCode(UssdCode UssdCode) {

        db.UssdCodeDao().saveUssdCode(UssdCode);
        return UssdCode;
    }
}
