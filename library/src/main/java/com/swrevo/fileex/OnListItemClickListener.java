package com.swrevo.fileex;

public interface OnListItemClickListener {
    public static final int POSITION_UP = -1;
    void onListItemClick(int position);
    void onListItemLongClick(int position);
}
