package com.batagliao.onebible.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.batagliao.onebible.R;
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
        View view = layoutInflater.inflate(R.layout.bookselection_list_item, parent, false);

        BookSelectionViewHolder viewHolder = new BookSelectionViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookSelectionViewHolder holder, int position) {
        final Book book = books.get(position);

        Resources res = context.getResources();

        holder.bookAbbrev.setText(book.getBookAbbrev());
        holder.bookName.setText(book.getBookName());
        holder.chapterQty.setText(res.getQuantityString(R.plurals.chapters, book.getChapters().size()));

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookSelectionViewHolder extends RecyclerView.ViewHolder {

        protected TextView bookAbbrev;
        protected TextView bookName;
        protected TextView chapterQty;

        public BookSelectionViewHolder(View itemView) {
            super(itemView);

            bookAbbrev = (TextView) itemView.findViewById(R.id.text_bookItem_BookAbbrev);
            bookName = (TextView) itemView.findViewById(R.id.text_bookItem_BookName);
            chapterQty = (TextView) itemView.findViewById(R.id.text_bookItem_ChapterQty);
        }

    }


}
