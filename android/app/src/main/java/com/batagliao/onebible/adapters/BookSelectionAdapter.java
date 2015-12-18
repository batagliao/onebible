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
import com.batagliao.onebible.models.BookTypeEnum;
import com.batagliao.onebible.util.BibleHelper;

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

        int bookSize = book.getChapters().size();
        holder.bookAbbrev.setText(book.getBookAbbrev());
        holder.bookName.setText(book.getBookName());
        holder.chapterQty.setText(res.getQuantityString(R.plurals.chapters, bookSize, bookSize));
        holder.bookFrame.setBackgroundColor(getColorForBook(book));

    }

    private int getColorForBook(Book book) {
        Resources res = context.getResources();
        BookTypeEnum type = BibleHelper.getBookType(book.getBookOrder());

        switch (type){
            case Pentateuch:
                return res.getColor(R.color.colorPentateuch);
            case Historic:
                return res.getColor(R.color.colorHistoric);
            case Poetic:
                return res.getColor(R.color.colorPoetic);
            case Prophetic:
                return res.getColor(R.color.colorProphetic);
            case Gospel:
                return res.getColor(R.color.colorGospel);
            case Epistle:
                return res.getColor(R.color.colorEpistle);
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookSelectionViewHolder extends RecyclerView.ViewHolder {

        protected TextView bookAbbrev;
        protected TextView bookName;
        protected TextView chapterQty;
        protected View bookFrame;

        public BookSelectionViewHolder(View itemView) {
            super(itemView);

            bookAbbrev = (TextView) itemView.findViewById(R.id.text_bookItem_BookAbbrev);
            bookName = (TextView) itemView.findViewById(R.id.text_bookItem_BookName);
            chapterQty = (TextView) itemView.findViewById(R.id.text_bookItem_ChapterQty);
            bookFrame = itemView.findViewById(R.id.item_book_frame);
        }

    }


}
