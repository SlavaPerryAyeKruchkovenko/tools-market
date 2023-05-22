package com.example.toolsmarket.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToolEntity(
    val title: String,
    val subtitle: String,
    val img: String?,
    val hasBag: String?,
    val isCircle: Int?
) {
    @PrimaryKey( autoGenerate = true)
    var id: Int = 0
}