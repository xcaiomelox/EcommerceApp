package dominio.proprio.ecommerceapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import dominio.proprio.ecommerceapp.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao {

    @Query("SELECT * FROM item")
    fun getAll(): List<Item>

    @Insert(onConflict = REPLACE)
    fun save(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun searchForId(id: Long): List<Item>

    @Delete
    fun delete(item: Item)
}
