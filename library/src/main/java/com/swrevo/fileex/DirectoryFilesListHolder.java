package com.swrevo.fileex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import android.view.View;

import java.io.File;

import com.swrevo.fileex.R;
import com.swrevo.fileex.OnListItemClickListener;

public class DirectoryFilesListHolder extends BaseFilesListHolder {
    @Nullable
    private final AppCompatTextView mFileSize;
    @NonNull
    private final AppCompatImageView mThumbnail;

    public DirectoryFilesListHolder(@NonNull View itemView) {
        super(itemView);
        mFileSize = (AppCompatTextView) this.itemView.findViewById(R.id.filesize);
        mThumbnail = (AppCompatImageView) this.itemView.findViewById(R.id.thumbnail);
    }

    @Override
    public void bind(@NonNull File file, boolean isMultiChoiceModeEnabled, boolean isSelected, @Nullable OnListItemClickListener listener) {
        super.bind(file, isMultiChoiceModeEnabled, isSelected, listener);
        if (mFileSize != null) {
            mFileSize.setVisibility(View.GONE);
        }
        mThumbnail.setImageResource(R.drawable.efp__ic_folder);
    }
}
