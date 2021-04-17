package com.example.mycustomview

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.custom_view_layout.view.*
import java.util.jar.Attributes

class MyCustomView(context:Context, attrs:Attributes) : LinearLayout(context,attrs){

    private var autoCompleteTextView : AutoCompleteTextView
    private var listView : ListView
    private var title : TextView
    private var add : ImageView

    private var selectedItems : MutableList<String> = ArrayList()
    private var allItems : MutableList<String> = ArrayList()


    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_view_layout,this,true)
        autoCompleteTextView = view.findViewById(R.id.autocompletetextview)
        listView = view.findViewById(R.id.listview)
        title = view.findViewById(R.id.title)
        add = view.findViewById(R.id.add)

        autoCompleteTextView.threshold = 1


        add.setOnClickListener{
            val selectedString = autoCompleteTextView.text.trim().toString()
            when{
                selectedString.isEmpty() -> Toast.makeText(getContext(),"please enter data", Toast.LENGTH_SHORT).show()
                selectedItems.contains(selectedString) -> Toast.makeText(getContext(), "Item alteady added", Toast.LENGTH_SHORT).show()
                else->{
                    selectedItems.add(0,selectedString)
                }
            }
        }


    }
    inner class MycustomViewAdapter(context: Context?, resource: Int, objects: MutableList<String>?) : ArrayAdapter<String>{
        private  val inflater : LayoutInflater = LayoutInflater.from(context)
        override fun getCount(): Int {
            return objects.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = inflater.inflate(resource, parent, false)
            val name =
            return view
        }

    }
}