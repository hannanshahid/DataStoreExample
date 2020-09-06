package com.hannanshahid.datastore_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.preferencesKey
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datastoreobject=user_data_Manager(this)
        prefrence.setOnClickListener {
           if(name_edittext.text.toString().isEmpty()) {

               val name = datastoreobject.getname()
               GlobalScope.launch(Dispatchers.IO) {
                name.collect {
                    showdata.text="Name store is : $it"
                }
               }
           }
            else
           {

            GlobalScope.launch(Dispatchers.IO) {
                datastoreobject.setname(name_edittext.text.toString())
            }

           }
        }


    }
}