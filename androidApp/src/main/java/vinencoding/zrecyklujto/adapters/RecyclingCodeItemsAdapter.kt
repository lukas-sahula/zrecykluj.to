package vinencoding.zrecyklujto.adapters

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import vinencoding.zrecyklujto.R
import vinencoding.zrecyklujto.models.RecyclingCode

open class RecyclingCodeItemsAdapter (private val context: Context,
                                      private val list: ArrayList<RecyclingCode>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycling_code, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is MyViewHolder){
            when(model.materialType){

                "Pl" -> holder.itemView.findViewById<LinearLayout>(R.id.ll_recycling_item_view)
                    .setBackgroundResource(R.color.colorYellowPlastic)
                "Pa" -> holder.itemView.findViewById<LinearLayout>(R.id.ll_recycling_item_view)
                    .setBackgroundResource(R.color.colorBluePaper)
                "Me" -> holder.itemView.findViewById<LinearLayout>(R.id.ll_recycling_item_view)
                    .setBackgroundResource(R.color.colorGreyMetal)
                "Gl" -> holder.itemView.findViewById<LinearLayout>(R.id.ll_recycling_item_view)
                    .setBackgroundResource(R.color.colorGreenGlass)
                "Te" -> holder.itemView.findViewById<LinearLayout>(R.id.ll_recycling_item_view)
                    .setBackgroundResource(R.color.colorOrangeTetra)
            }

            holder.itemView.findViewById<TextView>(R.id.tv_recycling_code_number).text = model.number
            if(holder.itemView.findViewById<TextView>(R.id.tv_recycling_code_number).text.length > 3){
                holder.itemView.findViewById<TextView>(R.id.tv_recycling_code_number).setTextSize(15F)
            }

            holder.itemView.findViewById<TextView>(R.id.tv_recycling_code_title).text = model.title
            holder.itemView.findViewById<TextView>(R.id.tv_recycling_code_description).text = model.throwInto
            holder.itemView.findViewById<TextView>(R.id.tv_recycling_code_code).text = model.code

            holder.itemView.setOnClickListener {
                if (onClickListener != null){
                    onClickListener!!.onClick(position, model)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClickListener{
        fun onClick(position: Int, model: RecyclingCode)
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}