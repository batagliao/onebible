package com.batagliao.onebible.activities;


import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.batagliao.onebible.R;
import com.batagliao.onebible.databinding.ActivityBooksBinding;
import com.batagliao.onebible.fragments.BookSelectionFragment;
import com.batagliao.onebible.helpers.ActivityHelper;
import com.batagliao.onebible.viewmodels.BooksSelectionViewModel;

public class BooksActivity extends AppCompatActivity implements BookSelectionFragment.FragmentInteractionListener {

    private Toolbar toolbar;
    BooksSelectionViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBooksBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_books);

        viewModel = new BooksSelectionViewModel();
        binding.setViewmodel(viewModel);

        toolbar = (Toolbar) findViewById(R.id.bookSelectionToolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState == null) {
            ActivityHelper.InsertFragment(BookSelectionFragment.newIntance(), findViewById(R.id.booksScrollview));
        }

//        setContentView(R.layout.activity_books);

    }

    @Override
    public boolean onSupportNavigateUp() {
        supportFinishAfterTransition();
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public BooksSelectionViewModel getViewModel() {
        return viewModel;
    }
}
