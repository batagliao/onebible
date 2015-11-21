package com.batagliao.onebible.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.batagliao.onebible.BR;
import com.batagliao.onebible.R;
import com.batagliao.onebible.databinding.BookselectionListItemBinding;
import com.batagliao.onebible.models.Book;

import java.util.List;

/**
 * Created by batagliao on 11/21/15.
 */
public class BookSelectionAdapter extends RecyclerView.Adapter<BookSelectionAdapter.BookSelectionViewHolder> {

    private Context context;
    private List<Book> books;

    public BookSelectionAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public BookSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BookselectionListItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.bookselection_list_item, parent, false);

        BookSelectionViewHolder viewHolder = new BookSelectionViewHolder(binding.getRoot());

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookSelectionViewHolder holder, int position) {
        final Book book = books.get(position);
        ViewDataBinding binding = holder.getBinding();
        binding.setVariable(BR.book, book);
        if (binding.hasPendingBindings()) {
            binding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookSelectionViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public BookSelectionViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }


}
