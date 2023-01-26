package dominio.proprio.ecommerceapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dominio.proprio.ecommerceapp.model.Item

@Database(
    version = 1,
    entities = [Item::class],
    exportSchema = true
)

abstract class AppDataBase: RoomDatabase() {


}