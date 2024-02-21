package edu.uncc.assignment05.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uncc.assignment05.R;
import edu.uncc.assignment05.databinding.FragmentAddUserBinding;
import edu.uncc.assignment05.models.User;

public class AddUserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_User = "user";
    private Integer selectedAge = null;
//    private  String name, email;
    private String selectedGender = null;
    private String selectedState = null;
    private String selectedGroup = null;

    public void setSelectedAge (int age) {
        this.selectedAge = age;
    }

    public void  setSelectedGender(String gender) {
        this.selectedGender = gender;
    }
    public void  setSelectedState(String state) {
        this.selectedState = state;
    }
    public void  setSelectedGroup(String group) {
        this.selectedGroup = group;
    }
    private User mUser;

    public AddUserFragment() {
        // Required empty public constructor
    }
//    public static AddUserFragment newInstance(String param1, String param2) {
//        AddUserFragment fragment = new AddUserFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mUser = (User) getArguments().getSerializable(ARG_PARAM_User);
        }
    }
    FragmentAddUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Add User");

        binding.buttonSelectGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoGenderFragment();
            }
        });

        binding.buttonSelectAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoAgeFragment();
            }
        });

        binding.buttonSelectState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoStateFragment();
            }
        });

        binding.buttonSelectGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoGroupFragment();
            }
        });


        if(selectedAge == null){
            binding.textViewAge.setText("N/A");
        } else {
            binding.textViewAge.setText(String.valueOf(selectedAge));
        }

        if(selectedGender == null){
            binding.textViewGender.setText("N/A");
        } else {
            binding.textViewGender.setText(selectedGender);
        }

        if(selectedState == null){
            binding.textViewState.setText("N/A");
        } else {
            binding.textViewState.setText(selectedState);
        }
        if(selectedGroup == null){
            binding.textViewGroup.setText("N/A");
        } else {
            binding.textViewGroup.setText(selectedGroup);
        }

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.editTextName.getText().toString();
                String email = binding.editTextEmail.getText().toString();

                if (name.equals("") || email.equals("") || selectedAge == null || selectedGender == null || selectedState == null || selectedGroup == null){
                    Toast.makeText(getActivity(), "Please enter missing field", Toast.LENGTH_SHORT).show();
                } else if (name.equals("") && email.equals("") && selectedAge.equals("")&& selectedGender == null && selectedState == null && selectedGroup == null) {
                    
                } else {
                    User user = new User(name, email, selectedGender, selectedAge, selectedState, selectedGroup);
                    mListener.sendUser(user);
                }

            }
        });

    }

    AddUserListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (AddUserListener) context;
    }

    public interface AddUserListener{
        void gotoAgeFragment();
        void gotoGenderFragment();
        void gotoStateFragment();
        void gotoGroupFragment();
        void sendUser(User user);
    }
}