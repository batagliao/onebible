package com.batagliao.onebible.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.provider.SyncStateContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.batagliao.onebible.BR;
import com.batagliao.onebible.R;
import com.batagliao.onebible.databinding.BookselectionListItemBinding;
import com.batagliao.onebible.models.Book;
import com.batagliao.onebible.models.BookTypeEnum;
import com.batagliao.onebible.util.BibleHelper;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by batagliao on 11/21/15.
 */
public class BookSelectionAdapter extends RecyclerView.Adapter<BookSelectionAdapter.BookSelectionViewHolder> {

    private Context context;
    private List<Book> books;
    private Resources res;

    public BookSelectionAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
        res = context.getResources();
    }


    @Override
    public BookSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        BookselectionListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.bookselection_list_item, parent, false);
        //View view = layoutInflater.inflate(R.layout.bookselection_list_item, parent, false);

        BookSelectionViewHolder viewHolder = new BookSelectionViewHolder(binding.getRoot());

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookSelectionViewHolder holder, int position) {
        final Book book = books.get(position);
        holder.bind(book, res);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setFilter(List<Book> books) {
        this.books = new ArrayList<>();
        this.books.addAll(books);
        notifyDataSetChanged();
    }


    public static class BookSelectionViewHolder extends RecyclerView.ViewHolder {

        //protected TextView bookAbbrev;
        //protected TextView bookName;
        private TextView chapterQty;
        private View bookFrame;
        private ViewDataBinding binding;

        public BookSelectionViewHolder(View itemView) {
            super(itemView);

            //TODO: bind the other properties

            binding = DataBindingUtil.bind(itemView);

            chapterQty = (TextView) itemView.findViewById(R.id.text_bookItem_ChapterQty);
            bookFrame = itemView.findViewById(R.id.item_book_frame);
        }

        public void bind(Book book, Resources res){
            int bookSize = book.getChapters().size();

            //TODO: bind the other properties
            chapterQty.setText(res.getQuantityString(R.plurals.chapters, bookSize, bookSize));
            bookFrame.setBackgroundColor(getColorForBook(book, res));
            binding.setVariable(BR.book, book);
        }

        private int getColorForBook(Book book, Resources res) {
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

    }


}
