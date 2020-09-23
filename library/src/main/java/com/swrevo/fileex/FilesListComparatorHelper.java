package com.swrevo.fileex;

import androidx.annotation.NonNull;

import com.swrevo.fileex.ExFilePicker;


public class FilesListComparatorHelper {
    @NonNull
    public static FilesListComparator getComparator(ExFilePicker.SortingType sortingType) {
        switch (sortingType) {
            case NAME_DESC:
                return new FilesListNameDescComparator();
            case SIZE_ASC:
                return new FilesListSizeAscComparator();
            case SIZE_DESC:
                return new FilesListSizeDescComparator();
            case DATE_ASC:
                return new FilesListDateAscComparator();
            case DATE_DESC:
                return new FilesListDateDescComparator();
            default:
                return new FilesListNameAscComparator();
        }
    }
}
