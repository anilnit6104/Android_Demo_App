package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val fname: Array<String> = arrayOf("Jyoti Patel","Suman Patel","Surbhi Singh","Sonu Singh","B.K Patel","Aarchi Agarwal","Akanksha Patel","Jagmohan Sahu","Akhil Singh")
    val contact: Array<String> = arrayOf("7000388452","7000472058","9406208599","7000865011","9424353041","8827107805","6261441382","8092579197","7619602499")
    val pics = intArrayOf(R.drawable.dp1,R.drawable.dp2,R.drawable.dp,R.drawable.dp1,R.drawable.dp2,R.drawable.dp,R.drawable.dp1,R.drawable.dp2,R.drawable.dp)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var pics : ImageView = itemView.findViewById(R.id.ContactImage)
        var fname : TextView = itemView.findViewById(R.id.rvtextview)
        var contact: TextView = itemView.findViewById(R.id.rvtextview2)
        var callbtn: FloatingActionButton = itemView.findViewById(R.id.call)
        
        init {
            callbtn.setOnClickListener(this)
        }

        override fun onClick(view: View?){
            if(view?.id==callbtn.id)
            {
                val phone = contact.text.toString()
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phone")
                view.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fname.text = fname[position]
        holder.pics.setImageResource(pics[position])
        holder.contact.text = contact[position]
    }

    override fun getItemCount(): Int {
        return fname.size
    }
}

