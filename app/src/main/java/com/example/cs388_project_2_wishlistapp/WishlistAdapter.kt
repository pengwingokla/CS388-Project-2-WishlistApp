import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs388_project_2_wishlistapp.R

class WishlistAdapter(private val itemList: List<WishlistItem>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val urlTextView = itemView.findViewById<TextView>(R.id.urlTextView)
        val priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)
        val productImageView = itemView.findViewById<ImageView>(R.id.productImgView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_display,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.nameTextView.text = currentItem.name
        holder.urlTextView.text = currentItem.url
        holder.priceTextView.text = currentItem.price
        holder.productImageView.setImageResource(currentItem.imageResource)
    }

    override fun getItemCount() = itemList.size

    data class WishlistItem(
        val name: String,
        val url: String,
        val price: String,
        val imageResource: Int
    )
}



