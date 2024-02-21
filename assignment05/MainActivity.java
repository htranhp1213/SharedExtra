package edu.uncc.assignment05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import edu.uncc.assignment05.fragments.AddUserFragment;
import edu.uncc.assignment05.fragments.SelectAgeFragment;
import edu.uncc.assignment05.fragments.SelectGenderFragment;
import edu.uncc.assignment05.fragments.SelectGroupFragment;
import edu.uncc.assignment05.fragments.SelectSortFragment;
import edu.uncc.assignment05.fragments.SelectStateFragment;
import edu.uncc.assignment05.fragments.UsersFragment;
import edu.uncc.assignment05.models.Data;
import edu.uncc.assignment05.models.User;

public class MainActivity extends AppCompatActivity implements UsersFragment.UsersListener, AddUserFragment.AddUserListener, SelectGenderFragment.GenderListener,
        SelectAgeFragment.AgeListener {

    private ArrayList<User> mUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsers = Data.sampleTestUsers;

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new UsersFragment(), "users")
                .commit();
    }

    @Override
    public void gotoAddUserFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment(), "add-user")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSortSelectionFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectSortFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void clearAll() {
        mUsers.clear();
    }

    @Override
    public void gotoAgeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectAgeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoGenderFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectGenderFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoStateFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectStateFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoGroupFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectGroupFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendUser(User user) {

    }

    @Override
    public void cancelGenderSelection() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendSelectedGender(String gender) {
        AddUserFragment addUserFragment = (AddUserFragment) getSupportFragmentManager().findFragmentByTag("add-user");
        if(addUserFragment != null){
            addUserFragment.setSelectedGender(gender);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelAgeSelection() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendSelectedAge(int age) {
        AddUserFragment addUserFragment = (AddUserFragment) getSupportFragmentManager().findFragmentByTag("add-user");
        if(addUserFragment != null){
            addUserFragment.setSelectedAge(age);
        }
        getSupportFragmentManager().popBackStack();
    }
}