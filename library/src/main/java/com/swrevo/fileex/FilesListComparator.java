package com.swrevo.fileex;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.io.File;
import java.util.Comparator;

abstract class FilesListComparator implements Comparator<File> {
    @Override
    @IntRange(from = -1, to = 1)
    public int compare(@NonNull File file1, @NonNull File file2) {
        if (file1.isDirectory() && !file2.isDirectory()) {
            return -1;
        } else if (!file1.isDirectory() && file2.isDirectory()) {
            return 1;
        } else {
            return compareProperty(file1, file2);
        }
    }

    @IntRange(from = -1, to = 1)
    abstract int compareProperty(@NonNull File file1, @NonNull File file2);
}
