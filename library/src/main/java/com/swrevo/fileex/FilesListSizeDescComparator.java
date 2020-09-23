package com.swrevo.fileex;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.io.File;

class FilesListSizeDescComparator extends FilesListComparator {
    @Override
    @IntRange(from = -1, to = 1)
    int compareProperty(@NonNull File file1, @NonNull File file2) {
        return Long.compare(file2.length(), file1.length());
    }
}
