package br.edu.up.rgm34240004.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ItemEntity::class],
    version = 1,
)
abstract class InventoryDatabase: RoomDatabase() {

    abstract val itemDao: ItemDao
}

object InventoryDatabaseProvider {

    @Volatile
    private var INSTANCE: InventoryDatabase? = null

    fun provide(context: Context): InventoryDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                InventoryDatabase::class.java,
                "inventory_database"
                ).build()
            INSTANCE = instance
            instance
        }
    }
}