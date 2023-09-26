import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs388_project_2_wishlistapp.WishItem

class WishlistAdapter(private val wishList: MutableList<WishItem>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_display, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishItem = wishList[position]
        holder.itemView.nameTextView.text = wishItem.name
        holder.itemView.urlTextView.text = wishItem.url
        holder.itemView.priceTextView.text = "$${wishItem.price}"
    }

    override fun getItemCount(): Int {
        return wishList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
data class WishItem(val name: String, val url: String, val price: Double)
