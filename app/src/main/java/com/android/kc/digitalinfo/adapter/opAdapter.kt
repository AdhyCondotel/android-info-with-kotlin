package com.android.kc.digitalinfo.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.kc.digitalinfo.R
import kotlinx.android.synthetic.main.item_list_names.view.*

/**
 * Created by programmer on 3/25/18.
 */
class opAdapter (val opItem: ArrayList<String>, val  context: Context) : RecyclerView.Adapter<ViewHolder2>() {

    private var row_index = 0

    override fun getItemCount(): Int {
        return opItem.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder2 {
        return ViewHolder2(LayoutInflater.from(context).inflate(R.layout.item_list_names, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder2?, position: Int) {
        holder?.textViewName?.text = opItem.get(position)

        holder?.textViewName?.setOnClickListener(View.OnClickListener {
            row_index = position
            notifyDataSetChanged()
        })
        if (row_index == position) {
            holder?.textViewName?.setTextColor(Color.parseColor("#ff2200"))

        } else {
            holder?.textViewName?.setTextColor(Color.parseColor("#FFA5A2A2"))

        }

    }

}

class ViewHolder2 (view: View) : RecyclerView.ViewHolder(view) {
    val textViewName = view.textViewOperator
}