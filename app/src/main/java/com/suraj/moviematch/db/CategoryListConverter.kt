package com.suraj.moviematch.db

import androidx.room.TypeConverter

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(categoryList: List<String>): String {
        return categoryList.joinToString(",")
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<String> {
        return categoryString.split(",")
    }
}
