package com.example.databaseexercise;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
    This is the Main Activity java file, it brings everything together.
    onCreate method opens our layout and executes 4 methods:
        AddData
        ViewAll
        Modify
        Delete
    These methods create listeners for all of buttons and are responsible for calling methods from
    the second class which is DataBaseOpenHelper.
    First things first go there and do what has to be done.
 */
public class MainActivity extends AppCompatActivity {

    DataBaseOpenHelper listDB;
    EditText editProduct, editAmount, editShop, editID;
    Button buttonAdd, buttonViewAll, buttonModify, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listDB = new DataBaseOpenHelper(this);

        editProduct = (EditText) findViewById(R.id.editProduct);
        editAmount = (EditText) findViewById(R.id.editAmount);
        editShop = (EditText) findViewById(R.id.editShop);
        editID = (EditText) findViewById(R.id.editID);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonViewAll = (Button) findViewById(R.id.buttonViewAll);
        buttonModify = (Button) findViewById(R.id.buttonModify);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        AddData();
        ViewAll();
        Modify();
        Delete();
    }

    public void AddData(){
        buttonAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = listDB.insertData(editProduct.getText().toString(),
                                editAmount.getText().toString(),
                                editShop.getText().toString());
                        if (isInserted){
                            Toast.makeText(MainActivity.this,"Data inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Data not inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void ViewAll(){
        buttonViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result =  listDB.getAllData();
                        if (result.getCount() == 0){
                            Toast.makeText(MainActivity.this,"No data", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(result.moveToNext()){
                            buffer.append(result.getString(0)+ ".  " );
                            buffer.append(result.getString(2)+ " of " );
                            buffer.append(result.getString(1)+ "    " );
                            buffer.append("Where: "+ result.getString(3)+ "\n\n" );
                        }
                        //TODO: ude showData method
                    }
                }
        );
    }

    public void Modify(){
        buttonModify.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = listDB.modifyData(editID.getText().toString(),
                                editProduct.getText().toString(),
                                editAmount.getText().toString(),
                                editShop.getText().toString());
                        //TODO: create a Toast as in AddData method to check the operation was successful
                    }
                }
        );
    }

    public void Delete(){
        buttonDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO: create integer and use method delete data
                        //TODO: create a Toast as in AddData method to check if deleting was successful

                    }
                }
        );
    }

    public void showData(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}

