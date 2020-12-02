package com.example.recyclerviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//클래스 옆에 : 있으면 상속받는것
class ProfileAdapter(val profilesList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val profile: Profiles = profilesList.get(curPos)
                Toast.makeText(parent.context, "이름 : ${profile.name} 나이 : ${profile.age}", Toast.LENGTH_SHORT).show()

            }

        }
    }

    override fun getItemCount(): Int {
        return profilesList.size
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profilesList.get(position).gender)
        holder.name.text = profilesList.get(position).name
        holder.age.text = profilesList.get(position).age.toString()
        holder.job.text = profilesList.get(position).job
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)        // 이름
        val age = itemView.findViewById<TextView>(R.id.tv_age)        // 나이
        val job = itemView.findViewById<TextView>(R.id.tv_job)        // 직업
    }
}