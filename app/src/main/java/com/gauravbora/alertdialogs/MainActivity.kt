package com.gauravbora.alertdialogs

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.gauravbora.alertdialogs.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)




//        first Dialog
        binding.one.setOnClickListener {

            Toast.makeText(this, "Dialog 1", Toast.LENGTH_SHORT).show()

            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(this)
            builder.setMessage(R.string.dialog_heading)
                .setPositiveButton(R.string.start,
                    DialogInterface.OnClickListener { dialog, id ->
                        // START THE GAME!
                        Toast.makeText(this, "Start Clicked", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                        Toast.makeText(this, "Cancel Clicked", Toast.LENGTH_SHORT).show()
                    })
            // Create the AlertDialog object and return it
            builder.create()

//showing the dialog 1
            builder.show()

        }




//        second Dialog
        binding.two.setOnClickListener {
            Toast.makeText(this, "Dialog 2", Toast.LENGTH_SHORT).show()

//            val alertDialog: AlertDialog? = this.let {
//                val builder = AlertDialog.Builder(it)
//                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title)
//
//
//
//                builder.apply {
//                    setPositiveButton(R.string.ok,
//                        DialogInterface.OnClickListener { dialog, id ->
//                            // User clicked OK button
//                            Toast.makeText(it, "Ok Clicked", Toast.LENGTH_SHORT).show()
//                        })
//                    setNegativeButton(R.string.cancel,
//                        DialogInterface.OnClickListener { dialog, id ->
//                            // User cancelled the dialog
//                            Toast.makeText(it, "Canceled", Toast.LENGTH_SHORT).show()
//                        })
//                }
//                // Set other dialog properties
////                ...
//
//                // Create the AlertDialog
//                builder.create()
//
//                builder.show()
//            }

            MaterialAlertDialogBuilder(this).setTitle("Alert").setMessage("Can You tell me more about Yourself")
                .setNeutralButton("Later"){dialog, which->
                    Toast.makeText(this ,"Later Clicked",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){dialog, which->
                    Toast.makeText(this ,"NO Clicked",Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("YES"){dialog, which->
                    Toast.makeText(this ,"YES Clicked",Toast.LENGTH_SHORT).show()
                }.show()


        }




//        third dialog
        binding.three.setOnClickListener {
            Toast.makeText(this, "Dialog 3", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.pick_color)
                .setItems(R.array.colors_array,
                    DialogInterface.OnClickListener { dialog, which ->
                        // The 'which' argument contains the index position
                        // of the selected item
                        Toast.makeText(this, "Color Picked", Toast.LENGTH_SHORT).show()
                    })
            builder.create()
            builder.show()
        }




//        fourth dialog
        binding.four.setOnClickListener {
            Toast.makeText(this, "Dialog 4", Toast.LENGTH_SHORT).show()

            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(this)
            // Set the dialog title
            builder.setTitle(R.string.dialog_title_4)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(R.array.toppings, null,
                    DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            selectedItems.add(which)
                        } else if (selectedItems.contains(which)) {
                            // Else, if the item is already in the array, remove it
                            selectedItems.remove(which)
                        }
                    })
                // Set the action buttons
                .setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK, so save the selectedItems results somewhere
                        // or return them to the component that opened the dialog
//                        ...
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
//                        ...
                    })

            builder.create()
            builder.show()

        }




//        fifth dialog
        binding.five.setOnClickListener {
            Toast.makeText(this, "Dialog 5  (Custom Layout)", Toast.LENGTH_SHORT).show()

            val builder = AlertDialog.Builder(this)
            // Get the layout inflater
            val inflater = this.layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_signin, null))
                // Add action buttons
                .setPositiveButton(R.string.signin,
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                        Toast.makeText(this,"Signed In",Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->

                        Toast.makeText(this,"Canceled",Toast.LENGTH_SHORT).show()
                    })
            builder.create()
            builder.show()
        }

    }




}