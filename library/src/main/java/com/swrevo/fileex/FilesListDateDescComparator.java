package com.swrevo.fileex;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.io.File;

class FilesListDateDescComparator extends FilesListComparator {
    @Override
    @IntRange(from = -1, to = 1)
    int compareProperty(@NonNull File file1, @NonNull File file2) {
        return Long.compare(file2.lastModified(), file1.lastModified());
    }
}
