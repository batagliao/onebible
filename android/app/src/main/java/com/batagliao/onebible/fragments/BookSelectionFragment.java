package com.batagliao.onebible.fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SearchView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.batagliao.onebible.R;
import com.batagliao.onebible.adapters.BookSelectionAdapter;
import com.batagliao.onebible.databinding.FragmentBookSelectionListBinding;
import com.batagliao.onebible.models.Book;
import com.batagliao.onebible.viewmodels.BooksSelectionViewModel;

import java.util.ArrayList;
import java.util.List;


public class BookSelectionFragment extends Fragment implements SearchView.OnQueryTextListener {

    private BookSelectionAdapter adapter;
    private BooksSelectionViewModel viewmodel;



    public BookSelectionFragment() {
        // Required empty public constructor
        viewmodel = new BooksSelectionViewModel();
    }

    public static BookSelectionFragment newIntance() {
        BookSelectionFragment fragment = new BookSelectionFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentBookSelectionListBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_book_selection_list, container, false);
        binding.setViewmodel(viewmodel);

        View rootView = binding.getRoot();
        RecyclerView recycler = (RecyclerView) rootView.findViewById(R.id.list);

        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new BookSelectionAdapter(getContext(), viewmodel.getBooks());
        recycler.setAdapter(adapter);

        AppCompatActivity activity = (AppCompatActivity)getActivity();
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.bookSelectionToolbar);
        activity.setSupportActionBar(toolbar);

        return rootView;
        //return inflater.inflate(R.layout.fragment_book_selection_list, container, false);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_bookselection, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when collapsed
                adapter.setFilter(viewmodel.getBooks());
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when expanded
                return true; // Return true to expand action view
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Book> books = filter(viewmodel.getBooks(), newText);
        adapter.setFilter(books);
        return true;
    }

    private List<Book> filter(List<Book> books, String query) {
        query = query.toLowerCase();

        final List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            final String text = book.getBookName().toLowerCase();
            if (text.contains(query)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    //    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof FragmentPlaceholderActivity) {
//            mActivity = (FragmentPlaceholderActivity) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement FragmentPlaceholderActivity");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mActivity = null;
//    }


}
