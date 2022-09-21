package com.example.mapskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.mapskotlin.Adapter.RecyclerAdapter
import com.example.mapskotlin.databinding.ActivityMainBinding
import com.example.mapskotlin.room.Maps
import com.example.mapskotlin.room.mapDao
import com.example.mapskotlin.room.mapData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mapdata: mapData
    private lateinit var mapD: mapDao
    private lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mapdata= Room.databaseBuilder(
            applicationContext,
            mapData::class.java, "Maps"
        ).build()

        mapD = mapdata.mapD()


        compositeDisposable.add(mapD.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::getAll))
    }

    private fun getAll(list : List<Maps>){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = RecyclerAdapter(list)
        binding.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInf = menuInflater
        menuInf.inflate(R.menu.options_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.optionMap){
            var intent = Intent(this@MainActivity,MapsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


}