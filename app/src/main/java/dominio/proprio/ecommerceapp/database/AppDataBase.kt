package dominio.proprio.ecommerceapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dominio.proprio.ecommerceapp.model.Item
import dominio.proprio.ecommerceapp.ui.HomeFragment

@Database(
    version = 1,
    entities = [Item::class]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao


    companion object {
        @Volatile
        private var db: AppDataBase? = null

        fun instance(context: Context?): AppDataBase {
            if (db == null) {
                db = context?.let {
                    Room.databaseBuilder(
                        it,
                        AppDataBase::class.java,
                        "database-EcommerceApp"
                    ).allowMainThreadQueries().build()
                }
            }
            return db!!
        }
    }
}