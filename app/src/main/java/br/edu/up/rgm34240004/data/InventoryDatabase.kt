package br.edu.up.rgm34240004.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDAO

    companion object{
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, InventoryDatabase::class.java, "inventory_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}