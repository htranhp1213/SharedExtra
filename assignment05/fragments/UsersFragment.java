package edu.uncc.assignment05.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.assignment05.R;
import edu.uncc.assignment05.databinding.FragmentUsersBinding;
import edu.uncc.assignment05.models.Data;
import edu.uncc.assignment05.models.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_USERS = "users";
    private User mUser;
    private ArrayList<User> userArrayList;
    public UsersFragment() {
        // Required empty public constructor
    }

    public static UsersFragment newInstance(User user) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_USERS, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mUser = getArguments().getString(ARG_PARAM_USERS);
        }
    }

    FragmentUsersBinding binding;
    // UserAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Users");

        binding.buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoAddUserFragment();
            }
        });

        binding.buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSortSelectionFragment();
            }
        });


        binding.buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.clearAll();
            }
        });
    }

    class UsersAdapter extends ArrayAdapter<User> {
        public UsersAdapter(@NonNull Context context, @NonNull List<User> objects) {
            super(context, R.layout.user_list_item, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.user_list_item, parent, false);
            }

            TextView textViewName = convertView.findViewById(R.id.textViewName);
            TextView textViewEmail = convertView.findViewById(R.id.textViewEmail);
            TextView textViewAge = convertView.findViewById(R.id.textViewAge);
            TextView textViewState = convertView.findViewById(R.id.textViewState);
            TextView textViewGroup = convertView.findViewById(R.id.textViewGroup);
            TextView textViewGender = convertView.findViewById(R.id.textViewGender);


            return convertView;
        }
    }

    UsersListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (UsersListener) context;
    }

    public interface UsersListener{
        void gotoAddUserFragment();
        void gotoSortSelectionFragment();
        void clearAll();
    }
}