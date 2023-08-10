package com.example.menuapplication

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import com.example.menuapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.tbToolBar)

        binding.btnPopUp.setOnClickListener {
            popUpMenu(binding.btnPopUp)
        }

        binding.btnContext.setOnClickListener {
            registerForContextMenu(binding.btnContext);
        }

    }


    //Pop Up Menu
    private fun popUpMenu(view: View) {

        val popupMenu = PopupMenu(this, binding.btnPopUp)

        popupMenu.menuInflater.inflate(R.menu.pop_up_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->

            when (item.itemId) {

                R.id.android -> {
                    Toast.makeText(this, "This is Android  Language", Toast.LENGTH_SHORT).show()
                }

                R.id.kotlin -> {
                    Toast.makeText(this, "This is Kotlin  Language", Toast.LENGTH_SHORT).show()
                }

                R.id.python -> {
                    Toast.makeText(this, "This is Python  Language", Toast.LENGTH_SHORT).show()
                }

                R.id.reactNative -> {
                    Toast.makeText(this, "This is React Native  Language", Toast.LENGTH_SHORT)
                        .show()
                }

                else -> {
                    Toast.makeText(this, "Language Not Found ", Toast.LENGTH_SHORT).show()

                }
            }
            true
        }
        popupMenu.show()
    }

    //Context Menu Long Press THen Open
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("Choose a color")
        menu.add(0, v.id, 0, "Yellow")
        menu.add(0, v.id, 0, "Gray")
        menu.add(0, v.id, 0, "Cyan")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.title === "Yellow") {
            binding.clLayout.setBackgroundColor(Color.YELLOW)
        } else if (item.title === "Gray") {
            binding.clLayout.setBackgroundColor(Color.GRAY)
        } else if (item.title === "Cyan") {
            binding.clLayout.setBackgroundColor(Color.CYAN)
        }
        return true
    }

    //Options Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.pop_up_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.android -> {
                Toast.makeText(this, "This is Android  Language", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.kotlin -> {
                Toast.makeText(this, "This is Kotlin  Language", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.python -> {
                Toast.makeText(this, "This is Python  Language", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.reactNative -> {
                Toast.makeText(this, "This is React Native  Language", Toast.LENGTH_SHORT)
                    .show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }


}