import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageResource")
fun imageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
    imageView.tag = resource
}