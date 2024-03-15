package com.example.musicstream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicstream.adapter.SongListAdapter
import com.example.musicstream.databinding.ActivitySongsListBinding
import com.example.musicstream.models.CategoryModel

class SongsListActivity : AppCompatActivity() {
    companion object{
        lateinit var category: CategoryModel
    }
    lateinit var binding:ActivitySongsListBinding
    lateinit var songListAdapter: SongListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameTextView.text = category.name
        Glide.with(binding.coverImageView).load(category.coverUrl)
            .apply(
                RequestOptions().transform(RoundedCorners(32))
            )
            .into(binding.coverImageView)
        setUpSongsListRecyclerView()
    }
    fun setUpSongsListRecyclerView(){
        songListAdapter = SongListAdapter(category.songs)
        binding.songsListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.songsListRecyclerView.adapter = songListAdapter
    }
}